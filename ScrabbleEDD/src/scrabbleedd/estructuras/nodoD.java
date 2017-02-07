
package scrabbleedd.estructuras;
/**
 *
 * @author luisl
 */
public class nodoD {
    private String palabra;
    private nodoD sig;

    /**
     * @return the palabra
     */
    public String getPalabra() {
        return palabra;
    }
    
     /**
     * @param palabra the palabra to set
     */
    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    /**
     * @return the sig
     */
    public nodoD getSig() {
        return sig;
    }
    
    /**
     * @param sig the sig to set
     */
    public void setSig(nodoD sig) {
        this.sig = sig;
    }
}
