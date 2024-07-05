package giovannighirardelli.u5w3d5.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record NewUtentiDTO(
        @NotEmpty(message = "Il nome è obbligatorio per la creazione di un utente")
        @Size(min = 4, max = 20, message = "Il nome dell' utente non può essere minore di 4 caratteri o maggiore di 20")
        String nome,
        @NotEmpty(message = "Il cognome è obbligatorio per la creazione di un utente")
        String cognome,
        @NotEmpty(message = "Lo username è obbligatorio per la creazione dell'utente")
        @Size(min = 3, max = 16, message = "Lo username non può essere minore di 3 caratteri o maggiore di 16")
        String username,
        @NotEmpty(message = "L' utente deve avere una email valida")
        @Email(message = "Formato indirizzo mail non valido")
        String email,
        @NotEmpty(message = "La password è obbligatoria per la creazione di un utente")
        @Size(min = 8, max = 20, message = "La password deve avere minimo 8 caratteri e massimo 20")
        String password,
        @NotEmpty(message = "Il ruolo dell'utente è obbligatorio per la creazione")
        String ruolo

) {
}
