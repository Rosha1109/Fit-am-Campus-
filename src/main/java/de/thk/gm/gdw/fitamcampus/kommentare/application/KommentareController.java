package de.thk.gm.gdw.fitamcampus.kommentare.application;


import de.thk.gm.gdw.fitamcampus.sporttreffen.application.SportTreffenService;
import de.thk.gm.gdw.fitamcampus.sporttreffen.domain.SportTreffenRepository;
import de.thk.gm.gdw.fitamcampus.weather.application.WeatherRestController;
import de.thk.gm.gdw.fitamcampus.kommentare.domain.Kommentare;
import de.thk.gm.gdw.fitamcampus.sporttreffen.domain.SportTreffen;
import de.thk.gm.gdw.fitamcampus.weather.domain.Weather;
import de.thk.gm.gdw.fitamcampus.sporttreffen.application.SportTreffenRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/sportTreffen/{sportTreffenId}")
public class KommentareController {
    @Autowired
    private CommentsRestController commentsRestController;
    @Autowired
    private SportTreffenRestController sportTreffenRestController;
    @Autowired
    private WeatherRestController weatherRestController;
    @Autowired
    private SportTreffenRepository sportTreffenRepository;

    @GetMapping("/kommentare")
    public String showKommentare(@PathVariable UUID sportTreffenId, Model model) throws IOException, InterruptedException {
        List<Kommentare> kommentare = commentsRestController.getAllComments();
        model.addAttribute("kommentare",kommentare);
        SportTreffen sportTreffen= sportTreffenRestController.getSportTreffenById(sportTreffenId);
        model.addAttribute("sportTreffen",sportTreffen);
        Weather weather = weatherRestController.getWeatherService(sportTreffen.getOrt());
        model.addAttribute("weather", weather);

        String mapUrl = weatherRestController.getMapUrl(sportTreffen.getOrt());
        model.addAttribute("mapUrl", mapUrl);

        return  "/kommentare/showKommentare";
    }
    @PostMapping("/kommentare")
    public String saveKommentar(String content,@PathVariable UUID sportTreffenId){
        commentsRestController.saveComment(content,sportTreffenId);
        return "redirect:/sportTreffen/"+sportTreffenId+"/kommentare";
    }

    @GetMapping("/kommentare/{kommentarId}")
    public String getKommentar(@PathVariable UUID sportTreffenId,@PathVariable UUID kommentarId,Model model){
        Kommentare kommentar= commentsRestController.getKommentar(kommentarId);
        model.addAttribute("kommentar",kommentar);
        return "/kommentare/showKommentar";
    }
    @PutMapping("/kommentare/{kommentarId}")
    public String updateKommentar(@PathVariable UUID sportTreffenId, @PathVariable UUID kommentarId,String content){
        commentsRestController.updateKommentar(sportTreffenId,kommentarId,content);
        return "redirect:/sportTreffen/"+sportTreffenId+"/kommentare";
    }

    @DeleteMapping("/kommentare/{kommentarId}")
    public String deleteKommentar(@PathVariable UUID sportTreffenId,@PathVariable UUID kommentarId){
        commentsRestController.deleteKommentar(kommentarId);
        return "redirect:/sportTreffen/"+sportTreffenId+"/kommentare";
    }
}
