package BTrees;
/**
 * This class will create the node with 2 keys at most 
 * @author mariam
 *
 * @param <Key> each node has 2 keys at most 
 * @param <E> the value for each node which is gonna be the hex,oct,and the char for decimal 
 */
public class TTNode <Key extends Comparable<? super Key>,E> {

	private E lval;        // The left record value 
	private Key lkey;        // The node's left key
	private E rval;        // The right r 	ecord
	private Key rkey;        // The node's right key
	private TTNode<Key,E> left;   // Pointer to left child
	private TTNode<Key,E> center; // Pointer to middle child
	private TTNode<Key,E> right;  // Pointer to right child
	
	/**
	 * Contractor to set the values of the childs  for the begin all to null 
	 */
	public TTNode() { center = left = right = null; }
	/**
	 * initialize the values of the child and the keys 
	 * @param lk	left key 
	 * @param lv	left key value 
	 * @param rk	right key 
	 * @param rv	right key value 
	 * @param child1	left child 
	 * @param child2	right child
	 * @param child3	center child 
	 */
	public TTNode(Key lk, E lv, Key rk, E rv,TTNode<Key,E> child1, TTNode<Key,E> child2,
	                TTNode<Key,E> child3) {
	    lkey = lk; 
	    rkey = rk;
	    lval = lv; 
	    rval = rv;
	    left = child1;
	    center = child2;
	    right = child3;
	  }
	/**
	* to check if the node is a leaf or not 
	* @return true if it is a leaf and flase if not 
	*/
	  public boolean isLeaf() { 
		  return left == null;   
	  }
	  /**
	   * set a left child 
	   * @return left
	   */
	  public TTNode<Key,E> lchild() {
		  return left;
	  }
	  /**
	   * set a right child 
	   * @return right child 
	   */
	  public TTNode <Key,E> rchild(){
		  return right;
	  }
	  /**
	   * set a center child 
	   * @return center child 
	   */
	  public TTNode<Key,E> cchild() { 
		  return center; 
	  }
	  /**
	   * set the left key 
	   * @return left key 
	   */
	  public Key lkey() { // Left key
		  return lkey;
	  }  
	  /**
	   * set the left key value 
	   * @return the value of the left key 
	   */
	  public E lval() { // Left value
		  return lval; 
	  }  
	  /**
	   * set the right key 
	   * @return the right key 
	   */
	  public Key rkey(){  // Right key
		  return rkey; 
	  } 
	  /**
	   * set the value of the right key 
	   * @return the value of the right key 
	   */
	  public E rval() { // Right value
		  return rval; 
	  }
	  /**
	   * set the left key of the node 
	   * @param k key 
	   * @param e value 
	   */ 
	  public void setLeft(Key k, E e) { 
		  lkey = k; lval = e; 
	  }
	  /**
	   * set the right key of the node 
	   * @param k key 
	   * @param e value 
	   */ 
	  public void setRight(Key k, E e) { 
		  rkey = k; rval = e; 
	  }
	  /**
	   * set the left child key of the node 
	   * @param k key 
	   * @param e value 
	   */ 
	  public void setLeftChild(TTNode<Key,E> it) { 
		  left = it; 
	  }
	  /**
	   * set the center child key with value 
	   * @param k key 
	   * @param e value 
	   */ 
	  public void setCenterChild(TTNode<Key,E> it){
	     center = it;
	  }
	  /**
	   * set the right child key with value 
	   * @param k key 
	   * @param e value 
	   */ 
	  public void setRightChild(TTNode<Key,E> it){
	     right = it; 
	  }
	  
	  /**
	   * insert method: if we are in the root, then insert . if it is a leaf node then 
	   * add the value to the left key. if there is a value in the left key. check the right key
	   * if it is null then insert to the right key if it is not then create a left child and insert to the left 
	   * key of the left child. if both keys  are not empty and the parent are not empty then we need to split the 
	   * node and get the median of the values and create a new node and pointed to the nodes we splited. if the value we need
	   * to inert is grate than the left key value and smallar then the right key value . then we insert 
	   * to the center child.  
	   * @param rt root 
	   * @param k key 
	   * @param e value 
	   * @return
	   */
	  public TTNode<Key,E> inserthelp(TTNode<Key,E> rt, Key k, E e) {
		  TTNode<Key,E> retval;
		  if (rt == null) // Empty tree: create a leaf node for root
		    return new TTNode<Key,E>(k, e, null, null, null, null, null);
		  if (rt.isLeaf()) // At leaf node: insert here
		    return rt.add(new TTNode<Key,E>(k, e, null, null, null, null, null));
		  // Add to internal node
		  if (k.compareTo(rt.lkey()) < 0) { // Insert left
		    retval = inserthelp(rt.lchild(), k, e);
		    if (retval == rt.lchild()) return rt;
		    else return rt.add(retval);
		  }
		  else if((rt.rkey() == null) || (k.compareTo(rt.rkey()) < 0)) {
		    retval = inserthelp(rt.cchild(), k, e);
		    if (retval == rt.cchild()) return rt;
		    else return rt.add(retval);
		  }
		  else { // Insert right
		    retval = inserthelp(rt.rchild(), k, e);
		    if (retval == rt.rchild()) return rt;
		    else return rt.add(retval);
		  }
		}
	  public TTNode<Key,E> add(TTNode<Key,E> it) {
		  if (rkey == null) { // Only one key, add here
		    if (lkey.compareTo(it.lkey()) < 0) {
		      rkey = it.lkey(); rval = it.lval();
		      center = it.lchild(); right = it.cchild();
		    }
		    else {
		      rkey = lkey; rval = lval; right = center;
		      lkey = it.lkey(); lval = it.lval();
		      center = it.cchild();
		    }
		    return this;
		  }
		  else if (lkey.compareTo(it.lkey()) >= 0) { // Add left
		    TTNode<Key,E> N1 = new TTNode<Key,E>(lkey, lval, null, null, it, this, null);
		    it.setLeftChild(left);
		    left = center; center = right; right = null;
		    lkey = rkey; lval = rval; rkey = null; rval = null;
		    return N1;
		  }
		  else if (rkey.compareTo(it.lkey()) >= 0) { // Add center
		    it.setCenterChild(new TTNode<Key,E>(rkey, rval, null, null, it.cchild(), right, null));
		    it.setLeftChild(this);
		    rkey = null; rval = null; right = null;
		    return it;
		  }
		  else { // Add right
		    TTNode<Key,E> N1 = new TTNode<Key,E>(rkey, rval, null, null, this, it, null);
		    it.setLeftChild(right);
		    right = null; rkey = null; rval = null;
		    return N1;
		  }
		}
}
