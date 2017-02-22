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
    
    
    //llenado
    public void llenado(){
        for (int i = 0; i < 12; i++) {
            ingresarFicha("A");
            ingresarFicha("E");
        }
        
        for (int i = 0; i < 9; i++) {
            ingresarFicha("O");
        }
        
        for (int i = 0; i < 6; i++) {
            ingresarFicha("I");
            ingresarFicha("S");
        }
        for (int i = 0; i < 5; i++) {
            ingresarFicha("N");
            ingresarFicha("D");
            ingresarFicha("R");
            ingresarFicha("U");
        }
        for (int i = 0; i < 4; i++) {
            ingresarFicha("L");
            ingresarFicha("T");
            ingresarFicha("C");
        }
        
        for (int i = 0; i < 2; i++) {
            ingresarFicha("G");
            ingresarFicha("B");
            ingresarFicha("M");
            ingresarFicha("P");
            ingresarFicha("H");
        }
        
        for (int i = 0; i < 1; i++) {
            ingresarFicha("F");
            ingresarFicha("V");
            ingresarFicha("Y");
            ingresarFicha("Q");
            ingresarFicha("J");
            ingresarFicha("Ñ");
            ingresarFicha("X");
            ingresarFicha("Z");
        }
    }
    
    //Mostrar lista
    public void verLista(){
        nodoFicha actual = new nodoFicha();
        actual = cabeza;
        while(actual!=null){
            System.out.println(actual.getLetra());
            actual = actual.getSig();
        }
    }
    
    //Graficar la lista
    public void Graficar(){
        String path = "C:\\Users\\luisl\\Documents\\EDD\\Practica1s12017_201114279\\ScrabbleEDD\\Grafos\\ColaFichas.dot";
        try {
            FileWriter wr = new FileWriter(path);
            wr.write("digraph G{ \n");
            nodoFicha aux = cabeza;
            
            if(aux==null){
                System.err.println("nada en la lista");
            }else{
                while(aux.getSig() !=null){
                    System.err.println(aux.getLetra()+"->"+aux.getSig().getLetra());
                    wr.write(aux.getLetra()+"->"+aux.getSig().getLetra()+"\n");
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

            String grafo = "C:\\Users\\luisl\\Documents\\EDD\\Practica1s12017_201114279\\ScrabbleEDD\\Grafos\\ColaFichas.dot";      
            String img_grafo = "C:\\Users\\luisl\\Documents\\EDD\\Practica1s12017_201114279\\ScrabbleEDD\\Grafos\\ColaFichas.jpg";

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
