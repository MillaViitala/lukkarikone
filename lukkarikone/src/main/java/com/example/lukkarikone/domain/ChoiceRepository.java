package com.example.lukkarikone.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ChoiceRepository extends CrudRepository<QuestionChoice, Long> {

    List<QuestionChoice> findByText(String text);

    List<QuestionChoice> findByQuestion(Question question);
}
