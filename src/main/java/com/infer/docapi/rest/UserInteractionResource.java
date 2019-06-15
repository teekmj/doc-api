package com.infer.docapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.infer.docapi.domain.UserInteractionMatrics;
import com.infer.docapi.service.UserInteractionService;

@RestController
@RequestMapping("/userinteractionmatrix")
public class UserInteractionResource {
	@Autowired
	UserInteractionService userInteractionService;
	
	
	@PostMapping("/save")
	@ResponseBody
	public List<UserInteractionMatrics> saveUserInteractionMatrics(@RequestBody List<UserInteractionMatrics> matric) {
		return userInteractionService.saveMatric(matric);
	}
}
