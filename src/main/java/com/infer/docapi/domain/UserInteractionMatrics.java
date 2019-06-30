package com.infer.docapi.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Document
@Data
@EqualsAndHashCode(of = "id")
public class UserInteractionMatrics implements Serializable {

	private static final long serialVersionUID = -88578165567768581L;

	@Id
	private String id;

	private String docId;
	private int paragraphSeqNo;
	private Long copyCount = 0L;
	private Long mouseOverCount = 0L;
	private Long mouseOverTime = 0L;
	private Long scrollCount = 0L;
	private Long scrollTime = 0L;
	private Long selectionCount = 0L;
	private Long count = 1L;

	public boolean isEmpty() {
		return this.mouseOverCount.equals(0L) && this.mouseOverTime.equals(0L) && this.copyCount.equals(0L)
				&& this.scrollTime.equals(0L) && this.scrollCount.equals(0L) && this.selectionCount.equals(0L);
	}
}
