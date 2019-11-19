package com.example.lukkarikone.web;

import com.example.lukkarikone.domain.Answer;

import com.example.lukkarikone.domain.AnswerRepository;

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
	
	// Hae vastaukset kysymykselle
	
	@RequestMapping(value = "questions/{questionId}/answers", method = RequestMethod.GET)
	public @ResponseBody Optional<Answer> getAnswer(@PathVariable ("id") Long answerId, Model model) {
		
		return arepository.findById(answerId);
		
	}
	
	// Tallenna vastaus
	
	@PostMapping(value = "/questions/{questionId}/answers", consumes = "application/json")
    public ResponseEntity saveAnswer(@RequestBody Answer answer, Model model) {
        arepository.save(answer);
        return (ResponseEntity) arepository;
    }
	
	
}
