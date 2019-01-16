package com.ems.ems.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ems.ems.controller.ErrorInfo;
import com.ems.ems.exceptions.ActionRefusedException;
import com.ems.ems.exceptions.InvalidParametersException;
import com.ems.ems.exceptions.InvalidTokenException;
import com.ems.ems.exceptions.ModelVerificationException;
import com.ems.ems.exceptions.ResourceUnavailableException;
import com.ems.ems.exceptions.UnauthorizedActionException;
import com.ems.ems.exceptions.UserAlreadyExistsException;

@ControllerAdvice("com.helen.assignment.controller")
public class RestExceptionHandler {

	@ExceptionHandler(UnauthorizedActionException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ResponseBody
	public ErrorInfo unauthorizedAction(HttpServletRequest req, Exception ex) {
		return new ErrorInfo(req.getRequestURL().toString(), ex, HttpStatus.UNAUTHORIZED.value());
	}

	@ExceptionHandler(UserAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	@ResponseBody
	public ErrorInfo userExists(HttpServletRequest req, Exception ex) {
		return new ErrorInfo(req.getRequestURL().toString(), ex, HttpStatus.CONFLICT.value());
	}

	@ExceptionHandler(ResourceUnavailableException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorInfo resourceUnavailable(HttpServletRequest req, Exception ex) {
		return new ErrorInfo(req.getRequestURL().toString(), ex, HttpStatus.NOT_FOUND.value());
	}

	@ExceptionHandler(ModelVerificationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorInfo modelVerificationError(HttpServletRequest req, Exception ex) {
		return new ErrorInfo(req.getRequestURL().toString(), ex, HttpStatus.BAD_REQUEST.value());
	}

	@ExceptionHandler(InvalidTokenException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorInfo invalidTokenError(HttpServletRequest req, Exception ex) {
		return new ErrorInfo(req.getRequestURL().toString(), ex, HttpStatus.BAD_REQUEST.value());
	}

	@ExceptionHandler(InvalidParametersException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorInfo invalidParametersError(HttpServletRequest req, Exception ex) {
		return new ErrorInfo(req.getRequestURL().toString(), ex, HttpStatus.BAD_REQUEST.value());
	}

	@ExceptionHandler(ActionRefusedException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ResponseBody
	public ErrorInfo actionRefusedError(HttpServletRequest req, Exception ex) {
		return new ErrorInfo(req.getRequestURL().toString(), ex, HttpStatus.FORBIDDEN.value());
	}
}
