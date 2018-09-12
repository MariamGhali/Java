package heaps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;
/**
 * The maxHeap class will create the tree using the add method 
 * then place the max value at the root of the tree 
 * by heapifying. Do the thre normal traversal inorder, postorder, preoder
 * then my names using 2 different kind of searching DFS and BFS
 * @author mariam
 *
 */
public class MaxHeap {

	private int lastAddedIndex = -1;
	private fullName [] arrayOfNames;
	private static BufferedWriter out;
	
	public MaxHeap (int size, BufferedWriter out){		//a constructor to get the size of the arrays for all the names 
		arrayOfNames = new fullName[size];
		this.out = out;
	}
	/**
	 * search element by element in the array to find the your name
	 * if you find you name print and get all the information about this node
	 * the name, children, the position and the level   
	 * if (i-1)< 0 it means there iis no parent and basically we are in the root 
	 * otherwise  check if there is aleft and right child by (2i)+1 and (2i)+2 
	 * @param firstthe first name 
	 * @param last the last name 
	 * @param bw 
	 * @throws IOException 
	 * 
	 */
	public void searchBFS (String first, String last, BufferedWriter bw) throws IOException{
		int i=0; 
		int position = 0;
		int level = 0;
		out.write("The BFS for the MaxHeap: ");
		out.newLine();
		for(i=0; i<arrayOfNames.length; i++){
			if (arrayOfNames[i].firstName.compareTo(first)==0 && arrayOfNames[i].lastName.compareTo(last)==0){
				System.out.println("Me: " + arrayOfNames[i].firstName + " " + arrayOfNames[i].lastName);
				out.write("Me: " + arrayOfNames[i].firstName + " " + arrayOfNames[i].lastName);
				out.newLine();
				if ((i-1)/2 < 0) {
					System.out.println("No parent");
					out.write("No parent");
					out.newLine();
					}
				else{
					System.out.println("The parent is " + arrayOfNames[(i-1)/2].firstName + " " + arrayOfNames[(i-1)/2].lastName);
			 		out.write("The parent is " + arrayOfNames[(i-1)/2].firstName + " " + arrayOfNames[(i-1)/2].lastName);
					out.newLine();
				}
				if ((2*i)+1> arrayOfNames.length ){
					System.out.println("No left children");
		        	out.write("No left children");
	        		out.newLine();
				}else{ 
					System.out.println("The left Child is " + arrayOfNames[(2*i)+1].firstName + " " + arrayOfNames[(2*i)+1].lastName);
	        		
					out.write("The left Child is " + arrayOfNames[(2*i)+1].firstName + " " + arrayOfNames[(2*i)+1].lastName);
	        		out.newLine();
				}
	        	if((2*i)+2 > arrayOfNames.length){
		        	System.out.println("No right children");
	        		out.write("No right children");
	        		out.newLine();
	        	}else {
	        		System.out.println("The right Child is " + arrayOfNames[(2*i)+2].firstName + " "  +arrayOfNames[(2*i)+2].lastName );
	        		
	        		out.write("The right Child is " + arrayOfNames[(2*i)+2].firstName + " "  +arrayOfNames[(2*i)+2].lastName );
	        		out.newLine();
	        	}	
		        level = (int) Math.floor(Math.log(i)/Math.log(2));
	        	position = (int) ((i+1) - Math.pow(2,level));
	        	System.out.println("The position is " + position);
	        	out.write("The position is " + position);
	        	out.newLine();
	        	System.out.println("The level is " + level);
	        	out.write("The level is " + level);
	        	out.newLine();
	        	out.newLine();	
		        	//System.out.println("The position is" + position); and level 
		        break;
			}
		}
	}
	/**
	 * searching for the names by the depth first search. DFS move from the root 
	 * to the left most child until it reach its leaf then go backto the next parent 
	 * then the right child and looping through this process to find the vallues we are searching for 
	 * then return it's parent, child, position, and level 
	 * @param first name 
	 * @param last name 
	 * @throws IOException 
	 */
	
