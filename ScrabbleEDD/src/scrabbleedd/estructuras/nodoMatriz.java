package scrabbleedd.estructuras;
/**
 *
 * @author luisl
 */
public class nodoMatriz {
    
    //Variables de la matriz
    private nodoMatriz up, down, right, left = null ;
    private String letra = "";

    /**
     * @return the up
     */
    public nodoMatriz getUp() {
        return up;
    }

    /**
     * @param up the up to set
     */
    public void setUp(nodoMatriz up) {
        this.up = up;
    }

    /**
     * @return the down
     */
    public nodoMatriz getDown() {
        return down;
    }

    /**
     * @param down the down to set
     */
    public void setDown(nodoMatriz down) {
        this.down = down;
    }

    /**
     * @return the right
     */
    public nodoMatriz getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(nodoMatriz right) {
        this.right = right;
    }

    /**
     * @return the left
     */
    public nodoMatriz getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(nodoMatriz left) {
        this.left = left;
    }

    /**
     * @return the letra
     */
    public String getLetra() {
        return letra;
    }

    /**
     * @param letra the letra to set
     */
    public void setLetra(String letra) {
        this.letra = letra;
    }
    
}
