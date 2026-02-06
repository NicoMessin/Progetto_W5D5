package niccolomessina.progetto_W5D5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import niccolomessina.progetto_W5D5.entities.Edificio;
import niccolomessina.progetto_W5D5.repositories.EdificiRepository;

@Service
public class EdificiService {
    private final EdificiRepository edificiRepository;

    @Autowired
    public EdificiService(EdificiRepository edificiRepository) {
        this.edificiRepository = edificiRepository;
    }

    public void save(Edificio e) {
        edificiRepository.save(e);
    }
}