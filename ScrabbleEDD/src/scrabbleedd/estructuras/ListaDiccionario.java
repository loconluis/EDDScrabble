package scrabbleedd.estructuras;
/**
 *
 * @author luisl
 */
public class ListaDiccionario {
    //Variables
    nodoD cabeza;
    nodoD cola;
    
    //Constructor 
    public ListaDiccionario(){
        //inicializamos
        cabeza = null;
        cola = null;
    }
    
    //Metodo de insercion
    public void ingresarPalabra(String palabra){
        nodoD nodopalabra = new nodoD();
        nodopalabra.palabra = palabra;
        //Validacion para saber si la lista esta vacia
        if(cabeza == null){
            cabeza = nodopalabra;
            cabeza.sig = null;
            cola = cabeza;
        }else{
            cola.sig = nodopalabra;
            nodopalabra.sig = null;
            cola = nodopalabra;
        }
    }
    //Mostrar la lista
    public void verLista(){
        nodoD actual = new nodoD();
        actual = cabeza;
        while(actual!=null){
            System.out.println(actual.palabra);
            actual = actual.sig;
        }
    }
}
