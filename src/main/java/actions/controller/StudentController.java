package actions.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import actions.dto.StudentDto;
import actions.service.StudentService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class StudentController {
	private final StudentService studentService;
	
	@GetMapping("/students")
	public List<StudentDto> getAllStudent() {
		
		List<StudentDto> students = studentService.getAllStudent();
		
		return students;
	}
	
	@GetMapping("/students/{sid}")
	public StudentDto getStudent(@PathVariable Long sid) {
		
		StudentDto student = studentService.getStudent(sid);
		
		return student;
	}
}
