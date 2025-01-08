package de.thk.gm.gdw.fitamcampus.user.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsersRepository extends CrudRepository<Users, UUID> {
    Users findByUsername(String username);
}
