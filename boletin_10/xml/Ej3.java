package ejercicio3;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ej3 {

	public static void main(String[] args) {

		try {

			// Obtenemos el DocumentBuilder
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();

			// Obtenemos el documento a través de la ruta
			Document doc = db.parse("./src/ejercicio3/desayuno.xml");

			// Obtenemos un listado de los nodos "food"
			NodeList listaComidas = doc.getElementsByTagName("food");

			ejercicioUno(listaComidas);

			ejercicioDos(listaComidas);

			ejercicioTres(listaComidas);

			ejercicioCuatro(doc);

			// Se actualiza el listado de elementos "food" para que se reflejen los cambios
			// realizados en el ejercicio anterior
			listaComidas = doc.getElementsByTagName("food");

			ejercicioCinco(doc, listaComidas);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Método dónde se realiza el listado de comidas con un precio inferior a 5€
	 * 
	 * @param listaComidas
	 */
	private static void ejercicioUno(NodeList listaComidas) {

		// Iteramos el listado de comidas
		for (int i = 0; i < listaComidas.getLength(); i++) {
			Element comida = (Element) listaComidas.item(i);

			// Obtenemos el precio de cada comida
			Element precio = (Element) comida.getElementsByTagName("price").item(0);

			// Parseamos a double el texto del nodo precio quitando el símbolo de € y
			// cambiando las comas por puntos
			// double precioComida = Double.parseDouble(precio.getTextContent().replace("€",
			// "").replace(",", "."));
			double precioComida = Double.parseDouble(
					precio.getTextContent().substring(0, (precio.getTextContent().length() - 1)).replace(",", "."));

			// Si el precio es menor que 5:
			if (precioComida < 5) {

				// Se obtiene el nombre de la comida y se muestra
				Element nombre = (Element) comida.getElementsByTagName("name").item(0);
				System.out.println("Nombre comida " + (i + 1) + ": " + nombre.getTextContent());
			}
		}
		System.out.println();

	}

	/**
	 * Método dónde se realiza el listado de comidas con un valor calórico inferior
	 * a 500 calorías
	 * 
	 * @param listaComidas
	 */
	private static void ejercicioDos(NodeList listaComidas) {

		// Iteramos el listado de comidas
		for (int i = 0; i < listaComidas.getLength(); i++) {
			Element comida = (Element) listaComidas.item(i);

			// Obtenemos las calorias de cada comida
			Element calorias = (Element) comida.getElementsByTagName("calories").item(0);

			// Parseamos a double el texto del nodo calories
			double caloriasComida = Double.parseDouble(calorias.getTextContent());

			// Si las calorías son iferiores a 500:
			if (caloriasComida < 500) {

				// Se obtiene el nombre de la comida y se muestra
				Element nombre = (Element) comida.getElementsByTagName("name").item(0);
				System.out.println("Nombre comida " + (i + 1) + ": " + nombre.getTextContent());
			}
		}

	}

	/**
	 * Método dónde se realiza la agregación del atributo "id" al elemento "food"
	 * con un valor númerico creciente
	 * 
	 * @param listaComidas
	 */
	private static void ejercicioTres(NodeList listaComidas) {

		// Se recorre la lista de comidas y se le añade el atributo id
		for (int i = 0; i < listaComidas.getLength(); i++) {
			Element comida = (Element) listaComidas.item(i);
			comida.setAttribute("id", (i + 1) + "");
		}

	}

	/**
	 * Método dónde se realiza la creación de una nueva comida, con elementos hijos
	 * y se añade al documento cargado en memoria, por último se guarda en el
	 * fichero "desayunoModificado.xml"
	 * 
	 * @param doc
	 */
	private static void ejercicioCuatro(Document doc) {

		// Se crea un nuevo elemento "food" y lo agregamos al elemento raíz
		Element comidaNueva = doc.createElement("food");
		doc.getDocumentElement().appendChild(comidaNueva);

		// Creamos un nuevo elemento "name", le asignamos un texto y la añadimos al
		// elemento "food" creado anteriormente
		Element nombreComidaNueva = doc.createElement("name");
		nombreComidaNueva.setTextContent("Huevos revueltos con café");
		comidaNueva.appendChild(nombreComidaNueva);

		// Creamos un nuevo elemento "price", le asignamos un texto y la añadimos al
		// elemento "food"
		Element precioComidaNueva = doc.createElement("price");
		precioComidaNueva.setTextContent("2.80€");
		comidaNueva.appendChild(precioComidaNueva);

		// Creamos un nuevo elemento "description", le asignamos un texto y la añadimos
		// al elemento "food"
		Element descripcionComidaNueva = doc.createElement("description");
		descripcionComidaNueva.setTextContent(
				"Huevos rehogados, con aceite de oliva virgen extra, ajo, cebolla y pimiento verde y café con leche.");
		comidaNueva.appendChild(descripcionComidaNueva);

		// Creamos un nuevo elemento "calories", le asignamos un texto y la añadimos al
		// elemento "food"
		Element caloriasComidaNueva = doc.createElement("calories");
		caloriasComidaNueva.setTextContent("350");
		comidaNueva.appendChild(caloriasComidaNueva);

		// Se guarda el documento
		guardaDoc(doc, "./src/ejercicio3/desayunoModificado.xml");

	}

	/**
	 * Método dónde se eliminan de la lista de comidas recibida todas aquellas
	 * comidas con un valor calórico superior a 500 calorías, por último se guarda
	 * el documento cargado en memoria en el fichero "desayunoSaludable.xml"
	 * 
	 * @param doc
	 * @param listaComidas
	 */
	private static void ejercicioCinco(Document doc, NodeList listaComidas) {

		// Se recorre el listado de comidas
		for (int i = 0; i < listaComidas.getLength(); i++) {
			Element comida = (Element) listaComidas.item(i);

			// Obtenemos las calorias de cada comida
			Element calorias = (Element) comida.getElementsByTagName("calories").item(0);

			// Parseamos a double el texto del nodo calories
			double caloriasComida = Double.parseDouble(calorias.getTextContent());

			// Si las calorías son superiores a 500, le decimos al nodo padre que borre la
			// comida actual y decrementamos el recorrido del listado
			if (caloriasComida > 500) {
				comida.getParentNode().removeChild(comida);
				i--;
			}
		}

		// Se guarda el documento
		guardaDoc(doc, "./src/ejercicio3/desayunoSaludable.xml");

	}

	/**
	 * Método que guarda el documento recibido por parámetros en la ruta de salida
	 * especificada
	 * 
	 * @param doc
	 * @param rutaSalida
	 */
	private static void guardaDoc(Document doc, String rutaSalida) {

		try {
			// Declaramos un nuevo Transformer
			Transformer t = TransformerFactory.newInstance().newTransformer();

			// Normalizamos el documento
			doc.normalizeDocument();

			// Asignamos las propiedas de salida para el transformador
			t.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			t.setOutputProperty(OutputKeys.INDENT, "yes");

			// Declaramos el documento fuente
			DOMSource fuente = new DOMSource(doc);

			// Declaramos el flujo de salida
			StreamResult resultado = new StreamResult(rutaSalida);

			// Guardamos el documento cargado en memoria
			t.transform(fuente, resultado);

		} catch (TransformerException | TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		}

	}

}
