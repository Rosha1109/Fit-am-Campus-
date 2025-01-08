package de.thk.gm.gdw.fitamcampus.user.application;

import de.thk.gm.gdw.fitamcampus.user.domain.UserPrincipal;
import de.thk.gm.gdw.fitamcampus.user.domain.Users;
import de.thk.gm.gdw.fitamcampus.user.domain.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByUsername(username);
        if (user == null) {
            System.out.println("user not found");
            throw new UsernameNotFoundException("user not found");
        }
        System.out.println("user found "+username);
        return new UserPrincipal(user);
    }
}
