package clase.herencia;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class VehiculoMotorizado extends Vehiculo implements Arrancable {

	public VehiculoMotorizado(int numeroRuedas, int numeroPasajeros) {
		super(numeroRuedas, numeroPasajeros);
		// TODO Auto-generated constructor stub
		ArrayList<Arrancable> v;
	}
	
	public VehiculoMotorizado() {
		Scanner a;
	}

	public void claxon() throws ParametroInvalidoException {
		//super.claxon();
		System.out.println("Claxon en vehiculo motorizado");
		throw new ParametroInvalidoException();
	}
	
	public abstract void repostar();

}
