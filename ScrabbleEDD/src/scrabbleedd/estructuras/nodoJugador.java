package scrabbleedd.estructuras;
/**
 *
 * @author luislocon
 */
public class nodoJugador {
    private String username;
    private nodoJugador sig;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the sig
     */
    public nodoJugador getSig() {
        return sig;
    }

    /**
     * @param sig the sig to set
     */
    public void setSig(nodoJugador sig) {
        this.sig = sig;
    }
    
}
