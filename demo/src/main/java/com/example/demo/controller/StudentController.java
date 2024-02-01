package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ApiResponse;
import com.example.demo.Service.StudentService;
import com.example.demo.entity.Student;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/getStudentDetails/{studentId}")
	public ResponseEntity<?> getStudentDetails(@PathVariable Long studentId) throws Exception {
		return ResponseEntity.ok().body(new ApiResponse(studentService.getStudentDetails(studentId).toString()));
	}

	@PostMapping("/registerStudentDetails")
	public ResponseEntity<?> registerStudentDetails(@RequestBody Student student) {
		return ResponseEntity.ok().body(new ApiResponse(studentService.registerStudentDetails(student)));
	}

	@PutMapping("/updateStudentDetails")
	public ResponseEntity<?> updateStudentDetails(@RequestBody Student entity) throws Exception {
		return ResponseEntity.ok().body(new ApiResponse(studentService.updateStudentDetails(entity)));
	}
	@DeleteMapping("/deleteStudentEntry/{studentId}")
	public ResponseEntity<?> deleteStudentEntry(@PathVariable Long studentId) {
		return ResponseEntity.ok().body(new ApiResponse(studentService.deleteStudentEntry(studentId)));
	}
	
}
