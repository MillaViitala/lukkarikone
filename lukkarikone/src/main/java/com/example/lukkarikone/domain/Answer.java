package com.example.lukkarikone.domain;

public class Answer {

	private Long id;
	private String text;
	private int QuestionId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getQuestionId() {
		return QuestionId;
	}

	public void setQuestionId(int questionId) {
		QuestionId = questionId;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", text=" + text + ", QuestionId=" + QuestionId + "]";
	}

}
