package com.example.lukkarikone.web;

import com.example.lukkarikone.domain.Answer;
import java.util.List;
import com.example.lukkarikone.domain.AnswerRepository;
import com.example.lukkarikone.domain.Question;
import com.example.lukkarikone.domain.QuestionRepository;



import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public @ResponseBody List<Answer> getAnswer(@PathVariable ("questionId") Long questionId) {
		Question question = new Question();
		question.setId(questionId);
		return arepository.findByQuestion(question);
		
	}
	
	// Tallenna vastaus 

	@RequestMapping(value = "/questions/{questionId}/answers", method = RequestMethod.POST)
	public @ResponseBody Answer saveAnswerRest(@PathVariable("questionId") Long questionId, @RequestBody Answer answer) {
		Optional<Question> question = qrepository.findById(questionId);
		answer.setQuestion(question.get());
		return arepository.save(answer);
		}
	

	
	
}
