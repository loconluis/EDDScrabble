package scrabbleedd.estructuras;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    //Graficar la lista
    public void Graficar(){
        String path = "C:\\Users\\luisl\\Documents\\EDD\\Practica1s12017_201114279\\ScrabbleEDD\\Grafos\\diccionario.dot";
        try {
            FileWriter wr = new FileWriter(path);
            wr.write("digraph G{ \n");
            nodoD aux = cabeza;
            
            if(aux==null){
                System.err.println("nada en la lista");
            }else{
                while(aux.getSig() !=null){
                    System.err.println(aux.getPalabra()+"->"+aux.getSig().getPalabra());
                    wr.write(aux.getPalabra()+"->"+aux.getSig().getPalabra()+"\n");
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

    private void getGraphiz() {
        try {
            String dot = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";

            String grafo = "C:\\Users\\luisl\\Documents\\EDD\\Practica1s12017_201114279\\ScrabbleEDD\\Grafos\\diccionario.dot";      
            String img_grafo = "C:\\Users\\luisl\\Documents\\EDD\\Practica1s12017_201114279\\ScrabbleEDD\\Grafos\\diccionario.jpg";

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
