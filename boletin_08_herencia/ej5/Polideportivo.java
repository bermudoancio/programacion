package boletin_08_herencia.ej5;

public class Polideportivo implements IEdificio, IInstalacionDeportiva {

	private int tipoInstalacion;
	private double superficieEdificio;
	
	public Polideportivo(int tipo, double superficie) throws InvalidValueException {
		this.setTipoInstalacion(tipo);
		this.setSuperficieEdificio(superficie);
	}

	public void setTipoInstalacion(int tipoInstalacion) {
		this.tipoInstalacion = tipoInstalacion;
	}

	public void setSuperficieEdificio(double superficieEdificio) throws InvalidValueException {
		if (superficieEdificio <= 0) {
			throw new InvalidValueException("La superficie del Edificio debe ser un número válido.");
		}
		this.superficieEdificio = superficieEdificio;
	}

	@Override
	public int getTipoInstalacion() {
		return tipoInstalacion;
	}

	@Override
	public double getSuperficieEdificio() {
		return superficieEdificio;
	}

	@Override
	public String toString() {
		return "Polideportivo [tipoInstalacion=" + getTipoInstalacion() + ", superficieEdificio=" + getSuperficieEdificio() + "]";
	}

}
