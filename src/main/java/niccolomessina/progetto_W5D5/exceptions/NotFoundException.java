package niccolomessina.progetto_W5D5.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("L'elemento con id " + id + " non è stato trovato!");
    }
}