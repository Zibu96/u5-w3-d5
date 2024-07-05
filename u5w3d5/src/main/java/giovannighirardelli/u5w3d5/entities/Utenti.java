package giovannighirardelli.u5w3d5.entities;


import giovannighirardelli.u5w3d5.enums.RuoliUtente;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "utenti")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Utenti {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "ruolo")
    private RuoliUtente ruoliUtente;

}
