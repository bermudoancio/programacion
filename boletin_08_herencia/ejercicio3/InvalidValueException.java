package boletin_08_herencia.ejercicio3;


@SuppressWarnings("serial")
public class InvalidValueException extends Exception {

	private String[] mensajes;
	
	public void addMensajeError(String m) {
		
	}
	
	public String[] getMensajes() {
		return this.mensajes;
	}
	
	
  public InvalidValueException() {
	  mensajes = new String[10];
    // TODO Auto-generated constructor stub
  }

  public InvalidValueException(String message) {
    super(message);
    // TODO Auto-generated constructor stub
  }

  public InvalidValueException(Throwable cause) {
    super(cause);
    // TODO Auto-generated constructor stub
  }

  public InvalidValueException(String message, Throwable cause) {
    super(message, cause);
    // TODO Auto-generated constructor stub
  }

  public InvalidValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
    // TODO Auto-generated constructor stub
  }

}
