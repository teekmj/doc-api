package com.infer.docapi.service;

import java.util.List;

import com.infer.docapi.domain.ISOGuidelinePolicy;
import com.infer.docapi.domain.PolicyDoc;

public interface DocService {

	List<PolicyDoc> readAllDocs();

	List<PolicyDoc> getAllDocs();

	PolicyDoc getDoc(String id);

	List<ISOGuidelinePolicy> readAndSaveISO();

}
