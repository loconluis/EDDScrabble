package scrabbleedd.estructuras;
/**
 *
 * @author luislocon
 * LISTA SIMPLE
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
        nodopalabra.setPalabra(palabra);
        //Validacion para saber si la lista esta vacia
        if(cabeza == null){
            cabeza = nodopalabra;
            cabeza.setSig(null);
            cola = cabeza;
        }else{
            cola.setSig(nodopalabra);
            nodopalabra.setSig(null);
            cola = nodopalabra;
        }
    }
    //Mostrar la lista
    
    public void verLista(){
        nodoD actual = new nodoD();
        actual = cabeza;
        while(actual!=null){
            System.out.println(actual.getPalabra());
            actual = actual.getSig();
        }
    }
}
