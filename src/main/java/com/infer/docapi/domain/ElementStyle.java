package com.infer.docapi.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class ElementStyle implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3524210639408987242L;
	
	private String text;
	private boolean bold;
	private int seqNo;
	private String color;
}
