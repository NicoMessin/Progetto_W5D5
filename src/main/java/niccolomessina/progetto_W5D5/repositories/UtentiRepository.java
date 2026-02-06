package niccolomessina.progetto_W5D5.repositories;

import niccolomessina.progetto_W5D5.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtentiRepository extends JpaRepository <Utente, Long> {
}
