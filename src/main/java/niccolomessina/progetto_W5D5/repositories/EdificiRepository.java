package niccolomessina.progetto_W5D5.repositories;

import niccolomessina.progetto_W5D5.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EdificiRepository extends JpaRepository <Edificio, Long> {
}
