package com.infer.docapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infer.docapi.dao.PolicyDocRepository;
import com.infer.docapi.domain.PolicyDoc;
import com.infer.docapi.service.UserInteractionService;

@Service
public class UserInteractionServiceImpl implements UserInteractionService{
	@Autowired
	PolicyDocRepository docRepository;
	
	@Override
	@Transactional
	public PolicyDoc getParaDetails(int seqNo, String id) {
		return docRepository.getParagraph(id).get(0);
	}
	
	
}
