package boletines_09_colecciones.correo;

public class Alumno extends Persona{

	private int curso;
	
	
	public Alumno(String dni, String nombre, int edad, int curso) throws IESException {
		super(dni, nombre, edad);
		setCurso(curso);
	
	}


	public int getCurso() {
		return curso;
	}


	private void setCurso(int curso) throws IESException {
		this.curso = curso;
	}


	public void enviarCorreo(String msg, Persona personaDestinatario) throws IESException{
		if (this.getEdad() < 18 && personaDestinatario instanceof Alumno) {
			throw new IESException("No puedes enviar mensajes a otros alumnos");
		}
		
		super.enviarCorreo(msg, personaDestinatario);
	}
	
	
	
	
	
	
}
