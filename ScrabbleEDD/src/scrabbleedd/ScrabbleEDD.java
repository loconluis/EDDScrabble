package scrabbleedd;

/**
 *  FIUSAC
 *  Estructuras de Datos
 *  201114279
 * @author luislocon
 * @version 1.0
 */
public class ScrabbleEDD {

    public static void main(String[] args) {
    scrabbleedd.estructuras.ListaDiccionario l = new scrabbleedd.estructuras.ListaDiccionario();

    l.ingresarPalabra("Hola");
    l.ingresarPalabra("Amigos");
    l.ingresarPalabra("de");
    l.ingresarPalabra("Snapchat");

    l.verLista();
    }
    
}
