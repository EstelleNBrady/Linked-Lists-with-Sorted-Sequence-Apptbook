// This is an assignment for students to complete after reading Chapter 3 of
// "Data Structures and Other Objects Using Java" by Michael Main.

package edu.uwm.cs351;

import java.util.function.Consumer;

import junit.framework.TestCase;
//Estelle Brady
//CS 351- section 401
//collaborated with tutor Matthew in library


/******************************************************************************
 * This class is a homework assignment;
 * An ApptBook ("book" for short) is a sequence of Appointment objects in sorted order.
 * The book can have a special "current element," which is specified and 
 * accessed through four methods that are available in the this class 
 * (start, getCurrent, advance and isCurrent).
 ******************************************************************************/
public class ApptBook implements Cloneable {

	// TODO: Declare the private static Node class.
	// It should have a constructor but no methods.
	// The constructor should take an Appointment and a Node.
	// The fields of Node should have "default" access (neither public, nor private)
	// and should not start with underscores.

	
	// TODO: Declare the private fields of ApptBook needed for sequences
	// (in the textbook, page 233 (3rd ed. 226), five are recommended, 
	//  you should declare all but tail, which is redundant.)
	private static class Node{
		Node(Appointment data, Node next){
			this.data = data;
			this.next = next;
		}
		Appointment data;
		Node next;
	}
	private int manyNodes;
	private Node head;
	private Node cursor;
	private Node precursor;
	
	public ApptBook() {
		precursor = null;
		manyNodes = 0;
		cursor = null;
		head = null;
		assert wellFormed() : "invariant failed at start of size";
	}
	

	
	
	private static Consumer<String> reporter = (s) -> { System.err.println("Invariant error: " + s); };
	
	private boolean report(String error) {
		reporter.accept(error);
		return false;
	}
	

	private boolean wellFormed() {
		// Check the invariant.
		// Invariant:
		// 1. The list must not include a cycle.
		//fast cannot be equal to current
		if (head != null) {
			// This check uses the "tortoise and hare" algorithm attributed to Floyd.
			Node fast = head.next;
			for (Node p = head; fast != null && fast.next != null; p = p.next) {
				if (p == fast) return report("list is cyclic!");
				fast = fast.next.next;
			}
		}
		
		// 2. "manyNodes" is number of nodes in list
		int count = 0;
		for(Node p = head; p!=null; p= p.next) {
			count++;
		} if(count != manyNodes)	return report("manyNodes is not correct");
		
		// 3. There are no null data in the list, and the
		//    data are all in natural increasing order.
			for(Node p = head; p!=null; p=p.next) {
				if(p.data == null)	return report("an element in the list is null");
			for(Node j = head; j.next != null&& j.next.data!=null; j=j.next) 
				if(j.data.compareTo(j.next.data) > 0) return report("this is out of order");
			}
			
			
			
			
			
			
			
		

		
		
	
		
		
		
		
		
		
		// 4. "precursor" is either null or points to a node in the list.
//		3. ----There are no null data in the list, and the data are all in natural increasing order---
//		  Start a conditional checking if the head is not null,
//		  within this conditional make a for loop with the normal idiom, then make a conditional 
//		  checking if p.data is null, then return your report
//		  Still nested within the head != null checker, after you return a report, you need a           conditional that checks: if the data at p.next AND p.next.data is not null.
//		  Then make a another conditional checking if p.data is greater than p.next.data, then
//		  return a report
//		
		boolean switchBoolean = false;
		if(precursor != null) {
			if(precursor == cursor)
				return report("precursor cannot be equal to cursor");
		
		for(Node p = head; p!=null; p=p.next) {
			if(precursor ==null) {
				switchBoolean = true;	
				break;
			}
			if(precursor == null && cursor != null) {
				switchBoolean = false;
				break;
			}
			if(precursor.data.compareTo(p.data) ==0) {
				switchBoolean = true;
				break;
			}
		}
		if(switchBoolean == false) 
			return report("precursor doesn't point to a node in the list");	
	}
	
		
		//5. "cursor" is the node after "precursor" (if "precursor" is not null),
		//    or is the same as the head otherwise.	
		if(precursor != null) {
			  if(precursor.next != cursor ) 
                  return report("Cursor isn't after precursor");
            for(Node p = head; p != null; p = p.next) {
            	 if(precursor.equals(p)) 
                     break;
                 if(precursor != p && p.next == null) 
                     return report("Can't be null");                
            }
            }
				if(precursor == null && cursor != head) 
                   return report("Cursor isn't equal to head when precursor is null.");     
		   // If no problems found, then return true:
               return true;
      }
             
		
			
		 
		      
                      


	

			
				
	
		
			
				
				
			
		
			
