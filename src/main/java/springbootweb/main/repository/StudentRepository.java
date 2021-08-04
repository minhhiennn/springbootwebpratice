package springbootweb.main.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springbootweb.main.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query(value = "select s from Student s")
    List<Student> getAllStudent(Sort sort);
}
