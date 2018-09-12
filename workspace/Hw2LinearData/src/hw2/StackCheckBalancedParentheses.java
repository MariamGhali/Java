package hw2;
/**
 * 
 * @author mariam
 *	this class has a method called CheckBalancedParentheses to check the balance by using stack
 *	and with the aid of the attribute text 
 */
public class StackCheckBalancedParentheses {

	String text;
	
	/**
	 * so we get the string and then convert it to char and push only the parentheses to the list 
	 * however when we find an open parentheses  we push it as a closed one and when it is a closed change it to open
	 * it make it easier when we pop it we get the right order and the vaild number of the unbalanced parentheses   
	 * After we get the stack full of the parentheses  I use a while loop so it will go throgh the whole stack
	 * then we pop it until we reach empty 
	 * so we take the first node it is it open pop it from the stack and increase the counter open
	 * if it is close , check first if it the counter open == 0 then increase the close counter if 
	 * it it's a closed parentheses  and open !=0 then decrement open by 1.then get the total by adding 
	 * open and close and return total 
	 * @param x the string text
	 * @return will return the total number of the unbalanced parentheses  
	 */
	public int 	CheckBalancedParentheses(String x){
		text = x;
		int i, open = 0, close = 0, total=0;
		char c; 
		CharStack myCharStack = new CharStack();//create a stack object 
		
		for(i=0; i<text.length(); i++){
			if (text.charAt(i)=='(')
				myCharStack.push(')');	
			if (text.charAt(i)==')')
				myCharStack.push('(');
		}
		
		
		while((c = myCharStack.pop()) != '\u0000'){		
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