package de.thk.gm.gdw.fitamcampus.user.application;


import de.thk.gm.gdw.fitamcampus.user.domain.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(produces={MediaType.TEXT_HTML_VALUE})
public class UserController {
    @Autowired
    UserRestController userController;

    @GetMapping("/")
    public String showStartPage(){
        return "start";
    }


    @PostMapping("/register")
    public String register(@RequestParam String email,
                           @RequestParam String username,
                           @RequestParam String password){
        userController.register(username,password,email);
        System.out.println(username+" registered");
        return "redirect:/login";
    }
    @GetMapping("/register")
    public String showRegisterPage(){
        return "/user/regristration";
    }
}
