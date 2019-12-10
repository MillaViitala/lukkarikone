package com.example.lukkarikone.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class QuestionChoice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long choiceId;
	private String text;
        
        @ManyToOne
        @JoinColumn(name="id")
        private Question question;
	
	public QuestionChoice() {
	}
	
	public QuestionChoice(String text, Question question) {
		super();
		this.text = text;
                this.question = question;
		
	}

	public Long getChoiceId() {
		return choiceId;
	}

	public void setId(Long choiceId) {
		this.choiceId = choiceId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Question getQuestionId() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}


	@Override
	public String toString() {
		return "QuestionChoice id=" + choiceId + ", text=" + text + "]";
	}

}
