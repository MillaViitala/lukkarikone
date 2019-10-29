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
			
			qrepository.save(new Question("Monennellako vuosikurssilla olet?"));
			qrepository.save(new Question("Millä seuraavista mieluiten etsit kurssin ajankohdan lukkarikoneesta: (Monivalinta -vaihtoehdot tulossa)"));
			qrepository.save(new Question("Kuinka työlääksi koet palvelun käyttämisen? (Monivalinta)"));
			qrepository.save(new Question("Kuinka nopeasti/tehokkaasti saat suoritettua halutun lopputuloksen palvelusta? (Monivalinta)"));
			qrepository.save(new Question("Vapaa palaute nykyisestä palvelusta/risut ja ruusut (Avoin boksi)"));
			
			log.info("get all questions");
			for (Question question : qrepository.findAll()) {
				log.info(question.toString());
			}

		};
	}


}
