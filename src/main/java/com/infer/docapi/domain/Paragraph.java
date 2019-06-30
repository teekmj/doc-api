package com.infer.docapi.domain;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Paragraph implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3490655154072823124L;
	
	private String text;
	private String style;
	private SectionType sectionType;
	private int seqNo;
	private String summary;
	private Double importance;
	private List<ElementStyle> elementStyles;
	
	private UserAttentionScore userScore = new UserAttentionScore();
	
}
