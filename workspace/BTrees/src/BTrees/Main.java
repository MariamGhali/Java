package BTrees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;
/**
 * The main method will read the acsii file and call the method insert in the 2-3tree class 
 * then after creating the tree. it will create 4 2-3 trees one for each colunm 
 * and same with 2-3-4 trees.  it will ask the user for an input to search for it in the for trees 
 * once we found it it will return all the relavent values of this searchedvalues from the ascii table 
 * it will aslo get the time that each search uses. 
 * @author mariam
 *
 */

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//RelevantValue rv = new RelevantValue();
		String fileName = "ascii.txt";
		String line = null;
		long startTime, endTime, totalTime ;
		double secondsDecTree, secondsHexTree,secondsOctTree, secondsCharTree;
		String hex;String oct;String charValue;String dec;
		Scanner reader = new Scanner(System.in);
		TwoThreeTree<Integer, RelevantValues> decTree = new TwoThreeTree<Integer, RelevantValues>();
		TwoThreeTree<Integer, RelevantValues> hexTree = new TwoThreeTree<Integer , RelevantValues>();
		TwoThreeTree<Integer, RelevantValues> octTree = new TwoThreeTree<Integer, RelevantValues>();
		TwoThreeTree<String, RelevantValues> charTree = new TwoThreeTree<String, RelevantValues>();
		String n = "";
		String line2="";
		
		while(n.compareTo("exit")!=0){
			System.out.println("Enter a value: ");
			 n = reader.next(); // Scans the next token of the input as an string.
			try {
				// FileReader reads text files in the default encoding.
		        FileReader fileReader =  new FileReader(fileName);
		        BufferedReader bufferedReader =  new BufferedReader(fileReader);
		        while((line = bufferedReader.readLine()) != null) {
		            	String[] splitLine = line.split("\t");
		            	hex = splitLine[2];
		            	oct = splitLine[1];
		            	dec = splitLine[0];
		            	charValue = splitLine[3];
		            	//Integer.parseInt(hex,16);	//from hex to integer 
		            	//String val = Integer.toHexString(Integer.parseInt(hex,16));
		            	//int n = (int) Long.parseLong("ffff8000", 16);
		            	//System.out.println(splitLine[4]);
		            	decTree.insert(Integer.parseInt(dec), new RelevantValues(hex,oct, charValue) ); //create dec tree
		            	hexTree.insert(Integer.parseInt(hex,16), new RelevantValues(dec,oct, charValue));	//create a hex tree
		            	octTree.insert(Integer.parseInt(oct), new RelevantValues(dec, hex , charValue));	//create a oct tree
		            	charTree.insert(charValue, new RelevantValues(dec,hex, oct));	//create char tree 
		            	//decTree.traversal(decTree.root,Integer.parseInt(dec));
		        }
		 	}catch(FileNotFoundException ex) {
	            System.out.println("Unable to open file '" + 
	                    fileName + "'");                 
		 	}
			//Traversing 
			decTree.traversal(decTree.root);
			hexTree.traversal(hexTree.root);
			charTree.traversal(charTree.root);
			octTree.traversal(octTree.root);
			
			
//			FileReader fileReader2 =  new FileReader("input.txt");
//	        BufferedReader bufferedReader2 =  new BufferedReader(fileReader2);
//	        FileWriter fw = new FileWriter("result.txt");
//			BufferedWriter  = new BufferedWriter(fw);
//			while((line2 = bufferedReader2.readLine()) != null){
//					String split[] =line2.split("\t");		
			
			startTime = System.nanoTime();
			if(isNumeric(n) && Integer.parseInt(n)<128){	//search in the decimal tree 
				
				RelevantValues values = decTree.findhelp(decTree.root, Integer.parseInt(n));
				System.out.println("Search in Decimal Tree for Value " + n + " is : " + "\n" + "HexValue:"+ values.val1 + "\n"+
				"OctValue: " + values.val2  + "\n" + "CharValue: " + values.val3 + "\n");
				
			}else {
				System.out.println("No Decimal value for the input: " + n + "\n");
				
			}
			endTime   = System.nanoTime();
			totalTime = endTime- startTime;
			secondsDecTree = (double)totalTime / (1000000000.0);
			System.out.println("Search Time for the Decmail Tree is:  " + secondsDecTree + " seconds");
			System.out.println("\n ");
			
			startTime = System.nanoTime();
			if (isOct(n)){		//search in the oct tree
			
				RelevantValues values = octTree.findhelp(octTree.root, Integer.parseInt(n));
				System.out.println("Search in Oct Tree for Value " + n + " is : " + "\n" + "DecmialValue:"+ values.val1 + "\n"+
						"HexValue: " + values.val2  + "\n" + "CharValue: " + values.val3 + "\n" );
				
				
			}else {
				System.out.println("No Oct value for the input: " + n + "\n");
				
			}
			endTime   = System.nanoTime();
			totalTime = endTime- startTime;
			secondsOctTree = (double)totalTime / (1000000000.0);
			System.out.println("Search Time for the Oct Tree is:  " + secondsOctTree + " seconds");
			System.out.println("\n ");
			
			startTime = System.nanoTime();
			if (isHex(n)&&hexTree.findhelp(hexTree.root, Integer.valueOf(String.valueOf(n), 16) )!=null){		//search in the oct tree
			
				RelevantValues values = hexTree.findhelp(hexTree.root, Integer.valueOf(String.valueOf(n), 16) );
				System.out.println("Search in Hex Tree for Value " + n + " is : " + "\n" + "DecmialValue:"+ values.val1 + "\n"+
				"OctValue: " + values.val2  + "\n" + "CharValue: " + values.val3 + "\n" );
				
				
			}else {
				System.out.println("No hex value for the input: " + n + "\n");
				
			}
			endTime   = System.nanoTime();
			totalTime = endTime- startTime;
			secondsHexTree = (double)totalTime / (1000000000.0);
			System.out.println("Search Time for the Hex Tree is:  " + secondsHexTree + " seconds");
			System.out.println("\n ");
			
			startTime = System.nanoTime();
			if ( charTree.findhelp(charTree.root, n)!=null){
				
				RelevantValues values = charTree.findhelp(charTree.root, n);		//search in the char tree
				System.out.println("Search in Char Tree for Value " + n + " is : " + "\n" + "DecmialValue: "+ values.val1 + "\n"+
					"HexValue: " + values.val2  + "\n" + "CharValue: " + values.val3 +"\n");
				
			
			}else {
				System.out.println("No Char value for the input: " + n + "\n");
				
			}
			endTime   = System.nanoTime();
			totalTime = endTime- startTime;
			secondsCharTree= (double)totalTime / (1000000000.0);
			System.out.println("Search Time for the CharTree is:  " + secondsCharTree + " seconds");
			System.out.println("\n ");
			}
		}
	/**
	 * to check if the input from the use is an integer or not 
	 * @param str the user input 
	 * @return true if it is an int 
	 */
	public static boolean isNumeric(String str)
	{
	  return str.matches("^[0-9]+$");
    }
	/**
	 * to check if the input from the use is an integer not exceeding 7 or basically if it's an oct number or not 
	 * @param str the user input 
	 * @return true if it is an oct 
	 */
	public static boolean isOct(String str)
	{
	  return str.matches("^[0-7]+$");
    }
	/**
	 * to check if the input from the use is an hex number or not 
	 * @param str the user input 
	 * @return true if it is an hex
	 */
	public static boolean isHex(String str)
	{
	  return str.matches("^[0-9a-fA-F]+$");
    }
}
