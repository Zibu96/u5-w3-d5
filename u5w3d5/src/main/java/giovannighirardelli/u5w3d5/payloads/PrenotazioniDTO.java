package giovannighirardelli.u5w3d5.payloads;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record PrenotazioniDTO(
        @NotNull(message = "Utente necessario per la creazione della prenotazione")
        UUID utentiId,
        @NotNull(message = "Evento necessario per la creazione della prenotazione")
        UUID eventiId
) {
}
