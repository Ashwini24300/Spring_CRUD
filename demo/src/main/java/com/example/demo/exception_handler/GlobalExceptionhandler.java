package com.example.demo.exception_handler;

// import java.util.List;
// import java.util.Map;
// import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.DTO.ApiResponse;



@RestControllerAdvice // to tell SC following is centralized custom exc handler ,
//to provide COMMON ADVICE to all rest controllers regarding exc handling
public class GlobalExceptionhandler {

	
	// add exc handling method : 
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception e) {
		System.out.println("in catch-all  exc");
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
	}

}
