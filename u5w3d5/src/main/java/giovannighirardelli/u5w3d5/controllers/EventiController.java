package giovannighirardelli.u5w3d5.controllers;


import giovannighirardelli.u5w3d5.entities.Eventi;
import giovannighirardelli.u5w3d5.exceptions.BadRequestException;
import giovannighirardelli.u5w3d5.payloads.NewEventiDTO;
import giovannighirardelli.u5w3d5.payloads.NewEventiResponseDTO;
import giovannighirardelli.u5w3d5.servicies.EventiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/eventi")
public class EventiController {
    @Autowired
    private EventiService eventiService;

    @GetMapping
    public Page<Eventi> getEventi(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
                                       @RequestParam(defaultValue = "id") String sortBy) {

        return this.eventiService.getEventi(page, size, sortBy);
    }

    @PostMapping("/newEvento")
    @PreAuthorize("hasAuthority('ORGANIZZATORE')")
    @ResponseStatus(HttpStatus.CREATED)
    public Eventi saveDispositivi (@RequestBody @Validated NewEventiDTO body, BindingResult validationResult){
        if (validationResult.hasErrors()) {
            System.out.println(validationResult.getAllErrors());
            throw new BadRequestException(validationResult.getAllErrors());
        }
        return  this.eventiService.saveEventi(body);
    }

    @PutMapping("/{dipendentiId}")
    @PreAuthorize("hasAuthority('ORGANIZZATORE')")
    public Eventi findByIdAndUpdate(@PathVariable UUID dipendentiId, @RequestBody Eventi body){
        return this.eventiService.findByIdAndUpdate(dipendentiId, body);

    }

    @DeleteMapping("/{eventiId}")
    @PreAuthorize("hasAuthority('ORGANIZZATORE')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable UUID eventiId) {
        this.eventiService.findByIdAndDelete(eventiId);
    }
}
