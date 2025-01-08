package de.thk.gm.gdw.fitamcampus.user.application;


import de.thk.gm.gdw.fitamcampus.user.domain.Users;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value="/api/v1",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class UserRestController {

    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public Users register(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam String email){
        return userService.register(username,password,email);
    }
}
