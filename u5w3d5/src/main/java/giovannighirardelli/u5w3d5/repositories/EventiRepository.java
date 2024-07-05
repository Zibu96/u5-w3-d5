package giovannighirardelli.u5w3d5.repositories;

import giovannighirardelli.u5w3d5.entities.Eventi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventiRepository extends JpaRepository<Eventi, UUID> {

}
