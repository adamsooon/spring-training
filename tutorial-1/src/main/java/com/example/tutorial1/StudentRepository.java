package com.example.tutorial1;

import com.example.tutorial1.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends
        MongoRepository<Student, String> {
}
