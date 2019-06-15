package com.infer.docapi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.infer.docapi.dao.TextMatrixRepository;
import com.infer.docapi.domain.SelectedTextMatrix;

@RestController
@RequestMapping("/textmatrix")
public class TextMatrixRestResource {
	
	@Autowired
	private TextMatrixRepository matrixRepository;
	
	@PostMapping("/")
	@ResponseBody
	public SelectedTextMatrix saveTextMatrix(@RequestBody SelectedTextMatrix textMatrix) {
		return matrixRepository.save(textMatrix);
	}
}
