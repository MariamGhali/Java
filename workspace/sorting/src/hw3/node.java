package hw3;

/**
 * this class will create a node with values and the pointer and myDate will be the value of each node 
 * @author mariam
 *
 */
public class node {


	node next;
	char value;
/**
 * to create the place value and the pointer of the nodes 
 * @param x 
 * @param myData 
 */
	public node(char x) {
		value = x;
		next = null;
		
	}
	/*
	public node next (){
		return next;
	}
	public char value (){
		return value;
	}
	public void setNext(node next){
		this.next = next;
	}
	public void setValue(char value){
		 this.value = value;
	}*/
	//public char getValue(){
		//return this.value;
	//}
	/*
	int data; 
    node nextNode;

    public node(int data) {
        this.data = data;
        this.nextNode = null;       
    }

    public int getData() {
        return this.data;
    }
	*/
}
