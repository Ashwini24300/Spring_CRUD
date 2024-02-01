package com.example.demo.DTO;

import java.time.LocalDateTime;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter

// Generic response from the server.
public class ApiResponse {

	// message to return to client.
	private String message;
	
	// timestamp of the action.
	private LocalDateTime timestamp;

	public ApiResponse(String message) {
		this.message = message;
		this.timestamp = LocalDateTime.now();

	}
}