		// 5. "cursor" is the node after "precursor" (if "precursor" is not null),
		//    or is the same the head otherwise.
		// This is not the same the invariant of the data structure according to the
		// design in the textbook on pages 233-4 (3rd ed. 226-7)
		// We made the following modifications:
		// - no "tail" and so don't need to check (less work!)
		// - Precursor at the last node (if any) is used to indicate no current element
//		for(Node a = head; a!=null; a=a.next) {
//			if(a.data.compareTo(a.next.data) < 0)
//				return report("");
//		}
		
		
		// Implementation:
		// Do multiple checks: each time returning false if a problem is found.
		// (Use "report" to give a descriptive report while returning false.)
		
	

			
			
		// Implement remaining conditions.

		// If no problems found, then return true:


	// This is only for testing the invariant.  Do not change!
	private ApptBook(boolean testInvariant) { }

	/**
	 * Initialize an empty book. 
	 **/   


	/**
	 * Determine the number of elements in this book.
	 * @return
	 *   the number of elements in this book
	 **/ 
	public int size( )
	{
		assert wellFormed() : "invariant failed at start of size";
		// TODO: Implemented by student.
//		int c = 0;
//		for(Node p = head; p!=null; p=p.next) {
//			c++;
//		}
//		manyNodes = c;
		
		return manyNodes;
	}

	/**
	 * Set the current element at the front of this book.
	 * @postcondition
	 *   The front element of this book is now the current element (but 
	 *   if this book has no elements at all, then there is no current 
	 *   element).
	 **/ 
	public void start( )
	{
		assert wellFormed() : "invariant failed at start of start";
		precursor = null;
		cursor = head;
		assert wellFormed() : "invariant failed at end of start";
	}

	/**
	 * Accessor method to determine whether this book has a specified 
	 * current element that can be retrieved with the 
	 * getCurrent method. 
	 * @return
	 *   true (there is a current element) or false (there is no current element at the moment)
	 **/
	public boolean isCurrent( )
	{
		assert wellFormed() : "invariant failed at start of isCurrent";	
//		for(Node p = head; p!=null; p=p.next) {
//			if(!(cursor.data.compareTo(p.data) ==0)) {
//				return false;
//			}
//			
//		}
//		
//	return true;
	return cursor != null;
	}

	/**
	 * Accessor method to get the current element of this book. 
	 * @precondition
	 *   isCurrent() returns true.
	 * @return
	 *   the current element of this book
	 * @exception IllegalStateException
	 *   Indicates that there is no current element, so 
	 *   getCurrent may not be called.
	 **/
	public Appointment getCurrent( )
	{
		assert wellFormed() : "invariant failed at start of getCurrent";
		if(this.isCurrent() == false)
			throw new IllegalStateException("There is no current element");
		return cursor.data;
	}

	/**
	 * Move forward, so that the current element will be the next element in
	 * this book.
	 * @precondition
	 *   isCurrent() returns true. 
	 * @postcondition
	 *   If the current element was already the end element of this book 
	 *   (with nothing after it), then there is no longer any current element. 
	 *   Otherwise, the new element is the element immediately after the 
	 *   original current element.
	 * @exception IllegalStateException
	 *   Indicates that there is no current element, so 
	 *   advance may not be called.
	 **/
	public void advance( )
	{
		assert wellFormed() : "invariant failed at start of advance";
		if(!(isCurrent())) {
			throw new IllegalStateException("cannot advance");
		}
		// TODO: Implemented by student.
		precursor = cursor;
		cursor = cursor.next;
		assert wellFormed() : "invariant failed at end of advance";
	}

