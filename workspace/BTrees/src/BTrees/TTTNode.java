package BTrees;
/**
 * This class will create the node with 3 keys at most 
 * @author mariam
 * this class will create the node for th 2-3-4 trees 
 * @param <Key> each node has 3 keys at most 
 * @param <E> the value for each node which is gonna be the hex,oct,and the char for decimal 
 */
public class TTTNode  <Key extends Comparable<? super Key>,E> {
	private E lval;        // The left record value 
	private Key lkey;        // The node's left key
	private Key mkey;		//middle record value
	private E mval;			//the node's middle key
	private E rval;        // The right r ecord
	private Key rkey;        // The node's right key
	private TTTNode<Key,E> left;   // Pointer to left child
	private TTTNode<Key,E> lcenter; // Pointer to middle left child
	private TTTNode<Key,E> rcenter; // Pointer to middle left child
	private TTTNode<Key,E> right;  // Pointer to right child
	/**
	 * Contractor to set the values of the childs  for the begin all to null 
	 */
	public TTTNode() { lcenter = rcenter = left = right = null; }
	/**
	 * initialize the values of the child and the keys 
	 * @param lk	left key 
	 * @param lv	left key value 
	 * @param rk	right key 
	 * @param rv	right key value 
	 * @param child1	left child 
	 * @param child2	right child
	 * @param child3	leftmost center child 
	 * @param child4	rightmost center child 
	 */
	public TTTNode(Key lk, E lv, Key rk, E rv,TTTNode<Key,E> child1, TTTNode<Key,E> child2,
	                TTTNode<Key,E> child3,TTTNode<Key,E> child4 ) {
	    lkey = lk; 
	    rkey = rk;
	    lval = lv; 
	    rval = rv;
	    left = child1;
	    lcenter = child2;
	    rcenter = child3;
	    right = child4;
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
	  public TTTNode<Key,E> lchild() {
		  return left;
	  }
	  /**
	   * set a right child 
	   * @return right child 
	   */
	  public TTTNode <Key,E> rchild(){
		  return right;
	  }
	  /**
	   * set a leftmost center child 
	   * @return center child 
	   */
	  public TTTNode<Key,E> cchild1() { 
		  return lcenter; 
	  }
	  /**
	   * set a rightmost center child 
	   * @return center child 
	   */
	  public TTTNode<Key,E> cchild2() { 
		  return rcenter; 
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
	   * set the middle key 
	   * @return middle key 
	   */
	  public Key mkey(){  // middle key
		  return mkey; 
	  } 
	  /**
	   * set the value of the middle key 
	   * @return the value of the right key 
	   */
	  public E mval() { // middle  value
		  return mval; 
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
	   * set the middle key of the node 
	   * @param k key 
	   * @param e value 
	   */
	  public void setmiddle(Key k, E e) { 
		  mkey = k; mval = e; 
	  }
	  /**
	   * set the left child key of the node 
	   * @param k key 
	   * @param e value 
	   */ 
	  public void setLeftChild(TTTNode<Key,E> it) { 
		  left = it; 
	  }
	  /**
	   * set the leftmost center child key with value 
	   * @param k key 
	   * @param e value 
	   */ 
	  public void setLeftCenterChild(TTTNode<Key,E> it){
		  lcenter = it;
	  }
	  /**
	   * set the rightmost center child key with value 
	   * @param k key 
	   * @param e value 
	   */ 
	  public void setRightCenterChild(TTTNode<Key,E> it){
		     rcenter = it;
	  }
	  
	  /**
	   * set the right child key with value 
	   * @param k key 
	   * @param e value 
	   */ 
	  
	  public void setRightChild(TTTNode<Key,E> it){
	     right = it; 
	  }
	  /**
	   * insert method: if we are in the root, then insert . if it is a leaf node then 
	   * add the value to the left key. if there is a value in the left key. check the middle key
	   * if it is null then insert to the middle key if it is not check the right key. if it is not
	   * null, then create a left child and insert to the left 
	   * key of the left child. if both keys  are not empty and the parent are not empty then we need to split the 
	   * node and get the median of the values and create a new node and pointed to the nodes we splited. if the value we need
	   * to inert is greater than the left key value and smaller then the middle key value . then we insert 
	   * to the leftmost center child. id the value is greater then the leftmost center child and less then 
	   * the right most center child then we insert to the right most center child. if the value is greater then then right key  then we  
	   * insert to  the right child 
	   * @param rt root 
	   * @param k key 
	   * @param e value 
	   * @return
	   */
	  
	  public TTTNode<Key,E> inserthelp(TTTNode<Key,E> rt, Key k, E e) {
		  TTTNode<Key,E> retval;
		  if (rt == null) // Empty tree: create a leaf node for root
		    return new TTTNode<Key,E>(k, e, null, null, null, null, null,null);
		  if (rt.isLeaf()) // At leaf node: insert here
		    return rt.add(new TTTNode<Key,E>(k, e, null, null, null, null, null,null));
		  // Add to internal node
		  if (k.compareTo(rt.lkey()) < 0) { // Insert left
		    retval = inserthelp(rt.lchild(), k, e);
		    if (retval == rt.lchild()) return rt;
		    else return rt.add(retval);
		  }
		  else if((rt.rkey() == null) || (k.compareTo(rt.rkey()) < 0)) {
		    retval = inserthelp(rt.cchild1(), k, e);
		    if (retval == rt.cchild1()) return rt;
		    else return rt.add(retval);
		  }
		  else { // Insert right
		    retval = inserthelp(rt.rchild(), k, e);
		    if (retval == rt.rchild()) return rt;
		    else return rt.add(retval);
		  }
		}
	  public TTTNode<Key,E> add(TTTNode<Key,E> it) {
		  if (rkey == null) { // Only one key, add here
		    if (lkey.compareTo(it.lkey()) < 0) {
		      rkey = it.lkey(); rval = it.lval();
		      lcenter = it.lchild(); right = it.cchild1();
		    }
		    else {
		      rkey = lkey; rval = lval; right = rcenter;
		      lkey = it.lkey(); lval = it.lval();
		      rcenter = it.cchild2();
		    }
		    return this;
		  }
		  else if (lkey.compareTo(it.lkey()) >= 0) { // Add left
		    TTTNode<Key,E> N1 = new TTTNode<Key,E>(lkey, lval, null, null, it, this, null,null);
		    it.setLeftChild(left);
		    left = lcenter; lcenter = right; right = null;
		    lkey = rkey; lval = rval; rkey = null; rval = null;
		    return N1;
		  }
		  else if (rkey.compareTo(it.lkey()) >= 0) { // Add center
		    it.setLeftCenterChild(new TTTNode<Key,E>(rkey, rval, null, null, it.cchild1(), right, null,null));
		    it.setLeftChild(this);
		    rkey = null; rval = null; right = null;
		    return it;
		  }
		  else { // Add right
		    TTTNode<Key,E> N1 = new TTTNode<Key,E>(rkey, rval, null, null, this, it, null,null);
		    it.setLeftChild(right);
		    right = null; rkey = null; rval = null;
		    return N1;
		  }
		}
}