	public void searchDFS(String first, String last) throws IOException{
	Stack<Integer> stack = new Stack<Integer>() ; //?!!!			double position = 0;
	double level = 0 ;
	int index= 0;
	int position = 0;
	out.write("The DFS for the MaxHeap: ");
	out.newLine();
    if (arrayOfNames.length == 0 || arrayOfNames[index]== null) //check if the tree exist 
        return;
    stack.clear();//??
    stack.add(index);
    while(!stack.isEmpty()){
        index = stack.pop(); //??!!!
        //x++;
        if (arrayOfNames[index].firstName.compareTo(first)==0 && arrayOfNames[index].lastName.compareTo(last)==0){//same name 
        	System.out.println("Me: " + arrayOfNames[index].firstName + " " + arrayOfNames[index].lastName);
        	out.write("Me: " + arrayOfNames[index].firstName + " " + arrayOfNames[index].lastName);
    		out.newLine();

        	if ((index-1)/2 < 0){
        		System.out.println("No parent");
        		out.write("No parent");
        		out.newLine();

        	}else{ 
        		System.out.println("The parent is " + arrayOfNames[(index-1)/2].firstName + " " + arrayOfNames[(index-1)/2].lastName);
        		out.write("The parent is " + arrayOfNames[(index-1)/2].firstName + " " + arrayOfNames[(index-1)/2].lastName);
        		out.newLine();

        	}if((2*index)+1> arrayOfNames.length ){
        		System.out.println("No left child");
        		out.write("No left child");
        		out.newLine();

        	}else{ 
        		System.out.println("The left Child is " + arrayOfNames[(2*index)+1].firstName+ " " + arrayOfNames[(2*index)+1].lastName);
        		out.write("The left Child is " + arrayOfNames[(2*index)+1].firstName+ " " + arrayOfNames[(2*index)+1].lastName);
        		out.newLine();

        	}if((2*index)+2> arrayOfNames.length){
        		System.out.println("No right child");
        		out.write("No right child");
        		out.newLine();

        	}else {
        		System.out.println("The right Child is " + arrayOfNames[(2*index)+2].firstName + " " + arrayOfNames[(2*index)+2].lastName);
        		out.write("The right Child is " + arrayOfNames[(2*index)+2].firstName + " " + arrayOfNames[(2*index)+2].lastName);
        		out.newLine();

        	}
        	out.newLine();
        	level =  Math.floor(Math.log(index)/Math.log(2));
        	position = (int) ((index+1) - Math.pow(2,level));
        	System.out.println("The position is" + position);
        	//out.write("The position is" + position);
        	out.newLine();
        	System.out.println("The level is" + level);
        	out.write("The level is" + level);
        	out.newLine();out.newLine();
        	index++;
        	break;
        }else{	
	        
	        if((2*index)+2 < arrayOfNames.length && arrayOfNames[(2*index)+2]!= null ) stack.add((2*index)+2); //right chikd 
	        if((2*index)+1 < arrayOfNames.length && arrayOfNames[(2*index)+1]!= null) stack.add((2*index)+1);	//left child
	        }
        //level++;
    }
    
}	
	/**
	 * to add the node"values of the tree to the array" we check first
	 * if the last element we add is bigger than the length of the array, so we are out of bound 
	 * other wise every element we add we increase by 1 
	 * @param x the first name 
	 * @param y the last name 
	 * @return
	 */
	public int add(String x , String y){
		if(lastAddedIndex >= arrayOfNames.length){ //if the last index that isadded is >= 55, return -1 
			return -1;
		}else {
			arrayOfNames[++lastAddedIndex] = new fullName(x,y); //if not add to the next position in the array
			return lastAddedIndex;
		}
	}
	/**
	 * after we add the values to the array we do upheapify so basicaly we compare each node by it is parent
	 * if the current node or the last added index is greater than the parent then swap until we 
	 * get the max value of the array at the top of the tree basically at position [0] in the array
	 * @param index
	 */
	public void heapify(int index){
		int i=0;
		String [] swap = new String[2];
		if (index < 0 && index > arrayOfNames.length)
			return;
		if ((index-1)/2 <0 ) //parents
			return;
	
		if (arrayOfNames[(index-1)/2].firstName.compareTo(arrayOfNames[index].firstName)<0){
			swap[0] =arrayOfNames[(index-1)/2].firstName;
			swap[1] = arrayOfNames[(index-1)/2].lastName;
			arrayOfNames[(index-1)/2].firstName = arrayOfNames[index].firstName ;
			arrayOfNames[(index-1)/2].lastName = arrayOfNames[index].lastName ;
			arrayOfNames[index].firstName = swap[0];
			arrayOfNames[index].lastName = swap[1];
			heapify((index-1)/2); //parent index 	
		}
	}
	/**
	 * 
	 * visit the current node starting from the first position of the array
	 * then the left child (2*i) + 1  and the right child (2*i)+2
	 *
	 */
	public void preOrdertraversal(int index){
		//Check that its not empty
		if(arrayOfNames[0]== null || index < 0 || index > arrayOfNames.length )
			return;
		//Print myself
		System.out.println(arrayOfNames[index].firstName);
		if(((2*index)+1) > arrayOfNames.length)//Check if possible left child is out of bounds.
			return;
		if(arrayOfNames[(2*index)+1]!= null){//If it's not, check if it exists
			preOrdertraversal((2*index)+1);//If it exists, recursively call this function for the left child
		} 
		if(((2*index)+2) > arrayOfNames.length)//Check if possible right child is out of bounds.
			return; 
		if(arrayOfNames[(2*index)+2]!= null){//If it's not, check if it exists
			preOrdertraversal((2*index)+2);//If it exists, recursively call this function for the right child
		}
			return; 
	}	
	/**
	 * travers the left child (2*i) + 1  then the right child (2*i)+2
	 * then visit the current node starting from the first position of the array
	 *
	 */
	public void postOrdertraversal(int index){
		//Check that its not empty
		if(arrayOfNames[0]== null || index < 0 || index > arrayOfNames.length )
			return;
		if(((2*index)+1) > arrayOfNames.length)//Check if possible left child is out of bounds.
			return;
		if(arrayOfNames[(2*index)+1]!= null){//If it's not, check if it exists
			postOrdertraversal((2*index)+1);//If it exists, recursively call this function for the left child
		} 
		if(((2*index)+2) > arrayOfNames.length)//Check if possible right child is out of bounds.
			return; 
		if(arrayOfNames[(2*index)+2]!= null){//If it's not, check if it exists
			postOrdertraversal((2*index)+2);//If it exists, recursively call this function for the right child
		}
		//	return; 
		//Print myself
		System.out.println(arrayOfNames[index].firstName);
				
	}
	/**
	 * travers the left child (2*i) + 1  
	 * then visit the current node starting from the first position of the array
	 *and the last one is the right child (2*i)+2
	 */
	public void inOrdertraversal(int index){
		//Check that its not empty
		if(arrayOfNames[0]== null || index < 0 || index > arrayOfNames.length )
			return;
		
		if(((2*index)+1) > arrayOfNames.length)//Check if possible left child is out of bounds.
			return;
		if(arrayOfNames[(2*index)+1]!= null){//If it's not, check if it exists
			inOrdertraversal((2*index)+1);//If it exists, recursively call this function for the left child
		} 
 
		//Print myself
		System.out.println(arrayOfNames[index].firstName);
		
		if(((2*index)+2) > arrayOfNames.length)//Check if possible right child is out of bounds.
			return; 
		if(arrayOfNames[(2*index)+2]!= null){//If it's not, check if it exists
			inOrdertraversal((2*index)+2);//If it exists, recursively call this function for the right child
		}
		
				
	}	
	
	
}