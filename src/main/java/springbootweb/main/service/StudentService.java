package springbootweb.main.service;

import springbootweb.main.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();

    Student saveStudent(Student student);

    Student getStudentById(Long id);

    Student updateStudent(Student student);

    int deleteStudent(Student student);
}
