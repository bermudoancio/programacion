package tema7;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class EjemploXML2 {

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
			NodeList nList = documento.getElementsByTagName("coche");
			//NodeList nList = e.getChildNodes();
			System.out.println("Número de coches: " + nList.getLength());

			
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					System.out.println("\nCoche id: " + eElement.getAttribute("id"));
					System.out.println("Marca: " + eElement.getElementsByTagName("marca").item(0).getTextContent());
					System.out.println("Modelo: " + eElement.getElementsByTagName("modelo").item(0).getTextContent());
					System.out.println("Cilindrada: " + eElement.getElementsByTagName("cilindrada").item(0).getTextContent());
				}
			}
						
			System.out.println("****************************");
			
			// Obtenemos la lista de todos los nodos que se llamen "coche"
			NodeList sede1 = documento.getElementsByTagName("sede1");
			nList = ((Element)sede1.item(0)).getElementsByTagName("moto");
			//NodeList nList = e.getChildNodes();
			System.out.println("Número de coches: " + nList.getLength());

			
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					System.out.println("\nCoche id: " + eElement.getAttribute("id"));
					System.out.println("Marca: " + eElement.getElementsByTagName("marca").item(0).getTextContent());
					
					/*
					 * El modelo lo vamos a obtener convirtiendo el nodo en un 
					 * nodo de tipo texto
					 */
					Node nModelo = eElement.getElementsByTagName("modelo").item(0);
					Text modelo = (Text) nModelo.getFirstChild();
					
					System.out.println("Modelo: " + modelo.getData());
					//System.out.println("Modelo: " + .getTextContent());
					System.out.println("Cilindrada: " + eElement.getElementsByTagName("cilindrada").item(0).getTextContent());
				}
			}
			
			

		} catch (Exception ex) {

			System.out.println("¡Error! No se ha podido cargar el documento XML: " + ex.getMessage());

		}

	}

}
