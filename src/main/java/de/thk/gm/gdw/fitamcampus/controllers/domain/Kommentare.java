package de.thk.gm.gdw.fitamcampus.controllers.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Kommentare {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID kommentarId;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    private SportTreffen sportTreffen;
}
