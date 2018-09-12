package hw3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
/**
 * the main class will handle open the output file and initialize the values of the linkedlist and array
 * then it will handle 3 different types of sorting for array bubble, insertion and selection sort. 
 * it will also have the binary search for the insertion sort 
 * it will also have the sort and special function the purpose of thoes function is to sorted it based on the last name 
 * then based of alpeh order 
 * @author mariam
 *
 */
public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int i;
		BufferedWriter bw = null;
		Random r = new Random();
		Scanner reader = new Scanner(System.in);  // Reading from System.in , read the user input
		long startTime, endTime, totalTime ;
		double secondsForBubble, secondsForInsertion,secondsForMerge, secondsForSelection;
		//write to outputsorting.txt fi;e 
		FileWriter fw = new FileWriter("outputSorting.txt");
		bw = new BufferedWriter(fw);
		System.out.println("Enter the number of the letters: ");
		int n = reader.nextInt(); // Scans the next token of the input as an int.
		bw.write("Enter the number of the letters: ");
		bw.newLine();
		bw.write("The number is: " + n);
		//initialize the array 
		char [] array1 = new char [n];
		char [] array2 = new char [n];
		char [] array3 = new char [n];
		char [] array4 = new char [n];
		char [] sortedArray = new char [n];
		
		charLinkedList linkedList = new charLinkedList();//create the object linkedlist of the char charLinkedList
		linklistSorting sorting = new linklistSorting ();
		bw.newLine();
		bw.write("Last name is : Ghali");
		//System.out.println(sort('g','l'));
		bw.newLine();
		MergeSort merge = new MergeSort(); // create the object merge for the mergeSort class 
		
		
		bw.write("The unsorted array is: ");
		for(i = 0; i < n; i++){	//create an array with lower case letter and print it 
		     char x  = (char)(r.nextInt(26) +97);
		     array1[i] = x;
		     array2[i] = x;
		     array3[i] = x;
		     array4[i] = x;
		     
		     bw.write( array1[i]+ " ");
		} bw.write("\n");
		bw.newLine();
		
		 bw.write("The unsorted Linked List is: ");	//print the unsorted inked list 
		for(i=0; i < n ; i++){
			char x  = (char)(r.nextInt(26) +97);
			linkedList.insert(x);
			System.out.print(x + " ");
		}bw.newLine();
		System.out.println("\n ");
		//printing the sorted lin
		sorting.bubbleSort(n,linkedList);
		System.out.print("The sorted Linked List by bubble sort is: "+ "\n");
		sorting.printData(linkedList);
		
		sorting.selectionSort(n,linkedList);
		System.out.print("The sorted Linked List by Selection sort is: "+ "\n");
		sorting.printData(linkedList);
		//mergeLL.sort(linkedList, 0, n-1);
		
		linkedList.head = linkedList.spiltLL(linkedList.head);
        System.out.print("Sorted Linked List is: \n");
    
		linkedList.printData(linkedList.head);
		//System.out.println("\n");
		//linkedList.sort();	
		//linkedList.printData();
		//linkedList.bubbleSort(n - 1);
		
				
		
		bw.write("Sorting using array");
		bw.newLine();
		
		//calling the bubble sort method 
		startTime = System.nanoTime();
		sortedArray = bubbleSort(array1);	//call a bubble sort function
		bw.write("Bubble Sort: ");
		for(i = 0; i < sortedArray.length; i++){	//print a sorted array with bubble sort 
			bw.write(sortedArray[i] + " ");
		}bw.newLine();
		endTime   = System.nanoTime();
		totalTime = endTime- startTime;
		secondsForBubble = (double)totalTime / (1000000000.0);
		System.out.println("Time for bubble sort: " + secondsForBubble); //print the time it takes to bubble sort an array
		
		//calling the insertion sort method 
		startTime = System.nanoTime();
		sortedArray = insertionSort(array2);
		bw.write("Insertion Sort: ");
		for(i = 0; i < sortedArray.length; i++){	//print a sorted array with bubble sort 
			bw.write(sortedArray[i] + " ");
		}bw.newLine();
		endTime   = System.nanoTime();
		totalTime = endTime- startTime;
		secondsForBubble = (double)totalTime / (1000000000.0);
		System.out.println("Time for insertion sort: " + secondsForBubble);//print the time it takes to insertion sort an array
		
		//calling selection sort method
		startTime = System.nanoTime();
		sortedArray = selectionSort(array3);
		bw.write("Selection Sort: ");
		for(i = 0; i < sortedArray.length; i++){	//print a sorted array with bubble sort 
			bw.write(sortedArray[i]+ " ");
		}bw.newLine();
		endTime   = System.nanoTime();
		totalTime = endTime- startTime;
		secondsForBubble = (double)totalTime / (1000000000.0);
		System.out.println("Time for selection sort: " + secondsForBubble); //print the time it takes to selection sort an array
		
		
		//calling merge sort method that is in the merge class 
		startTime = System.nanoTime();
		sortedArray = merge.sort(array4,0,array4.length-1);
		bw.write("Merge Sort: ");	
		for(i = 0; i < sortedArray.length; i++){	//print a sorted array with bubble sort 
			bw.write(sortedArray[i] + " ");
		}bw.newLine();
		endTime   = System.nanoTime();
		totalTime = endTime- startTime;
		secondsForBubble = (double)totalTime / (1000000000.0);
		System.out.println("Time for merge sort: " + secondsForBubble);//print the time it takes to merge sort an array
		

		bw.close();
		fw.close();
	}
	/**
	 * Bubble sort will loop through the array twice one for the whole array and the other one for comparsion
	 * it will compare based on the last name char first then the alpeh order 
	 * take the first 2 char if ii> i+1 then swap  
	 * @param charArray
	 * @return the sorted array 
	 */
	public static char[] bubbleSort(char[] charArray) {

	    char temp;
	    int i  = 0 ;
	    int j = 1;
	    for (i = 0; i < charArray.length-1 ; i++) {
	        for (j = 1; j < (charArray.length - i); j++) {

	            //if (charArray[j - 1] > charArray[j]) {
	        	if (sort(charArray[j-1], charArray[j])) {
	                temp = charArray[j - 1];
	                charArray[j - 1] = charArray[j];
	                charArray[j] = temp;
	            }
	        }
	    }
		return charArray ;
		
	}
	/**
	 * it will take the element in the first position and compare it until the end of the array and fiind the 
	 * place where it should be, we use binary search 
	 * to reduce the number of the comparison so the time complex. will 
	 * be o(nlogn) instead of o(n^2) and 
	 * 
	 * @param charArray
	 * @return the sorted array 
	 */
	public static char[] insertionSort(char[] charArray) {
		char temp;
	    int i  = 0 ;
	    int j = 0;
        for (i = 0; i < charArray.length-1 ; i++) {
            
             //if(charArray[i] > charArray[i+1])
        	if (sort(charArray[i], charArray[i+1])) {
                    //temp = charArray[j];
                    //charArray[j] = charArray[j-1];
                    //charArray[j-1] = temp;
                int position = binarySearch(charArray, charArray[i+1], 0 , i);
              
                temp = charArray[i+1];
                //Shift
                for (j=i+1; j>position; j--){
                	charArray[j] = charArray[j-1];
                }
                charArray[position] = temp;	
                	//charArray[j] = charArray[position];
                	//charArray[j-1] = temp;
            }
        }
		return charArray;
		
	}
	/**
	 * it will take the an element and find the place where it shoud be in the array.
	 * the binary search is basically dividing the array unit it find the right
	 * position for the new sorted element 
	 * @param a
	 * @param item
	 * @param low
	 * @param high
	 * @return the position of the new sorted element
	 */
	public static int binarySearch(char a[],char item, int low, int high)
	{
	    if (high <= low)
	        return  (sort(item, a[low])? (low + 1): low);
	 
	    int mid = (low + high)/2;
	 
	    if(item == a[mid])
	        return  (mid+1);
	 
	    //if(item > a[mid])
	    if (sort(item, a[mid]))	 	
	    	return binarySearch(a, item, mid+1, high);
	    return binarySearch(a, item, low, mid-1);
	}
	/**
	 * it will divide the array to sorted and unsorted part 
	 * it will also compare in terms of last name char first then the alpeh order
	 * if the value at the min index is > the next value then swap   
	 * @param array
	 * @return the sorted array 
	 */
	public static char[] selectionSort(char[] array){
		char temp;
	    int i  = 0 ;
	    int j = 1;
        for (i = 0; i < array.length; i++){ //outer loop
        	int min_index = i; //the first unsorted index
            for (j = i+1; j < array.length; j++){
                //if (array[min_index] > array[j])
            	if(sort(array[min_index], array[j]))
                    min_index = j;    
            // Swap the found minimum element with the first
            // element
            }
            if (min_index != i){
	            temp = array[min_index];
	            array[min_index] = array[i];
	            array[i] = temp;
            }
		} 
        return array;
    }
	/**
	 * it will basically compare the char we used to compare in the sort 
	 * if x is special and y is special too so we call the special method first 
	 * and sort based in the last name then the alpeh order
	 * if x is special and y not then sort x only based on the last name first then allpeh
	 * same with y
	 * @param x
	 * @param y
	 * @return true if is the char is one of the special char which is the last name 
	 * and false otherwise 
	 */
	public static boolean sort(char x, char y){
		
		//int indexX =specialChar(x);
		//int indexY = specialChar(y);
		if (x > y){
			if (specialChar(x)>=0){
				if(specialChar(y)>=0){
					if(specialChar(x)>specialChar(y)){
						return true;
					}
					return false;
				}
				return false;
			}
				
		return true;	
		}else{
			if (specialChar(y)>=0){
				if(specialChar(x)>=0){
					if(specialChar(y)>specialChar(x)){
						return false;
					}
					return true;
				}
				return true;
			}		
		return false;	
		}
	}
	/**
	 * compare each char if they are one of the special char return the postion so it will be sorted based on the 
	 * last name then alpeh
	 * @param a
	 * @return the index of the char that is one of the last name char
	 */
	public static int specialChar (char a){
		int index = 0; 
		char [] lastName   = {'g', 'h','a', 'l', 'i'};
		
		for(index= 0; index < lastName.length; index++){
			if(lastName[index]== a){
				return index; 
			}
		}
		return -1;
	}
	/*public static void print (node head ){	//print ll
		node temp = head ;
		while (temp != null){
			System.out.printf("%c " , temp.value()  );
			temp.next();
		}
		System.out.println();
	}*/
}