	/**
	 * Remove the current element from this book.
	 * @precondition
	 *   isCurrent() returns true.
	 * @postcondition
	 *   The current element has been removed from this book, and the 
	 *   following element (if there is one) is now the new current element. 
	 *   If there was no following element, then there is now no current 
	 *   element.
	 * @exception IllegalStateException
	 *   Indicates that there is no current element, so 
	 *   removeCurrent may not be called. 
	 **/
	public void removeCurrent( )
	{
		assert wellFormed() : "invariant failed at start of removeCurrent";
		if(!(isCurrent()))
		{
			throw new IllegalStateException("there is no element in remove");
		}
		Node prev = null;
        for(Node p=head; p != null; p=p.next) {
            // get the prev of current cursor
            if(p.next != null && p.next == cursor) {
                prev = p;
                break;
            }
        }

        // Perform deletion if prev was found
        if(prev != null) {
            prev.next = prev.next.next;

            // the following is current if there is one
            // else there is no current (prev is the last element)
            if(prev.next != null) cursor = prev.next;
            else {
                cursor = null;
                precursor = prev;
            }

            --manyNodes;
        }
        // only one element / removing the head
        else if (prev == null && head == cursor) {
            head = head.next;
            cursor = head;
            --manyNodes;
        }
		
		
		assert wellFormed() : "invariant failed at end of removeCurrent";
	}
	
	/**
	 * Set the current element to the first element that is equal
	 * or greater than the guide.
	 * @param guide element to compare against, must not be null.
	 */
	public void setCurrent(Appointment guide) {
		assert wellFormed() : "invariant failed at start of setCurrent";
		if (guide == null) throw new NullPointerException("guide cannot be null");
		start();
		while (isCurrent() && getCurrent().compareTo(guide) < 0) {
			advance();
		}
		assert wellFormed() : "invariant failed at end of setCurrent";
	}

