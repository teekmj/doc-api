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
public class UserInteractionMatrics implements Serializable{
	
	private static final long serialVersionUID = -88578165567768581L;

	@Id
	private String id;
	
	private String docId;
	private Long paragraphSeqNo;
	private Long copyCount;
	private Long mouseOverCount;
	private Long mouseOverTime;
	private Long scrollCount;
	private Long scrollTime;
	private Long count;
}
