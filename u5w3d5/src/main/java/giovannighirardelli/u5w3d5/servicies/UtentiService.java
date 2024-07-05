package giovannighirardelli.u5w3d5.servicies;

import giovannighirardelli.u5w3d5.entities.Utenti;
import giovannighirardelli.u5w3d5.enums.RuoliUtente;
import giovannighirardelli.u5w3d5.exceptions.BadRequestException;
import giovannighirardelli.u5w3d5.exceptions.NotFoundException;
import giovannighirardelli.u5w3d5.payloads.NewUtentiDTO;
import giovannighirardelli.u5w3d5.repositories.UtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UtentiService {

    @Autowired
    private UtentiRepository utentiRepository;
    @Autowired
    private PasswordEncoder bCrypt;


    public Page<Utenti> getUtenti(int pageNumber, int pageSize, String sortBy){
        if (pageSize > 20) pageSize = 20;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        return utentiRepository.findAll(pageable);
    }

    public Utenti saveUtenti(NewUtentiDTO body) {
       this.utentiRepository.findByEmail(body.email()).ifPresent(utente-> {
            throw new BadRequestException("L'utente con " + body.email() + " esiste già");
        });


        Utenti dipendenti = new Utenti(body.nome(), body.cognome(), body.username(), body.email(), bCrypt.encode(body.password()), RuoliUtente.USER);


        return this.utentiRepository.save(dipendenti);

    }


    public Utenti findById(UUID id) {
        return this.utentiRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
}
}

