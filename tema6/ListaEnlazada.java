package tema6;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ListaEnlazada<E> implements List<E> {

	private Nodo<E> primero;
	private Nodo<E> ultimo;
	
	private int size;
	
	public ListaEnlazada() {
		primero = null;
		ultimo = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return primero == null;
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
		
		Nodo<E> nodo = new Nodo<>(e);
		
		if (this.isEmpty()) {
			primero = nodo;
			ultimo = nodo;
		}
		else {
			// La lista no está vacía. Cojo el último
			ultimo.setSiguiente(nodo);
			ultimo = ultimo.getSiguiente();
		}
		
		this.size++;
		
		return true;
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
	
	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public E get(int index) {
		
		checkIndex(index);
		
		Nodo<E> n = primero;
		for (int i = 0; i < index; i++) {
			n = n.getSiguiente();
		}
		
		return n.getElemento();
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, E element) {
		
		checkIndex(index);
		
		Nodo<E> nodo = new Nodo<>(element);
		
		Nodo<E> n = primero;
		
		if (index == 0) {
			nodo.setSiguiente(n);
			primero = nodo;
		}
		else {
			for (int i = 1; i < index; i++) {
				n = n.getSiguiente();
			}
			nodo.setSiguiente(n.getSiguiente());
			
			n.setSiguiente(nodo);
		}
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		
		Nodo<E> n = primero;
		
		int indice = -1;
		
		for (int i = 0; i < size && indice == -1; i++) {
			if (o == null && n.getElemento() ==  null || 
				n.getElemento() != null && n.getElemento().equals(o)) {
				indice = i;
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
	
	class ListaEnlazadaIterator implements Iterator<E> {

		int contador;
		
		Nodo<E> siguiente;
		Nodo<E> ultimoDevuelto;
		Nodo<E> anteriorAlUltimoDevuelto;
		
		public ListaEnlazadaIterator() {
			contador = 0;
			siguiente = primero;
		}
		
		@Override
		public boolean hasNext() {
			return contador < size;
		}

		@Override
		public E next() {
			
			if (contador >= size) {
				throw new NoSuchElementException();
			}
			
			anteriorAlUltimoDevuelto = ultimoDevuelto;
			
			ultimoDevuelto = siguiente;
			
			siguiente = siguiente.getSiguiente();
			
			contador++;
			
			return ultimoDevuelto.getElemento();
		}
		
		@Override
		public void remove() {
			if (ultimoDevuelto == null) {
				throw new IllegalStateException();
			}
			
			// if (contador == 1)
			if (anteriorAlUltimoDevuelto == null) {
				// Es el primer elemento
				primero = ultimoDevuelto.getSiguiente();
			}
			else {
				anteriorAlUltimoDevuelto.setSiguiente(siguiente);
			}
			
			if (siguiente == null) {
				ultimo = anteriorAlUltimoDevuelto;
			}
			
			// Actualizo el tamaño
			--size;
			
			// Actualizo el índice por el que voy
			--contador;
			
			ultimoDevuelto = null;
			
		}
		
	}

}
