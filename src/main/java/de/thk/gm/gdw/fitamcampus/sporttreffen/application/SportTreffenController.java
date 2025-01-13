package de.thk.gm.gdw.fitamcampus.sporttreffen.application;

import de.thk.gm.gdw.fitamcampus.sporttreffen.domain.SportTreffen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value="/sportTreffen",produces={MediaType.TEXT_HTML_VALUE})
public class SportTreffenController {
    @Autowired
    private SportTreffenRestController sportTreffenRestController;

    @GetMapping()
    public String showSportTreffen(Model model){
        List<SportTreffen> sportTreffen = sportTreffenRestController.getAllSportTreffen();
        model.addAttribute("sportTreffen", sportTreffen);
        return "sportTreffen/showSportTreffen";
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String saveSportTreffen(String name, String ort, LocalDate datum, String sportArt, String description,SportTreffen.DrinneOderDraussen drinneOderDraussen){
    sportTreffenRestController.saveSportTreffen(name,ort,datum,sportArt,description,drinneOderDraussen);
    return "redirect:/sportTreffen";
    }
    @GetMapping("/{sportTreffenId}/edit")
    public String showEditSportTreffen(@PathVariable UUID sportTreffenId, Model model){
        model.addAttribute("sportTreffen",sportTreffenRestController.getSportTreffenById(sportTreffenId));
        return "sportTreffen/editSportTreffen";
    }
    @PutMapping("/{sportTreffenId}")
    public String updateSportTreffen(String name, String ort, String datum, String sportArt, String description, @PathVariable UUID sportTreffenId){
        sportTreffenRestController.updateSportTreffen(sportTreffenId,name);
        return "redirect:/sportTreffen/"+sportTreffenId+"/kommentare";
    }
    @DeleteMapping("/{sportTreffenId}")
    public String deleteSportTreffen(@PathVariable UUID sportTreffenId){
        sportTreffenRestController.deleteSportTreffen(sportTreffenId);
        return "redirect:/sportTreffen";
    }
}
