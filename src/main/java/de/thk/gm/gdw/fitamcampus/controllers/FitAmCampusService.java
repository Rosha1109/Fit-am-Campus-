package de.thk.gm.gdw.fitamcampus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
@Service
public class FitAmCampusService implements FitAmCampusInterface{
    @Autowired
    private SportTreffenRepository sportTreffenRepository;
    @Override
    public void saveSportTreffen(String name, String ort, String datum, String sportArt, String description) {
        SportTreffen sportTreffen = new SportTreffen();
        sportTreffen.setName(name);
        sportTreffen.setOrt(ort);
        sportTreffen.setDatum(datum);
        sportTreffen.setSportArt(sportArt);
        sportTreffen.setDescription(description);
        sportTreffenRepository.save(sportTreffen);
    }

    @Override
    public String getAllSportTreffen() {
        return sportTreffenRepository.findAll().toString();
    }

    @Override
    public String getSportTreffenById(UUID id) {
        SportTreffen sportTreffen = sportTreffenRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Sport Treffen Not Found"));
        return sportTreffen.toString();
    }

    @Override
    public void updateSportTreffen(UUID id, String name) {
        SportTreffen sportTreffen = sportTreffenRepository.findById(id).orElseThrow(null);
        sportTreffen.setName(name);
        sportTreffenRepository.save(sportTreffen);
    }

    @Override
    public void deleteSportTreffen(UUID id) {
        SportTreffen sportTreffen = sportTreffenRepository.findById(id).orElseThrow(null);
        sportTreffenRepository.delete(sportTreffen);
    }
}
