package fr.dauphine.miageif.projectF.PfinalHATEOAS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class CompteController {

    @Autowired
    private Environment environment;

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private CompteService service;

    public CompteController(CompteService service) {
        this.service = service;
    }

    //Create an instance of account and insert it into database
    @PostMapping(path = "/newAccount")
    public Compte createCompte(@RequestParam long id,@RequestParam String iban, @RequestParam String type, @RequestParam BigDecimal interest, @RequestParam String frais) {
        Compte compte = new Compte(id,iban, type, interest, frais);
        compteRepository.save(compte);
        return compte;
    }

    //Get an account informations by iban
    @GetMapping("/getCompteIban/{iban}")
    public Compte getCompteByIban(@PathVariable String iban) {
        Compte compte = compteRepository.findByIban(iban);
        return compte;
    }

    //Get account informations by id
    @GetMapping("/getCompteBid/{id}")
    public Optional<Compte> getCompteById(@PathVariable Long id) {
        Optional<Compte> compte = compteRepository.findById(id);
        return compte;
    }

    //Get account informations of every accounts in the database
    @GetMapping("/compte/getAll")
    public List<Compte> getAll() {

        List<Compte> comptes = compteRepository.findAll();

        return comptes;
    }

    //Update account informations
    @PutMapping("/compte/update/{id}")
    public ResponseEntity<Compte> updateCompteById(@PathVariable("id") Long id, @RequestBody Compte updatedItem) {
        service.update(id, updatedItem);
        return null;
    }
}

