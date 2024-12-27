package actions.service;

import java.util.List;

import org.springframework.stereotype.Service;

import actions.dto.StudentDto;
import actions.entity.Student;
import actions.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentService {
	
	private final StudentRepository studentRepository;

	public List<StudentDto> getAllStudent() {
		return studentRepository.findAll().stream().map(Student::toDto).toList();
	}

	public StudentDto getStudent(Long sid) {
		
		return studentRepository.findById(sid).map(Student::toDto).orElseThrow();
	}

	@Transactional
	public StudentDto insertStudent(String sname) {
		
		Student student = studentRepository.save(Student.of(sname));
	
		return student.toDto(student);
	}
	
	@Transactional
	public StudentDto updateStudent(Long sid, String sname) {
		
		Student student = studentRepository.findById(sid).orElseThrow();
		student.updateStudentName(sname);

		return student.toDto(student);
	}

	

	
}
