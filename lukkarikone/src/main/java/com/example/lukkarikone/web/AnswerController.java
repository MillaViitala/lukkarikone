package com.example.lukkarikone.web;

import com.example.lukkarikone.domain.Answer;
import com.example.lukkarikone.domain.AnswerRepository;
import com.example.lukkarikone.domain.Question;
import com.example.lukkarikone.domain.QuestionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
public class AnswerController {

    @Autowired
    private AnswerRepository arepository;
    @Autowired
    private QuestionRepository qrepository;

    // Hae vastaukset kysymykselle
    @RequestMapping(value = "questions/{questionId}/answers", method = RequestMethod.GET)
    public @ResponseBody
    List<Answer> getAnswer(@PathVariable("questionId") Long questionId) {
        Question question = new Question();
        question.setId(questionId);
        return arepository.findByQuestion(question);

    }

    // Tallenna vastaus
    @RequestMapping(value = "/questions/{questionId}/answers", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity saveAnswerRest(@PathVariable("questionId") Long questionId, @RequestBody Answer answer) {
        Question question = qrepository.findById(questionId).get();
        answer.setQuestion(question);
        arepository.save(answer);
        return new ResponseEntity<>("Choice added!", HttpStatus.OK);
    }

}
