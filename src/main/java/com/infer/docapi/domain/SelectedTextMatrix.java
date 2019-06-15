package com.infer.docapi.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Document
@Data
@EqualsAndHashCode(of = "id")
public class SelectedTextMatrix {
	@Id
	private String id;
	
	private String docId;
	private List<String> selectedText;
	
}
