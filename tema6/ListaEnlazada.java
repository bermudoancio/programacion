package tema6;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public E get(int index) {
		
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
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
		// TODO Auto-generated method stub
		
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

}
