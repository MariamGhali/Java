package BTrees;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * this class will call the insert method from the node. it has the search method 
 * so if the user wants to search for the file we will call findsearch from this class. it will 
 * also traves the 4 tress level by level traversal 
 * @author mariam
 *
 * @param <Key> key node
 * @param <E>	value 
 */
public class TwoThreeTree <Key extends Comparable<? super Key>,E> {

	TTNode<Key,E> root = null;
	/**
	 * if the root is null then create a node what the values that is sent to the node  
	 * if the root exsits then recurssively call the method inserthelp to check 
	 * where we can insert the new value 
	 * @param key the node key 
	 * @param value the value of the key
	 */
	public void insert(Key key, E value) {
		if (root == null)
			 //root == create new node and add key/value to left
			root = new TTNode<Key,E>(key, value, null, null, null, null, null);
		//root.add(it)
		else
			root = root.inserthelp(root, key, value);
		
		return;
	}
	/**
	 * this search works in a away similer to the BST search. first check the root exists. if not return null
	 * if not compare the value if the left key of the root. if you find it return the value. chcek the right key
	 * of it is not null and the values are the same return the value of the right key. otherwise start searching 
	 * in the left right and center child and see where it exists 
	 * @param root of the tree 
	 * @param k the key we searching for 
	 * @return the value of the key we searched 
	 */
	public E findhelp(TTNode<Key,E> root, Key k) {
		  if (root == null) return null;          // val not found
		  if (k.compareTo(root.lkey()) == 0) return root.lval();
		  if ((root.rkey() != null) && (k.compareTo(root.rkey())
		       == 0))
		    return root.rval();
		  if (k.compareTo(root.lkey()) < 0)       // Search left
		    return findhelp(root.lchild(), k);
		  else if (root.rkey() == null)           // Search center
		    return findhelp(root.cchild(), k);
		  else if (k.compareTo(root.rkey()) < 0)  // Search center
		    return findhelp(root.cchild(), k);
		  else return findhelp(root.rchild(), k); // Search right
	}
	/**
	 * traversal all the four trees we created using queues. 
	 * so first if the tree consist of the root only then return the root. if not add the root to the queue
	 * then while the queue is not empty, then remove the root from the quese then it check if the root is a lead
	 * then return the left and  the right key. if not return the left, right key of the node , return it is parent, and 
	 * Their child left, right , center if they exists. Then enqueue the left, right and center chiild.
	 * @param root of th tree
	 */
	public void traversal(TTNode<Key,E> root)  { //
		//System.out.println("The traversal for 2-3 tree is: ");
		Queue<TTNode<Key,E>> queue = new LinkedList<TTNode<Key,E>>();
		if (root.lval() == null || root.rval() == null)
	        return;
		 queue.add(root);
	        while (!queue.isEmpty()) 
	        {
	        	root = queue.remove();
	        	if (root.isLeaf()){
	        		if (root.lkey() != null){
	        			System.out.println(root.lkey());
	        			System.out.println(root.lval());
	        			
	        		}else {
	        			System.out.println("No left key for this node");
	        		}
	        		if (root.rkey() !=null){
	        			System.out.println(root.rkey());
	        			System.out.println(root.rval());
	        		}else {
	        			System.out.println("No right key for this node");
	        		}
	        		      		
	        	}else {
	        		if (root.lkey() != null){
	        			System.out.println(root.lkey());
	        		}else {
	        			System.out.println("No left key for this node");
	        		}
	        		if (root.rkey() !=null){
	        			System.out.println(root.rkey());
	        		}else {
	        			System.out.println("No right key for this node");
	        		}
	        		
	        		if(root.lchild() != null){
	        			if (root.lchild().rkey() != null){
	        				System.out.println(root.lchild().rkey());//else
	        			}else{
	        				System.out.println(root.lchild().lkey());
	        			}
	        		}else{
	        			System.out.println("No left child for this node");
	        		}
	        		
	        		if(root.rchild() != null){
	        			if (root.rchild().rkey() != null){
	        				System.out.println(root.rchild().rkey());
	        			}else{
	        				System.out.println(root.rchild().lkey());
	        			}
	        		}else{
	        			System.out.println("No right child for this node");
	        		}
	        		if(root.cchild() != null){
	        			if (root.cchild().rkey() != null){
	        				System.out.println(root.cchild().rkey());
	        			}else{
	        				System.out.println(root.cchild().lkey());
	        			}	
	        		}else{
	        			System.out.println("No center child for this node");
	        		}
	        	}
	        	
	            /*Enqueue left child */
	            if (root.lchild() != null) {
	                queue.add(root.lchild());
	            }
	            if (root.cchild() != null) {
	                queue.add(root.cchild());
	            }
	            /*Enqueue right child */
	            if (root.rchild() != null) {
	                queue.add(root.rchild());
	            }
	        }
	}	    
}
