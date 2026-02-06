package niccolomessina.progetto_W5D5.repositories;

import niccolomessina.progetto_W5D5.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;

public interface PrenotazioniRepository extends JpaRepository <Prenotazione, Long> {
    boolean existsByPostazioneAndGiorno(Postazione postazione, LocalDate giorno);
    boolean existsByUtenteAndGiorno(Utente utente, LocalDate giorno);
}
