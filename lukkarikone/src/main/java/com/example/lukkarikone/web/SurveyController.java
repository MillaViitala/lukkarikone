package com.example.lukkarikone.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lukkarikone.domain.Question;
import com.example.lukkarikone.domain.QuestionRepository;


@Controller
public class SurveyController {

	@Autowired
	private QuestionRepository qrepository;

	// Näytä kaikki kysymykset
	@RequestMapping(value = "/questionlist")
	public String questionList(Model model) {
		model.addAttribute("questions", qrepository.findAll());
		return "questionlist";
	}

	// REST kysymyksille
	@RequestMapping(value = "/questions", method = RequestMethod.GET)
	public @ResponseBody List<Question> questionListRest() {
		return (List<Question>) qrepository.findAll();
	}
	
	// Lisää kysymys
    @RequestMapping(value = "/add")
    public String addQuestion(Model model){
    	model.addAttribute("question", new Question());
        return "addquestion";
    }     
    
    // Tallenna kysymys
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Question question){
        qrepository.save(question);
        return "redirect:questionlist";
    }   
    
    // Poista kysymys
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteQuestion(@PathVariable("id") Long questionId, Model model) {
    	qrepository.deleteById(questionId);
        return "redirect:../questionlist";
    }     
}