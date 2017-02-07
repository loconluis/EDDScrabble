package scrabbleedd.estructuras;
/**
 *
 * @author luisl
 */
public class ColaFichas {
    nodoFicha cabeza, cola;

    public ColaFichas() {
        cabeza = null;
        cola = null;
    }
    
    //Encolar 
    public void ingresarFicha(String letra){
        nodoFicha nuevaficha = new nodoFicha();
        nuevaficha.setLetra(letra);
        
        //Validadcion si existe la cola
        if(cabeza==null){
            cabeza = nuevaficha;
            nuevaficha.setSig(null);
            cola = cabeza;
        }else{
            cola.setSig(nuevaficha);
            nuevaficha.setSig(null);
            cola = nuevaficha;
        }
    }
    
    //Desencolar
    
    //Mostrar lista
    public void verLista(){
        nodoFicha actual = new nodoFicha();
        actual = cabeza;
        while(actual!=null){
            System.out.println(actual.getLetra());
            actual = actual.getSig();
        }
    }
}
