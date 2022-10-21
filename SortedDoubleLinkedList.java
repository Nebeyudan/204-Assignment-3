import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

import javax.security.auth.callback.UnsupportedCallbackException;
/**
 * 
 * @author Nebeyu PC
 *
 * @param <T>
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{
		private Comparator<T> comparable;
	public SortedDoubleLinkedList(Comparator<T> sComp) {
		this.comparable = sComp;
		
	}
	/**
	 * 
	 * 
	 * Adds onto a new node by comparing the two data
	 * @param data which is being added
	 * @return void;
		 
	 */
	public void add(T newElement) {
		Node newNode = new Node(newElement);
		//checks its size and assigns new nodes
		if(size==0) {
			head = newNode;
			tail = newNode;
			size++;
		}
		//checks if the first val is greater than latter
		// then changes the data 
		else if(comparable.compare(newElement, head.data)<0) {
			head.data = newElement;
			newNode.next = head.next;
		}
		//else checks if the second val is greater
		// assigns new element to the tail
		else if(comparable.compare(newElement, head.data)>0){
			tail.next = newNode;
			tail.next.data = newElement;
			newNode.next = tail.prev;
		}
		
	}
	/**
	 * Invalid operation for sorted list
	 * @throws UnsupportedOperationException
	 */
	@Override
	//implement from super class
	public void addToEnd(T data){
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	/**
	 * Invalid operation for sorted list
	 * @throws UnsupportedOperationException
	 */
	@Override
	//implement from super class
	public void addToFront(T data){
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	/**
	 * implements the super class remove
	 */
	@Override
	//implement from super class
	public BasicDoubleLinkedList.Node remove(T newElement, Comparator<T> sComp) {
		return super.remove(newElement, sComp);
		
	}
	/**
	 * implements the super class iterator
	 */
	@Override
	//implement from super class
	public ListIterator<T> iterator() {
		// TODO Auto-generated method stub
		return super.iterator();
	}

}
