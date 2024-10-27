package de.thk.gm.gdw.fitamcampus.controllers;

import org.springframework.data.repository.CrudRepository;


import java.util.UUID;
public interface SportTreffenRepository extends CrudRepository<SportTreffen, UUID> {
   // SportTreffen findByName(String name);

}
