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
    private String categoryName;

    //konstruktorit
    public QuestionCategory() {
    }

    public QuestionCategory(Long categoryId, String categoryName) {
        super();
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    //setterit ja getterit
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    //to-string
    @Override
    public String toString() {
        return "QuestionCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
    }

}
