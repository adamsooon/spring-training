package com.example.tutorial1;

import com.example.tutorial1.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    public String deleteStudentById(String id) {
        studentRepository.deleteById(id);
        return "Student deleted successfully";
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student editStudent(Student newStudent, String id) {
        Student student = studentRepository.findById(id).get();
        if (newStudent.getGender() != null) {
            student.setGender(newStudent.getGender());
        }
        if (newStudent.getEmail() != null) {
            student.setEmail(newStudent.getEmail());
        }
        if (newStudent.getFirstName() != null) {
            student.setFirstName(newStudent.getFirstName());
        }
        if (newStudent.getLastName() != null) {
            student.setLastName(newStudent.getLastName());
        }
        if (newStudent.getFavouriteSubjects() != null) {
            student.setFavouriteSubjects(newStudent.getFavouriteSubjects());
        }
        if (newStudent.getAddress() != null) {
            student.setAddress(newStudent.getAddress());
        }

        return studentRepository.save(student);
    }
}
