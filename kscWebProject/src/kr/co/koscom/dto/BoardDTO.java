package kr.co.koscom.dto;

import java.util.Date;

public class BoardDTO {
	public double sequence = 0;
	public String regDate = null;
	public String id = null;
	public String contents = null;
	
	public BoardDTO() {
		super();
	}

	public double getSequence() {
		return sequence;
	}

	public void setSequence(double sequence) {
		this.sequence = sequence;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	
}