package boletines_09_colecciones.correo;


public class PrincipalCorreo {

	public static void main(String[] args) {
		try {
			Alumno a1 = new Alumno("123", "Paquito", 17, 1);
			Alumno a2 = new Alumno("321", "Anita", 23, 2);
			Profesor p1 = new Profesor("111", "Joselito", 35);
			
			a2.enviarCorreo("Hola", p1);
			a1.enviarCorreo("Hola profe", p1);
			a2.enviarCorreo("Prueba", p1);
			p1.enviarCorreo("Otro", p1);
			//a1.enviarCorreo("Hola compi", a2);
			
			System.out.println(p1.mostrarMensajes());
			System.out.println("--------------");
			System.out.println(p1.mostrarMensajesOrdenados());
			
			System.out.println("--------------");
			
			System.out.println(p1.buscarMensajesConTexto("Hola"));
		} 
		catch (IESException e) {
			System.err.println(e.getMessage());
		}
	}

}
