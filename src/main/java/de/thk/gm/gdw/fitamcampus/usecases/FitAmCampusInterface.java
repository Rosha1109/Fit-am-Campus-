package de.thk.gm.gdw.fitamcampus.usecases;

import de.thk.gm.gdw.fitamcampus.controllers.domain.SportTreffen;

import java.util.List;
import java.util.UUID;

public interface FitAmCampusInterface {
    public void saveSportTreffen(String name,
                                 String ort,
                                 String datum,
                                 String sportArt,
                                 String description);
    public List<SportTreffen> getAllSportTreffen();
    public SportTreffen getSportTreffenById(UUID id);
    public void updateSportTreffen(UUID id, String name);
    public void deleteSportTreffen(UUID id);

}
