package boletines_09_colecciones.correo;

public class Alumno extends Persona{


	
	private static final int CURSO_MAX_BACHILLERATO = 2;
	private static final int CURSO_MIN_BACHILLERATO = 1;
	private static final int CURSO_MIN_CICLO = 1;
	private static final int CURSO_MAX_CICLO = 2;
	private static final int CURSO_MIN_ESO = 1;
	private static final int CURSO_MAX_ESO = 4;

	
	private TipoEnsennanza ensennanza;
	private int curso;
	
	
	public Alumno(String dni, String nombre, int edad, TipoEnsennanza ensennanza, int curso) throws IESException {
		super(dni, nombre, edad);
		this.ensennanza=ensennanza;
		setCurso(curso);
	
	}


	public TipoEnsennanza getEnsennanza() {
		return ensennanza;
	}


	public int getCurso() {
		return curso;
	}


	private void setCurso(int curso) throws IESException {
		int cursoMenor=0, cursoMayor=0;
		
		switch (ensennanza){
		case CICLO:
			cursoMenor=CURSO_MIN_CICLO;
			cursoMayor=CURSO_MAX_CICLO;
			break;
		case BACHILLERATO:
			cursoMenor=CURSO_MIN_BACHILLERATO;
			cursoMayor=CURSO_MAX_BACHILLERATO;
			break;
		case ESO:
			cursoMenor=CURSO_MIN_ESO;
			cursoMayor=CURSO_MAX_ESO;
			break;
		}
		
		if ( curso< cursoMenor || curso > cursoMayor){
			throw new IESException("Valor del curso incorrecto");
		}
		this.curso = curso;
	}


	public void enviarCorreo(String msg, Persona personaDestinatario) throws IESException{
		
		
		
	}
	
	
	
	
	
	
}
