package de.thk.gm.gdw.fitamcampus.sporttreffen.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import de.thk.gm.gdw.fitamcampus.kommentare.domain.Kommentare;
//import de.thk.gm.gdw.fitamcampus.user.domain.User;
import de.thk.gm.gdw.fitamcampus.user.domain.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class SportTreffen {
    public enum DrinneOderDraussen{
        INDOOR,
        OUTDOOR
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
     String name;
    private String ort;
  //  private String datum;
    @JsonFormat(pattern="dd.MM.yyyy")
    private LocalDate datum;
    private String sportArt;
    private DrinneOderDraussen drinneOderDraussen;
    private String description;

    @OneToOne
    private Users user;

   @OneToMany(mappedBy = "sportTreffen", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Kommentare> comments = new ArrayList<>();
    @Override
    public String toString() {
        return "SportTreffen [id=" + id + ", name=" + name + ", ort=" + ort;
    }
}

