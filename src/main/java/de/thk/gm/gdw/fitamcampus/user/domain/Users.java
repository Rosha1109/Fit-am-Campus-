package de.thk.gm.gdw.fitamcampus.user.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity

public class Users {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Getter
    @Setter
    private String username;
    @Setter
    @Getter
    private String password;
    @Setter
    @Getter
    private String email;
}
