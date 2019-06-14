package com.infer.docapi.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
