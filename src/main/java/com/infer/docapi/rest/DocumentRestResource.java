package com.infer.docapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infer.docapi.domain.ISOGuidelinePolicy;
import com.infer.docapi.domain.PolicyDoc;
import com.infer.docapi.service.DocService;


@RestController
@RequestMapping("/documents")
public class DocumentRestResource {
	
	@Autowired
	DocService docService;
	
	@PostMapping(path = "/read",  produces = "application/json")
	public List<PolicyDoc> readDocuments() {
		return docService.readAllDocs();
	}
	
	@GetMapping(path = "/", produces = "application/json")
	public List<PolicyDoc> getDocuments() {
		return docService.getAllDocs();
	}
	
	@GetMapping(path = "/{id}",  produces = "application/json")
	public PolicyDoc getDocument(@PathVariable("id") String id) {
		return docService.getDoc(id);
	}
	
	@PostMapping(path = "/iso",  produces = "application/json")
	public List<ISOGuidelinePolicy> readISO() {
		return docService.readAndSaveISO();
	}
}
