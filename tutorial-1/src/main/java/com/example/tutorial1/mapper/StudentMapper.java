package com.example.tutorial1.mapper;

import com.example.tutorial1.DTO.StudentDto;
import com.example.tutorial1.model.Student;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface StudentMapper {
    StudentDto toStudentDto(Student student);
    Student toStudentModel(StudentDto student);

}
