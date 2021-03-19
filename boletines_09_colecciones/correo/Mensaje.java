package boletines_09_colecciones.correo;

import java.time.LocalDateTime;

public class Mensaje {
	private Persona remitente;
	private String texto;
	private LocalDateTime fechaEnvio;
	
	public Mensaje (Persona remitente, String texto) throws IESException {
		if (remitente == null) {
			throw new IESException("El remitente no puede ser nulo");
		}
		this.remitente = remitente;
		this.texto = texto;
	}

	public Persona getRemitente() {
		return remitente;
	}

	public void setRemitente(Persona remitente) {
		this.remitente = remitente;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getFechaEnvio() {
		return fechaEnvio;
	}
	
	
}
