package pasapalabra;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.util.Random;

public class Pregunta {
    //Ha de ser String, ya que ñ no puede ser char.
    private String letra;
    private String pregunta;
    private String respuesta;
    public Pregunta(String letra){

        this.letra = letra;
        try {
            //Parte copiada de Internet sí
            File input = new File("src/main/resources/preguntas.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(input);
            doc.getDocumentElement().normalize();

            Element rootElement = doc.getDocumentElement();
            NodeList aList = rootElement.getElementsByTagName(letra);

            if (aList.getLength() > 0) {
                Element aElement = (Element) aList.item(0);

                NodeList cuestionList = aElement.getElementsByTagName("cuestion");

                if (cuestionList.getLength() > 0) {
                    //El random es para que cueste más aprenderte las preguntas de memoria. Ya que esto solo se activa al construirlo no debería de haber ningún problema
                    Random rng = new Random();


                    Element randomCuestion = (Element) cuestionList.item(rng.nextInt(cuestionList.getLength()));
                    Element preguntaElement = (Element) randomCuestion.getElementsByTagName("pregunta").item(0);
                    Element respuestaElement = (Element) randomCuestion.getElementsByTagName("respuesta").item(0);

                    pregunta = preguntaElement.getTextContent().trim();
                    respuesta = respuestaElement.getTextContent().trim();


                }

        }
        }catch (Exception e) {
            e.printStackTrace();
        }


    }


    public String getLetra(){
        return letra;
    }
    public String getPregunta(){
        return pregunta;
    }
    public String getRespuesta(){
        return respuesta;
    }




}
