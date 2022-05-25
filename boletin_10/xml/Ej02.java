package boletin_10.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class Ej02 {
	public static void main(String[] args) {
		try {
			// 1º Creamos una nueva instancia de un fábrica de constructores de documentos.
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// 2º A partir de la instancia anterior, fabricamos un constructor de
			// documentos, que procesará el XML.
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 3º Procesamos el documento (almacenado en un archivo) y lo convertimos en un
			// árbol DOM.

			File archivo = new File("src/boletin_10/xml/web1.html");

			Document doc = db.parse(archivo);
//			// No del todo bien:Sacamos la lista de los nodos que tengan como nombre de etiqueta "title"
//			NodeList lista = doc.getElementsByTagName("title");
//			// Cogemos el primer nodo de la lista porque se supone que solo hay un título
//			Node titulo = lista.item(0);
//			// imprimimos su contenido
//			System.out.println("Título de la página web:" + titulo.getTextContent());
//			// ¿? DUDA: no consigo hacerlo sin coger la lista

			Element raiz = doc.getDocumentElement();
//			System.out.println(raiz.getTagName());
			NodeList listaNodos = raiz.getElementsByTagName("head");
			Element head = (Element) listaNodos.item(0);
			NodeList lista = head.getElementsByTagName("title");
			Element title = (Element) lista.item(0);
			System.out.println("Título de la página web:" + title.getTextContent());

//			NodeList n = doc.getElementsByTagName("h2");
//			for (int i = 0; i < n.getLength(); i++) {
//				Node nodo = n.item(i);
//				if (nodo.getNodeType() == (Node.TEXT_NODE)) {
//					System.out.println("El nodo " + nodo.getLocalName() + " es de texto.");
//				}
//			}

			// Contar cuántos divisores existen:
			NodeList listaDivisores = doc.getElementsByTagName("div");
			System.out.println("Número de divisores: " + listaDivisores.getLength());

			// Contar cuántos divisores tienen el atributo id con valor
			int contador = 0;
			for (int i = 0; i < listaDivisores.getLength(); i++) {
				Element elemento = (Element) listaDivisores.item(i);

				if (elemento.hasAttribute("id") && !elemento.getAttribute("id").isEmpty()) {
					contador++;
				}
			}
			System.out.println("Número de divisores con el atributo id: " + contador);

			// Imprimir el texto alternativo de todas las imágenes que haya

			// Sacamos la lista de las etiquetas img
			NodeList listaImagenes = doc.getElementsByTagName("img");
			System.out.println("\nTexto alternativo de imágenes:");

			// Recorremos las etiquetas img e imprimimos el valor del atributo alt.
			for (int i = 0; i < listaImagenes.getLength(); i++) {
				Element elemento1 = (Element) listaImagenes.item(i);
				System.out.println(elemento1.getAttribute("alt"));

			}

			// Imprimir por pantalla el titular de las noticias que haya en la página,
			// seguido del texto alternativo de la imagen que la acompaña.
			for (int i = 0; i < listaDivisores.getLength(); i++) {
				Element elemento = (Element) listaDivisores.item(i);
				if (elemento.getAttribute("class").equals("noticia")) {
					Element titular = (Element) elemento.getElementsByTagName("h2").item(0);
					Element imagen = (Element) elemento.getElementsByTagName("img").item(0);

					System.out.println(titular.getTextContent() + ": " + imagen.getAttribute("alt"));

				}

			}

			// Imprime por pantalla las opciones del menú principal
			Element body = (Element) raiz.getElementsByTagName("body").item(0);
			NodeList list = body.getElementsByTagName("div");

			for (int i = 0; i < list.getLength(); i++) {
				Element div = (Element) list.item(i);

				if (div.getAttribute("id").equals("menu-principal")) {
					// Busca todos los hijos, nietos...
					NodeList listaLi = div.getElementsByTagName("li");

					for (int j = 0; j < listaLi.getLength(); j++) {
						Element elemento = (Element) listaLi.item(j);
						System.out.println(elemento.getTextContent());
					}
				}
			}

			// Muestra ahora todos los titulares de noticia, seguido en la línea de abajo
			// del texto de la misma
			for (int i = 0; i < listaDivisores.getLength(); i++) {
				Element elemento = (Element) listaDivisores.item(i);
				if (elemento.getAttribute("class").equals("noticia")) {
					Element titular = (Element) elemento.getElementsByTagName("h2").item(0);
					Element parrafo = (Element) elemento.getElementsByTagName("p").item(0);
					System.out.println(titular.getTextContent() + ": \n" + parrafo.getTextContent());
				}
			}

		}
		catch (Exception ex) {
			System.out.println("¡Error! No se ha podido cargar el documento XML.");
		}

	}
}
