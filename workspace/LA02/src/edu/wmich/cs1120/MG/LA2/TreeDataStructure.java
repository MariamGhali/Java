package edu.wmich.cs1120.MG.LA2;

public class TreeDataStructure implements Node{


	private String parentID;
	private String myID;
	private TreeDataStructure leftChild;
	private TreeDataStructure rightChild;

	/**
	 * to get the constroctor of the myID
	 * @param myId
	 */
	public TreeDataStructure(String myId) {
		// TODO Auto-generated constructor stub
		myID= myId;
		
	}
 
	/**
	This method creates a new Node and 
	 * adds it to the children of the node it was called on 
      * if its ID matches the parentID, otherwise it looks through
      * all its children
	 * @param data A String containing the data
	 * @return true if successful, false otherwise
	  */
	@Override

	public boolean addChild(String ID, String parentID) {
		// TODO Auto-generated method stub
	
		if (parentID.equals(myID)){
			if(leftChild == null){
				leftChild = new TreeDataStructure(ID);
				leftChild.setParent(parentID);
				return true;
			}
			if(rightChild == null){
				rightChild = new TreeDataStructure(ID);
				rightChild.setParent(parentID);
				return true;
			}
		}
		if(leftChild != null){
			 if (leftChild.addChild(ID, parentID)== false){
				 if(rightChild != null)
					 rightChild.addChild(ID, parentID); 
				 
			 }
		}
		return false;
	}
	
	public void setParent(String parent){
		parentID = parent;
	}
 
	/**
	 * Looks within the tree to find if value is contained
	 * in that subtree. The node you use to call the find function
	 * acts as the root of the tree.
	 * @param value a string to be found in the tree
	 * @return the node if found.
	 */
	@Override
	public Node find(String value) {
		// TODO Auto-generated method stub]
		
		if (myID.equals(value)){
			return this;
		}
		if (leftChild!= null){
			if (leftChild.getId().equals(value)) {
            return leftChild;
        }
         else if (rightChild.getId().equals(value)) {
        	return rightChild;
         }

        	
        	else{ 
        		if (leftChild.find(value)==null)
        				leftChild.find(value);
        			if (rightChild.find(value) == null){
       	
        				rightChild.find(value);
        			}	
        		}
			}	
	}
	
	/**
	 * Gets the parent of that node.
	 * @return the parent node of the Node that is used to call
	 * this function.
	 */
	@Override
	public Node getParent() {
		// TODO Auto-generated method stub
	
			
		return null;
	}

	/**
	 * Gets the size of the tree.
	 * @return the size of the tree starting from the node that is 
	 * used to call this function, all the way down to the leaf 
	 * nodes.
	 * 
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		if (leftChild!=null || rightChild!= null){
			return 1 + leftChild.size() + rightChild.size();
		}
		if(leftChild!= null){
			 return 1 + leftChild.size();
			
		}
		if (rightChild!= null){
			 return 1 + rightChild.size();
		}
		else 
		return 1;
	}

	/**
	 * Converts the data into a string and returns it
	 * For example, Node A has 2 children B and C.
	 * A.toString() will return A B C
	 * @return String representation of the node.
	 */

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return myID;
	}

	/**
	 * Prints the node upon which this method is called 
	 * as well as all the children nodes.
	 * Use the toString() format to print.
	 */
	@Override
	public void printTree() {
		// TODO Auto-generated method stub

		System.out.print(myID);
		if(leftChild!= null)
			System.out.print(leftChild.getId());
		if (rightChild!= null)
			System.out.print(rightChild.getId());
		
		System.out.println();
		
		if (leftChild!= null)
			leftChild.printTree();
		
		if (rightChild!= null)
			rightChild.printTree();	
	}
	
}




