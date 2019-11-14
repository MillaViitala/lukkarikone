package com.example.lukkarikone.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long answerId;
	private String text;
	
	@JoinColumn(name = "id")
	private Question Id;
	
	public Answer() {
		
	}
	
	public Answer(String text) {
		super();
		this.text = text;
		
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

	public Question getId() {
		return Id;
	}

	public void setQuestion(Question Id) {
		this.Id = Id;
	}

	@Override
	public String toString() {
		return "Answer [id=" + answerId + ", text=" + text + ", QuestionId=" + Id + "]";
	}

}
