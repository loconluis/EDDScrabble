package scrabbleedd;


//importantes
import scrabbleedd.estructuras.ListaDiccionario;
import scrabbleedd.estructuras.nodoD;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 *
 * @author luisl
 */
public class LoadXML extends DefaultHandler {
    private nodoD palabra;
    private ListaDiccionario ld = new ListaDiccionario();
    private StringBuilder buffer = new StringBuilder();
    

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        
    }

    @Override
    public void endElement(String url, String localName, String qname) throws SAXException {
        switch(qname){
            case "scrabble":
                break;
            case "dimension":
                break;
            case "dobles":
                break;
            case "triples":
                break;
            case "diccionario":
                break;
            case "palabra":
                ld.ingresarPalabra(buffer.toString());
                break;
        }
    }

    @Override
    public void startElement(String url, String localName, String qname, Attributes atr) throws SAXException {
        switch(qname){
            case "scrabble":
                break;
            case "dimension":
                break;
            case "dobles":
                break;
            case "triples":
                break;
            case "diccionario":
                break;
            case "palabra":
                buffer.delete(0, buffer.length());
                break;
        }
    }

    
//    public static void cargarXML() throws ParserConfigurationException, SAXException, IOException{
//        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
//        
//        SAXParser saxParser = saxParserFactory.newSAXParser();
//        File file = new File("config.xml");
//        
//        saxParser.parse(file, null);

}
