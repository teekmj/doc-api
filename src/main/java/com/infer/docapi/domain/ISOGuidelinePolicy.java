package com.infer.docapi.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ISOGuidelinePolicy implements Serializable{

	private static final long serialVersionUID = 3230026888273122111L;

	@Id
	private String id;
	
	private String policyName;
	private String subpolicyName;
	private String objective;
	private String policyText;
	
}
