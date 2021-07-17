
package project3;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Collection;

/**
 * LinkedList class is the generic linked list class. 
 * This class implements java.util.Collection<E> interface and Iterable<E> interface.
 * Implements all the abstract methods within the two interfaces.
 * @author Yi Yang
 *
 * @param <E>
 */


public class LinkedList<E> implements Collection<E>, Iterable<E> {
	/**
	 * This class represents a Node.
	 * 
	 * @author Yi Yang
	 *
	 */

	private static class Node<E> {
		private E data;
		private Node<E> next;
		/**
		 * Constructs a node given data and next.
		 * @param data
		 * @param next
		 */
		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
		/**
		 * Returns the data.
		 * @return data
		 */
		public E getData() {
			return data;
		}
		
		/**
		 * Validates and sets the data.
		 * @param data
		 */
		@SuppressWarnings("unused")
		public void setData(E data) {
			this.data = data;
		}
		/**
		 * Returns the data
		 * @return data
		 */
		public Node<E> getNext() {
			return next;
		}

		/**
		 * Validates and sets next.
		 * @param next
		 */
		public void setNext(Node<E> next) {
			this.next = next;
		}
		/**
		 * Validates if the object is equal to the data
		 * @param o
		 * @return true if it is equal, false otherwise
		 */
		public boolean equals(Object o) {
			 return data.equals(o);
		 }
		
	}
	
	/**
	 * Iter class iterates through the linked list.
	 * This class implements the Iterator<E> interface.
	 * @author Yi Yang
	 *
	 */
	private class Iter implements Iterator<E> {

		Node<E> current = head;



		/**
		 * Checks if the current element has an element following.
		 * @return true if there is an element after the current Node, false otherwise
		 */
		public boolean hasNext() {
			return current != null;
		}

		/**
		 * Returns the next element of the current Node.
		 * @return the next element of the current Node
		 */
		public E next() {

			E temp = current.getData();
			current = current.getNext();
			return temp;
		}

	}

	private Node<E> head;
	int size = 0;
	/**
	 * Constructs a new LinkedList.
	 */
	public LinkedList() {
		head = null;
	}
	/**
	 * Returns the index of the first occurrence of the specified element in this list,
	 * or -1 if this list does not contain the element
	 * @param o
	 * @return index of first occurence or -1.
	 */
	public int indexOf(Object o) {
		int index = 0;
		Node<E> current = head;

		while (current != null) {
			if (current.equals(o)) {
				return index;
			}
			current = current.getNext();
			index++;
		}
		return -1;
	}
	/**
	 * Returns the element at the specified position in this list.
	 * @param a given index
	 * @return the element at the specified position in this list.
	 */
	public E get(int index) throws IndexOutOfBoundsException{
		int count = 0;
		Node<E> current = head;
		if (index < 0) {
			throw new IndexOutOfBoundsException("Index cannot be negative.");
		}
		while (count < index) {
			current = current.getNext();
			if (index >= size()) {
				throw new IndexOutOfBoundsException("Index is too big.");
			}
			count++;
		}
		return current.getData();
	}
	/**
	 * Returns string value of this collection.
	 * @return the string representation of the collection.
	 */
	public String toString() {
		String string = "";
		Node<E> current = head;

		while (current.getNext() != null) {
			current = current.getNext();
		}
		string += "["+current.getData()+ ", "+"]";
		return string;
	}
	/**
	 * Sorts the Collection.
	 */
	@SuppressWarnings("unchecked")
	public void sort() {
		Object[] array = toArray();
		Arrays.sort(array);
		this.clear();
		for (Object o : array) {
			this.add((E) o);
		}
	}

	/**
	 * Checks if data can be added to the list, and adds the data to the list
	 * @param data
	 * @return true if the data have been added.
	 */
	public boolean add(E data) {
		Node<E> newNode = new Node<E>(data, null);
		Node<E> current = head;
		if (current == null) {
			head = newNode;
			head.setNext(null);
			size++;
			return true;
		} else {
			while (current.getNext() != null)
				current = current.getNext();

			current.setNext(newNode);
			size++;
			return true;
		}
	}
	/* (non-Javadoc)
	 * @see java.util.Collections#addAll(java.util.Collections)
	 */
	@Override
	public boolean addAll(Collection<? extends E> c) {

		return false;
	}
	
	/**
	 * Removes all of the elements from this collection
	 */
	public void clear() {
		head = null;
		size = 0;

	}
	/**
	 * Checks if the object is contained in the collection. 
	 * Returns true if this collection contains the specified element.
	 * @param an object
	 * @return true if it the collection contains such object, false otherwise
	 */
	public boolean contains(Object o) {
		if (this.indexOf(o) != -1) {
			return true;
		} else
			return false;
	}

	/**
	 * Checks if all the objects are contained in the collection.
	 * Returns true if this collection contains all of the elements in the specified collection.
	 * @param c
	 * @return true if the collection contains all the objects, false otherwise
	 */
	public boolean containsAll(Collection<?> c) {
        for (Object e : c)
            if (!contains(e))
                return false;
        return true;
	}	
	/**
	 * Validates if the object is equal to the data.
	 * @param o
	 * @return true if it is the same, false if not
	 */
	public boolean equals(Object o) {
		if (this==o)
			return true;
		else
			return false;
	 }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode(java.lang.Object)
	 */
	@Override
	public int hashCode() {
		return 0;
	}

	/**
	 * Checks to see if the collection is empty.
	 * @return true if no element is in the collection
	 */
	public boolean isEmpty() {
		return (head == null);
	}
	
	/**
	 * Returns an iterator over the elements in this collection.
	 * @return an iterator over the elements in the collection
	 */
	public Iterator<E> iterator() {
		return new Iter();
	}

	/**
	 * Removes a single instance of the specified element from this collection, if it is present.
	 * @param object
	 * @return true if the element is successfully removed
	 */
	public boolean remove(Object o) {
		Node<E> current = head;

		while (current != null) {
			current.setNext(current.getNext().getNext());
				return true;
				
			}
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Collections#removeAll(java.util.Collections)
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see java.util.Collections#retainAll(java.util.Collections)
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	/**
	 * Returns the number of elements in this collection.
	 * @return the number of elements
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Returns an array containing all of the elements in this collection.
	 * @return an object array containing all the elements 
	 */
	public Object[] toArray() {
		Object[] array = new Object[size()];

		int n = 0;
		for (E e : this) {
			array[n] = e;
			n++;
		}
		return array;
	}

	@SuppressWarnings("unchecked")
	/**
	 * Returns an array containing all of the elements in this collection; 
	 * the runtime type of the returned array is that of the specified array.
	 */
	public <T> T[] toArray(T[] a) {
		int size = size();
		if (a.length < size) {
			//a = new T[size];
		} else if (a.length > size) {
			a[size] = null;
		}

		int i = 0;
		for (E e : this) {
			a[i] = (T) e;
			i++;
		}
		return a;
	}

	
	
	
}