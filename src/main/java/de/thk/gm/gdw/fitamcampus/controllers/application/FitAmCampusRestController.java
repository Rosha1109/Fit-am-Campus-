package de.thk.gm.gdw.fitamcampus.controllers.application;


import de.thk.gm.gdw.fitamcampus.controllers.domain.SportTreffen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping( produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class FitAmCampusRestController {
    @Autowired
    private FitAmCampusService fitAmCampusService;

    @GetMapping("/sporttreffen")
    public List<SportTreffen> getAllSportTreffen() {
        return fitAmCampusService.getAllSportTreffen();
    }
    @GetMapping("/sporttreffen/{id}")
    public SportTreffen getSportTreffenById(@PathVariable("id") UUID id){

        return fitAmCampusService.getSportTreffenById(id);
    }

    @PostMapping("/sporttreffen")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveSportTreffen(String name,
                                 String ort,
                                 String datum,
                                 String sportArt,
                                 String description)
    {
       fitAmCampusService.saveSportTreffen(name, ort, datum, sportArt, description);
    }
    @PutMapping("sporttreffen/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSportTreffen(@PathVariable("id") UUID id,String name ){
        fitAmCampusService.updateSportTreffen(id, name);

    }
    @DeleteMapping("/sporttreffen/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSportTreffen(@PathVariable("id") UUID id){
        fitAmCampusService.deleteSportTreffen(id);
    }

}
