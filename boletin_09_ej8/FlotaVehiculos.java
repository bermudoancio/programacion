package boletin_09_ej8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlotaVehiculos {
	
	private Map<String, Vehiculo> vehiculos;

	/**
	 *  Variable que guarda donde se insertará el siguiente vehiculo
	 *  Empieza con 0 y si vale vehiculos.length el almacen esta lleno
	 */
	private int numeroRealDeVehiculos;

	public FlotaVehiculos() throws VehiculoException {
		vehiculos = new HashMap<>();
		numeroRealDeVehiculos = 0;
	}

	public void introducirVehiculo(Vehiculo vehiculo) throws VehiculoException {
		if (vehiculos.containsKey(vehiculo.getMatricula())) {
			throw new VehiculoException("La matrícula ya existe");
		}
		
		numeroRealDeVehiculos++;
		vehiculos.put(vehiculo.getMatricula(), vehiculo);
		
	}

	private Vehiculo buscarMatricula(String matricula) {
		return vehiculos.get(matricula);
	}

	public double precioAlquiler(String matricula, int dias) throws VehiculoException {
		Vehiculo buscado = buscarMatricula(matricula);
		if (buscado == null) {
			throw new VehiculoException("La matrícula buscada no existe");
		}
		
		return buscado.calcularAlquiler(dias);
	}
	
	public List<Vehiculo> listadoOrdenadoMatriculas(){
		List<Vehiculo> l = new ArrayList<Vehiculo>(this.vehiculos.values());
//		l.sort(new Comparator<Vehiculo>() {
//			public int compare(Vehiculo v1, Vehiculo v2) {
//				return v1.getMatricula().compareTo(v2.getMatricula());
//			}
//		});
//		return l;
		
		return l.stream().sorted((v1, v2) -> v1.getMatricula().compareTo(v2.getMatricula()))
				.collect(Collectors.toList());
		
	}
	
	public List<Vehiculo> listadoOrdenadoPorPrecio(int dias, double minPrecio) {
		return this.vehiculos.values().stream()
				.filter(v -> {
					boolean pasa = false;
					try {
						pasa = v.calcularAlquiler(dias) >= minPrecio;
					} catch (VehiculoException e1) {
						
					}
					return pasa;
				})
				.sorted((v1, v2) -> {
					int orden = 0;
					try {
						orden = (int)(v1.calcularAlquiler(dias) - v2.calcularAlquiler(dias));
					} catch (VehiculoException e) {
						
					}
					return orden;
				})
				.toList();
	}
	
	public List<Vehiculo> listadoFurgonetasOrdenadoPMA() {
		List<Vehiculo> l = new ArrayList<Vehiculo>(this.vehiculos.values());
		
		return l.stream().filter(e -> e instanceof Furgoneta)
				.map(e -> (Furgoneta) e)
				.sorted(new Comparator<Furgoneta>() {
					public int compare(Furgoneta f1, Furgoneta f2) {
						return f1.getPma() - f2.getPma();
					}
				}).collect(Collectors.toList());
	}
	
	public List<Vehiculo> listadoOrdenadoGama() {
		return this.vehiculos.values().stream()
		.sorted( (v1, v2) -> v1.getGama().ordinal() - v2.getGama().ordinal())
		.collect(Collectors.toList());
	}
	
	public String toString() {
		
		return null;
		
		
	}
}
