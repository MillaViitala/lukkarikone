package com.example.lukkarikone.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuestionCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    //attribuutit
    private Long categoryId;
    private Category category;

    //konstruktorit
    public QuestionCategory() {
    }

    public QuestionCategory(Category categoryName) {
        super();
        this.category = categoryName;
    }

    //setterit ja getterit
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    //to-string
    @Override
    public String toString() {
        return "QuestionCategory [categoryId=" + categoryId + ", categoryName=" + category + "]";
    }

}
