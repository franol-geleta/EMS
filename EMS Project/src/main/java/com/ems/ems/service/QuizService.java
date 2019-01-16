package com.ems.ems.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ems.ems.Domain.Quiz;
import com.ems.ems.Domain.Response;
import com.ems.ems.Domain.Result;
import com.ems.ems.Domain.User;
import com.ems.ems.exceptions.ResourceUnavailableException;
import com.ems.ems.exceptions.UnauthorizedActionException;


public interface QuizService {
	Quiz save(Quiz quiz, User user);

	Page<Quiz> findAll(Pageable pageable);

	Page<Quiz> findAllPublished(Pageable pageable);

	Page<Quiz> findQuizzesByUser(User user, Pageable pageable);

	Quiz find(Long id) throws ResourceUnavailableException;

	Quiz update(Quiz quiz) throws ResourceUnavailableException, UnauthorizedActionException;

	void delete(Quiz quiz) throws ResourceUnavailableException, UnauthorizedActionException;

	Page<Quiz> search(String query, Pageable pageable);

	Result checkAnswers(Quiz quiz, List<Response> answersBundle);

	void publishQuiz(Quiz quiz);



	
}
