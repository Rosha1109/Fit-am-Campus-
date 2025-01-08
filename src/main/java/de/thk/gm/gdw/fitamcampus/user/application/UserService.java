package de.thk.gm.gdw.fitamcampus.user.application;

import de.thk.gm.gdw.fitamcampus.user.domain.Users;
import de.thk.gm.gdw.fitamcampus.user.domain.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserService {
        @Autowired
    private UsersRepository usersRepository;

        private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register( String username, String password,String email) {
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        user.setEmail(email);
        return usersRepository.save(user);
    }
}
