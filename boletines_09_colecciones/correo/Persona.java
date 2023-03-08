package boletines_09_colecciones.correo;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public abstract class Persona {
	
	private static final int EDAD_MINIMA = 12;
	
	// Atributos
	private String dni;
	private String nombre;
	private int edad;
	private LinkedList<Mensaje> mensajes;
	
	// Constructor
	public Persona(String dni,String nombre,int edad) throws IESException {
		this.dni=dni;
		this.nombre = nombre;
		mensajes = new LinkedList<Mensaje>();
		setEdad(edad);
	}

	// Métodos get y set
	public int getEdad() {
		return edad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	private void setEdad(int edad) throws IESException {
		if (edad < EDAD_MINIMA)
			throw new IESException("La edad minima es de" + EDAD_MINIMA);
		this.edad = edad;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
		
	public void enviarCorreo(String msg, Persona personaDestinatario) throws IESException{
		Mensaje m = new Mensaje(this, msg);
		
		personaDestinatario.mensajes.add(m);
		m.enviar();
	}
	
	/**
	 * Si no tiene ningún mensaje salta la excepción
	 * @return
	 * @throws IESException
	 */
	
	public String mostrarMensajes() throws IESException{
		if (this.mensajes.size() == 0) {
			throw new IESException("No hay mensajes");
		}
		
		StringBuilder sb = new StringBuilder();
		
		int indice = 1;
		for (Mensaje m: this.mensajes) {
			sb.append("Mensaje ").append(indice++).append(": ")
			.append(m).append(System.lineSeparator())
			.append("####################")
			.append(System.lineSeparator())
			.append(System.lineSeparator());
		}
		
		return sb.toString();
	}
	
	/**
	 * 
	 * @param numeroMensaje De 1 en adelante
	 * @throws IESException 
	 */
	public void borrarMensaje( int numeroMensaje) throws IESException{
		
		try {
			this.mensajes.remove(numeroMensaje);
		}
		catch (IndexOutOfBoundsException e) {
			throw new IESException("No existe ese índice");
		}
		
	}
	
	
	public String mostrarMensajesOrdenados()throws IESException{
		if (this.mensajes.size() == 0) {
			throw new IESException("No hay mensajes");
		}
		
		this.mensajes.sort(new Comparator<Mensaje>() {
			public int compare(Mensaje p1, Mensaje p2) {
				return p1.getRemitente().getNombre().compareTo(p2.getRemitente().getNombre());
			}
		});
		
		//this.mensajes.sort((a,b) -> a.getRemitente().getNombre().compareTo(b.getRemitente().getNombre()));
		
		return this.mostrarMensajes();
	}	
	
	
	public String buscarMensajesConTexto( String texto) throws IESException{
		StringBuilder sb = new StringBuilder();
		int indice = 1;
		
		for (Mensaje m: this.mensajes) {
			if (m.getTexto().contains(texto)) {
				sb.append("Mensaje ").append(indice++).append(": ")
				.append(m).append(System.lineSeparator())
				.append("####################")
				.append(System.lineSeparator())
				.append(System.lineSeparator());
			}
		}
		
		if (indice == 1) {
			throw new IESException("No hay mensajes que contengan dicho texto");
		}
		
		return sb.toString();
	}
}
