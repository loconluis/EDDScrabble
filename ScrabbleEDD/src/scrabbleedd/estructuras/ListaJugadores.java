/*
 LISTA CIRCULAR
 */
package scrabbleedd.estructuras;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    //Graficar la lista
    public void Graficar(){
        String path = "C:\\Users\\luisl\\Documents\\EDD\\Practica1s12017_201114279\\ScrabbleEDD\\Grafos\\jugadores.dot";
        try {
            FileWriter wr = new FileWriter(path);
            wr.write("digraph G{ \n");
            nodoJugador aux = cabeza;
            
            if(aux==null){
                System.err.println("nada en la lista");
            }else{
                while(aux.getSig() !=null){
                    System.err.println(aux.getUsername()+"->"+aux.getSig().getUsername());
                    wr.write(aux.getUsername()+"->"+aux.getSig().getUsername()+"\n");
                    aux = aux.getSig();
                }
            }
            wr.write("}\n");
            
            wr.close();
            
            FileReader leer = new FileReader(path);
            int x = leer.read();
            
            while(x!=-1){
                x=leer.read();
            }
            leer.close();
            
            getGraphiz();
            
        } catch (IOException ex) {
            Logger.getLogger(ListaDiccionario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR AL INTENTAR GRAFICAR");
        }
    
    }

    //Codigo Generico para graphiz en consola
    private void getGraphiz() {
        try {
            String dot = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";

            String grafo = "C:\\Users\\luisl\\Documents\\EDD\\Practica1s12017_201114279\\ScrabbleEDD\\Grafos\\jugadores.dot";      
            String img_grafo = "C:\\Users\\luisl\\Documents\\EDD\\Practica1s12017_201114279\\ScrabbleEDD\\Grafos\\jugadores.jpg";

            String tParam = "-Tjpg";
            String tOParam = "-o";

            String[] cmd = new String[5];
            cmd[0] = dot;
            cmd[1] = tParam;
            cmd[2] = grafo;
            cmd[3] = tOParam;
            cmd[4] = img_grafo;

            Runtime rt = Runtime.getRuntime();
             System.out.println(rt.toString());
            rt.exec( cmd );

          } catch (Exception ex) {
            //ex.printStackTrace();
              System.out.println("ERROR AL LLAMAR GRAPH DESDE CONSOLA");
          }
    }
    
}
