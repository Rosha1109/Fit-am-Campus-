package de.thk.gm.gdw.fitamcampus.kommentare.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface KommentareRepository extends CrudRepository<Kommentare, UUID> {
}
