package de.thk.gm.gdw.fitamcampus.kommentare.domain;

import de.thk.gm.gdw.fitamcampus.sporttreffen.domain.SportTreffen;
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
