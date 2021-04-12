package boletines_09_colecciones;

public class PruebaEquipo {

	public static void main(String[] args) {
		Equipo e1 = new Equipo("Equipo 1");
		Equipo e2 = new Equipo("Equipo 2");
		
		Alumno a1 = new Alumno("Jose", "123456");
		Alumno a2 = new Alumno("Otro", "123456");
		Alumno a3 = new Alumno("Otro1", "123456");
		Alumno a4 = new Alumno("Otro2", "123456");
		Alumno a5 = new Alumno("Otro3", "123456");
		Alumno a6 = new Alumno("Otro4", "123456");
		
		Alumno a7 = new AlumnoAventajado("José Manuel", "321654987");
		
			
		try {
			e1.add(a1);
			e1.add(a2);
			e1.add(a3);
			e1.add(a4);
			
						
			e2.add(a3);
			e2.add(a4);
			e2.add(a5);
			e2.add(a6);
			
			e1.muestraEquipo();
			System.out.println("----------------");
			e2.muestraEquipo();
			System.out.println("----------------");
			
			//e1.union(e2);
			e1.interseccion2(e2);
			e1.muestraEquipo();
		} 
		catch (EquipoException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
