package springbootweb.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import springbootweb.main.entity.Student;
import springbootweb.main.service.StudentService;


@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listStudent(Model model) {
        model.addAttribute("students", studentService.getAllStudent());
        return "students";
    }

    @GetMapping("/students/new")
    public String addStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable Long id,Model model){
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit_student";
    }

    @GetMapping("/students/{id}")
    public RedirectView deleteStudent(@PathVariable Long id){
        Student deleteStudent = studentService.getStudentById(id);
        int result  = studentService.deleteStudent(deleteStudent);
        return new RedirectView("/students");
    }
    @PostMapping("/students")
    public RedirectView saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return new RedirectView("/students");
    }
    @PostMapping("/students/{id}")
    public RedirectView  updateStudent(@PathVariable Long id,@ModelAttribute("student") Student student){

        // get Student from database by Id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        // save update student object
        studentService.updateStudent(existingStudent);
        return new RedirectView("/students");
    }

}
