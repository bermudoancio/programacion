package boletin_10.xml;
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

public class Ej01 {

	
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
			// 1� Creamos una nueva instancia de un f�brica de constructores de documentos.
			 DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			
			 // 2� A partir de la instancia anterior, fabricamos un constructor de
			 // documentos, que procesar� el XML.
			 DocumentBuilder db = dbf.newDocumentBuilder();
			 
			 // Construimos un objeto del tipo Document
			 Document doc = db.newDocument();
			 
			 // Al document se le a�ade el nodo principal o ra�z
			 Element rootElement = doc.createElement("personas");
		     doc.appendChild(rootElement);
		     
		     // Recorremos la lista
		     for(Persona p: lista) {
		    	 
		    	 // Creamos el nodo que representa a la persona
		    	 Element persona = doc.createElement("persona");
		    	 
		    	 // A�adimos al nodo padre
		    	 rootElement.appendChild(persona);
		    	 
		    	 // Creamos los siguientes elementos hijos del nodo persona y se le da valor en la siguiente l�nea
		    	 Element nombre = doc.createElement("nombre");
		    	 nombre.setTextContent(p.getNombre());
		    	 
		    	 Element dni = doc.createElement("dni");
		    	 dni.setTextContent(p.getDNI());
		    	 
		    	 Element telefono = doc.createElement("telefono");
		    	 telefono.setTextContent(p.getTelefono());
		    	 
		    	 Element fechaNac = doc.createElement("fechaNacimiento");
		    	 fechaNac.setTextContent(p.getFechaNacimiento().toString());
		    	 
		    	 // A�adimos todos los elementos a persona
		    	 persona.appendChild(nombre);
		    	 persona.appendChild(dni);
		    	 persona.appendChild(telefono);
		    	 persona.appendChild(fechaNac);
		     }	
		     	// 1� Creamos una instancia de la clase File para acceder al archivo donde
				// guardaremos el XML.

				File f = new File("D:\\Personal\\Instituto\\Asignaturas\\Programacion\\Tema 7\\personas.xml");

				// 2� Creamos una nueva instancia del transformador a trav�s de la f�brica de
				// transformadores.

				Transformer transformer = TransformerFactory.newInstance().newTransformer();

				// 3� Establecemos algunas opciones de salida, como por ejemplo, la codificaci�n
				// de salida.

				transformer.setOutputProperty(OutputKeys.INDENT, "yes");

				transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

				// 4� Creamos el StreamResult, que intermediar� entre el transformador y el
				// archivo de destino.

				StreamResult result = new StreamResult(f);

				// 5� Creamos el DOMSource, que intermediar� entre el transformador y el �rbol
				// DOM.

				DOMSource source = new DOMSource(doc);

				// 6� Realizamos la transformaci�n.

				transformer.transform(source, result);
		} 
		catch (Exception ex) {
			System.out.println("�Error! No se ha podido cargar el documento XML." + ex.getMessage());
		}

		
	}
}
