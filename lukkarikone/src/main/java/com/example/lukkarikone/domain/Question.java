package com.example.lukkarikone.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String qtitle;

	public Question() {

	}

	public Question(String qtitle) {
		super();
		this.qtitle = qtitle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQtitle() {
		return qtitle;
	}

	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}

	@Override
	public String toString() {
		return "Question [qtitle=" + qtitle + "]";
	}

}
