package de.thk.gm.gdw.fitamcampus.controllers.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class SportTreffen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
     String name;
    private String ort;
    private String datum;
    private String sportArt;
   // private DrinneOderDraussen drinneOderDraussen = DrinneOderDraussen.OUTDOOR;
    private String description;


   @OneToMany(mappedBy = "sportTreffen", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Kommentare> comments = new ArrayList<>();
    @Override
    public String toString() {
        return "SportTreffen [id=" + id + ", name=" + name + ", ort=" + ort;
    }
}

