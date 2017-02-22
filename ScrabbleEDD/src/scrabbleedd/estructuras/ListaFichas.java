package scrabbleedd.estructuras;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListaFichas {
    //Variables
    nodoFicha cabeza;
    nodoFicha cola;
    
    //Constructor
    public ListaFichas(){
        cabeza=null;
        cola=null;
    }
    
    //Metodo de insercion
    public void ingresarFicha(String letra){
        nodoFicha nodoficha = new nodoFicha();
        nodoficha.setLetra(letra);
        //Validacion para saber si la lista esta vacia
        if(cabeza == null){
            cabeza = nodoficha;
            cabeza.setSig(null);
            cola = cabeza;
        }else{
            cola.setSig(nodoficha);
            nodoficha.setSig(null);
            cola = nodoficha;
        }
    }
    
    //Metodo de buscar ficha
    public nodoFicha buscarFicha(String letra){
        nodoFicha buscado = null;
        nodoFicha actual = cabeza;
        
        if(actual==null){
            System.err.println("No existe la letra");
            javax.swing.JOptionPane.showMessageDialog(null, "No hay datos en la lista");
        }else{
            boolean existe=false;
            while(actual !=null){
                if(actual.getLetra().equalsIgnoreCase(letra)){
                    existe = true;
                    buscado = actual;
                    System.out.println("Letra encontrada");
                }
                actual = actual.getSig();
            }
            if (!existe) {
                System.err.println("Letra no encontrada");
            }
        }
        return buscado;
    }
    
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
    
    
    //Ver lista ficha
    
    //Graficar la lista
    public void Graficar(){
        String path = "C:\\Users\\luisl\\Documents\\EDD\\Practica1s12017_201114279\\ScrabbleEDD\\Grafos\\fichas.dot";
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

            String grafo = "C:\\Users\\luisl\\Documents\\EDD\\Practica1s12017_201114279\\ScrabbleEDD\\Grafos\\fichas.dot";      
            String img_grafo = "C:\\Users\\luisl\\Documents\\EDD\\Practica1s12017_201114279\\ScrabbleEDD\\Grafos\\fichas.jpg";

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
