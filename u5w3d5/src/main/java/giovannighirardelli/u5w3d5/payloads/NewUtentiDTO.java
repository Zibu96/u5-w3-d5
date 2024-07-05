package giovannighirardelli.u5w3d5.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record NewUtentiDTO(
        @NotEmpty(message = "Il nome è obbligatorio per la creazione di un dipendente")
        @Size(min = 4, max = 20, message = "Il nome del dipendente non può essere minore di 4 caratteri o maggiore di 20")
        String nome,
        @NotEmpty(message = "Il cognome è obbligatorio per la creazione di un dipendente")
        @Size(min = 3, max = 16, message = "Il cognome non può essere minore di 3 caratteri o maggiore di 16")
        String cognome,
        @NotEmpty(message = "Il dipendente deve avere una email valida")
        @Email(message = "Formato indirizzo mail non valido")
        String email,
        @NotEmpty(message = "La password è obbligatoria per la creazione di un dipendente")
        @Size(min = 8, max = 20, message = "La password deve avere minimo 8 caratteri e massimo 20")
        String password

) {
}
