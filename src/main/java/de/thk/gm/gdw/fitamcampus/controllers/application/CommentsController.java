package de.thk.gm.gdw.fitamcampus.controllers.application;

import de.thk.gm.gdw.fitamcampus.controllers.domain.Kommentare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sporttreffen/{id}")
public class CommentsController {

    @Autowired
    private KommentareService kommentareService;

    @GetMapping("/kommentare")
    @ResponseStatus(HttpStatus.OK)
    public List<Kommentare> getKommentare(@PathVariable UUID id) {
        return kommentareService.getComments(id);
    }

    @PostMapping("/kommentare")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveKommentar(@PathVariable UUID id, @RequestParam String content) {
        kommentareService.addComment(id, content);
    }

    @PutMapping("/kommentare/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateKommentar(@PathVariable UUID id, @PathVariable UUID commentId, @RequestParam String content) {
        kommentareService.updateComment(id, commentId, content);
    }

    @DeleteMapping("/kommentare/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteKommentar(@PathVariable UUID id, @PathVariable UUID commentId) {
        kommentareService.deleteComment(commentId);
    }
}
