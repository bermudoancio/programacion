package boletines_09_colecciones;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class ListaEnlazada<E> implements List<E> {
	
	// El n�mero de elementos que contiene actualmente la lista
	private int numElementos;
	// El primer nodo de la lista
	private Nodo<E> primero;
	// El �ltimo nodo de la lista
	private Nodo<E> ultimo;

	public ListaEnlazada() {
		this.numElementos = 0;
		this.primero = null;
		this.ultimo = null;
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
		return this.indexOf(o) != -1;
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
		Nodo<E> n = new Nodo<>(e);
		
		if (primero == null) {
			primero = n;
			ultimo = n;
		}
		else {
			ultimo.setSiguiente(n);
			n.setAnterior(ultimo);
			ultimo = n;
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
		
		checkValidIndex(index);
		
		Nodo<E> t;
		if (index < numElementos / 2) {
			t = primero;
			for (int i = 0; i < index; i++) {
				t = t.getSiguiente();
			}
		}
		else {
			t = ultimo;
			for (int i = numElementos - 1; i > index; i--) {
				t = t.getAnterior();
			}
		}
		
		return t.getElemento();
	}
	
	public void checkValidIndex(int index) {
		if (index < 0 || index >= this.numElementos) {
			throw new IndexOutOfBoundsException();
		}
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
		int indiceTemporal = 0;
		
		// Suponemos que o nunca es null
		for (Nodo<E> n = primero; n != null && indice == -1; n = n.getSiguiente()) {
			if (o == null && n.getElemento() == null || n.getElemento().equals(o)) {
				indice = indiceTemporal;
			}
			else {
				indiceTemporal++;
			}
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
        private Nodo<E> siguiente;
        private int indice;
		
		protected ListaEnlazadaIterator() {
			indice = 0;
			siguiente = primero;
		}
		
		@Override
		public boolean hasNext() {
			return (indice < numElementos);
		}

		@Override
		public E next() {
			if (indice >= numElementos) {
				// Han llamado a next sin hacer antes hasNext y ya no hab�a m�s elementos
				throw new NoSuchElementException();
			}
			
			ultimoDevuelto = siguiente;
			siguiente = siguiente.getSiguiente();
			
			indice++;
			
			return ultimoDevuelto.getElemento();
		}
		
		@Override
		public void remove() {
			// Si llaman a remove sin hacer un next()
			if (ultimoDevuelto == null) {
				throw new IllegalStateException();
			}
			
			Nodo<E> sig = ultimoDevuelto.getSiguiente();
			Nodo<E> ant = ultimoDevuelto.getAnterior();
			
			if (ant == null) {
				// Era el primero
				primero = sig;
			}
			else {
				ant.setSiguiente(sig);
			}
			
			if (sig == null) {
				// Era el �ltimo
				ultimo = ant;
			}
			else {
				sig.setAnterior(ant);
			}
			
			// puntero ahora debe ser nulo
			ultimoDevuelto.setElemento(null);
			ultimoDevuelto = null;
			
			// El tama�o de la lista se ha reducido
			numElementos--;
			
			// Decrementamos tambi�n el �ndice que indica el elemento que iteramos
			indice--;
		}
		
	}

}
