package fr.dauphine.miageif.projectF.PfinalHATEOAS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class OperationController {
    @Autowired
    private Environment environment;

    @Autowired
    private OperationRepository repository;


    @PostMapping("/addOperation")
    public Operation addOperation(@RequestBody long id,@RequestBody String type,@RequestBody Compte source,@RequestBody Compte destination,@RequestBody String devise,@RequestBody BigDecimal montant){
        Operation op=new Operation(id,type,source,destination,devise,montant);
        repository.save(op);
        return op;

    }

    @GetMapping("/operations")
    public List<Operation> getAllOperations(){
        return repository.findAll();
    }

    @GetMapping("/operationById/{id}")
    public Operation getOperationById(@PathVariable long id){
        return repository.findById(id);
    }

    @GetMapping("/operation/findByMontant/{montant}")
    public Optional<Operation> getOperationByMontant(@PathVariable BigDecimal montant){
        return repository.findByMontant(montant);
    }

    @GetMapping("/operation/findByIbanSrc/{IbanSrc}")
    public Optional<Operation> getOperationByIbanSrc(@PathVariable String ibanSrc){
        return repository.findBySourceIban(ibanSrc);

    }

    @GetMapping("/operation/findByIbanDest/{ibanDest}")
    public Optional<Operation> getOperationByIbanDest(@PathVariable String ibanDest){
        return repository.findBySourceIban(ibanDest);
    }

    @GetMapping("/operation/findByDate/{date}")
    public Optional<Operation> getOperationByDate(@PathVariable String date){
        return repository.findByDate(date);
    }

    @GetMapping("/operation/findByCompte/src/{src}/dest/{dest}")
    public Optional<Operation> getOperationsCompte(@PathVariable String src, @PathVariable String dest){
        return repository.findBySourceAndDestination(src,dest);
    }

    @GetMapping("/operation/montant/{id}")
    public BigDecimal getMontantOperation(@PathVariable Long id){
        return repository.findById(id).get().getMontant();
    }

    @GetMapping("/operation/date/{id}")
    public Date getDateOperation(@PathVariable Long id){
        return repository.findById(id).get().getDate();
    }


    @GetMapping("/operation/type/{id}")
    public String getTypeOperation(@PathVariable Long id){
        return repository.findById(id).get().getType();
    }



}
