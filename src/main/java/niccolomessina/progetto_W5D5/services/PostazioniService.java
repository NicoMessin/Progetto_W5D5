package niccolomessina.progetto_W5D5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import niccolomessina.progetto_W5D5.entities.Postazione;
import niccolomessina.progetto_W5D5.entities.TipoPostazione;
import niccolomessina.progetto_W5D5.repositories.PostazioniRepository;

import java.util.List;

@Service
public class PostazioniService {
    private final PostazioniRepository postazioniRepository;

    @Autowired
    public PostazioniService(PostazioniRepository postazioniRepository) {
        this.postazioniRepository = postazioniRepository;
    }

    public void save(Postazione p) {
        postazioniRepository.save(p);
    }

    public List<Postazione> cercaPerTipoECitta(TipoPostazione tipo, String citta) {
        return postazioniRepository.findByTipoAndEdificio_Citta(tipo, citta);
    }
}