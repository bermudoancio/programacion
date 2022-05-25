package boletin_09_granAlmacen;

public class GranAlmacen {

	public static final int NUMERO_CAJAS = 20;

	private int numClientes;

	private Caja[] cajas;

	public GranAlmacen() {
		this.numClientes = 0;
		this.cajas = new Caja[GranAlmacen.NUMERO_CAJAS];
		for (int i = 0; i < this.cajas.length; i++) {
			this.cajas[i] = new Caja();
		}
	}

	public void abrirCaja(int numCaja) throws GranAlmacenException {

		this.validaCajaCerrada(numCaja);

		this.cajas[numCaja - 1].abrir();
	}

	private void validaCajaAbierta(int numCaja) throws GranAlmacenException {
		
		this.existeCaja(numCaja);
		
		if (!this.cajas[numCaja - 1].estaAbierta()) {
			throw new GranAlmacenException("La caja se encuentra cerrada.");
		}		
	}

	public void cerrarCaja(int numCaja) throws GranAlmacenException {

		this.validaCajaAbierta(numCaja);
		
		if (this.cajas[numCaja - 1].tieneClientes()) {
			throw new GranAlmacenException("La caja tiene que atender a los clientes antes de cerrar.");
		}

		this.cajas[numCaja - 1].cerrar();
	}

	private void validaCajaCerrada(int numCaja) throws GranAlmacenException {
		
		this.existeCaja(numCaja);
		
		if (this.cajas[numCaja - 1].estaAbierta()) {
			throw new GranAlmacenException("La caja se encuentra abierta.");
		}
		
	}

	private void existeCaja(int numCaja) throws GranAlmacenException {
		if (numCaja < 1 || numCaja > this.cajas.length) {
			throw new GranAlmacenException("La caja no existe.");
		}		
	}

	public int nuevoCliente() throws GranAlmacenException {

		int minClientes = Integer.MAX_VALUE;
		int numCaja = -1;

		for (int i = 0; i < this.cajas.length; i++) {

			if (this.cajas[i].estaAbierta() && this.cajas[i].getNumClientes() < minClientes) {
				minClientes = this.cajas[i].getNumClientes();
				numCaja = i;
			}
		}

		if (numCaja < 0) {
			throw new GranAlmacenException("No hay ninguna caja abierta.");
		}

		this.cajas[numCaja].addCliente(++this.numClientes);

		return ++numCaja;
	}

	public int atenderCliente(int numCaja) throws GranAlmacenException {

		this.validaCajaAbierta(numCaja);

		if (!this.cajas[numCaja - 1].tieneClientes()) {
			throw new GranAlmacenException("La caja que desea atender no tiene clientes.");
		}

		return this.cajas[numCaja - 1].atenderCliente();
	}

	public int getNumClientes() {
		return this.numClientes;
	}
}
