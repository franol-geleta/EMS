package com.ems.ems.service;

import java.util.List;

import com.ems.ems.Domain.Answer;
import com.ems.ems.Domain.Question;
import com.ems.ems.exceptions.ResourceUnavailableException;
import com.ems.ems.exceptions.UnauthorizedActionException;

public interface AnswerService {
	Answer save(Answer answer) throws UnauthorizedActionException;

	Answer find(Long id) throws ResourceUnavailableException;

	Answer update(Answer newAnswer) throws UnauthorizedActionException, ResourceUnavailableException;

	void delete(Answer answer) throws UnauthorizedActionException, ResourceUnavailableException;

	List<Answer> findAnswersByQuestion(Question question);

	int countAnswersInQuestion(Question question);
}
