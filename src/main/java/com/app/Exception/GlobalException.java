package com.app.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {
	
	
	
//	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	+                                                                                +
//	+                            ProjectsException Handler                           +
//	+                                                                                +
//	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	
	
	
	
	@ExceptionHandler(ProjectsException.class)
	public ResponseEntity<MyErrorDetails> projectsExceptionHandler(ProjectsException pe, WebRequest wr)
	{
		
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), pe.getMessage(), wr.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	
	
	
	
	
	   //-------------------------------------------------------------------------//
	   //								GLOBAL EXCEPTIONS
	   //-------------------------------------------------------------------------//


 //	if any logical error happens than this exception will be thrown.

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> logicalHandler(Exception e, WebRequest wr){
	
		System.out.println("Inside the Exception Handler...");
		
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
			
 }

	
	
	

	   //-------------------------------------------------------------------------//
	   //								WRONG URI EXCEPTIONS
	   //-------------------------------------------------------------------------//
	
	
 //	if user passes wrong uri than this exception will be thrown automatically by spring boot
	
	   @ExceptionHandler(NoHandlerFoundException.class)
 public ResponseEntity<MyErrorDetails> wrongApiHandler(NoHandlerFoundException e, WebRequest wr){
		
		  System.out.println("Inside the NoHandlerFoundException Handler...");
		
		  MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
		
		  return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		
	   }

	

}
