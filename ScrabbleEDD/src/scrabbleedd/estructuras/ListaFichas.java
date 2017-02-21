package scrabbleedd.estructuras;

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
    
    //Ver lista ficha
}
