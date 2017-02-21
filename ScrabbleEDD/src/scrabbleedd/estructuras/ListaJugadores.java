/*
 LISTA CIRCULAR
 */
package scrabbleedd.estructuras;

/**
 *
 * @author luisl
 */
public class ListaJugadores {
    //Nodos de identificacion
    nodoJugador cabeza, cola;
    
    //Constructor
    public ListaJugadores(){
        //Inicializacion
        cabeza = null;
        cola = null;
    }
    
    //Metodo para ingresar jugadores
    public void ingresarUsuario(String username){
        //nuevo jugador
        nodoJugador jugador = new nodoJugador();
        jugador.setUsername(username);
        
        //Si existe la lista
        if (cabeza==null){
            cabeza = jugador;
            cola = cabeza;
            cabeza.setSig(cola);
        }else{
            cola.setSig(jugador);
            jugador.setSig(cabeza);
            cola = jugador;
        }
    }
    
    //Metodo para buscar usuarios
    public nodoJugador buscarUsuario(String username){
        nodoJugador buscado = null;
        nodoJugador actual = cabeza;
        
        if(actual==null){
            System.err.println("No existe el jugador");
            javax.swing.JOptionPane.showMessageDialog(null, "No hay datos en lista");
        }else{
            boolean existe=false;
            do{
            
            }
             while(buscado.getSig()!=cabeza);
            if (!existe) {
                System.err.println("Usuario disponible");
            }
        }
        return buscado;
    }
    
    //Metodo para ver la lista
    public void verListaCircular(){
        nodoJugador actual = new nodoJugador();
        actual = cabeza;
        do{
            System.out.println(actual.getUsername());
            actual = actual.getSig();
        }while(actual != cabeza);
    }
    
}
