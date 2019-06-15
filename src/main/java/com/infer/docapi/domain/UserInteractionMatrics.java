package com.infer.docapi.domain;

import java.io.Serializable;

import org.bson.types.ObjectId;
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
	private ObjectId id;
	
	private String docId;
	private Long paragraphSeqNo;
	private Long copyCount;
	private Long mouseOverCount;
	private Long mouseOverTime;
	private Long scrollCount;
	private Long scrollTime;
	private Long count = 1L;
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	public Long getParagraphSeqNo() {
		return paragraphSeqNo;
	}
	public void setParagraphSeqNo(Long paragraphSeqNo) {
		this.paragraphSeqNo = paragraphSeqNo;
	}
	public Long getCopyCount() {
		return copyCount;
	}
	public void setCopyCount(Long copyCount) {
		this.copyCount = copyCount;
	}
	public Long getMouseOverCount() {
		return mouseOverCount;
	}
	public void setMouseOverCount(Long mouseOverCount) {
		this.mouseOverCount = mouseOverCount;
	}
	public Long getMouseOverTime() {
		return mouseOverTime;
	}
	public void setMouseOverTime(Long mouseOverTime) {
		this.mouseOverTime = mouseOverTime;
	}
	public Long getScrollCount() {
		return scrollCount;
	}
	public void setScrollCount(Long scrollCount) {
		this.scrollCount = scrollCount;
	}
	public Long getScrollTime() {
		return scrollTime;
	}
	public void setScrollTime(Long scrollTime) {
		this.scrollTime = scrollTime;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public boolean isEmpty() {
		return this.getMouseOverCount() == 0 && this.getMouseOverTime() == 0 && this.getCopyCount() == 0;
	}
}
