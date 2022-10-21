

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class StudentDBLL {
	BasicDoubleLinkedList<String> linkedString;
	StringComparator comparator;
	public String a=new String();
	public ArrayList<String> fill = new ArrayList<String>();
	

	@Before
	public void setUp() throws Exception {
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd("hi");
		linkedString.addToEnd("bye");
		comparator = new StringComparator();
	}

	@After
	public void tearDown() throws Exception {
		linkedString = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(2,linkedString.getSize());
	}
	
	@Test
	public void testAddToEnd() {
		assertEquals("bye", linkedString.getLast());
		linkedString.addToEnd("End");
		assertEquals("End", linkedString.getLast());
	}
	
	@Test
	public void testAddToFront() {
		assertEquals("hi", linkedString.getFirst());
		linkedString.addToFront("Start");
		assertEquals("Start", linkedString.getFirst());
		
	}
	
	@Test
	public void testGetFirst() {
		assertEquals("hi", linkedString.getFirst());
		linkedString.addToFront("Peace");
		assertEquals("Peace", linkedString.getFirst());
		
	}

	@Test
	public void testGetLast() {
		assertEquals("bye", linkedString.getLast());
		linkedString.addToEnd("StaySafe");
		assertEquals("StaySafe", linkedString.getLast());
	
	}
	
	@Test
	public void testToArrayList()
	{
		ArrayList<String> list;
		linkedString.addToFront("Nebeyu");
		linkedString.addToEnd("Daniel");
		list = linkedString.toArrayList();
		assertEquals(a,list.get(0));
		assertEquals(a,list.get(1));
		assertEquals(a,list.get(2));
		assertEquals(a,list.get(3));
	}
	
	@Test
	public void testIteratorSuccessfulNext() {
		linkedString.addToFront("Begin");
		linkedString.addToEnd("End");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Hey", iterator.next());
		assertEquals("Hi", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("End", iterator.next());
	}
	@Test
	public void testIteratorSuccessfulPrevious() {
		linkedString.addToFront("sup");
		linkedString.addToEnd("deuce");
		ListIterator<String> iteratorCar = linkedString.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(a, iteratorCar.next());
		assertEquals(true, iteratorCar.hasPrevious());
		assertEquals(a, iteratorCar.previous());
		assertEquals(a, iteratorCar.previous());
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		linkedString.addToFront("Why");
		linkedString.addToEnd("What");
		ListIterator<String> iteratorCar = linkedString.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(a, iteratorCar.next());
		assertEquals(a, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		
		try{
			//no more elements in list
			iteratorCar.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionPrevious() {
		linkedString.addToFront("Hey");
		linkedString.addToEnd("HI");
		ListIterator<String> iteratorCar = linkedString.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(a, iteratorCar.next());
		assertEquals(true, iteratorCar.hasPrevious());
		assertEquals(a, iteratorCar.previous());
		assertEquals(a, iteratorCar.previous());
		
		try{
			//no more elements in list
			iteratorCar.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorUnsupportedOperationException() {
		linkedString.addToFront("sky");
		linkedString.addToEnd("ground");
		ListIterator<String> iteratorCar = linkedString.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(a, iteratorCar.next());
		assertEquals(a, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		
		try{
			//remove is not supported for the iterator
			iteratorCar.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
		
	}
	
	@Test
	public void testRemove() {
		// remove the first
		assertEquals(a, linkedString.getFirst());
		assertEquals(a, linkedString.getLast());
		linkedString.addToFront("blue");
		assertEquals(a, linkedString.getFirst());
		linkedString.remove(a, comparator);
		assertEquals(a, linkedString.getFirst());
		//remove from the end of the list
		linkedString.addToEnd("tail");
		assertEquals(a, linkedString.getLast());
		linkedString.remove(a, comparator);
		assertEquals(a, linkedString.getLast());
		//remove from middle of list
		linkedString.addToFront("red");
		assertEquals(a, linkedString.getFirst());
		assertEquals(a, linkedString.getLast());
		linkedString.remove(a, comparator);
		assertEquals(a, linkedString.getFirst());
		assertEquals(a, linkedString.getLast());
		
	}

	@Test
	public void testRetrieveFirstElement() {
		assertEquals(a, linkedString.getFirst());
		linkedString.addToFront("hey");
		assertEquals(a, linkedString.getFirst());
		assertEquals(a, linkedString.retrieveFirstElement());
		assertEquals(a,linkedString.getFirst());
		assertEquals(a, linkedString.retrieveFirstElement());
		assertEquals(a,linkedString.getFirst());
		
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
		assertEquals("New", linkedString.retrieveFirstElement());
		assertEquals("Hello",linkedString.getFirst());
		assertEquals("Hello", linkedString.retrieveFirstElement());
		assertEquals("World",linkedString.getFirst());
		
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals(a, linkedString.getLast());
		linkedString.addToEnd("Bye");
		assertEquals(a, linkedString.getLast());
		assertEquals(a, linkedString.retrieveLastElement());
		assertEquals(a,linkedString.getLast());
		
		assertEquals("World", linkedString.getLast());
		linkedString.addToEnd("New");
		assertEquals("Bye", linkedString.getLast());
		assertEquals("New", linkedString.retrieveLastElement());
		assertEquals("World",linkedString.getLast());
	}

	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
}
