package heaps;

import java.io.BufferedWriter;

/**
 * The min heap is a binary tree that will be create once we read the file and it will be oexplicit 
 * implementation. it will 
 * insert the nodes then heapifying based on the lowest values to move it to the root 
 * of the tree,the travers the tree using the main three traversal, postorder, inorder and preorder
 * @author mariam
 *
 */
public class MinHeap {
	Node root = null;

	/**
	 * 
	 * @param temp every time we add a node 
	 * @param last last name 
	 * @param first first name 
	 * @return the node itself that we added 
	 * so it will first check if the root is null then create a node and make it as the root 
	 * if not check the left child if it is empty create the node and add the values to this node
	 * and if not chech the right node. if either right or left node,
	 */
	public Node insert(Node temp, String last, String first){
		if(root == null){
			root = new Node();
			root.data[0] = last;
			root.data[1] = first;
			return root;
		}
		if (temp.leftChild != null && temp.rightChild != null){
			if (temp.sizeOfSubTree%2 == 0){ //even number got to left 
				temp.sizeOfSubTree++;
				return insert(temp.leftChild, last, first);
				//return temp.leftChild;
			}else {							//the size is odd, insert to right
				temp.sizeOfSubTree++;
				return insert(temp.rightChild, last, first);
				
			}
		}
		if(temp.leftChild == null){
			temp.leftChild = new Node();
			temp.leftChild.parent = temp;
			temp.leftChild.data[0] = last;
			temp.leftChild.data[1] = first;
			temp.sizeOfSubTree++;
			return temp.leftChild;
			//insert(temp.leftChild, last);
		}else {
			temp.rightChild = new Node();
			temp.rightChild.parent = temp;
			temp.rightChild.data[0] = last;
			temp.rightChild.data[1] = first;
			temp.sizeOfSubTree++;
			return temp.rightChild;
		}
	
	}
	/**
	 * 
	 * @param x is the last node we added 
	 * so after we add the node we comapre it is vales"based on last name" with it's parent 
	 * if the parent is greater then the node itself then up hepifing to get the smallest at the root 
	 */
	public void upHeapify (Node x){
		String[] swapValues = new String[2];
		if(x.parent != null){
			if (x.parent.data[1].compareTo(x.data[1])>0){
				swapValues[0] = x.parent.data[0];
				swapValues[1] = x.parent.data[1];
				x.parent.data[0] = x.data[0];
				x.parent.data[1] = x.data[1];
				x.data[0] = swapValues[0];
				x.data[1] =  swapValues[1];
				upHeapify(x.parent);	
			}
		}
	}
	/**
	 * to call the postOrder method from the node 
	 */
	public void postOrdertraversal(){
		if(root!= null)
			root.postOrder();
	}
	/**
	 * to call the inOrder method from the node 
	 */
	public void inorderOrdertraversal(){
		if(root!= null)
			root.inOrder();
	}
	/**
	 * to call the preOrder method from the node 
	 */
	public void preOrdertraversal(){
		if(root!= null)
			root.preOrder();
	}
}
