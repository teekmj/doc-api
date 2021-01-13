package com.infer.docapi.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class UserAttentionScore implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1162170575241607785L;

	private Double copyCountScore = 0D;
	private Double mouseOverCountScore = 0D;
	private Double mouseOverTimeScore = 0D;
	private Double scrollCountScore = 0D;
	private Double scrollTimeScore = 0D;
	private Double selectionCountScore = 0D;
	private Double countScore = 0D;
	private Double totalScore = 0D;

	public void computeTotalScore() {
		this.totalScore = this.copyCountScore + this.mouseOverCountScore + this.mouseOverTimeScore
				+ this.scrollCountScore + this.scrollTimeScore + this.selectionCountScore + this.countScore;
	}
}
