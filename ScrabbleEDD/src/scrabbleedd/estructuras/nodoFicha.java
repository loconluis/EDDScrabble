package scrabbleedd.estructuras;
/**
 *
 * @author luisl
 */
public class nodoFicha {
    private String letra;
    private nodoFicha sig;

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public nodoFicha getSig() {
        return sig;
    }

    public void setSig(nodoFicha sig) {
        this.sig = sig;
    }
    
    
}
