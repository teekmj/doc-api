package com.infer.docapi.service;

import java.util.List;

import com.infer.docapi.domain.PolicyDoc;
import com.infer.docapi.domain.UserInteractionMatrics;

public interface UserInteractionService {

	PolicyDoc getParaDetails(int seqNo, String id);
	List<UserInteractionMatrics> saveMatric(List<UserInteractionMatrics> matrics);
	
}
