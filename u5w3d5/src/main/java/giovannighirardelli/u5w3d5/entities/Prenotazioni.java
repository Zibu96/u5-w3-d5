package giovannighirardelli.u5w3d5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "prenotazioni")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Prenotazioni {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "utenti")
    private Utenti utenti;
    @ManyToOne
    @JoinColumn(name = "eventi")
    private Eventi eventi;


    public Prenotazioni(Utenti utenti, Eventi eventi) {
        this.utenti = utenti;
        this.eventi = eventi;
    }
}
