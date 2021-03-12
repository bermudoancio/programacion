package boletin_09_clase;

public class Nodo<E> {
	
	// El elemento que contiene
	private E elemento;
	
	// El puntero al siguiente nodo
	private Nodo<E> siguiente;
	
	// El puntero al anterior nodo
	private Nodo<E> anterior;
	
	public Nodo(E e){
		this.elemento = e;
	}

	public Nodo<E> getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo<E> siguiente) {
		this.siguiente = siguiente;
	}

	public Nodo<E> getAnterior() {
		return anterior;
	}

	public void setAnterior(Nodo<E> anterior) {
		this.anterior = anterior;
	}

	public E getElemento() {
		return elemento;
	}

	public void setElemento(E elemento) {
		this.elemento = elemento;
	}
	
}
