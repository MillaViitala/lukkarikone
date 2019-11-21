package com.example.lukkarikone.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
	
	List<Question> findByQtitle(String qtitle);

	Optional<Question> findById(Long id);

}
