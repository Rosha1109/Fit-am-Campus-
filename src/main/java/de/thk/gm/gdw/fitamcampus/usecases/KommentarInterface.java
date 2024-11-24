package de.thk.gm.gdw.fitamcampus.usecases;

import de.thk.gm.gdw.fitamcampus.controllers.domain.Kommentare;

import java.util.List;
import java.util.UUID;

public interface KommentarInterface {
    void addComment(UUID sportTreffenID,String comment);
    void deleteComment(UUID commentId);
    Kommentare getComment(UUID sportTreffenID);
    void updateComment(UUID sportTreffenID,UUID kommentarId,String comment);
}