	/**
	 * Add a new element to this book, in order.  If an equal appointment is already
	 * in the book, it is inserted after the last of these. 
	 * If the new element would take this book beyond its current capacity,
	 * then the capacity is increased before adding the new element.
	 * The current element (if any) is not affected.
	 * @param element
	 *   the new element that is being added, must not be null
	 * @postcondition
	 *   A new copy of the element has been added to this book. The current
	 *   element (whether or not is exists) is not changed.
	 * @exception IllegalArgumentException
	 *   indicates the parameter is null
	 * @exception OutOfMemoryError
	 *   Indicates insufficient memory for increasing the book's capacity.
	 **/
	public void insert(Appointment element)
	{
		assert wellFormed() : "invariant failed at start of insert";
		if(element == null)
			throw new IllegalArgumentException("The element is null in insert");
	
		Node nElement = new Node(element, null);
		//this is if there is no current element
        if (head == null) {
            head = nElement;
            precursor = nElement;
        } else {
            // if we are inserting before head
            if(head.data.compareTo(element) > 0) {
                nElement.next = head;
                head = nElement;
                if(precursor == null)
                    precursor = head;
            }else {
            	for (Node p = head, prev = head; prev != null; prev = p, p = p.next) {

                    // if p reached the last element
                    // insert after prev (between prev and p)
                    if (p == null) {
                        prev.next = nElement;
                        // update precursor if cursor is null
                        // as if cursor doesn't exist precursor has to be the last element
                        if (cursor == null)
                            precursor = nElement;
                        break;
                    } 
                    // loop thru until we find an element(at p)
                    // which is greater than element
                    // then insert the element between prev and p
                    else if (p.data.compareTo(element) > 0) {
                        nElement.next = p;
                        prev.next = nElement;
                        // if we are inserting an element that has the same value
                        // as the precursor then we have to update the precursor
                        // B = element
                        // ^ = precursor
                        // * = cursor
                        // A->B^->C->E->F
                        // A->B^->B->C->E->F
                        if (prev == precursor)
                            precursor = precursor.next;
                        break;
                    }
                }
            }
       
            
        }
        


    	++manyNodes;
	
		assert wellFormed() : "invariant failed at end of insert";

					
					}
			
				
			
//		if(precursor != null && cursor != null) {
//			precursor = precursor.next;
////		}
//		if(cursor !=null) {
//			if(temp!=precursor) {
//				precursor = temp;
//			}
//			precursor.next = cursor;
//			
////		if(cursor == null) {
////			cursor = 
////		}
//			
//			
//	
//			
//		}
//			
//		
//
////
////	if(cursor !=null)
////		if(precursor!= null) {
////			precursor.next = cursor;
////		}else {
////			cursor = head;
////		}
////	if(temp != precursor) {
////	precursor = temp;
////}
////else {
////	cursor = precursor.next;
////}
//	


	
	
//	for(Node p = head;p!=null;lag=p,p=p.next) {
//		
//		if(lag == null) {
//			head = new Node(element, null);;	++manyNodes;
//			break;
//		}
//		
//		if(p.data.compareTo(element)>0) {
//			Node newNode = new Node(element, lag.next);
//			lag.next=newNode;
//		}
//		if(p.data.compareTo(element) <0) {
//			while(p.data.compareTo(element) <0)
//			{
//				p=p.next;
//			}
//			break;
//		}
	//new node = p.next	
		
	
//	}
//	for(Node a = head; p!=null; lag=p,p=p.next) {
//		while ()
	
	
//	int tempIndex = 0;
//	while(tempIndex < manyItems && data[tempIndex].compareTo(element)<= 0) {
//		tempIndex++;
//	
	//int p = head; p!=null; p=p.next
	//
	//while(p!=null && cursor.data.compareTo(newN) <=0)
		
		
	
         
//        Node prev = precursor; // precursor
//        Node iter = cursor; // cursor
//         
//        while (iter != null && iter.data.compareTo(element) <= 0) {
//            // take backup of prev node
//            // used in appending the new node
//            prev = iter;
//            iter = iter.next;
//        }
//         
//        newN.next = prev.next;
//        prev.next = newN;
//        
//        while (head.next != null)
//            head = head.next;
//        head.next = new Node(element, head.next);
//		assert wellFormed() : "invariant failed at end of insert";	
//		 return;
//	}
//       
//        
		
//		Node newN = new Node(element, head);
//		System.out.print(newN);
//		
//		Node temp = head;
//		while(temp!=null) {
//			temp= temp.next;
//		}
//			
//		
//		temp.next = newN;
//		System.out.print(newN);
//		
//		while(newN.data.compareTo(cursor.data) > 0) {
//			
//		}
//		
//		System.out.print(newN);
		

	

//			for(Node p = head;p!=null;lag=p,p=p.next) {
//				if(lag == null) {
//					head = new Node(element, null);;	++manyNodes;
//					break;
//				}
//				if(p.data.compareTo(element) ==0)
//				{
//					lag.next = new Node(element, p.next);	++manyNodes;
//					break;
//				}
		
		  
		
			
			
			
			//set a temp index because we cannot influence currentIndex
			//iterate through the array to see if any of these values are equal or less than the incoming element
			//breaks out when these are true
			
			
			
			//with the given index through the while loop, it will break if we get the element that comes after element
			//it then shifts the left of them to the right
//			for(int i = manyItems; i>tempIndex; i--) {
//				data[i] = data[i-1];
//			}
//			//if the currentindex is not less than tempindex, then we can increment current index
//			data[tempIndex] = element;	manyItems++;	
//			if(!(currentIndex<tempIndex)) currentIndex++;
			

	
	
//		Node tempC = cursor;
//		int tempIndex = 0;
//			
//		
//		if(element == null) {
//			throw new IllegalArgumentException("element cannot be null");
//		}
//		Node lag = null;
//		
//		for(Node p = head;p!=null;lag=p,p=p.next) {
//			++tempIndex;
//			if(lag == null) {
//				head = new Node(element, null);;	++manyNodes;
//				break;
//			}
//			if(p.data.compareTo(element) ==0)
//			{
//				lag.next = new Node(element, p.next);	++manyNodes;
//				break;
//			}
//			
			

			
			
	
	

