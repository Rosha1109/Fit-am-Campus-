package de.thk.gm.gdw.fitamcampus.controllers;

import java.util.UUID;

public interface FitAmCampusInterface {
    public void saveSportTreffen(String name,
                                 String ort,
                                 String datum,
                                 String sportArt,
                                 String description);
    public String getAllSportTreffen();
    public String getSportTreffenById(UUID id);
    public void updateSportTreffen(UUID id, String name);
    public void deleteSportTreffen(UUID id);

}
