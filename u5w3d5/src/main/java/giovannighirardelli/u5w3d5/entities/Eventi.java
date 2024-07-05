package giovannighirardelli.u5w3d5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "eventi")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Eventi {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String titolo;
    private String descrizione;
    private LocalDate data;
    @Column(name = "max_partecipanti")
    private int maxPartecipanti;
    private String location;
    @ManyToOne
    @JoinColumn(name = "creato_da")
    private Utenti utenti;
}
