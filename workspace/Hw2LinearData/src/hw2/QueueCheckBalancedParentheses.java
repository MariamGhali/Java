package hw2;

/**
 * This class will has the text attribute and i will convert it at a char then it will call the 
 * method CheckBalancedParentheses to get the number of the unbalanced parentheses 
 * by using Queue
 * @author mariam
 *
 */

public class QueueCheckBalancedParentheses {
	String text;
	/**so we get the string and then convert it to char and enqueue only the parentheses to the list 
	* then dequeue char by char and check until we reach and empty list   
	* so we take the first node it is it open dequeue it from the queue and increase the counter open
	* if it is close , check first if it the counter open == 0 then increase the close counter if 
	* it it's a closed parentess and open !=0 then decrement open by 1.then get the total by adding 
	* open and close and return total 
	* @param x the string text
 	* @return 	will return the total number of the unbalanced parenthess 
	*/
		public int 	CheckBalancedParentheses(String x){
			text = x;
			int i, open = 0, close = 0, total=0;
			char c = 0;
			CharQueue myCharQueue = new CharQueue();
			//Enqueue all ( )
			for(i=0; i<text.length(); i++){
				if(text.charAt(i)=='(' || text.charAt(i)==')')
					myCharQueue.enqueue(text.charAt(i));	//we have only the Parentheses inside the queue
			}
			while((c = myCharQueue.dequeue()) != '\u0000'){			
				if (c == '('){
					open++;	
				}else if (c == ')'&& open !=0){
					open--;
				}else if (c == ')' && open ==0){
					close++;
				}
			}
		
		total = open+close;
		return total;
	}		
}
