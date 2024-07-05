package giovannighirardelli.u5w3d5.servicies;


import giovannighirardelli.u5w3d5.entities.Utenti;
import giovannighirardelli.u5w3d5.exceptions.UnauthorizedException;
import giovannighirardelli.u5w3d5.payloads.UtentiLoginDTO;
import giovannighirardelli.u5w3d5.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UtentiService utentiService;
    @Autowired
    private JWTTools jwtTools;
    @Autowired
    private PasswordEncoder bCrypt;

    public String authenticateUtenteAndGenerateToken(UtentiLoginDTO payload){
        Utenti dipendenti = this.utentiService.findByEmail(payload.email());
        if (bCrypt.matches(payload.password(), dipendenti.getPassword())){
            return jwtTools.createToken(dipendenti);
        } else {
            throw  new UnauthorizedException("Credenziali non corrette");
        }
    }
}
