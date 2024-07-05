package giovannighirardelli.u5w3d5.controllers;


import giovannighirardelli.u5w3d5.entities.Prenotazioni;
import giovannighirardelli.u5w3d5.exceptions.BadRequestException;
import giovannighirardelli.u5w3d5.payloads.PrenotazioniDTO;
import giovannighirardelli.u5w3d5.servicies.PrenotazioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioniController {
    @Autowired
    private PrenotazioniService prenotazioniService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Prenotazioni savePrenotazioni (@RequestBody @Validated PrenotazioniDTO body, BindingResult validationResult){
        if (validationResult.hasErrors()) {
            System.out.println(validationResult.getAllErrors());
            throw new BadRequestException(validationResult.getAllErrors());
        }
        return  this.prenotazioniService.savePrenotazioni(body);
    }
}
