package com.infer.docapi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infer.docapi.domain.PolicyDoc;
import com.infer.docapi.domain.UserInteractionMatrics;
import com.infer.docapi.service.UserInteractionService;

@RestController
@RequestMapping("/userinteractionmatrix")
public class UserInteractionResource {
	@Autowired
	UserInteractionService userInteractionService;
	
	@GetMapping(produces = "application/json")
	public PolicyDoc getParaDetails() {
		return userInteractionService.getParaDetails(1, "5d03ee6f8a3993159c8faa5f");
	}
	
	
}
