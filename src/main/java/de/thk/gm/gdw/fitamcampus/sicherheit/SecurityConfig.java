package de.thk.gm.gdw.fitamcampus.sicherheit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        http
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**", "/register").permitAll() // Zugriff auf H2-Konsole erlauben
                        .anyRequest().authenticated())
                .formLogin(form -> form.defaultSuccessUrl("/sportTreffen"))
                .logout(form -> form.logoutSuccessUrl("/login"))
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));


        return http.build();

          /*  http
                    .csrf(csrf -> csrf.disable())
                    .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()))
                    .authorizeHttpRequests(auth -> auth
                            .anyRequest().permitAll()) // Alle Anfragen erlauben
                    .formLogin(form -> form.defaultSuccessUrl("/sportTreffen"))
                    .logout(form -> form.logoutSuccessUrl("/login"))
                    .httpBasic(Customizer.withDefaults())
                    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));

            return http.build();*/



    }

    @Bean
    WebSecurityCustomizer webSecurityCustomizer() throws Exception {
        return (web -> web.ignoring().requestMatchers("/", "/register", "/h2-console/**"));
    }

    @Bean
    public AuthenticationProvider authProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        provider.setUserDetailsService(userDetailsService);

        return provider;
    }

}




