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
import com.infer.docapi.domain.ISOGuidelinePolicy;
import com.infer.docapi.domain.PolicyDoc;
import com.infer.docapi.exception.BusinessException;
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
	ISOParser isoParser;
	
	private static final String FOLDER_PATH = "G:\\Makeathon\\docs\\";
	
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
	
	@Override
	@Transactional
	public List<PolicyDoc> getAllDocs() {
		return docRepository.getAllDocNames();
	}
	
	@Override
	@Transactional
	public PolicyDoc getDoc(String id) {
		return docRepository.findById(id).orElseThrow(() -> new BusinessException("Not found"));
	}
	
	@Override
	@Transactional
	public List<ISOGuidelinePolicy> readAndSaveISO(){
		return policyRepository.saveAll(isoParser.parseISO());
	}
}
