package com.example.lukkarikone;

import com.example.lukkarikone.domain.Category;
import com.example.lukkarikone.domain.CategoryRepository;
import com.example.lukkarikone.domain.ChoiceRepository;
import com.example.lukkarikone.domain.Question;
import com.example.lukkarikone.domain.QuestionCategory;
import com.example.lukkarikone.domain.QuestionChoice;
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
    public CommandLineRunner surveyDemo(QuestionRepository qrepository, CategoryRepository catrepo, ChoiceRepository chorepo) {
        return (args) -> {

            QuestionCategory checkbox = new QuestionCategory(Category.checkbox);
            QuestionCategory radiobox = new QuestionCategory(Category.radiobox);
            QuestionCategory textbox = new QuestionCategory(Category.textbox);

            if (!catrepo.findAll().iterator().hasNext()) {
                log.info("save categories");

                catrepo.save(checkbox);
                catrepo.save(radiobox);
                catrepo.save(textbox);
            }

            log.info("save questions");
            if (!qrepository.findAll().iterator().hasNext()) {
                Question one = new Question("Monennellako vuosikurssilla opiskelet?", radiobox);
                qrepository.save(one);

                chorepo.save(new QuestionChoice("1", one));
                chorepo.save(new QuestionChoice("2", one));
                chorepo.save(new QuestionChoice("3", one));
                chorepo.save(new QuestionChoice("4", one));

                Question two = new Question("Millä seuraavista mieluiten etsit kurssin ajankohdan lukkarikoneesta:", checkbox);
                qrepository.save(two);

                chorepo.save(new QuestionChoice("Opettajan nimi", two));
                chorepo.save(new QuestionChoice("Kurssin nimi", two));
                chorepo.save(new QuestionChoice("Kurssitunnus", two));
                chorepo.save(new QuestionChoice("Ryhmätunnus", two));
                chorepo.save(new QuestionChoice("Kurssin ajankohta, eli milloin kurssi alkaa", two));

                Question three = new Question("Kuinka työlääksi koet palvelun käyttämisen?", radiobox);
                qrepository.save(three);

                chorepo.save(new QuestionChoice("Ei yhtään työlääksi", three));
                chorepo.save(new QuestionChoice("Hieman työläs", three));
                chorepo.save(new QuestionChoice("En osaa sanoa", three));
                chorepo.save(new QuestionChoice("Työläs", three));
                chorepo.save(new QuestionChoice("Erittäin työläs", three));

                Question four = new Question("Kuinka nopeasti/tehokkaasti saat suoritettua halutun lopputuloksen palvelusta?", radiobox);
                qrepository.save(four);

                chorepo.save(new QuestionChoice("Erittäin nopeasti", four));
                chorepo.save(new QuestionChoice("Nopeasti", four));
                chorepo.save(new QuestionChoice("En osaa sanoa", four));
                chorepo.save(new QuestionChoice("Hitaasti", four));
                chorepo.save(new QuestionChoice("Erittäin hitaasti", four));

                Question five = new Question("Vapaa palaute nykyisestä palvelusta:", textbox);
                qrepository.save(five);
            }

            log.info("get all questions");
            for (Question question : qrepository.findAll()) {
                log.info(question.toString());
            }

        };
    }

}
