package com.example.tutorial1.mapper;

import com.example.tutorial1.Address;
import com.example.tutorial1.DTO.StudentDto;
import com.example.tutorial1.Gender;
import com.example.tutorial1.model.Student;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-18T19:34:59+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentDto toStudentDto(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDto studentDto = new StudentDto();

        studentDto.setId( student.getId() );
        studentDto.setFirstName( student.getFirstName() );
        studentDto.setLastName( student.getLastName() );
        studentDto.setEmail( student.getEmail() );
        studentDto.setGender( student.getGender() );
        studentDto.setAddress( student.getAddress() );
        List<String> list = student.getFavouriteSubjects();
        if ( list != null ) {
            studentDto.setFavouriteSubjects( new ArrayList<String>( list ) );
        }
        studentDto.setTotalSpentInBooks( student.getTotalSpentInBooks() );
        studentDto.setCreated( student.getCreated() );

        return studentDto;
    }

    @Override
    public Student toStudentModel(StudentDto student) {
        if ( student == null ) {
            return null;
        }

        String firstName = null;
        String lastName = null;
        String email = null;
        Gender gender = null;
        Address address = null;
        List<String> favouriteSubjects = null;
        BigDecimal totalSpentInBooks = null;
        LocalDateTime created = null;

        firstName = student.getFirstName();
        lastName = student.getLastName();
        email = student.getEmail();
        gender = student.getGender();
        address = student.getAddress();
        List<String> list = student.getFavouriteSubjects();
        if ( list != null ) {
            favouriteSubjects = new ArrayList<String>( list );
        }
        totalSpentInBooks = student.getTotalSpentInBooks();
        created = student.getCreated();

        Student student1 = new Student( firstName, lastName, email, gender, address, favouriteSubjects, totalSpentInBooks, created );

        student1.setId( student.getId() );

        return student1;
    }
}
