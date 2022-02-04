package com.spring.SpringRESTful.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.SpringRESTful.Model.StudentExceptionHandler;

@ControllerAdvice
public class ControllersExceptions {
	@ExceptionHandler
	public ResponseEntity<StudentExceptionHandler> studentException(StudentException e) {
		StudentExceptionHandler studentExceptionHandler = new StudentExceptionHandler();
		studentExceptionHandler.setStatusCode(HttpStatus.NOT_FOUND.value());
		studentExceptionHandler.setTime(System.currentTimeMillis());
		studentExceptionHandler.setMessage(e.getMessage());
		return new ResponseEntity<StudentExceptionHandler>(studentExceptionHandler, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<StudentExceptionHandler> studentException(Exception e) {
		StudentExceptionHandler studentExceptionHandler = new StudentExceptionHandler();
		studentExceptionHandler.setStatusCode(HttpStatus.BAD_REQUEST.value());
		studentExceptionHandler.setTime(System.currentTimeMillis());
		studentExceptionHandler.setMessage(e.getMessage());
		return new ResponseEntity<StudentExceptionHandler>(studentExceptionHandler, HttpStatus.BAD_REQUEST);
	}
}
