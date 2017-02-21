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


public class CargarXML {
    
    public void CargarXML(){
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File("config.xml");
        try {
            Document document = (Document) builder.build(xmlFile);
            //Obtengo la raiz principal <scrabble>
            Element rootNode = document.getRootElement();
            
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
                    
                    System.out.println("X: "+x+" Y: "+y);
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
                    
                    System.out.println("X: "+x+" Y: "+y);
                }
            }

            //Hago un List para todos los atributos de doble<>
            List ldiccionario = rootNode.getChildren("diccionario");
            for (int i = 0; i < ldiccionario.size(); i++) {
                //Devuelvo un elemento de Tabla con las casillas
                Element tdiccionario = (Element) ldiccionario.get(i);
                
                String palabra = tdiccionario.getChildTextTrim("palabra");
                
                System.out.println("Palabra "+i+" es: "+palabra);
            }            
            
        }catch (JDOMException ex) {
            Logger.getLogger(CargarXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CargarXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
