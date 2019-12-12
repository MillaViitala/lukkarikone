package com.example.lukkarikone.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String qtitle;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private QuestionCategory category;

    @JsonIgnoreProperties("questionId")
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<QuestionChoice> choices;

    @JsonIgnoreProperties("question")
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Answer> answers;

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

    public Set<QuestionChoice> getChoices() {
        return choices;
    }

    public void setChoices(Set<QuestionChoice> choices) {
        this.choices = choices;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question [id= " + id + ", qtitle=" + qtitle + ", category=" + category + "]";
    }

}
