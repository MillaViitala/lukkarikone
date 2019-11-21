package com.example.lukkarikone.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long answerId;
	private String text;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Question question;
	
	public Answer() {
		
	}
	
	public Answer(String text, Question question) {
		super();
		this.text = text;
		this.question = question;
		
	}

	public Long getAnswerId() {
		return answerId;
	}

	public void setId(Long answerId) {
		this.answerId = answerId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestionById(Question id) {
		this.question = id;
	}

	@Override
	public String toString() {
		return "Answer [id=" + answerId + ", text=" + text + ", QuestionId=" + question + "]";
	}

}