	/**
	 * Place all the appointments of another book (which may be the
	 * same book as this!) into this book in order as in {@link #insert}.
	 * The elements should added one by one from the start.
	 * The elements are probably not going to be placed in a single block.
	 * @param addend
	 *   a book whose contents will be placed into this book
	 * @precondition
	 *   The parameter, addend, is not null. 
	 * @postcondition
	 *   The elements from addend have been placed into
	 *   this book. The current el;ement (if any) is
	 *   unchanged.
	 * @exception NullPointerException
	 *   Indicates that addend is null. 
	 * @exception OutOfMemoryError
	 *   Indicates insufficient memory to increase the size of this book.
	 **/
	public void insertAll(ApptBook addend)
	{
		assert wellFormed() : "invariant failed at start of insertAll";
		if(addend ==null)
			throw new NullPointerException("this addend is null!");

		
		//iterates through each index of data and individually puts each one in a
		for(Node p = addend.head; p != null; p = p.next) {
            if(p.data != null) insert(p.data);
        }
		
			
		assert wellFormed() : "invariant failed at end of insertAll";
	
		
		assert addend.wellFormed() : "invariant of addend broken in insertAll";
	
	
	}

	/**
	 * Generate a copy of this book.
	 * @return
	 *   The return value is a copy of this book. Subsequent changes to the
	 *   copy will not affect the original, nor vice versa.
	 * @exception OutOfMemoryError
	 *   Indicates insufficient memory for creating the clone.
	 **/ 
	//for clone u need to throw new RuntimeException,  keep track of nodes(have 2 nodes Original and copy), have a for loop and what happens if manyNodes == 0

	public ApptBook clone( ) { 
		assert wellFormed() : "invariant failed at start of clone";
		ApptBook answer;
	
		try
		{
			answer = (ApptBook) super.clone( );
		}
		catch (CloneNotSupportedException e)
		{  // This exception should not occur. But if it does, it would probably
			// indicate a programming error that made super.clone unavailable.
			// The most common error would be forgetting the "Implements Cloneable"
			// clause at the start of this class.
			throw new RuntimeException
			("This class does not implement Cloneable");
		}
	
		// Much more work than in Homework #2!
		// TODO: Copy the list
		// (make sure cursor/precursor are updated too!)
		ApptBook n1 = new ApptBook();
		
		for(Node p = head; p != null; p = p.next) {
            if(p.data != null) n1.insert(p.data);
        }
		answer = n1;
		

		
		assert wellFormed() : "invariant failed at end of clone";
		assert answer.wellFormed() : "invariant on answer failed at end of clone";
		return answer;
	}

	// don't change this nested class:
	public static class TestInvariantChecker extends TestCase {
		Time now = new Time();
		Appointment e1 = new Appointment(new Period(now,Duration.HOUR),"1: think");
		Appointment e2 = new Appointment(new Period(now,Duration.DAY),"2: current");
		Appointment e3 = new Appointment(new Period(now.add(Duration.HOUR),Duration.HOUR),"3: eat");
		Appointment e4 = new Appointment(new Period(now.add(Duration.HOUR.scale(2)),Duration.HOUR.scale(8)),"4: sleep");
		Appointment e5 = new Appointment(new Period(now.add(Duration.DAY),Duration.DAY),"5: tomorrow");
		ApptBook hs;

		private int reports = 0;
		
		private void assertWellFormed(boolean expected) {
			reports = 0;
			Consumer<String> savedReporter = reporter;
			try {
				reporter = (String message) -> {
					++reports;
					if (message == null || message.trim().isEmpty()) {
						assertFalse("Uninformative report is not acceptable", true);
					}
					if (expected) {
						assertFalse("Reported error incorrectly: " + message, true);
					}
				};
				assertEquals(expected, hs.wellFormed());
				if (!expected) {
					assertEquals("Expected exactly one invariant error to be reported", 1, reports);
				}
				reporter = null;
			} finally {
				reporter = savedReporter;
			}
		}
		
