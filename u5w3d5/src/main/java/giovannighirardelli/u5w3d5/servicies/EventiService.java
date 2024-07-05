package giovannighirardelli.u5w3d5.servicies;

import giovannighirardelli.u5w3d5.entities.Eventi;
import giovannighirardelli.u5w3d5.entities.Utenti;
import giovannighirardelli.u5w3d5.exceptions.BadRequestException;
import giovannighirardelli.u5w3d5.exceptions.NotFoundException;
import giovannighirardelli.u5w3d5.payloads.NewEventiDTO;
import giovannighirardelli.u5w3d5.payloads.NewUtentiDTO;
import giovannighirardelli.u5w3d5.repositories.EventiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EventiService {
    @Autowired
    private EventiRepository eventiRepository;
    @Autowired
    private UtentiService utentiService;


    public Page<Eventi> getEventi(int pageNumber, int pageSize, String sortBy){
        if (pageSize > 20) pageSize = 20;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        return eventiRepository.findAll(pageable);
    }

    public Eventi saveEventi(NewEventiDTO body) {
        Utenti found = utentiService.findById(body.utenteId());


        Eventi eventi = new Eventi(body.titolo(), body.descrizione(), body.data(), body.maxPartecipanti(), body.location(), found);


        return this.eventiRepository.save(eventi);

    }
    public Eventi findById(UUID id) {
        return this.eventiRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Eventi findByIdAndUpdate(UUID id, Eventi updatedEventi) {
        Eventi found = this.findById(id);

        found.setTitolo(updatedEventi.getTitolo());
        found.setDescrizione(updatedEventi.getDescrizione());
        found.setData(updatedEventi.getData());
        found.setMaxPartecipanti(updatedEventi.getMaxPartecipanti());
        found.setLocation(updatedEventi.getLocation());
        found.setUtenti(updatedEventi.getUtenti());

        return this.eventiRepository.save(found);

    }


    public void findByIdAndDelete(UUID id) {
        Eventi found = this.findById(id);
        this.eventiRepository.delete(found);
    }
}
