package tema7;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class EjemploXML1 {

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

		} catch (Exception ex) {

			System.out.println("¡Error! No se ha podido cargar el documento XML: " + ex.getMessage());

		}

	}

}
