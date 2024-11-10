package de.thk.gm.gdw.fitamcampus.controllers.application;

import de.thk.gm.gdw.fitamcampus.controllers.domain.Kommentare;
import de.thk.gm.gdw.fitamcampus.controllers.domain.KommentareRepository;
import de.thk.gm.gdw.fitamcampus.controllers.domain.SportTreffen;
import de.thk.gm.gdw.fitamcampus.controllers.domain.SportTreffenRepository;
import de.thk.gm.gdw.fitamcampus.usecases.KommentarInterface;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KommentareService implements KommentarInterface {
   @Autowired
   private KommentareRepository kommentareRepository;
    @Autowired
    private SportTreffenRepository sportTreffenRepository;

    @Override
    public void addComment(UUID sportTreffenID, String comment) {
                SportTreffen sportTreffen = sportTreffenRepository.findById(sportTreffenID).orElseThrow(() -> new EntityNotFoundException("Kommentar not found"));
        Kommentare kommentare = new Kommentare();
        if(sportTreffen != null) {
            kommentare.setSportTreffen(sportTreffen);
            kommentare.setContent(comment);
            sportTreffen.getComments().add(kommentare);
        }else{
            throw new IllegalArgumentException("SportTreffen is null");
        }
        kommentareRepository.save(kommentare);
        sportTreffenRepository.save(sportTreffen);
    }

    @Override
    public void deleteComment( UUID commentId) {
        Kommentare kommentar = kommentareRepository.findById(commentId).orElseThrow(() -> new EntityNotFoundException("Kommentare not found"));
        kommentareRepository.delete(kommentar);
    }

    @Override
    public List<Kommentare> getComments(UUID sportTreffenID) {
        SportTreffen sportTreffen = sportTreffenRepository.findById(sportTreffenID).orElseThrow(() -> new EntityNotFoundException("Kommentar not found"));
        if(sportTreffen != null){
            return sportTreffen.getComments();
        }else{
            throw new IllegalArgumentException("SportTreffen is null");
        }
    }

    @Override
    public void updateComment(UUID sportTreffenID, UUID kommentarId,String comment) {
        SportTreffen sportTreffen = sportTreffenRepository.findById(sportTreffenID).orElseThrow(() -> new EntityNotFoundException("SportTreffen not found"));
        if(sportTreffen == null){
            throw new IllegalArgumentException("SportTreffen is null");
        }else{
            Kommentare kommentare = findKommentareById(sportTreffenID, kommentarId);
            kommentare.setContent(comment);
            kommentareRepository.save(kommentare);
            List<Kommentare> comments = sportTreffen.getComments();
            for(Kommentare kommentare1 : comments){

                if(kommentare1.getKommentarId().equals(kommentarId)){
                    sportTreffen.getComments().remove(kommentare1);
                    sportTreffen.getComments().add(kommentare);
                }
            }
        }
    }

    private Kommentare findKommentareById(UUID sportTreffenId,UUID kommentarId) {
        SportTreffen sportTreffen = sportTreffenRepository.findById(sportTreffenId).orElseThrow(() -> new EntityNotFoundException("SportTreffen not found"));
        List<Kommentare> All = sportTreffen.getComments();
        Kommentare wantedKommentare = new Kommentare();
        for(Kommentare kommentare : All){
            if(kommentare.getKommentarId().equals(kommentarId)){
                wantedKommentare = kommentare;
            }else{
                throw new IllegalArgumentException("Kommentare not found");
            }
        }
        return wantedKommentare;
    }
}
