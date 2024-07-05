package giovannighirardelli.u5w3d5.controllers;


import giovannighirardelli.u5w3d5.exceptions.BadRequestException;
import giovannighirardelli.u5w3d5.payloads.NewUtentiDTO;
import giovannighirardelli.u5w3d5.payloads.NewUtentiResponseDTO;
import giovannighirardelli.u5w3d5.payloads.UtentiLoginDTO;
import giovannighirardelli.u5w3d5.payloads.UtentiLoginResponseDTO;
import giovannighirardelli.u5w3d5.servicies.AuthService;
import giovannighirardelli.u5w3d5.servicies.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private UtentiService utentiService;

    @PostMapping("/login")
    public UtentiLoginResponseDTO login(@RequestBody UtentiLoginDTO payload){
        return new UtentiLoginResponseDTO(authService.authenticateUtenteAndGenerateToken(payload));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public NewUtentiResponseDTO saveUtenti(@RequestBody @Validated NewUtentiDTO body, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            System.out.println(validationResult.getAllErrors());
            throw new BadRequestException(validationResult.getAllErrors());
        }
        System.out.println(body);
        return new NewUtentiResponseDTO(this.utentiService.saveUtenti(body).getId());
    }
}
