package heaps;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**
 * in the class I will use the BFS and DFS search for the min heap
 * by the aid of Queue and stack
 * @author mariam
 *
 */
public class NameSearch {
	
	Queue<Node> queue = new LinkedList<Node>() ; //?!!!
	private BufferedWriter out;
	public NameSearch(BufferedWriter out) {
		this.out = out;
	}
	/**
	 * The Queue will add the parent of the root to the stach then checkit the queue is not empty 
	 * then dequeue or reove all the element in the queue then move to the let and the right child. if the left is not 
	 * null then add it to the queue. if the right child is not null then add it to the queue. then reoeat the process of removing and a
	 * and adding to the queue. once we find thevalue we return it with the parent , LC,RC and postion and the level
	 * x will be the number of the elements every time we add one and we use this value to get the position and the level
	 *
	 * @param root
	 * @param last name
	 * @param first name
	 * @throws IOException 
	 */
	public void BFS(Node root, String last , String first ) throws IOException { //for min Heap
	int position = 0;
	int level = 0 ;
	int x= 0;
	out.write("The search for MinHeap using BFS: ");
	out.newLine();
    if (root == null)
        return;
    queue.clear();//??
    queue.add(root);
    while(!queue.isEmpty()){
        Node node = queue.remove();
        x++;
        if (node.data[1].compareTo(last)==0 && node.data[0].compareTo(first)==0){//same name 
        	
        	System.out.println("Me: " + node.data[0] + " " +node.data[1]);
        	out.write("Me: " + node.data[0] + " " +node.data[1]);
        	out.newLine();
        	if (node.parent== null){
        		System.out.println("NO parent ");
        		out.write("NO parent ");
        		out.newLine();
        	}else{ 
        		System.out.println("The parent is " + node.parent.data[0] + " " + node.parent.data[1]);
        		out.write("The parent is " + node.parent.data[0] + " " + node.parent.data[1]);
        		out.newLine();
        	}if(node.leftChild == null){
        		System.out.println("NO leftChild ");
        		out.write("NO leftChild ");
        		out.newLine();
        	}else {
        		System.out.println("The left Child is " + node.leftChild.data[0] + " " + node.leftChild.data[1]);
        		out.write("The left Child is " + node.leftChild.data[0] + " " + node.leftChild.data[1]);
        		out.newLine();
        	}if (node.rightChild == null){
        		System.out.println("NO rightChild ");
        		out.write("NO rightChild ");
        		out.newLine();
        	}else {
        		System.out.println("The right Child is " + node.rightChild.data[0] + " " + node.rightChild.data[1]);
        		out.write("The right Child is " + node.rightChild.data[0] + " " + node.rightChild.data[1]);
        		out.newLine();
        	}	
        	level = (int) Math.floor(Math.log(x)/Math.log(2));
        	position = (int) ((x+1) - Math.pow(2,level));
            System.out.println("The position is " + position);
            out.write("The position is " + position);
            out.newLine();
        	System.out.println("The level is " + level);
        	out.write("The level is " + level);
        	out.newLine();out.newLine();
        	break;
        }else{	
        //System.out.print(node.element + " ");//search 
        if(node.leftChild != null) 
        	queue.add(node.leftChild);
        if(node.rightChild != null)
        	queue.add(node.rightChild);
        }
        //level++;
    }
    
}
	/**
	 * The Stack will add the parent of the root to the stack then check it the stack is not empty 
	 * then pop or remove all the element in the stack then move to the let and the right child. if the right is not 
	 * null then add it to the stack. if the left child is not null then add it to the stack. then repeat the process of removing and a
	 * and adding to the stack. once we find the value we return it with the parent , LC,RC and postion and the level
	 * x will be the number of the elements every time we add one and we use this value to get the position and the level
	 *
	 * @param root
	 * @param last name
	 * @param first name
	 */
	Stack<Node> stack = new Stack<Node>(); //?!!!
	public void DFS(Node root, String last , String first ) throws IOException { //for minHeap
		double position = 0;
		double level = 0 ;
		int x= 0;
		out.write("The search for MinHeap using DFS: ");
		out.newLine();
	    if (root == null)
	        return;
	    stack.clear();//??
	    stack.add(root);
	    while(!stack.isEmpty()){
	        Node node = stack.pop();
	        x++;
	        if (node.data[1].compareTo(last)==0 && node.data[0].compareTo(first)==0){//same name 
	        	
	        	System.out.println("Me: " + node.data[0] + " " +node.data[1]);
	        	out.write("Me: " + node.data[0] + " " +node.data[1]);
	        	if (node.parent == null){
	        		System.out.println("No parent");
	        		out.write("No parent");
	        		out.newLine();

	        	}else{ 
	        		System.out.println("The parent is " + node.parent.data[0] + " " + node.parent.data[1]);
	        		out.write("The parent is " + node.parent.data[0] + " " + node.parent.data[1]);
	        		out.newLine();

	        	}if (node.leftChild == null){
	        		System.out.println("No leftChild");
	        		out.write("No leftChild");
	        		out.newLine();

	        	}else{ 
	        		System.out.println("The left Child is " + node.leftChild.data[0] + " " + node.leftChild.data[1]);
	        		out.write("The left Child is " + node.leftChild.data[0] + " " + node.leftChild.data[1]);
	        		out.newLine();

	        	}if (node.rightChild == null){
	        		System.out.println("No rightChild");
	        		out.write("No rightChild");
	        		out.newLine();

	        	}else {
	        		System.out.println("The right Child is " + node.rightChild.data[0] + " " + node.rightChild.data[1]);
	        		out.write("The right Child is " + node.rightChild.data[0] + " " + node.rightChild.data[1]);
	        		out.newLine();

	        	}
	        	level =  Math.floor(Math.log(x)/Math.log(2));
	        	position = (x+1) - Math.pow(2,level);
	        	System.out.println("The position is " + position);
	        	out.write("The position is " + position);
	    		out.newLine();

	        	System.out.println("The level is " + level);
	        	out.write("The level is " + level);
	        	out.newLine();
	    		out.newLine();
	        	break;
	        }else{	
	        //System.out.print(node.element + " ");//search 
	        if(node.rightChild != null) stack.add(node.rightChild);
	        if(node.leftChild != null) stack.add(node.leftChild);
	        }
	        //level++;
	    }
	    
	}
}
