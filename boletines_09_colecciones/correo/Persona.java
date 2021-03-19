package boletines_09_colecciones.correo;
import java.util.LinkedList;
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
		
	}
	
	/**
	 * Si no tiene ningún mensaje salta la excepción
	 * @return
	 * @throws IESException
	 */
	
	public String mostrarMensajes() throws IESException{
		return null;
	}
	
	/**
	 * 
	 * @param numeroMensaje De 1 en adelante
	 * @throws IESException 
	 */
	public void borrarMensaje( int numeroMensaje) throws IESException{
	
		
	}
	
	
	public String mostrarMensajesOrdenados()throws IESException{
		return null;
	}	
	
	
	public String buscarMensajesConTexto( String texto) throws IESException{
		return null;
	}
}
