package de.thk.gm.gdw.fitamcampus.controllers.application;

import de.thk.gm.gdw.fitamcampus.controllers.domain.Kommentare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class CommentsRestController {

    @Autowired
    private KommentareService kommentareService;


  @PostMapping("sporttreffen/{sporttreffenId}/kommentare")
  @ResponseStatus(HttpStatus.CREATED)
  public void saveComment(
          @RequestParam String content,
          @PathVariable UUID sporttreffenId
  ){
      kommentareService.addComment(sporttreffenId,content);
  }




    @GetMapping("sporttreffen/{sporttreffenId}/kommentare/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Kommentare getKommentar(@PathVariable("id") UUID id) {
        return kommentareService.getComment(id);
    }
    @GetMapping("sporttreffen/{sporttreffenId}/kommentare")
    @ResponseStatus(HttpStatus.OK)
    public List<Kommentare> getAllComments(){
        return kommentareService.getAllComments();
    }



    @PutMapping("sporttreffen/{sporttreffenId}/kommentare/{commentid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateKommentar(@PathVariable("sporttreffenId") UUID id, @PathVariable("commentid") UUID commentId, @RequestParam String content) {
        kommentareService.updateComment(id, commentId, content);
    }

    @DeleteMapping("sporttreffen/{sporttreffenId}/kommentare/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteKommentar( @PathVariable UUID commentId) {
        kommentareService.deleteComment(commentId);
    }
}
