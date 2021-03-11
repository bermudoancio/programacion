package boletines_09_colecciones;

public class Nodo<E> {

	private E elemento;
	private Nodo<E> anterior;
	private Nodo<E> siguiente;
	
	public Nodo(E e) {
		this.elemento = e;
	}

	/**
	 * @return the elemento
	 */
	public E getElemento() {
		return elemento;
	}

	/**
	 * @param elemento the elemento to set
	 */
	public void setElemento(E elemento) {
		this.elemento = elemento;
	}

	/**
	 * @return the anterior
	 */
	public Nodo<E> getAnterior() {
		return anterior;
	}

	/**
	 * @param anterior the anterior to set
	 */
	public void setAnterior(Nodo<E> anterior) {
		this.anterior = anterior;
	}

	/**
	 * @return the siguiente
	 */
	public Nodo<E> getSiguiente() {
		return siguiente;
	}

	/**
	 * @param siguiente the siguiente to set
	 */
	public void setSiguiente(Nodo<E> siguiente) {
		this.siguiente = siguiente;
	}
	
	

}
