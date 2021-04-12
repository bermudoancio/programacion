package tema7;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class EjemploXML4 {

	public static void main(String[] args) {

		try {

			// 1º Creamos una nueva instancia de un fábrica de constructores de documentos.

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			

			// 2º A partir de la instancia anterior, fabricamos un constructor de
			// documentos, que procesará el XML.

			DocumentBuilder db = dbf.newDocumentBuilder();

			// 3º Procesamos el documento (almacenado en un archivo) y lo convertimos en un
			// árbol DOM.

			Document documento = db.parse("./ejemplos_de_clase/concesionario.xml");

			Element e = documento.getDocumentElement();
			// Normaliza los elementos del documento
			e.normalize();
			
			/*
			 * Vamos a mostrar primero la lista original, para poder apreciar los cambios
			 */
			// Obtenemos la lista de todos los nodos que se llamen "coche"
			NodeList nList = documento.getElementsByTagName("coche");
			System.out.println("Número de coches: " + nList.getLength());

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					System.out.println("\nCoche id: " + eElement.getAttribute("id"));
					System.out.println("Marca: " + eElement.getElementsByTagName("marca").item(0).getTextContent());
					System.out.println("Modelo: " + eElement.getElementsByTagName("modelo").item(0).getTextContent());
					System.out.println("Cilindrada: " + eElement.getElementsByTagName("cilindrada").item(0).getTextContent());
				}
			}
			
			
			/*
			 * Actualizaremos la marca y el identificador del primer coche.
			 * Puedo hacerlo así porque estoy seguro de que al menos hay un coche
			 */
			
			Element primerCoche = (Element) documento.getElementsByTagName("coche").item(0);
			primerCoche.getElementsByTagName("marca").item(0).setTextContent("Toyota");
			
			// Vamos a modificar ahora el atributo id
			NamedNodeMap attribute = primerCoche.getAttributes();
            Node nodeAttr = attribute.getNamedItem("id");
            nodeAttr.setTextContent("10");
			
			// Volvemos a mostrar la lista, ahora con los elementos modificados
			NodeList nList2 = documento.getElementsByTagName("coche");
			System.out.println("Número de coches: " + nList2.getLength());

			for (int temp = 0; temp < nList2.getLength(); temp++) {
				Node nNode = nList2.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					System.out.println("\nCoche id: " + eElement.getAttribute("id"));
					System.out.println("Marca: " + eElement.getElementsByTagName("marca").item(0).getTextContent());
					System.out.println("Modelo: " + eElement.getElementsByTagName("modelo").item(0).getTextContent());
					System.out.println("Cilindrada: " + eElement.getElementsByTagName("cilindrada").item(0).getTextContent());
				}
			}

		} catch (Exception ex) {

			System.out.println("¡Error! No se ha podido cargar el documento XML: " + ex.getMessage());

		}

	}

}
