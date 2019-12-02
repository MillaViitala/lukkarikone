package com.example.lukkarikone.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String qtitle;

    @OneToMany
    @JoinColumn(name = "categoryId")
    private QuestionCategory category;

    public Question() {
    }

    public Question(String qtitle) {
        super();
        this.qtitle = qtitle;
    }

    public Question(String qtitle, QuestionCategory category) {
        super();
        this.qtitle = qtitle;
        this.category = category;
    }

    public QuestionCategory getCategory() {
        return category;
    }

    public void setCategory(QuestionCategory category) {
        this.category = category;
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
        return "Question [id= " + id + ", qtitle=" + qtitle + "category" + category + "]";
    }

}
