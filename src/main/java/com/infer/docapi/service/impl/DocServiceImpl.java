package com.infer.docapi.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infer.docapi.dao.ISOGuidelinePolicyRepository;
import com.infer.docapi.dao.PolicyDocRepository;
import com.infer.docapi.dao.UserInteractionRepository;
import com.infer.docapi.domain.ISOGuidelinePolicy;
import com.infer.docapi.domain.PolicyDoc;
import com.infer.docapi.domain.UserInteractionMatrics;
import com.infer.docapi.helper.MatricsScoreCalculator;
import com.infer.docapi.parser.DocumentParser;
import com.infer.docapi.parser.ISOParser;
import com.infer.docapi.service.DocService;

@Service
public class DocServiceImpl implements DocService {
	
	@Autowired
	DocumentParser documentParser;
	@Autowired
	PolicyDocRepository docRepository;
	@Autowired
	ISOGuidelinePolicyRepository policyRepository;
	@Autowired
	UserInteractionRepository interactionRepository;
	@Autowired
	ISOParser isoParser;
	@Autowired
	MatricsScoreCalculator matricsScoreCalculator; 
	
	private static final String FOLDER_PATH = "G:\\Makeathon\\docs\\";
	
	/**
	 * A service to Read all documents in the given folder
	 * Should be triggered only when we need to load the data to the system
	 */
	@Override
	@Transactional
	public List<PolicyDoc> readAllDocs() {
		
		List<PolicyDoc> policyDocs = new ArrayList<>();
		try {
			Files.walk(Paths.get(FOLDER_PATH))
			.filter(Files::isRegularFile)
			.map(Path::toFile)
			.forEach(f ->{ 
				policyDocs.add(documentParser.parseDoc(f)); }
			);
			
			return docRepository.saveAll(policyDocs);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return policyDocs;
	}
	
	/**
	 * Get all policy documents
	 */
	@Override
	@Transactional
	public List<PolicyDoc> getAllDocs() {
		return docRepository.getAllDocNames();
	}
	
	/**
	 * Get a specific document by id
	 */
	@Override
	@Transactional
	public PolicyDoc getDoc(String id) {
		PolicyDoc policyDoc = docRepository.findById(id).orElse(null);
		if(policyDoc != null) {
			return assignParagraphScores(policyDoc);
		}
		return null;
	}
	
	/**
	 * A service to populate the ISO27001 data for the first time
	 */
	@Override
	@Transactional
	public List<ISOGuidelinePolicy> readAndSaveISO(){
		return policyRepository.saveAll(isoParser.parseISO());
	}
	
	/**
	 * Calculate the the sectional score based on user-interaction events for all paragraphs in a document
	 * called when we do a getByID
	 * @param policyDoc
	 * @return
	 */
	private PolicyDoc assignParagraphScores(PolicyDoc policyDoc) {
		List<UserInteractionMatrics> matricsList = interactionRepository.getByDocID(policyDoc.getId());
		for (UserInteractionMatrics matric: matricsList) {
				policyDoc.getParagraphs()
				.stream()
				.filter(each -> each.getSeqNo() == matric.getParagraphSeqNo())
				.forEach(each -> each.setUserScore(matricsScoreCalculator.calculateScore(matric)));
		}
		return policyDoc;
	}
}
