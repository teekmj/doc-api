package com.infer.docapi.service;

import com.infer.docapi.domain.PolicyDoc;

public interface UserInteractionService {

	PolicyDoc getParaDetails(int seqNo, String id);

}
