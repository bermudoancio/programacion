package boletin_09_granAlmacen;

import java.util.LinkedList;
import java.util.List;

public class Caja {

	private boolean abierta;

	private List<Integer> clientes;

	public Caja() {
		this.clientes = new LinkedList<>();
		this.abierta = false;
	}

	public boolean estaAbierta() {
		return this.abierta;
	}

	public void abrir() {
		this.abierta = true;
	}

	public void cerrar() {
		this.abierta = false;
	}

	public boolean tieneClientes() {
		return !this.clientes.isEmpty();
	}

	public int getNumClientes() {
		return this.clientes.size();
	}

	public void addCliente(int numCliente) {
		this.clientes.add(numCliente);
	}

	public int atenderCliente() {
		return this.clientes.remove(0);
	}
}
