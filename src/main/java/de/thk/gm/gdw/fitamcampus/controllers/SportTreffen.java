package de.thk.gm.gdw.fitamcampus.controllers;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


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

    @Override
    public String toString() {
        return "SportTreffen [id=" + id + ", name=" + name + ", ort=" + ort;
    }
}

