package giovannighirardelli.u5w3d5.repositories;


import giovannighirardelli.u5w3d5.entities.Utenti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UtentiRepository extends JpaRepository<Utenti, UUID> {
    Optional<Utenti> findByEmail(String email);
}
