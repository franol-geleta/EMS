package com.ems.ems.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.ems.Domain.Quiz;
import com.ems.ems.Domain.Response;
import com.ems.ems.Domain.Result;
import com.ems.ems.Domain.User;
import com.ems.ems.exceptions.ResourceUnavailableException;
import com.ems.ems.exceptions.UnauthorizedActionException;
import com.ems.ems.repository.QuizRepository;

@Service("QuizService")
@Transactional
public class QuizServiceImpl implements QuizService {

	private static final Logger logger = LoggerFactory.getLogger(QuizServiceImpl.class);
	private QuizRepository quizRepository;

	private QuestionService questionService;

	@Autowired
	public QuizServiceImpl(QuizRepository quizRepository, QuestionService questionService) {
		this.quizRepository = quizRepository;
		this.setQuestionService(questionService);
	}

	@Override
	public Quiz save(Quiz quiz, User user) {
		quiz.setCreatedBy(user);
		return quizRepository.save(quiz);
	}

	@Override
	public Page<Quiz> findAll(Pageable pageable) {
		return quizRepository.findAll(pageable);
	}

	@Override
	public Page<Quiz> findAllPublished(Pageable pageable) {
		return quizRepository.findByIsPublishedTrue(pageable);
	}

	@Override
	public Quiz find(Long id) throws ResourceUnavailableException {
		Quiz quiz = quizRepository.findOne(id);

		if (quiz == null) {
			logger.error("Quiz " + id + " not found");
			throw new ResourceUnavailableException("Quiz " + id + " not found");
		}

		return quiz;
	}

	@Override
	public Quiz update(Quiz newQuiz) throws UnauthorizedActionException, ResourceUnavailableException {
		Quiz currentQuiz = find(newQuiz.getId());

		mergeQuizzes(currentQuiz, newQuiz);
		return quizRepository.save(currentQuiz);
	}

	@Override
	public void delete(Quiz quiz) throws ResourceUnavailableException, UnauthorizedActionException {
		quizRepository.delete(quiz);
	}

	private void mergeQuizzes(Quiz currentQuiz, Quiz newQuiz) {
		currentQuiz.setName(newQuiz.getName());
		currentQuiz.setDescription(newQuiz.getDescription());
	}

	@Override
	public Page<Quiz> search(String query, Pageable pageable) {
		return quizRepository.searchByName(query, pageable);
	}

	@Override
	public Page<Quiz> findQuizzesByUser(User user, Pageable pageable) {
		return quizRepository.findByCreatedBy(user, pageable);
	}

	@Override
	public Result checkAnswers(Quiz quiz, List<Response> answersBundle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void publishQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		
	}

	public QuestionService getQuestionService() {
		return questionService;
	}

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	

}
