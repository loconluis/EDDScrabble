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
    
    //Metodo de buscarNodo
    public nodoD buscarPalabra(String palabra){
        nodoD buscado = null;
        nodoD actual = cabeza;
        
        if(actual==null){
            System.err.println("No existe la palabra");
            javax.swing.JOptionPane.showMessageDialog(null, "No hay datos en la lista");
        }else{
            boolean existe=false;
            while(actual !=null){
                if(actual.getPalabra().equalsIgnoreCase(palabra)){
                    existe = true;
                    buscado = actual;
                    javax.swing.JOptionPane.showMessageDialog(null, "¡¡¡ACERTASTE!!! Tu palabra coincide");
                    System.out.println("Palabra encontrada");
                }
                actual = actual.getSig();
            }
            if (!existe) {
                javax.swing.JOptionPane.showMessageDialog(null, "¡¡¡FALLASTE!!! Tu palabra no coincide");
                System.err.println("Palabra no encontrada en el diccionario");
            }
        }
        return buscado;
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