		protected Node newNode(Appointment a, Node n) {
			Node result = new Node(a, n);
			result.data = a;
			result.next = n;
			return result;
		}
		
		protected void setUp() {
			hs = new ApptBook(false);
			hs.head = hs.cursor = hs.precursor = null;
			hs.manyNodes = 0;
		}

		public void testA() {
			hs.manyNodes = 1;
			assertWellFormed(false);
			hs.manyNodes = 0;
			assertWellFormed(true);
			hs.manyNodes = -1;
			assertWellFormed(false);
		}
		
		public void testB() {
			hs.cursor = newNode(e1,null);
			assertWellFormed(false);
			hs.precursor = newNode(null,hs.cursor);
			assertWellFormed(false);
			hs.cursor = null;
			assertWellFormed(false);
			hs.precursor.next = null;
			assertWellFormed(false);
		}
		
		public void testC() {
			hs.manyNodes = 1;
			hs.head = newNode(e1,null);
			assertWellFormed(false);
			hs.precursor = newNode(e1,null);
			assertWellFormed(false);
		}
		
		public void testD() {
			hs.manyNodes = 1;
			hs.head = newNode(null,null);
			assertWellFormed(false);
			hs.precursor = hs.head;
			assertWellFormed(false);
			
			hs.manyNodes = 0;
			assertWellFormed(false);
			hs.manyNodes = 2;
			assertWellFormed(false);
		}
		
		public void testE() {
			hs.head = newNode(e1,null);
			hs.manyNodes = 1;
			hs.precursor = hs.head;
			assertWellFormed(true);
			hs.cursor = hs.head;
			assertWellFormed(false);
			hs.precursor = null;
			assertWellFormed(true);
		}
		
		public void testF() {
			hs.head = hs.precursor= newNode(e1,null);
			hs.manyNodes = 1;
			hs.cursor = newNode(e1,null);
			assertWellFormed(false);
			hs.precursor = null;
			assertWellFormed(false);
			hs.cursor = hs.head;
			assertWellFormed(true);
		}

		public void testG() {
			hs.head = newNode(e2, null);
			hs.precursor = hs.head;
			hs.manyNodes = 1;
			assertWellFormed(true);
			
			hs.head.next = hs.head;
			assertWellFormed(false);
			hs.manyNodes = 2;
			assertWellFormed(false);
		}
		
		public void testH() {
			hs.head = newNode(e1, null);
			hs.precursor = newNode(e2, null);
			hs.manyNodes = 2;
			assertWellFormed(false);
			hs.head.next = hs.precursor;
			assertWellFormed(true);
			
			hs.manyNodes = 1;
			assertWellFormed(false);
			hs.manyNodes = 3;
			assertWellFormed(false);
			hs.manyNodes = 0;
			assertWellFormed(false);
		}
		
		public void testI() {
			hs.precursor = newNode(e2, null);
			hs.head = newNode(e1, hs.precursor);
			hs.manyNodes = 2;
			assertWellFormed(true);
			
			hs.precursor = newNode(e1,null);
			assertWellFormed(false);
			hs.precursor = null;
			assertWellFormed(false);
			hs.precursor = hs.head;
			assertWellFormed(false);
			hs.head.next.next = hs.precursor;
			assertWellFormed(false);
			hs.manyNodes = 3;
			assertWellFormed(false);
		}
		
