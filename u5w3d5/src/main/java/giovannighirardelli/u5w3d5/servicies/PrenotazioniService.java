package giovannighirardelli.u5w3d5.servicies;


import giovannighirardelli.u5w3d5.entities.Eventi;
import giovannighirardelli.u5w3d5.entities.Prenotazioni;
import giovannighirardelli.u5w3d5.entities.Utenti;
import giovannighirardelli.u5w3d5.exceptions.BadRequestException;
import giovannighirardelli.u5w3d5.payloads.PrenotazioniDTO;
import giovannighirardelli.u5w3d5.repositories.PrenotazioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioniService {
    @Autowired
    private PrenotazioniRepository prenotazioniRepository;
    @Autowired
    private UtentiService utentiService;
    @Autowired
    private EventiService eventiService;


    public Prenotazioni savePrenotazioni(PrenotazioniDTO body){
        Utenti findUtenti = this.utentiService.findById(body.utentiId());
        Eventi findEventi = this.eventiService.findById(body.eventiId());

        if (prenotazioniRepository.existsByUtenti(findUtenti)) throw new BadRequestException("Questo utente ha già una prenotazione per questo evento");

        if (prenotazioniRepository.getPrenotazioniByEventiId(body.eventiId()).size() >= findEventi.getMaxPartecipanti()) throw new BadRequestException("L'evento " + findEventi.getTitolo() + " ha raggiunto la capienza massima");

        Prenotazioni prenotazioni = new Prenotazioni(findUtenti, findEventi);

        return this.prenotazioniRepository.save(prenotazioni);
    }
}
