package hw2;
/**
 * This class will create the main nodes of the list which are Head Tail and the temp nodes
 * then it will create the insert and delete method and insert method will be used by the 2 classes
 * CharStack and CharQueue as a push() and enqueue() methods 
 * @author mariam
 *
 */
public class CharList {
	//the main three nodes that should be create from charNode , head to be the start and 
	//tail the end and the temp for the current position
	protected CharNode head;
	protected CharNode tail;
	protected CharNode temp;

	/**
	 * get the value from the StackQueueDemo class the one the user wants to insert 
	 * and there is 2 situation if the linkedlist is empty then create a node
	 *  that will hold this value in the data attribute in charNode and assigmen this 
	 *  node to be the head and the tail of the linked list  
	 *  case 2 if the insert at the end make temp = tail and move through the whole linked list 
	 *  until we find the next one is null so we create a node and make it the tail of the new linked lisrt
	 * @param toAdd
	 */
public void insert(char toAdd){

	if (head == null){
		temp = new CharNode(toAdd);
		head = temp;
		tail = temp;
		//if the first node is empty make it as a head 
	}else {
		temp = head;
		while(true){
			if (temp.next == null) {
	            temp.next = new CharNode(toAdd);	//create a noda at the end of the linked list 
	            tail = temp.next;
	            break;
			} else {
				temp = temp.next;		//and if temp is not the last element move to the next node 
			}
		}
    }
}
/**
 * get the value we need to delete then we move through the list 
 * we have 4 cases 
 * first if the list is empty return null
 * second if the list has only one element and the value is the same with the one we need to delete so we delete and return the 
 * value that is delete if it is not the value return null 
 * third if required value is in the head of the list we return the value and move the pointer to the next  
 * by using head = temp.next 
 * the last case is to go through the whole list if we found it move the pointer to the next node and it will
 * be deleted directly and return the value if not return null 
 * @param toDelete
 * @return
 */
public char delete (char toDelete){
	
		char deletedValue = toDelete;
		temp=head;
		//an empty list 
		if (head==null){
			return '\u0000';
		//if it has only one element 	
		}else if (head == tail){
			if(head.value == deletedValue){	//if it has the required value return it 
				return deletedValue;
			}else {
				return '\u0000';		//if not return null
			}
		}else if (head.value == deletedValue){//first node 
			head = temp.next;	//move head to the next node 	
			return deletedValue;	//return the deleted value 
		}else {		//start from the head until the tail for find if the value exist or not and if so delete it 
			temp=head;
			while(temp != tail){
			if (temp.next.value == deletedValue){
				temp.next=temp.next.next;
				return deletedValue;
			}else{	
			temp = temp.next;
			return '\u0000';
			}
		}	
	}
		return '\u0000';
}
	
}