		public void testJ() {
			hs.precursor = newNode(e2, null);
			hs.head = newNode(e1, hs.precursor);
			hs.manyNodes = 2;
			assertWellFormed(true);
						
			hs.precursor = hs.head;
			hs.cursor = null;
			assertWellFormed(false);
			hs.cursor = hs.head;
			assertWellFormed(false);
			hs.cursor = hs.head.next;
			assertWellFormed(true);
			hs.cursor = newNode(e2, null);
			assertWellFormed(false);
			
			hs.precursor = null;
			hs.cursor = null;
			assertWellFormed(false);
			hs.cursor = hs.head;
			assertWellFormed(true);
			hs.cursor = hs.head.next;
			assertWellFormed(false);
			hs.cursor = newNode(e1, hs.head.next);
			assertWellFormed(false);
		}
		
		public void testK() {
			hs.precursor = newNode(e1, null);
			hs.head = newNode(e2, hs.precursor);
			hs.manyNodes = 2;
			assertWellFormed(false);
			
			hs.precursor.data = e2;
			assertWellFormed(true);
			
			hs.precursor.data = null;
			assertWellFormed(false);
			
			hs.precursor = hs.head;
			hs.cursor = hs.head.next;
			assertWellFormed(false);
			
			hs.precursor = null;
			hs.cursor = hs.head;
			assertWellFormed(false);
			
			hs.head.next.data = e3;
			hs.head.data = null;
			assertWellFormed(false);
			
			hs.head.data = e3;
			assertWellFormed(true);
			
			hs.head.next.next = hs.head;
			assertWellFormed(false);
			
			hs.head.next.next = hs.head.next;
			assertWellFormed(false);
		}
		
		public void testL() {
			hs.head = hs.precursor = newNode(e5,null);
			hs.head = newNode(e4,hs.head);
			hs.head = newNode(e3,hs.head);
			hs.head = newNode(e2,hs.head);
			hs.head = newNode(e1,hs.head);
			hs.manyNodes = 1;
			assertWellFormed(false);
			hs.manyNodes = 2;
			assertWellFormed(false);
			hs.manyNodes = 3;
			assertWellFormed(false);
			hs.manyNodes = 4;
			assertWellFormed(false);
			hs.manyNodes = 0;
			assertWellFormed(false);
			hs.manyNodes = -1;
			assertWellFormed(false);
			hs.manyNodes = 5;
			assertWellFormed(true);
			
			hs.precursor = newNode(e5, null);
			assertWellFormed(false);
		}
		
		public void testM() {
			hs.head = hs.precursor = newNode(e4,null);
			hs.head = newNode(e3,hs.head);
			hs.head = newNode(e3,hs.head);
			hs.head = newNode(e1,hs.head);
			hs.head = newNode(e1,hs.head);
			hs.manyNodes = 5;
			assertWellFormed(true);
			
			hs.precursor = null;
			assertWellFormed(false);
			hs.precursor = newNode(e4,null);
			assertWellFormed(false);
			hs.precursor = hs.head;
			assertWellFormed(false);
			hs.precursor = hs.head.next;
			assertWellFormed(false);
			hs.precursor = hs.head.next.next;
			assertWellFormed(false);
			hs.precursor = hs.precursor.next;
			assertWellFormed(false);
			hs.precursor = hs.precursor.next;
			
			assertWellFormed(true);
		}
		
		public void testN() {
			Node n1,n2,n3,n4,n5;
			hs.head = n5 = newNode(e5,null);
			hs.head = n4 = newNode(e4,hs.head);
			hs.head = n3 = newNode(e3,hs.head);
			hs.head = n2 = newNode(e2,hs.head);
			hs.head = n1 = newNode(e1,hs.head);
			hs.manyNodes = 5;

			hs.precursor = newNode(e1, n1);
			hs.cursor = n1;
			assertWellFormed(false);
			hs.precursor = newNode(e1, n2);
			hs.cursor = n2;
			assertWellFormed(false);
			hs.precursor = newNode(e2, n3);
			hs.cursor = n3;
			assertWellFormed(false);
			hs.precursor = newNode(e3, n4);
			hs.cursor = n4;
			assertWellFormed(false);
			hs.precursor = newNode(e4, n5);
			hs.cursor = n5;
			assertWellFormed(false);
			hs.precursor = newNode(e5, null);
			hs.cursor = null;
			assertWellFormed(false);
			
			hs.precursor = null;
			hs.cursor = n1;
			assertWellFormed(true);
			hs.precursor = n1;
			hs.cursor = n2;
			assertWellFormed(true);
			hs.precursor = n2;
			hs.cursor = n3;
			assertWellFormed(true);
			hs.precursor = n3;
			hs.cursor = n4;
			assertWellFormed(true);
			hs.precursor = n4;
			hs.cursor = n5;
			assertWellFormed(true);
			hs.precursor = n5;
			hs.cursor = null;
			assertWellFormed(true);
		}
		
