package de.thk.gm.gdw.fitamcampus.controllers.application;


import de.thk.gm.gdw.fitamcampus.controllers.domain.SportTreffen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class FitAmCampusController {
    @Autowired
    private FitAmCampusService fitAmCampusService;

    @GetMapping("/sporttreffen")
    @ResponseBody
    public List<SportTreffen> getAllSportTreffen() {
        return fitAmCampusService.getAllSportTreffen();
    }
    @GetMapping("/sporttreffen/{id}")
    public SportTreffen getSportTreffenById(@PathVariable("id") UUID id){

        return fitAmCampusService.getSportTreffenById(id);
    }

    @PostMapping("/sporttreffen")
    @ResponseBody
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
