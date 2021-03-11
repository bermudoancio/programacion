package boletin_08_herencia.ej5;

public class EdificioOficinas implements IEdificio {

	private double superficieEdificio;
	
	public EdificioOficinas(double superficie) throws InvalidValueException {
		this.setSuperficieEdificio(superficie);
	}
	
	public void setSuperficieEdificio(double superficieEdificio) throws InvalidValueException {
		if (superficieEdificio <= 0) {
			throw new InvalidValueException("La superficie del Edificio debe ser un número válido.");
		}
		this.superficieEdificio = superficieEdificio;
	}
	
	@Override
	public double getSuperficieEdificio() {
		return superficieEdificio;
	}

	@Override
	public String toString() {
		return "EdificioOficinas [superficieEdificio=" + getSuperficieEdificio() + "]";
	}

}
