package giovannighirardelli.u5w3d5.controllers;

import giovannighirardelli.u5w3d5.entities.Eventi;
import giovannighirardelli.u5w3d5.entities.Utenti;
import giovannighirardelli.u5w3d5.servicies.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utenti")
public class UtentiController {

    @Autowired
    private UtentiService utentiService;

    @GetMapping
    public Page<Utenti> getUtenti(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
                                  @RequestParam(defaultValue = "id") String sortBy) {

        return this.utentiService.getUtenti(page, size, sortBy);
    }
}
