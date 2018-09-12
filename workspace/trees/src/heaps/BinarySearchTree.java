package heaps;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * BST is another way to implement the values in the tree. BST is not a complete or balanced tree
 * This class will insert the nodes, search for the names, then travers 
 * @author mariam
 *
 */
public class BinarySearchTree {

	Node root = null;
	private static BufferedWriter out;
	
	public BinarySearchTree (BufferedWriter out){		//a constructor to get the size of the arrays for all the names 
		
		this.out = out;
	}
	/**
	 * BST compare with the parent or the root for the first irretation if the value
	 * is smallar than the parent insert to the left ,if it is larger, insert to the right
	 * and repeat the proces recurrseivaly 
	 * @param temp
	 * @param last
	 * @param first
	 * @return
	 */
	public Node insert(Node temp, String last, String first){
		String swap =  null;	
		if(root == null){
			root = new Node();
			root.data[0] = last;
			root.data[1] = first;
			return root;
		}
		if(temp.data[0].compareTo(last)>0){ //the value smaller than the root 
			if(temp.leftChild == null){ 
				temp.leftChild = new Node();
				temp.leftChild.parent = temp;
				temp.leftChild.data[0] = last;
				temp.leftChild.data[1] = first;
				return temp.leftChild;
				
			}else{
				return insert(temp.leftChild, last, first);
			}
		}else {
			
			if(temp.rightChild == null){ 
				temp.rightChild = new Node();
				temp.rightChild.parent = temp;
				temp.rightChild.data[0] = last;
				temp.rightChild.data[1] = first;
				return temp.rightChild;
			}else {
				return insert(temp.rightChild, last, first);
			}
		}
			
	
	}
	/**
	 * search for the names and compare the data ased on the first name. if we find the data 
	 * then print the values: parent, LC ,RC, position and level. if the value is greater that the 
	 * node we checked then search on the right of the tree. if the values is smaller, search for the left 
	 * side of the BST
	 * @param temp node to start searching in the tree
	 * @param last last name 
	 * @param first first name 
	 * @param level the level of the name we found 
	 * @throws IOException 
	 */
	
	public void searchBST (Node temp, String last, String first, int level ) throws IOException{
		double position = 0;
		
		if ((temp.data[0].compareTo(first)==0)){
				out.write("Searching in Binary search tree : ");
				out.newLine();
				System.out.println("Me: " + temp.data[0] + " " +temp.data[1]);
				out.write("Me: " + temp.data[0] + " " +temp.data[1]);
				out.newLine();
				
			if (temp.parent== null){
				System.out.println("NO parent ");
				out.write("NO parent ");
				out.newLine();
			}else{ 
				System.out.println("The parent is " + temp.parent.data[0] + " " + temp.parent.data[1]);
				out.write("The parent is " + temp.parent.data[0] + " " + temp.parent.data[1]);
				out.newLine();
			}if(temp.leftChild == null){
	    		System.out.println("NO leftChild ");
	    		out.write("NO leftChild ");
	    		out.newLine();
			}else{ 
	    		System.out.println("The left Child is " + temp.leftChild.data[0] + " " + temp.leftChild.data[1]);
	    		out.write("The left Child is " + temp.leftChild.data[0] + " " + temp.leftChild.data[1]);
	    		out.newLine();
			}if(temp.rightChild== null){
	    		System.out.println("NO rightChild ");
	    		out.write("NO rightChild ");
	    		out.newLine();
			}else{ 
	    		System.out.println("The right Child is " + temp.rightChild.data[0] + " " + temp.rightChild.data[1]);
	    		out.write("The right Child is " + temp.rightChild.data[0] + " " + temp.rightChild.data[1]);
	    		out.newLine();
			}
		    	position = (level+1) - Math.pow(2,level);
		    	System.out.println("The position is " + position);
		    	out.write("The position is " + position);
		    	out.newLine();
		    	out.write("The level is " + level);
		    	out.newLine();
		    	out.newLine();
		    	return;
		}else if((temp.data[0].compareTo(first))> 0 ){
			searchBST(temp.leftChild, last, first, ++level);
		}else if((temp.data[0].compareTo(first))< 0) {
			searchBST(temp.rightChild, last, first, ++level );
		}
		
	}
	/**
	 * post order travrsal 
	 */
	public void postOrdertraversal(){
		if(root!= null)
			root.postOrder();
	}
	/**
	 * in order traversal 
	 */
	public void inorderOrdertraversal(){
		if(root!= null)
			root.inOrder();
	}
	/**
	 * pre order traversal 
	 */
	public void preOrdertraversal(){
		if(root!= null)
			root.preOrder();
	}
}
