import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import javax.security.auth.callback.UnsupportedCallbackException;
/**
 * 
 * @author Nebeyu PC
 *
 * @param <T>
 */
public class BasicDoubleLinkedList<T> {
	
		protected Node head;
		protected Node tail;
		protected int size;
		/**
		 * Constructed that initializes variables
		 */
		//constructor initializing the parameters
		public BasicDoubleLinkedList() {
			head= null;
			tail = null;
			size =0;
		}
		/**
		 * method that adds data value to the end of the linked list
		 * @param data
		 * @return void;
		 */
			//method that adds onto the tail of the list
			public void addToEnd(T data)  {
				Node node = new Node(data);
				if(size ==0) {
					head = node;
					tail = node;
				}
				else {
					tail = node;
					tail.setNext(tail);
				}
				size++;
			}
			/**
			 * Method that adds data to the front of the linked list
			 * @param data
			 * return void;
			 */
			//adds to the front of the list
			public void addToFront(T data)  {
				Node node = new Node(data);
				if(size ==0) {
					head = node;
				}
				else {
					head =node;
					node.next = head;
				}
				size++;
			}
			
				
		/**
		 * 
		 * @author Nebeyu PC
		 * protected Node class used for linked list
		 */
		
		
		//protected class for node
		protected class Node{
			protected T data;
			protected Node prev;
			protected Node next;
			/**
			 * Parameterized constructor
			 * @param T dataNode
			 */
		//paramatized constr	
			Node(T dataNode){
				prev = null;
				next = null;
				data = dataNode;
			//getter and setters	
			}
			public Node getNext() {
				return next;
			}
			public void setNext(Node next) {
				this.next = next;
			}
			public Node getPrev() {
				return prev;
			}
			public void setPrev(Node prev) {
				this.prev = prev;
				
			}
			public T getData() {
				return data;
			}
			public void setData(T data) {
				this.data = data;
			}
			
		
		}
		/**
		 * 
		 * @author Nebeyu PC
		 *Protected Iterator class that implements ListIterator
		 */
		//protected class for iterator	
		protected class Iterator implements ListIterator<T>{
			protected Node node;
			protected Node LastNode;
			protected int i;
			/**
			 * constructor for iterator class
			 */
			//constructor for iterator
			Iterator(){
				node = head;
				LastNode = null;
				i =0;
			}
			/**
			 * checks if has next 
			 * @return boolean
			 */
			//checks if it has next
			public boolean hasNext() {
				return (i<size);
			}

			/**
			 * goes on to the next value in data and continues to iterate
			 * @return T
			 */
			//after checking next it assigns the value to a new 
			// node and then iterates to the next
			public T next() {
				Node newNode= new Node(node.getData());
				if(hasNext()==true) {
					T result = node.data; 
					newNode.next = head;
					head.prev = newNode;
					head = newNode;
					i++;
					return result;
				}
				else {
					throw new NoSuchElementException();
					
				}
			}
			/**
			 * checks if previous is available
			 * @return boolean
			 */
			//check if their is a prev value on 
			//list
			public boolean hasPrevious() {
				if(i>0) {
					return true;
				}
				else return false;
			}

			/**
			 * after it checks it iterates back one
			 * @return T
			 */
			//after checking again it assigns tail to the current 
			//prev and returns that data value
			// then iterates to the new node
			public T previous() {
				Node newNode= new Node(node.getData());
				if(hasPrevious() == true) {
					T result = node.data;
					newNode.prev = tail;
					tail.next = newNode;
					tail = newNode;;
					i--;
					return result;
				}
				throw new NoSuchElementException();
			}

			
			public int nextIndex() {
				throw new UnsupportedOperationException();
				
			}

			
			public int previousIndex() {
				throw new UnsupportedOperationException();
				
			}

			
			public void remove() {
				throw new UnsupportedOperationException();
				
			}

			
			public void set(T e) {
				throw new UnsupportedOperationException();
				
			}

			
			public void add(T e) {
				throw new UnsupportedOperationException();
				
			}
		}


		/**
		 * Takes all values from the list and adds it into an
		 * ArrayList
		 * @return ArrayList<T>
		 */
		//adds each value from the list to an arrayList
		public ArrayList<T> toArrayList() {
			 ArrayList<T> arr = new ArrayList<T>(getSize());
			 Node node = head;
			while(size>0) {
				 arr.add(node.data);
				 node = head.next;
				 size--;
			 }
			return arr;
				}




		
		
		/**
		 * grabs the first data in the head node in the list
		 * @return T
		 */
		public T getFirst() {  //gets the first head value on the list
			if (head != null) {
	            return head.data;
	        }
	        return null;
		}
		/**
		 * grabs the data in the last node
		 * @return T
		 */
		//get the Last tail value on the list
		public T getLast() {
			
			return (T) tail.data;
		}
		/**
		 * 
		 * @return The size of the list
		 */
		//returns the size
		public int getSize() {
			return size;
		}
		/**
		 *  gets the first data element and removes it
		 * @return T of the current Data
		 */
		//grabs the first element and removes
		public T retrieveFirstElement() {
			Node newNode = head;
			if (head != null) {
				
				T result = head.data;
				head.next = newNode;
				head.prev = null;
				return result;
	        }
	        return null;
		}
		/**
		 *  gets the last data element and removes it
		 * @return T of the current Data
		 */
		//grabs the last element and removes
		public T retrieveLastElement() {
			Node newNode = new Node(tail.getData());
			if(tail != null) {
				T result = tail.data;
				tail.prev = newNode;
				tail.next = null;
				return result;
			}
			return null;
			
		}
		/**
		 * public method for the protected iterator class
		 * @return a call from the iterator constructor
		 * @throws UnsupportedOperationException
		 * @throws NoSuchElementException
		 */
		//method used for the inner interator class
		public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
			return new Iterator();
			// TODO Auto-generated method stub
			
		}
		/**
		 * 
		 * @param data
		 * @param comparator
		 * @return the Node after removal process
		 */
		//remove method using comparator
		public  BasicDoubleLinkedList.Node remove(T data, Comparator<T> comparator) {
			Node node = head;
				while(size>0) {
					//compares the two data then removes
					if(comparator.compare(data, node.getData())==0) {
						//removes head if the data are the same
						if(node.equals(head)) {
							head = head.next;
							node = head;
							size--;
						}
						//same with tail removes if same
						else if(node.equals(tail)) {
							node = tail.prev;
							node = tail;
							size--;
						}
						else {
							tail.prev = node.next;
							head.next = node.prev;
							
						}
					}
					//otherwise continues on
					else {
						node = node.next;
					}
				}
			return node;
			
			
		}


		
	}

