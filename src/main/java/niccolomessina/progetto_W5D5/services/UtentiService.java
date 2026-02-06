package niccolomessina.progetto_W5D5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import niccolomessina.progetto_W5D5.entities.Utente;
import niccolomessina.progetto_W5D5.repositories.UtentiRepository;

@Service
public class UtentiService {
    private final UtentiRepository utentiRepository;

    @Autowired
    public UtentiService(UtentiRepository utentiRepository) {
        this.utentiRepository = utentiRepository;
    }

    public void save(Utente u) {
        utentiRepository.save(u);
    }
}