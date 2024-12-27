package actions.dto;

import actions.entity.Student;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StudentDto {
	
	private Long id;
	
	private String name;
	
	public static StudentDto from(Student student) {
		return StudentDto.builder()
						.id(student.getId())
						.name(student.getName())
						.build();
	}
}
