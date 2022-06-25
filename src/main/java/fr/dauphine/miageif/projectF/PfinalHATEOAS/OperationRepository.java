package fr.dauphine.miageif.projectF.PfinalHATEOAS;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface OperationRepository extends JpaRepository<Operation, Long> {
        List<Operation> findAll();
        Operation save(Operation operation);
        Operation findById(long id);
        Optional<Operation> findBySourceIban(String sourceIban);
        //Optional<Operation> findByIbanDest(String desIban);
        Optional<Operation> findByDate(String date);
        Optional<Operation> findByMontant(BigDecimal montant);
        //Optional<Operation> findByTypeOp(String type);
        Optional<Operation> findBySourceAndDestination(String sourceIban, String destIban);
    }

