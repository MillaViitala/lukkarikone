package com.example.lukkarikone.web;

import com.example.lukkarikone.domain.Question;
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
        qrepository.save(new Question(question.getQtitle()));
        return new ResponseEntity<>("Question created!", HttpStatus.OK);
    }

    // Poista kysymys
    @DeleteMapping(value = "/questions/{id}")
    public ResponseEntity deleteQuestion(@PathVariable("id") Long questionId, Model model) {
        qrepository.deleteById(questionId);
        return new ResponseEntity<>("Question with id: " + questionId + " deleted!", HttpStatus.OK);
    }
    
    // Muokkaa kysymystä
    /*@RequestMapping(value = "/question/{id}", consumes = "application/json")
    public ResponseEntity editQuestion(@PathVariable("id") Long questionId, Model model) {
    	model.addAttribute("question", qrepository.findById(questionId));
    	Question q = qrepository.findById(questionId);
    	q.setQtitle(qtitle);
    	qrepository.save(q);
    	return new ResponseEntity<>("Question updated!", HttpStatus.OK);
    }
   */ 
    
}
