package heaps;
/**
 * create the node that will have the string array for handling the last and the first name
 * also it will have the left and the right child and the parent of the current node also 
 * a size field to maintain the size of the sub trees 
 * @author mariam
 *
 */
public class Node {

	
	String []data = new String[2];
	//String first ; 
	Node leftChild = null;
	Node rightChild = null;
	Node parent = null;
	int sizeOfSubTree = 0;
	/**
	 * Preorder traversal: it is a way to travers the tree or visit it's nodes  
	 * for the Preorder
	 * visit the current node starting from the root , then the left and the right child 
	 *
	 */
	public void preOrder() {
		 
		System.out.println(this.data[0]+ " " + this.data[1]+ ".");
		if (leftChild != null) // Process all nodes in left
			leftChild.preOrder();
		if(rightChild != null)
			rightChild.preOrder();
	}
	/**
	 * for the Postorder
	 * visit the left child then the right chiild then the parent of the root if it is 
	 * the starting of the tree
	 */
	
	public void postOrder(){
		if (leftChild != null) // Process all nodes in left
			leftChild.preOrder();
		if(rightChild != null)
			rightChild.preOrder();
		System.out.println(this.data[0]+ " " + this.data[1]+ ".");
	}
	/**
	 * for the inorder visit the left child fisrt then the parent then the right child 
	 */
	public void inOrder(){
		if (leftChild != null) // Process all nodes in left
			leftChild.preOrder();
		System.out.println(this.data[0]+ " " + this.data[1]+ ".");
		if(rightChild != null)
			rightChild.preOrder();
	}	
}
