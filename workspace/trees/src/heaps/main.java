package heaps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
/**
 * The main class will read the file line by line split by the tap to last and first name 
 *  creating the three main data structure: minHeap, maxHeap and BST
 *  heapify for the values in min and max heap then traversal through the trees. 
 *  min heap and BST have explicit while max heap has implicit implementation  
 * @author mariam
 *
 */
public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String fileName = "list.txt";
		String line = null;
		
		// out file
		FileWriter fw = new FileWriter("result.txt");
		BufferedWriter bw = new BufferedWriter(fw);
        
		
		int numOfLines = 0;
		int level = 0;
		long startTime, endTime, totalTime ;
		double secondsMaxBFS, secondsMaxDFS,secondsMinBFS, secondsMinDFS,secondsBST;
		MinHeap minHeap = new MinHeap();
		MaxHeap maxHeap = new MaxHeap(10001, bw);
		BinarySearchTree BST = new BinarySearchTree(bw);
		NameSearch search = new NameSearch(bw);
  	    String myLastName = "Ghali";
  	     String myFirstName = "Mariam Adel";
  	  	
		
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =  new FileReader(fileName);
            //int count=0;
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =  new BufferedReader(fileReader);
            //String names []  = new String[52];
            while((line = bufferedReader.readLine()) != null) {
               // System.out.println(line);
            	String[] splitLine = line.split("\t");
            	//lastName.add(splitLine[1]);
            	//firstName.add(splitLine[0]);
            	//minHeap.insert(minHeap.root,splitLine[0],splitLine[1]);
            	minHeap.upHeapify(minHeap.insert(minHeap.root,splitLine[0],splitLine[1]));
            	maxHeap.heapify(maxHeap.add(splitLine[0], splitLine[1]));
            	//count++;
            	BST.insert(BST.root, splitLine[0], splitLine[1]);
            }
            //BST.inorderOrdertraversal();
            //minHeap.preOrdertraversal();
            //search
             
			//maxHeap
            System.out.println("The BFS for the MaxHeap: ");
            startTime = System.nanoTime();
			maxHeap.searchBFS(myLastName,myFirstName,bw);
			endTime   = System.nanoTime();
			totalTime = endTime- startTime;
			secondsMaxBFS = (double)totalTime / (1000000000.0);
			System.out.println("Search Time for the BFS in the MaxHeap is:  " + secondsMaxBFS + " seconds");
			System.out.println("\n ");
			System.out.println("The DFS for the MaxHeap: ");
			startTime = System.nanoTime();
			maxHeap.searchDFS(myLastName, myFirstName);
			endTime   = System.nanoTime();
			totalTime = endTime- startTime;
			secondsMaxDFS = (double)totalTime / (1000000000.0);
			System.out.println("Search Time for the DFS in the MaxHeap is:  " + secondsMaxDFS + " seconds");
			System.out.println("\n ");
			//minHeap
			
			System.out.println("The BFS for the MinHeap: ");
			search.BFS(minHeap.root, myFirstName,myLastName); // for minHeap
			endTime   = System.nanoTime();
			totalTime = endTime- startTime;
			secondsMinBFS = (double)totalTime / (1000000000.0);
			System.out.println("Search Time for the BFS in the MinHeap is:  " + secondsMinBFS + " seconds");
			System.out.println("\n ");
			System.out.println("The DFS for the MinHeap: ");
			search.DFS(minHeap.root, myFirstName,myLastName);
			endTime   = System.nanoTime();
			totalTime = endTime- startTime;
			secondsMinDFS = (double)totalTime / (1000000000.0);
			System.out.println("Search Time for the DFS in the MinHeap is:  " + secondsMinDFS + " seconds");
			System.out.println("\n ");
			
			System.out.println("The search for the BST: ");
            BST.searchBST(BST.root,myFirstName, myLastName,level);
            endTime   = System.nanoTime();
			totalTime = endTime- startTime;
			secondsBST = (double)totalTime / (1000000000.0);
			System.out.println("Search Time for the BST:  " + secondsBST+ " seconds");
            // Always close files.
          
          
            bw.close();
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                 
        }
	}
}
