package boletines_09_colecciones.correo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
	
	public void enviar() throws IESException {
		if (fechaEnvio != null) {
			throw new IESException("No puedes enviar un mensaje dos veces");
		}
		
		this.fechaEnvio = LocalDateTime.now();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		
		sb.append("De: ").append(this.remitente.getNombre()).append(System.lineSeparator())
		.append("Texto: ").append(this.getTexto()).append(System.lineSeparator())
		.append("Fecha y hora: ").append(this.getFechaEnvio().format(formatter));
		
		return sb.toString();
	}
}
