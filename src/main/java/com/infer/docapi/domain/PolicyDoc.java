package com.infer.docapi.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Document
@Data
@EqualsAndHashCode(of = "id")
public class PolicyDoc implements Serializable {
	
	private static final long serialVersionUID = -6527567606401405892L;
	
	@Id
	private String id;
	private String name;
	private String type;
	private Double compliance;
	private List<Paragraph> paragraphs; 
}
