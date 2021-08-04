package springbootweb.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import springbootweb.main.entity.Student;
import springbootweb.main.entity.Users;
import springbootweb.main.service.UsersService;

import java.util.List;

@Controller
public class LoginController {

    private final UsersService usersService;

    public LoginController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/login")
    public String login(Model model){
        Users users = new Users();
        model.addAttribute("user",users);
        return "login";
    }
    @PostMapping("/login")
    public RedirectView loginSuccess(@ModelAttribute("student") Users users){
        boolean bool = this.usersService.checkExistUser(users);
        System.out.println(bool);
        return new RedirectView("/students");
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public RedirectView postRegister(@RequestParam("email") String email,@RequestParam("password") String password){
        Users users = new Users(email,password);
        this.usersService.saveUsers(users);
        return new RedirectView("/login");
    }
}
