package com.infer.docapi.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Document
@Data
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
	private Long count = 1L;
	
	
	public boolean isEmpty() {
		return this.getMouseOverCount() == 0 && this.getMouseOverTime() == 0 && this.getCopyCount() == 0;
	}
}
