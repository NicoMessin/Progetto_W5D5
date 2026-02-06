package niccolomessina.progetto_W5D5.repositories;

import niccolomessina.progetto_W5D5.entities.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import niccolomessina.progetto_W5D5.entities.TipoPostazione;
import java.util.List;

public interface PostazioniRepository extends JpaRepository<Postazione, Long> {
    List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, String citta);
}
