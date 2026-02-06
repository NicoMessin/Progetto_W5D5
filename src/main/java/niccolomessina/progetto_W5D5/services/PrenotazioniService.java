package niccolomessina.progetto_W5D5.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import niccolomessina.progetto_W5D5.entities.Prenotazione;
import niccolomessina.progetto_W5D5.exceptions.ValidationException;
import niccolomessina.progetto_W5D5.repositories.PrenotazioniRepository;

@Slf4j
@Service
public class PrenotazioniService {
    private final PrenotazioniRepository prenotazioniRepository;

    @Autowired
    public PrenotazioniService(PrenotazioniRepository prenotazioniRepository) {
        this.prenotazioniRepository = prenotazioniRepository;
    }

    public void save(Prenotazione p) {
        //postazione libera in quel giorno
        if (prenotazioniRepository.existsByPostazioneAndGiorno(p.getPostazione(), p.getGiorno())) {
            throw new ValidationException("Postazione già prenotata per il giorno " + p.getGiorno());
        }

        //un utente NON può prenotare più di una postazione per la STESSA data
        if (prenotazioniRepository.existsByUtenteAndGiorno(p.getUtente(), p.getGiorno())) {
            throw new ValidationException("L'utente ha già una prenotazione per il giorno " + p.getGiorno());
        }

        prenotazioniRepository.save(p);
        log.info("Prenotazione salvata correttamente.");
    }
}