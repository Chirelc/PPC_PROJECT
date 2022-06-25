package fr.dauphine.miageif.projectF.PfinalHATEOAS;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// Creation du JPA Repository basé sur Spring Data
//  Permet de "générer" toutes sortes de requêtes JPA, sans implementation
public interface CompteRepository extends JpaRepository<Compte, Long>{
    Compte save(Compte compte);
    Compte findByIban(String iban);
    List<Compte> findAll();
    Optional<Compte> findById(Long id);
}