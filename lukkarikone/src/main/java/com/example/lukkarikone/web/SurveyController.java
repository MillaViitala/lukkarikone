package com.example.lukkarikone.web;

import com.example.lukkarikone.domain.CategoryRepository;
import com.example.lukkarikone.domain.ChoiceRepository;
import com.example.lukkarikone.domain.Question;
import com.example.lukkarikone.domain.QuestionCategory;
import com.example.lukkarikone.domain.QuestionChoice;
import com.example.lukkarikone.domain.QuestionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
public class SurveyController {

    @Autowired
    private QuestionRepository qrepository;
    @Autowired
    private ChoiceRepository choicerepo;
    @Autowired
    private CategoryRepository categoryrepo;

    // REST homepage
    @RequestMapping(value = "/homepage")
    public String homePage(Model model) {
        return "homepage";
    }

    // REST kysymyksille
    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public @ResponseBody
    List<Question> questionListRest() {
        return (List<Question>) qrepository.findAll();
    }

    // Hae kysymys
    @RequestMapping(value = "/questions/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Question> getQuestion(@PathVariable("id") Long questionId, Model model) {
        return qrepository.findById(questionId);
    }

    //update: tallenna kysymys
    @PostMapping(value = "/questions", consumes = "application/json")
    public ResponseEntity saveQuestion(@RequestBody Question question, Model model) {
        QuestionCategory category = categoryrepo.findByCategory(question.getCategory().getCategory());
        qrepository.save(new Question(question.getQtitle(), category));
        return new ResponseEntity<>("Question created!", HttpStatus.OK);
    }

    // Poista kysymys
    @DeleteMapping(value = "/questions/{id}")
    public ResponseEntity deleteQuestion(@PathVariable("id") Long questionId, Model model) {
        qrepository.deleteById(questionId);
        return new ResponseEntity<>("Question with id: " + questionId + " deleted!", HttpStatus.OK);
    }

    // Muokkaa kysymystä
    @RequestMapping(value = "/questions/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity editQuestion(@PathVariable("id") Long questionId, @RequestBody Question question, Model model) {
        model.addAttribute("question", qrepository.findById(questionId));
        Question q = qrepository.findById(questionId).get();
        q.setQtitle(question.getQtitle());
        qrepository.save(q);
        return new ResponseEntity<>("Question updated!", HttpStatus.OK);
    }

    // Hae vaihtoehdot
    @RequestMapping(value = "questions/{questionId}/choices", method = RequestMethod.GET)
    public @ResponseBody
    List<QuestionChoice> getChoices(@PathVariable("questionId") Long questionId) {
        Question question = new Question();
        question.setId(questionId);
        return choicerepo.findByQuestion(question);
    }

    //tallenna vaihtoehto
    @RequestMapping(value = "/questions/{questionId}/choices", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity saveChoice(@PathVariable("questionId") Long questionId, @RequestBody QuestionChoice choice) {
        Question question = qrepository.findById(questionId).get();
        choice.setQuestion(question);
        choicerepo.save(choice);
        return new ResponseEntity<>("Choice added!", HttpStatus.OK);
    }

    //poista vaihtoehto
    @DeleteMapping(value = "/questions/{id}/choices/{choiceId}")
    public ResponseEntity deleteChoice(@PathVariable("id") Long questionId, @PathVariable("choiceId") Long choiceId, Model model) {
        Question question = qrepository.findById(questionId).get();
        List<QuestionChoice> choices = choicerepo.findByQuestion(question);
        QuestionChoice choice = choicerepo.findById(choiceId).get();
        if (choices.contains(choice)) {
            choicerepo.deleteById(choiceId);
            return new ResponseEntity<>("Choice: " + choice.getText() + " deleted!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Choice does not exist in this question!", HttpStatus.NOT_FOUND);
        }
    }

}
