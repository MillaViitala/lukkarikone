package com.example.lukkarikone;

import com.example.lukkarikone.domain.Category;
import com.example.lukkarikone.domain.CategoryRepository;
import com.example.lukkarikone.domain.Question;
import com.example.lukkarikone.domain.QuestionCategory;
import com.example.lukkarikone.domain.QuestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LukkarikoneApplication {

    private static final Logger log = LoggerFactory.getLogger(LukkarikoneApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LukkarikoneApplication.class, args);
    }

    @Bean
    public CommandLineRunner surveyDemo(QuestionRepository qrepository, CategoryRepository catrepo) {
        return (args) -> {

            log.info("save categories");
            
            QuestionCategory cat1 = new QuestionCategory(Category.checkbox);
            QuestionCategory cat2 = new QuestionCategory(Category.radiobox);
            QuestionCategory cat3 = new QuestionCategory(Category.textbox);
            
            catrepo.save(cat1);
            catrepo.save(cat2);
            catrepo.save(cat3);
            
            log.info("save questions");
            Question one = new Question("Monennellako vuosikurssilla olet?");
            qrepository.save(one);
            Question two = new Question("Millä seuraavista mieluiten etsit kurssin ajankohdan lukkarikoneesta: (Monivalinta -vaihtoehdot tulossa)");
            qrepository.save(two);
            Question three = new Question("Kuinka työlääksi koet palvelun käyttämisen? (Monivalinta)");
            qrepository.save(three);
            Question four = new Question("Kuinka nopeasti/tehokkaasti saat suoritettua halutun lopputuloksen palvelusta? (Monivalinta)");
            qrepository.save(four);
            Question five = new Question("Vapaa palaute nykyisestä palvelusta/risut ja ruusut (Avoin boksi)");
            qrepository.save(five);

            log.info("get all questions");
            for (Question question : qrepository.findAll()) {
                log.info(question.toString());
            }

        };
    }

}
