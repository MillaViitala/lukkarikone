package com.example.lukkarikone.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long>{

	List<Answer> findByText(String text);
}
