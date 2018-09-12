package hw2;
/**
 * CharStack is a class that implements charList class
 * and has 2 methods push() and pop()  
 * @author mariam
 *
 */
public class CharStack extends CharList {
	
	/**
	 * 3 cases if the list is empty return null
	 * second if it has one element return the value and set both head and tail to null
	 * third  since stack it FILO so we go through the whole lint until we find the tail 
	 * return the value of the tail and move the tail one step backword and we keed doing it until we reach the first element
	 * @return the last char of the list the value at "tail'
	 */
	public char pop(){
		char lastChar = '\u0000';
		
		if (head == null)//the list is empty
			return '\u0000';
		
		if (head == tail){	//one node , get the value and set both to null
			lastChar = temp.value;
			head = null;
			tail = null;
			return lastChar;
		}
		
		//O(n)
		temp=head;
		while(true){	//go through the list until it reach out the last node get it is value and move step backwords  
			if (temp.next==tail){
				lastChar= temp.next.value;
				temp.next=null;
				tail =temp;
				return lastChar;
			}else{					
				temp = temp.next;
			}
		}
	}
	
	/**
	 * use the same method of the insert
	 * @param toAdd push starts at the beginning of the linked list 
	 */
	public void push(char toAdd){
		insert(toAdd);
	}
	
}
