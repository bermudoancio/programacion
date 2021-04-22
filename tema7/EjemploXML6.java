package tema7;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * En esta clase vamos a mostrar un ejemplo completo.
 * Basándonos en el ejemplo 5, guardaremos una copia de las modificaciones
 * realizadas en un nuevo fichero, llamado concesionarioModificado.xml
 * @author José Manuel Bermudo Ancio
 *
 */
public class EjemploXML6 {

	public static void main(String[] args) {

		try {

			// 1º Creamos una nueva instancia de un fábrica de constructores de documentos.

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			

			// 2º A partir de la instancia anterior, fabricamos un constructor de
			// documentos, que procesará el XML.

			DocumentBuilder db = dbf.newDocumentBuilder();

			// 3º Procesamos el documento (almacenado en un archivo) y lo convertimos en un
			// árbol DOM.

			Document documento = db.parse("./src/tema7/concesionario.xml");

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
			 * Vamos a borrar el coche cuyo id sea "2"
			 */
			
			NodeList nListBusqueda = documento.getElementsByTagName("coche");
			boolean encontrado = false;
			
			for (int temp = 0; temp < nListBusqueda.getLength() && !encontrado; temp++) {
				Node nNode = nListBusqueda.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					/*
					 * Si el atributo id coincide con el valor buscado, indicamos al nodo padre (que
					 * lo obtenemos mediante la llamada getParentNode()), que debe borrar la instancia
					 * buscada de su lista de hijos. 
					 */
					if (eElement.getAttribute("id").equals("2")) {
						eElement.getParentNode().removeChild(eElement);
						encontrado = true;
					}
				}
			}
			
						
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
			
			/*
			 * Ahora vamos a guardar el resultado de haber borrado el nodo
			 * en un fichero nuevo.
			 */
			
			
			// 1º Creamos una instancia de la clase File para acceder al archivo donde
			// guardaremos el XML.

			File f = new File("./src/tema7/concesionarioModificado.xml");

			// 2º Creamos una nueva instancia del transformador a través de la fábrica de
			// transformadores.

			Transformer transformer = TransformerFactory.newInstance().newTransformer();

			// 3º Establecemos algunas opciones de salida, como por ejemplo, la codificación
			// de salida.

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

			// 4º Creamos el StreamResult, que intermediará entre el transformador y el
			// archivo de destino.

			StreamResult result = new StreamResult(f);

			// 5º Creamos el DOMSource, que intermediará entre el transformador y el árbol
			// DOM.

			DOMSource source = new DOMSource(documento);

			// 6º Realizamos la transformación.

			transformer.transform(source, result);

		} 
		catch (TransformerException ex) {

			System.out.println("¡Error! No se ha podido llevar a cabo la transformación.");

		}
		catch (Exception ex) {

			System.out.println("¡Error! No se ha podido cargar el documento XML: " + ex.getMessage());

		}


	}

}
