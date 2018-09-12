/*
 * Name: Mariam ghali
 * Assignment2: linear data
 * Data: 10-16-2017 
 */
package hw2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * The main method will manage to read an input file and write the number of the 
 * parentheses into and output file. It will also check the time of each method 
 * StackCheckBalancedParentheses and QueueCheckBalancedParenthesesthat will take for 
 * executing those methods. It will create the objects and instance of the class 
 * CharStack, charQueue, QueueCheckBalancedParentheses, StackCheckBalancedParentheses.
 * @author mariam
 *
 */
public class StackQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char x = '\u0000';
		//char myData = r;
		//CharNode  myCharNode = new CharNode(myData);
		String text = "((((()())()";
		String line;
		int queue = 0, stack=0;
		long startTime;
		long endTime  ;
		long totalTime;
		double secondsForStack;
		double secondsForQueue;
		
		BufferedWriter bw = null;
		StackCheckBalancedParentheses myStackCheckBalancedParentheses = new StackCheckBalancedParentheses(); //create and object of the StackCheckBalanced..
		QueueCheckBalancedParentheses myQueueCheckBalancedParentheses = new QueueCheckBalancedParentheses();	//create and object of the StackCheckBalanced.
		CharQueue  myCharListQueue = new CharQueue();	// object of charqueue
		CharStack  myCharListStack = new CharStack();	//object of CharStack
		
		
		
		
		
		//complexity?!!!!
		/*
		 * Try to open a file named balancedParencheckInputs and if it doesn't exist create one
		 * read a file using FileReader and a buffer to read the whole file as a line by line 
		 * call the the method checkBalancedParentheses from the both classes Queue and Stack checkedBalanced classes
		 *one the method return the number of the unbalanced parentheses it make an output of the result 
		 *then close all the files and a buffer we created
		 */
		
		try {
			File file = new File("balancedParenCheckInputs.txt");
			 if (!file.exists()) {
			     file.createNewFile();
			  } 
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			
			//write to balancedParenCheckOutput.txt file 
			FileWriter fw = new FileWriter("balancedParenCheckOutput.txt");
			bw = new BufferedWriter(fw);
			while ((line = bufferedReader.readLine()) != null) {
				//to calculate the time the of Stackbalanced use to get the number of the unbalanced parentheses using stack
				startTime = System.nanoTime();
				stack = myStackCheckBalancedParentheses.CheckBalancedParentheses(line);
				endTime   = System.nanoTime();
				totalTime = endTime- startTime;
				secondsForStack = (double)totalTime / (1000000000.0);
				//System.out.println("Search Time for the Stack for the line:  " + line + secondsForStack + " seconds");

				bw.write("The number of the unbalanced parentheses for " + line + " using Stack are " + stack);
				bw.newLine();
				//to calculate the time the of Queuebalanced use to get the number of the unbalanced parentheses using queue

				startTime = System.nanoTime();
				queue = myQueueCheckBalancedParentheses.CheckBalancedParentheses(line);
				endTime   = System.nanoTime();
				totalTime = endTime- startTime;
				secondsForQueue = (double)totalTime / (1000000000.0);
				//System.out.println("Search Time for the Queue for the line:  " + line + secondsForQueue + " seconds");
				bw.write("The number of the unbalanced parentheses for " + line + " using Queue are " + queue);
				bw.newLine();	
			}
			fileReader.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		
		//in terms of testing 
		/*CharList   myCharList = new CharList();
		myCharList.insert('a');
		myCharList.insert('b');
		myCharList.insert('c');
		myCharList.insert('d');
		*/
	
		
		
		/*to test
		myCharListStack.push('o');
		myCharListStack.push('s');	
		myCharListStack.push('c');
		myCharListStack.push('a');
		myCharListStack.push('r');
		 
		myCharListQueue.enqueue('o');
		myCharListQueue.enqueue('s');
		myCharListQueue.enqueue('c');
		myCharListQueue.enqueue('a');
		myCharListQueue.enqueue('r');
		
		//to test
		while ((x = myCharListQueue.dequeue()) != '\u0000')
			//System.out.print(x);
		
		System.out.println();
	
		while ((x = myCharListStack.pop()) != '\u0000')
			System.out.print(x);
		*/
	}

}
