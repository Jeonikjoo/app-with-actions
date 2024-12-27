package actions.entity;

import actions.dto.StudentDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Student {
	@Id
	@Column(name = "sid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "sname")
	private String name;
	
	public static StudentDto toDto(Student student) {
		return StudentDto.builder()
				.id(student.getId())
				.name(student.getName())
				.build();
	}
}
