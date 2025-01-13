package de.thk.gm.gdw.fitamcampus.usecases;


import de.thk.gm.gdw.fitamcampus.sporttreffen.domain.SportTreffen;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface FitAmCampusInterface {
    public void saveSportTreffen(String name,
                                 String ort,
                                 LocalDate datum,
                                 SportTreffen.DrinneOderDraussen drinneOderDraussen,
                                 String sportArt,
                                 String description);
    public List<SportTreffen> getAllSportTreffen();
    public SportTreffen getSportTreffenById(UUID id);
    public void updateSportTreffen(UUID id, String name);
    public void deleteSportTreffen(UUID id);

}
