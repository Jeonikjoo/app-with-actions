package actions.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@PostMapping("/students")
	public StudentDto insertStudent(String sname) {
		StudentDto student = studentService.insertStudent(sname);
		return student;
	}
	
	@PutMapping("/students/{sid}")
	public StudentDto updateStudent(@PathVariable Long sid, String sname) {

		StudentDto student = studentService.updateStudent(sid, sname);
		return student;
	} 
	
	
	@DeleteMapping("/students/{sid}")
	public void deleteStudent(@PathVariable Long sid) {
		studentService.deleteStudent(sid);
	}
}
