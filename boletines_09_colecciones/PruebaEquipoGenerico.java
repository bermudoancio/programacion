package boletines_09_colecciones;

public class PruebaEquipoGenerico {

	public static void main(String[] args) {
		EquipoGenerico<Alumno> e1 = new EquipoGenerico<>("New Team");
		EquipoGenerico<AlumnoAventajado> e2 = new EquipoGenerico<>("Betis");

		Alumno a1 = new Alumno("A1", "asdfasd");
		Alumno a2 = new Alumno("A2", "asdfasd");
		Alumno a3 = new Alumno("A3", "asdfasd");
		Alumno a4 = new Alumno("A4", "asdfasd");
		
		AlumnoAventajado av1 = new AlumnoAventajado("AV1", "123456");
		
		try {
			e1.add(a1);
			e1.add(a2);
			e1.add(a3);
			e1.add(a4);
			
			e2.add(av1);
			
			e1.union(e2);
		} 
		catch (EquipoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
