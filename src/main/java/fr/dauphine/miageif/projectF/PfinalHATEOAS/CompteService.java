package fr.dauphine.miageif.projectF.PfinalHATEOAS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CompteService {
    private CompteRepository compteRepository;
    @Autowired
    private CompteRepository repository;

    public List<Compte> getAllComptes(){
        return repository.findAll();
    }


    public String deleteChange(long id){
        try {
            repository.deleteById(id);
            return "Taux change " + id + " supprimé";
        }
        catch(Exception e){
            return "Can't delete rate by id "+ id;
        }
    }


    public Compte update(Long id, Compte newCompte){
        Compte ex =repository.findById(id).orElse(null);
        ex.setIban(newCompte.getIban());
        ex.setFrais(newCompte.getFrais());
        ex.setInterest(newCompte.getInterest());
        ex.setType(newCompte.getType());

        return   repository.save(ex);
    }

    public Optional<Compte> findById(long id) {
        return repository.findById(id);
    }
}
