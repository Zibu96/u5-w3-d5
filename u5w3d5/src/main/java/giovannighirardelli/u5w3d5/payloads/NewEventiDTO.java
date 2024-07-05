package giovannighirardelli.u5w3d5.payloads;

import giovannighirardelli.u5w3d5.entities.Utenti;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record NewEventiDTO(
        @NotEmpty(message = "Il titolo dell'evento è obbligatorio per la creazione")
        String titolo,
        @NotEmpty(message = "La descrizione dell'evento è obbligatoria per la creazione")
        String descrizione,
        @NotNull(message = "La data dell'evento è obbligatoria per la creazione")
        LocalDate data,
        @NotNull(message = "L'evento deve avere un numero massimo di partecipanti per la creazione")
        int maxPartecipanti,
        @NotNull(message = "Il creatore dell'evento è obbligatorio per la creazione")
        Utenti utenti
) {
}
