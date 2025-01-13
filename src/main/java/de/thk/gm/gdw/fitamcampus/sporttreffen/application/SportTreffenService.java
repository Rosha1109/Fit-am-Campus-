package de.thk.gm.gdw.fitamcampus.sporttreffen.application;

import de.thk.gm.gdw.fitamcampus.usecases.FitAmCampusInterface;
import de.thk.gm.gdw.fitamcampus.sporttreffen.domain.SportTreffen;
import de.thk.gm.gdw.fitamcampus.sporttreffen.domain.SportTreffenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Service
public class SportTreffenService implements FitAmCampusInterface {
    @Autowired
    private SportTreffenRepository sportTreffenRepository;
//    @Override
//    public void saveSportTreffen(String name, String ort, LocalDate datum, String sportArt, String description,SportTreffen.DrinneOderDraussen drinneOderDraussen) {
//        SportTreffen sportTreffen = new SportTreffen();
//        sportTreffen.setName(name);
//        sportTreffen.setOrt(ort);
//        sportTreffen.setDatum(datum);
//        sportTreffen.setSportArt(sportArt);
//        sportTreffen.setDescription(description);
//        sportTreffenRepository.save(sportTreffen);
//    }

    @Override
    public void saveSportTreffen(String name, String ort, LocalDate datum, SportTreffen.DrinneOderDraussen drinneOderDraussen, String sportArt, String description) {
        SportTreffen sportTreffen = new SportTreffen();
        sportTreffen.setName(name);
        sportTreffen.setOrt(ort);
        sportTreffen.setDatum(datum);
        sportTreffen.setSportArt(sportArt);
        sportTreffen.setDrinneOderDraussen(drinneOderDraussen);
        sportTreffen.setDescription(description);
        sportTreffenRepository.save(sportTreffen);
    }

    @Override
    public List<SportTreffen> getAllSportTreffen() {
        List<SportTreffen> liste = (List<SportTreffen>) sportTreffenRepository.findAll();
        return liste;
    }

    @Override
    public SportTreffen getSportTreffenById(UUID id) {
        SportTreffen sportTreffen = sportTreffenRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Sport Treffen Not Found"));
        return sportTreffen;
    }

    @Override
    public void updateSportTreffen(UUID id, String name) {
        SportTreffen sportTreffen = sportTreffenRepository.findById(id).orElseThrow(null);
        sportTreffen.setName(name);
        sportTreffenRepository.save(sportTreffen);
    }

    @Override
    public void deleteSportTreffen(UUID id) {
        SportTreffen sportTreffen = sportTreffenRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Sport Treffen Not Found"));
        sportTreffenRepository.delete(sportTreffen);
    }
}
