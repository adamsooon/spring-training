package com.example.tutorial1;

import com.example.tutorial1.DTO.StudentDto;
import com.example.tutorial1.mapper.StudentMapper;
import com.example.tutorial1.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @GetMapping("api/v1/students")
    public List<Student> fetchAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("api/v1/students/{id}")
    public Optional<Student> fetchStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("api/v1/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteStudentById(@PathVariable String id) {
        return studentService.deleteStudentById(id);
    }

    @PostMapping("api/v1/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudent(@Valid @RequestBody StudentDto studentDto) {
        Student student = studentMapper.toStudentModel(studentDto);
        student.setCreated(LocalDateTime.now());
        return studentService.addStudent(student);
    }

    @PatchMapping("api/v1/student/{id}")
    public Student editStudent(@RequestBody StudentDto studentDto, @PathVariable("id") String id) {
        Student student = studentMapper.toStudentModel(studentDto);
        return studentService.editStudent(student, id);
    }


}
