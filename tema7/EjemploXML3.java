package tema7;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class EjemploXML3 {

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
			 * Vamos a añadir un nuevo coche.
			 * Un coche está formado por:
			 * 		- La etiqueta coche
			 * 		- Un atributo llamado id, con un número
			 * 		- Una etiqueta interna llamada "marca", con el valor de la marca
			 * 		- Una etiqueta interna llamada "modelo", con el valor del modelo
			 * 		- Una etiqueta interna llamada "cilindrada", con el valor de la cilindrada
			 * 
			 * Por tanto, empecemos creando el elemento coche
			 */
			Element nuevoCoche = documento.createElement("coche");
			
			// El coche tiene un atributo id
			Attr atributo = documento.createAttribute("id");
			
			// Para obtener el nuevo valor de id, obtendremos el id del último coche introducido
			int newId = Integer.parseInt(EjemploXML3.getLastId(documento)) + 1;
			atributo.setNodeValue(Integer.toString(newId));
			
			// Ahora, enlazamos el atributo al elemento
			nuevoCoche.setAttributeNode(atributo);
			
			/*
			 * Lo anterior es equivalente a esto:
			 * nuevoCoche.setAttribute("id", Integer.toString(newId));
			 * 
			 * OK, ya tenemos el nodo coche creado. Antes de añadirlo al documento (podríamos hacerlo
			 * también después), vamos a añadirle los nodos internos
			*/
			Element marca = documento.createElement("marca");
			marca.setTextContent("Honda");
			
			/*
			 * Existe otra forma de crear un nodo con texto que sería la siguiente:
			 * Element etiquetaMarca = documento.createElement("marca");
			 * Text marcaTXT = documento.createTextNode("Honda");
 			 * etiquetaMarca.appendChild(marcaTXT);
			 * documento.getDocumentElement().appendChild(etiquetaMarca);
			 */

			
			Element modelo = documento.createElement("modelo");
			modelo.setTextContent("CR-V");
			
			Element cilindrada = documento.createElement("cilindrada");
			cilindrada.setTextContent("1.9");
			
			// Ahora, añadimos estos 3 nodos al nodo coche
			nuevoCoche.appendChild(marca);
			nuevoCoche.appendChild(modelo);
			nuevoCoche.appendChild(cilindrada);
			
			/*
			 * Por último, añadimos el nuevo coche al documento. Como he comentado
			 * podríamos haberlo incluido justo al crearlo
			 */
			documento.getDocumentElement().appendChild(nuevoCoche);
			
			
			// Mostramos el resultado
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

		} catch (Exception ex) {

			System.out.println("¡Error! No se ha podido cargar el documento XML: " + ex.getMessage());

		}

	}
	
	/**
	 * Devuelve el valor del atributo id del último nodo del documento XML
	 * @param doc
	 * @return
	 */
	public static String getLastId(Document doc) {
		String lastId = null;

		Node child = doc.getDocumentElement().getLastChild();
		boolean found = false;

		while (child != null && !found) {
			if (child.getNodeType() == Node.ELEMENT_NODE) {
				found = true;
			}
			else {
				child = child.getPreviousSibling();
			}
		}

		lastId = child.getAttributes().getNamedItem("id").getNodeValue();

		return lastId;
	}

}
