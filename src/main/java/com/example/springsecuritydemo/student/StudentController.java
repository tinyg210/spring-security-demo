package com.example.springsecuritydemo.student;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

  private static final List<Student> students = Arrays
      .asList(new Student(1L, "James Bond", "jb@email.com", StudentType.LOCAL),
          new Student(2L, "Maria Jones", "mj@email.com", StudentType.LOCAL),
          new Student(3L, "Anna Smith", "as@email.com", StudentType.EXCHANGE)
      );

  @GetMapping(path = "/{id}")
  public Student getStudent(@PathVariable("id") Long id) {
    return students.stream().filter(student -> id.equals(student.getId())).findFirst()
        .orElseThrow(() -> new IllegalStateException("Student does not exist"));
  }
}
