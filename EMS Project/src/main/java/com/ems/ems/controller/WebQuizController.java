package com.ems.ems.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ems.ems.Domain.Quiz;
import com.ems.ems.service.QuestionService;
import com.ems.ems.service.QuizService;


@Controller
public class WebQuizController {

	@Autowired
	QuizService quizService;

	@Autowired
	QuestionService questionService;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/createQuiz", method = RequestMethod.GET)
	@PreAuthorize("isAuthenticated()")
	public String newQuiz(Map<String, Object> model) {
		return "createQuiz";
	}



	@RequestMapping(value = "/quiz/{quiz_id}", method = RequestMethod.GET)
	@PreAuthorize("permitAll")
	public ModelAndView getQuiz(@PathVariable long quiz_id) {
		Quiz quiz = quizService.find(quiz_id);

		ModelAndView mav = new ModelAndView();
		mav.addObject("quiz", quiz);
		mav.setViewName("quizView");

		return mav;
	}

	@RequestMapping(value = "/quiz/{quiz_id}/play", method = RequestMethod.GET)
	@PreAuthorize("permitAll")
	public ModelAndView playQuiz(@PathVariable long quiz_id) {
		Quiz quiz = quizService.find(quiz_id);

		ModelAndView mav = new ModelAndView();
		mav.addObject("quiz", quiz);
		mav.setViewName("playQuiz");

		return mav;
	}
}
