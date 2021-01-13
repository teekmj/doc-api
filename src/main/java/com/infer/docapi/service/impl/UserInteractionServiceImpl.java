package com.infer.docapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infer.docapi.dao.PolicyDocRepository;
import com.infer.docapi.dao.UserInteractionRepository;
import com.infer.docapi.domain.PolicyDoc;
import com.infer.docapi.domain.UserInteractionMatrics;
import com.infer.docapi.service.UserInteractionService;

@Service
public class UserInteractionServiceImpl implements UserInteractionService{
	@Autowired
	PolicyDocRepository docRepository;
	
	@Autowired
	UserInteractionRepository userInteractionRepository;
	
	@Override
	@Transactional
	public PolicyDoc getParaDetails(int seqNo, String id) {
	
		return docRepository.getParagraph(id).get(0);
	}
	
	/** 
	 * Add or update UserInteractionMatrics data for a section
	 * @param matrices user interaction details for a session
	 */
	@Override
	@Transactional
	public List<UserInteractionMatrics> saveMatric(List<UserInteractionMatrics> matrices) {
		matrices = matrices.stream().filter(m -> !m.isEmpty()).collect(Collectors.toList());
		
		for(UserInteractionMatrics eachMatrics : matrices) {
			UserInteractionMatrics matricsDB = userInteractionRepository.getUserInteractionMatric(eachMatrics.getDocId(), eachMatrics.getParagraphSeqNo());
			if (matricsDB != null) {
				matricsDB.setCopyCount(matricsDB.getCopyCount() + eachMatrics.getCopyCount());
				matricsDB.setCount(matricsDB.getCount() + 1);
				matricsDB.setMouseOverCount(matricsDB.getMouseOverCount() + eachMatrics.getMouseOverCount());
				matricsDB.setMouseOverTime(matricsDB.getMouseOverTime() + eachMatrics.getMouseOverTime());
				matricsDB.setScrollTime(matricsDB.getScrollTime() + eachMatrics.getScrollTime());
				matricsDB.setScrollCount(matricsDB.getScrollCount() + eachMatrics.getScrollCount());
				matricsDB.setSelectionCount(matricsDB.getSelectionCount() + eachMatrics.getSelectionCount());
				userInteractionRepository.save(matricsDB);
			} else {
				userInteractionRepository.save(eachMatrics);
			}
		}
		return matrices;
	}
	
}
