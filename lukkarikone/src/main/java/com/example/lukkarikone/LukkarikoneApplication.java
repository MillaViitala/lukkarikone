package com.example.lukkarikone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.lukkarikone.domain.Question;
import com.example.lukkarikone.domain.QuestionRepository;

@SpringBootApplication
public class LukkarikoneApplication {
	
	private static final Logger log = LoggerFactory.getLogger(LukkarikoneApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LukkarikoneApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner surveyDemo(QuestionRepository qrepository) {
		return (args) -> {
			log.info("save questions");
			
			qrepository.save(new Question("Kysymys 1"));
			qrepository.save(new Question("Kysymys 2"));
			qrepository.save(new Question("Kysymys 3"));
			qrepository.save(new Question("Kysymys 4"));
			qrepository.save(new Question("Kysymys 5"));
			
			log.info("get all questions");
			for (Question question : qrepository.findAll()) {
				log.info(question.toString());
			}

		};
	}


}
