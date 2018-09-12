package hw2;

/**
 * mainly 2 methods enqueue() and dequeue() and it is implemented by CharList 
 * in the Queue it means that first in first out so we dequeue the first node of the list 
 * @author mariam
 *
 */
public class CharQueue extends CharList{
	
	char toReturn = '\u0000';
	char toAdd;
	
	/**
	 * using the same method as insert which is basicaly is adding the element once we recieve it  
	 * @param c 
	 * @return
	 */
	
	public void enqueue(char toAdd){
		insert(toAdd);
	}
	/**
	 * 3 cases 
	 * if the list is empty return null
	 * if it has one element return the value and set head = tail 
	 * the last one is  get the value of the head then move to the next node and get the
	 * value and so one 
	 * @return the value of the first node 
	 */
	public char dequeue() {
		
		if (head == null)
			return '\u0000';
		
		if (head == tail){
			toReturn = head.value;
			head = null;
			tail = null;		//when it is just one node in the linkedlist
			return toReturn;
		}
	
		toReturn = head.value;
		head = head.next;		//move the pointer to the next node
			
		return toReturn;		//get the value of the first node
	}
	
}
