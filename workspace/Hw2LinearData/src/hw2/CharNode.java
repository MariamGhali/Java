package hw2;

/**
 * this class will create a node with values and the pointer and myDate will be the value of each node 
 * @author mariam
 *
 */

public class CharNode{
	
	CharNode next;
	char value;
/**
 * to create the place value and the pointer of the nodes 
 * @param myData the value we need to save in this node 
 */
	public CharNode(char myData) {
		value = myData;
		next = null;
	}

}
