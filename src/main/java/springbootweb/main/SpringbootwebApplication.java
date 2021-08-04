package springbootweb.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springbootweb.main.entity.Student;
import springbootweb.main.repository.StudentRepository;

@SpringBootApplication
public class SpringbootwebApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(SpringbootwebApplication.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public void run(String... args) throws Exception {
//        Student student1 = new Student("Doa","Lisa","lisacutegirl@gmail.com");
//        studentRepository.save(student1);
//
//        Student student2 = new Student("Sia","Ana","anacutegirl@gmail.com");
//        studentRepository.save(student2);
//
//        Student student3 = new Student("tony","stack","tonystack@gmail.com");
//        studentRepository.save(student3);
    }
}
