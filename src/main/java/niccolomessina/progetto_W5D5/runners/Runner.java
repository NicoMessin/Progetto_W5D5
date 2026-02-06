package niccolomessina.progetto_W5D5.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import niccolomessina.progetto_W5D5.entities.*;
import niccolomessina.progetto_W5D5.services.*;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {
    private final EdificiService edificiService;
    private final PostazioniService postazioniService;
    private final UtentiService utentiService;
    private final PrenotazioniService prenotazioniService;

    public Runner(EdificiService edificiService, PostazioniService postazioniService, UtentiService utentiService, PrenotazioniService prenotazioniService) {
        this.edificiService = edificiService;
        this.postazioniService = postazioniService;
        this.utentiService = utentiService;
        this.prenotazioniService = prenotazioniService;
    }

    @Override
    public void run(String... args) {

        Edificio e1 = new Edificio("Edificio Epicode", "Viale Italia 18", "Roma");
        edificiService.save(e1);

        Postazione p1 = new Postazione("Postazione-1", "Postazione piano terra all'angolo", TipoPostazione.PRIVATO, 1, e1
        );

        Postazione p2 = new Postazione("Postazione-2", "Postazione primo piano Open space", TipoPostazione.OPENSPACE, 4, e1
        );

        postazioniService.save(p1);
        postazioniService.save(p2);

        Utente u1 = new Utente("marioRossi", "Mario Rossi", "mariorossi@gmail.com");
        Utente u2 = new Utente("marcoBianchi", "Marco Bianchi", "marcobianchi@gmail.com");

        utentiService.save(u1);
        utentiService.save(u2);

        LocalDate giorno = LocalDate.of(2026, 5, 10);

        Prenotazione pr1 = new Prenotazione(giorno, u1, p1);
        prenotazioniService.save(pr1);

        // errore stessa postazione, stesso giorno, utente diverso
        Prenotazione errorePostazione = new Prenotazione(giorno, u2, p1);
        prenotazioniService.save(errorePostazione);

        // errore stesso utente, stesso giorno, postazione diversa
        Prenotazione erroreUtente = new Prenotazione(giorno, u1, p2);
        prenotazioniService.save(erroreUtente);
    }
}