		public void testO() {
			Node n1,n2,n3,n4,n5;
			hs.head = n5 = newNode(e5,null);
			hs.head = n4 = newNode(e5,hs.head);
			hs.head = n3 = newNode(e5,hs.head);
			hs.head = n2 = newNode(e5,hs.head);
			hs.head = n1 = newNode(e5,hs.head);
			hs.manyNodes = 5;

			hs.precursor = null;
			hs.cursor = n2;
			assertWellFormed(false);
			hs.cursor = n3;
			assertWellFormed(false);
			hs.cursor = n4;
			assertWellFormed(false);
			hs.cursor = n5;
			assertWellFormed(false);
			hs.cursor = null;
			assertWellFormed(false);
			
			hs.precursor = n1;
			hs.cursor = n1;
			assertWellFormed(false);
			hs.cursor = n3;
			assertWellFormed(false);
			hs.cursor = n4;
			assertWellFormed(false);
			hs.cursor = n5;
			assertWellFormed(false);
			hs.cursor = null;
			assertWellFormed(false);
			
			hs.precursor = n2;
			hs.cursor = n1;
			assertWellFormed(false);
			hs.cursor = n2;
			assertWellFormed(false);
			hs.cursor = n4;
			assertWellFormed(false);
			hs.cursor = n5;
			assertWellFormed(false);
			hs.cursor = null;
			assertWellFormed(false);
			
			hs.precursor = n3;
			hs.cursor = n1;
			assertWellFormed(false);
			hs.cursor = n2;
			assertWellFormed(false);
			hs.cursor = n3;
			assertWellFormed(false);
			hs.cursor = n5;
			assertWellFormed(false);
			hs.cursor = null;
			assertWellFormed(false);
			
			hs.precursor = n4;
			hs.cursor = n1;
			assertWellFormed(false);
			hs.cursor = n2;
			assertWellFormed(false);
			hs.cursor = n3;
			assertWellFormed(false);
			hs.cursor = n4;
			assertWellFormed(false);
			hs.cursor = null;
			assertWellFormed(false);
			
			hs.precursor = n5;
			hs.cursor = n1;
			assertWellFormed(false);
			hs.cursor = n2;
			assertWellFormed(false);
			hs.cursor = n3;
			assertWellFormed(false);
			hs.cursor = n4;
			assertWellFormed(false);
			hs.cursor = n5;
			assertWellFormed(false);			
		}
		
		public void testP() {
			Node n1,n2,n3,n4,n5;
			hs.head = n5 = newNode(e5,null);
			hs.head = n4 = newNode(e4,hs.head);
			hs.head = n3 = newNode(e3,hs.head);
			hs.head = n2 = newNode(e2,hs.head);
			hs.head = n1 = newNode(e1,hs.head);
			hs.manyNodes = 5;
			hs.cursor = n1;
			assertWellFormed(true);
			
			n5.data = null;
			assertWellFormed(false);
			
			n5.data = e3;
			assertWellFormed(false);
			
			n4.data = e3;
			assertWellFormed(true);
			
			n4.data = null;
			assertWellFormed(false);
			
			n4.data = e2;
			assertWellFormed(false);
			
			n3.data = e2;
			assertWellFormed(true);
			
			n3.data = null;
			assertWellFormed(false);

			n3.data = e1;
			assertWellFormed(false);
			
			n2.data = e1;
			assertWellFormed(true);
						
			n2.data = null;
			assertWellFormed(false);
		}
	}
}

