package scrabbleedd;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.input.SAXBuilder;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import scrabbleedd.estructuras.ListaDiccionario;


public class CargarXML {
    
    public void CargarXML(File xml){
        //Declaraciones
        int z=1;
        ListaDiccionario diccionario = new ListaDiccionario();
        
        
       //Lector XML
        SAXBuilder builder = new SAXBuilder();
//        File xmlFile = new File("config.xml");
        try {
            Document document = (Document) builder.build(xml);
            //Obtengo la raiz principal <scrabble>
            Element rootNode = document.getRootElement();
            
            
            //Recuperando el valor de la dimension de la Matriz
            List ldim = rootNode.getChildren("dimension");
            Element tdim = (Element) ldim.get(0);
            int dim = Integer.parseInt(tdim.getTextTrim());
            System.out.println("Matriz dimensión: "+dim);
            
            
            //Hago un List para todos los atributos de doble<>
            List ldoble = rootNode.getChildren("dobles");
            for (int i = 0; i < ldoble.size(); i++) {
                //Devuelvo un elemento de Tabla con las casillas
                Element tdoble = (Element) ldoble.get(i);
                
                //Listo(Obtengo) las casillas
                List lcasillas = tdoble.getChildren();
                
                //Recorro los hijos <casillas>
                for (int j = 0; j < lcasillas.size(); j++) {
                    //Obtengo casilla
                    Element tcasilla = (Element) lcasillas.get(j);
                    
                    String x = tcasilla.getChildTextTrim("x");
                    String y = tcasilla.getChildTextTrim("y");
                    
                    //System.out.println("X: "+x+" Y: "+y);
                }
            }

            //Hago un List para todos los atributos de triple<>
            List ltriple = rootNode.getChildren("triples");
            for (int i = 0; i < ltriple.size(); i++) {
                //Devuelvo un elemento de Tabla con las casillas
                Element t_triple = (Element) ltriple.get(i);
                
                //Listo(Obtengo) las casillas
                List lcasillas = t_triple.getChildren();
                
                //Recorro los hijos <casillas>
                for (int j = 0; j < lcasillas.size(); j++) {
                    //Obtengo casilla
                    Element tcasilla = (Element) lcasillas.get(j);
                    
                    String x = tcasilla.getChildTextTrim("x");
                    String y = tcasilla.getChildTextTrim("y");
                    
                    //System.out.println("X: "+x+" Y: "+y);
                }
            }

            //Hago un List para todos los atributos de diccionario<>
            List ldiccionario = rootNode.getChildren("diccionario");
            for (int i = 0; i < ldiccionario.size(); i++) {
                //Devuelvo un elemento de Tabla con palabras
                Element tdiccionario = (Element) ldiccionario.get(i);
                
                List lpalabra = tdiccionario.getChildren();
                
                for (int j = 0; j < lpalabra.size(); j++) {
                    //Obtengo las palabra
                    Element tpalabra = (Element) lpalabra.get(j);
                    String palabra = tpalabra.getTextTrim();
                    //agrego a la lista
                    diccionario.ingresarPalabra(palabra);
                    
                    
                    //System.out.println("Palabra "+z+" es: "+palabra);
                    z++;
                }
            }            
            
            //diccionario.verLista();
            diccionario.Graficar();
            
            System.out.println("Cargado el archivo XML");
        }catch (JDOMException ex) {
            Logger.getLogger(CargarXML.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al cargar el archivo XML");
        } catch (IOException ex) {
            Logger.getLogger(CargarXML.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al cargar el archivo XML");
        }
    }
    
    
}
