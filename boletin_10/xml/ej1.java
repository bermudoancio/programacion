package ej1;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ej1 {

	
	public static void main(String[] args) {
		
		LocalDate fecha = LocalDate.of(1984, 11, 25);
		
		Persona p1 = new Persona ("Alberto", "123456789", "666222333", fecha);
		Persona p2 = new Persona ("Abel", "123456789", "4569874", fecha);
		Persona p3 = new Persona ("Maria", "123456789", "022545", fecha);
		Persona p4 = new Persona ("Cristina", "123456789", "456832", fecha);
		Persona p5 = new Persona ("Jose", "123456789", "4267423", fecha);
		
		List<Persona> lista = new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		lista.add(p4);
		lista.add(p5);
		
		try {
			// 1º Creamos una nueva instancia de un fábrica de constructores de documentos.
			 DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			
			 // 2º A partir de la instancia anterior, fabricamos un constructor de
			 // documentos, que procesará el XML.
			 DocumentBuilder db = dbf.newDocumentBuilder();
			 
			 // Construimos un objeto del tipo Document
			 Document doc = db.newDocument();
			 
			 // Al document se le añade el nodo principal o raíz
			 Element rootElement = doc.createElement("personas");
		     doc.appendChild(rootElement);
		     
		     // Recorremos la lista
		     for(Persona p: lista) {
		    	 
		    	 // Creamos el nodo que representa a la persona
		    	 Element persona = doc.createElement("persona");
		    	 
		    	 // Añadimos al nodo padre
		    	 rootElement.appendChild(persona);
		    	 
		    	 // Creamos los siguientes elementos hijos del nodo persona y se le da valor en la siguiente línea
		    	 Element nombre = doc.createElement("nombre");
		    	 nombre.setTextContent(p.getNombre());
		    	 
		    	 Element dni = doc.createElement("dni");
		    	 dni.setTextContent(p.getDNI());
		    	 
		    	 Element telefono = doc.createElement("telefono");
		    	 telefono.setTextContent(p.getTelefono());
		    	 
		    	 Element fechaNac = doc.createElement("fechaNacimiento");
		    	 fechaNac.setTextContent(p.getFechaNacimiento().toString());
		    	 
		    	 // Añadimos todos los elementos a persona
		    	 persona.appendChild(nombre);
		    	 persona.appendChild(dni);
		    	 persona.appendChild(telefono);
		    	 persona.appendChild(fechaNac);
		     }	
		     	// 1º Creamos una instancia de la clase File para acceder al archivo donde
				// guardaremos el XML.

				File f = new File("D:\\Personal\\Instituto\\Asignaturas\\Programacion\\Tema 7\\personas.xml");

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

				DOMSource source = new DOMSource(doc);

				// 6º Realizamos la transformación.

				transformer.transform(source, result);
		} 
		catch (Exception ex) {
			System.out.println("¡Error! No se ha podido cargar el documento XML." + ex.getMessage());
		}

		
	}
}
