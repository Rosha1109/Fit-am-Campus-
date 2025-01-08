package de.thk.gm.gdw.fitamcampus.kommentare.application;

import de.thk.gm.gdw.fitamcampus.kommentare.domain.Kommentare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value= "api/v1", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class CommentsRestController {

    @Autowired
    private KommentareService kommentareService;


  @PostMapping("/sportTreffen/{sportTreffenId}/kommentare")
  @ResponseStatus(HttpStatus.CREATED)
  public void saveComment(
          @RequestParam String content,
          @PathVariable UUID sportTreffenId
  ){
      System.out.println("restcontroller: "+sportTreffenId);
      kommentareService.addComment(sportTreffenId,content);
  }




    @GetMapping("/sportTreffen/{sporttreffenId}/kommentare/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Kommentare getKommentar(@PathVariable("id") UUID id) {
        return kommentareService.getComment(id);
    }
    @GetMapping("sportTreffen/{sporttreffenId}/kommentare")
    @ResponseStatus(HttpStatus.OK)
    public List<Kommentare> getAllComments(){
        return kommentareService.getAllComments();
    }



    @PutMapping("/sportTreffen/{sporttreffenId}/kommentare/{commentid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateKommentar(@PathVariable("sporttreffenId") UUID id, @PathVariable("commentid") UUID commentId, @RequestParam String content) {
        kommentareService.updateComment(id, commentId, content);
    }

    @DeleteMapping("/sportTreffen/{sporttreffenId}/kommentare/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteKommentar( @PathVariable UUID commentId) {
        kommentareService.deleteComment(commentId);
    }
}
