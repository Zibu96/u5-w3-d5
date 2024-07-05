package giovannighirardelli.u5w3d5.repositories;


import giovannighirardelli.u5w3d5.entities.Prenotazioni;
import giovannighirardelli.u5w3d5.entities.Utenti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PrenotazioniRepository extends JpaRepository<Prenotazioni, UUID> {

    List<Prenotazioni> getPrenotazioniByEventiId(UUID eventiID);
    boolean existsByUtenti(Utenti utenti);
}
