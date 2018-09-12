package hw3;
/**
 * This class will create the main nodes of the list which are Head Tail and the temp nodes
 * then it will create the insert and and the different type of the sorting methods 
 * @author mariam
 *
 */
public class charLinkedList {
	// public charLinkedList(int n) {
	// // TODO Auto-generated constructor stub
	// int sizeOfLinkedList = n;
	// }
	protected node head;
	protected node tail;
	
	protected node temp;
	/**
	 * get the value from the StackQueueDemo class the one the user wants to insert 
	 * and there is 2 situation if the linkedlist is empty then create a node
	 *  that will hold this value in the data attribute in charNode and assigmen this 
	 *  node to be the head and the tail of the linked list  
	 *  case 2 if the insert at the end make temp = tail and move through the whole linked list 
	 *  until we find the next one is null so we create a node and make it the tail of the new linked lisrt
	 * @param x the value we want to insert in thr linked list 
	 */
	  public void insert(char x) {
	  
		  if (head == null){
				temp = new node(x);
				head = temp;
				tail = temp;
				//if the first node is empty make it as a head 
			}else {
				temp = head;
				while(true){
					if (temp.next == null) {
			            temp.next = new node(x);	//create a noda at the end of the linked list 
			            tail = temp.next;
			            break;
					} else {
						temp = temp.next;		//and if temp is not the last element move to the next node 
					}
				}
		    }
	  }
	  
	  node sortedMerge(node left, node right){
		  node result = null;
		  /* Base cases */
		  if (left == null)
			  return right;
		  if (right == null)
			  return left;

		  /* Pick either a or b, and recur */
		  if (main.sort(right.value,  left.value)) 
		  {
			  result = left;
			  result.next = sortedMerge(left.next, right);
		  } 
		  else
		  {
			  result = right;
			  result.next = sortedMerge(left, right.next);
		  }
		  return result;

	  }
	  node spiltLL(node head){
		  // Base case : if head is null
		  if (head == null || head.next == null)		      {
			  return head;
		  }

		  // get the middle of the list
		  node middle = middle(head);
		  node nextomiddle = middle.next;

		  // set the next of middle node to null
		  middle.next = null;

		  // Apply spiltLL on left list
		  node left = spiltLL(head);

		  // Apply spiltLL  on right list
		  node right = spiltLL(nextomiddle);

		  // Merge the left and right lists
		  node sortedlist = sortedMerge(left, right);
		  return sortedlist;
	  }    
	  node middle(node head) 
	  {
		  //Base case
		  if (head == null)
			  return head;
		  node fastptr = head.next;
		  node slowptr = head;

		  // Move fastptr by two and slow ptr by one
		  // Finally slowptr will point to middle node
		  while (fastptr != null)
		  {
			  fastptr = fastptr.next;
			  if(fastptr!=null)
			  {
				  slowptr = slowptr.next;
				  fastptr=fastptr.next;
			  }
		  }
		  return slowptr;
	  }  
	  //print the merge sort 
	  public void printData(node head) {
	        
	        while(head != null) {
	            char data = head.value;
	            System.out.print(data + " ");
	            head = head.next;
	        }
	        System.out.println(" ");
	    }
	  
	
	
}
