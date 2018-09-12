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
public class TwoThreeFourTree <Key extends Comparable<? super Key>,E>{
	
	TTTNode<Key,E> root = null;
	/**
	 * if the root is null then create a node what the values that is sent to the node  
	 * if the root exists then recursively call the method inserthelp to check 
	 * where we can insert the new value 
	 * @param key the node key 
	 * @param value 
	 */
	public void insert(Key key, E value) {
		if (root == null)
			 //root == create new node and add key/value to left
			root = new TTTNode<Key,E>(key, value, null, null, null,null, null, null);
		//root.add(it)
		else
			root = root.inserthelp(root, key, value);
		
		return;
	}
	/**
	 * this search works in a away similar to the BST search. first check the root exists. if not return null
	 * if not compare the value if the left key of the root. if you find it return the value. check the right key
	 * of it is not null and the values are the same return the value of the right key. otherwise start searching 
	 * in the left right and center child and see where it exists 
	 * @param root
	 * @param k
	 * @return the value 
	 */
	public E findhelp(TTTNode<Key,E> root, Key k) {
		  if (root == null) return null;          // val not found
		  if (k.compareTo(root.lkey()) == 0) return root.lval();
		  if ((root.rkey() != null) && (k.compareTo(root.rkey())
		       == 0))
		    return root.rval();
		  if (k.compareTo(root.lkey()) < 0)       // Search left
		    return findhelp(root.lchild(), k);
		  else if (root.rkey() == null)           // Search center
		    return findhelp(root.cchild1(), k);
		  else if (k.compareTo(root.rkey()) < 0)  // Search center
		    return findhelp(root.cchild2(), k);
		  else return findhelp(root.rchild(), k); // Search right
	}
	
	public void traversal(TTTNode<Key,E> root, Key k) throws IOException { //
		System.out.println("The traversal for 2-3 tree is: ");
		Queue<TTTNode<Key,E>> queue = new LinkedList<TTTNode<Key,E>>();
		if (root.lval() == null || root.rval() == null)
	        return;
		 queue.add(root);
	        while (!queue.isEmpty()) 
	        {
	        	root = queue.remove();
	        	if (root.isLeaf()){
	        		if (root.lkey() != null){
	        			System.out.println(root.lkey());
	        			//System.out.println(root.lval());
	        			
	        		}else {
	        			System.out.println("No left key for this node");
	        		}
	        		if (root.rkey() !=null){
	        			System.out.println(root.rkey());
	        			//System.out.println(root.rval());
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
	        		if(root.cchild1() != null){
	        			if (root.cchild1().rkey() != null){
	        				System.out.println(root.cchild1().rkey());
	        			}else{
	        				System.out.println(root.cchild1().lkey());
	        			}	
	        		}else{
	        			System.out.println("No leftmost center child for this node");
	        		}
	        		if(root.cchild2() != null){
	        			if (root.cchild2().rkey() != null){
	        				System.out.println(root.cchild2().rkey());
	        			}else{
	        				System.out.println(root.cchild2().lkey());
	        			}	
	        		}else{
	        			System.out.println("No rightmost  center child for this node");
	        		}
	        	}
	        	
	            /*Enqueue left child */
	            if (root.lchild() != null) {
	                queue.add(root.lchild());
	            }
	            if (root.cchild1() != null) {
	                queue.add(root.cchild1());
	            }
	            if (root.cchild2() != null) {
	                queue.add(root.cchild2());
	            }
	            /*Enqueue right child */
	            if (root.rchild() != null) {
	                queue.add(root.rchild());
	            }
	        }
	  }	    
}
