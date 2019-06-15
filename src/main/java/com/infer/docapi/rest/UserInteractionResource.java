package com.infer.docapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@PostMapping("/save")
	@ResponseBody
	public List<UserInteractionMatrics> saveUserInteractionMatrics(@RequestBody List<UserInteractionMatrics> matric) {
		return userInteractionService.saveMatric(matric);
	}
}
