package tema7;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class EjemploXML2b {

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

			// Obtenemos la lista de todos los nodos que se llamen "coche"
			NodeList nList = e.getChildNodes();
			System.out.println("Número de coches: " + nList.getLength());

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				switch (nNode.getNodeType()) {

				case Node.ELEMENT_NODE:

					Element elemento = (Element) nNode;

					System.out.println("Etiqueta:" + elemento.getTagName());

					break;

				case Node.TEXT_NODE:

					Text texto = (Text) nNode;

					System.out.println("Texto:" + texto.getTextContent());

					break;

				}
			}
			
			/* ##### AHORA LO HAREMOS CON UN XML SIN ESPACIOS ##### */
			System.out.println("Ahora cargamos el fichero XML sin espacios");
			Document documentoSinEspacios = db.parse("./src/tema7/concesionario2.xml");

			Element e2 = documentoSinEspacios.getDocumentElement();
			// Normaliza los elementos del documento
			e2.normalize();

			// Obtenemos la lista de todos los nodos que se llamen "coche"
			NodeList nListSinEspacios = e2.getChildNodes();
			System.out.println("Número de coches: " + nListSinEspacios.getLength());

			for (int temp = 0; temp < nListSinEspacios.getLength(); temp++) {
				Node nNode = nListSinEspacios.item(temp);

				switch (nNode.getNodeType()) {

				case Node.ELEMENT_NODE:

					Element elemento = (Element) nNode;

					System.out.println("Etiqueta:" + elemento.getTagName());

					break;

				case Node.TEXT_NODE:

					Text texto = (Text) nNode;

					System.out.println("Texto:" + texto.getTextContent());

					break;

				}
			}

		} catch (Exception ex) {

			System.out.println("¡Error! No se ha podido cargar el documento XML: " + ex.getMessage());

		}

	}

}
