package boletin_09_clase;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ListaEnlazada<E> implements List<E> {

	private int numElementos;
	
	// Apuntador al primer y al último nodo
	private Nodo<E> primero;
	private Nodo<E> ultimo;
	
	public ListaEnlazada() {
		// Inicializar el número de elementos a 0
		numElementos = 0;
	}
	
	@Override
	public int size() {
		return numElementos;
	}

	@Override
	public boolean isEmpty() {
		return numElementos == 0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return new ListaEnlazadaIterator();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		
		Nodo<E> nuevo = new Nodo<>(e);
		
		if (this.isEmpty()) {
			primero = nuevo;
			ultimo = nuevo;
		}
		else {
			ultimo.setSiguiente(nuevo);
			nuevo.setAnterior(ultimo);
			ultimo = nuevo;
		}
		
		numElementos++;
		
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		int indice = -1;
		int indiceTemp = 0;
		
		for (Nodo<E> x = primero; x != null && indice == -1; x = x.getSiguiente()) {
			
			if (o == null && x.getElemento() == null || x.getElemento().equals(o)) {
				indice = indiceTemp;
			}
			
			indiceTemp++;
		}
				
		return indice;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	protected class ListaEnlazadaIterator implements Iterator<E> {

		private Nodo<E> ultimoDevuelto;
		private int objetosDevueltos;
		
		public ListaEnlazadaIterator() {
			objetosDevueltos = 0;
		}
		
		@Override
		public boolean hasNext() {
			/*
			 * ListaEnlazada.this hace referencia al objeto ListaEnlazada
			 * que envuelve a este iterador en concreto. En este caso, al 
			 * no haber conflicto de nombres con la clase interna, no sería
			 * necesario y se podría obviar.
			 */
			return objetosDevueltos < ListaEnlazada.this.numElementos;
		}

		@Override
		public E next() {
			
			// Esta comprobación es equivalente a la realizada abajo
//			if (objetosDevueltos >= numElementos) {
//				throw new NoSuchElementException();
//			}
			
			if (ultimoDevuelto == null) {
				ultimoDevuelto = primero;
			}
			else {
				ultimoDevuelto = ultimoDevuelto.getSiguiente();
			}
			
			if (ultimoDevuelto == null) {
				throw new NoSuchElementException();
			}
			
			// Vamos a devolver un objeto más
			objetosDevueltos++;
			
			return ultimoDevuelto.getElemento();
		}
		
	}

}
