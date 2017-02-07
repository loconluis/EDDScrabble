/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    public void verListaCircular(){
        nodoJugador actual = new nodoJugador();
        actual = cabeza;
        do{
            System.out.println(actual.getUsername());
            actual = actual.getSig();
        }while(actual != cabeza);
    }
    
}
