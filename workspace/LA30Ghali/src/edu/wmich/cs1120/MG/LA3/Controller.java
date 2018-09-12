package edu.wmich.cs1120.MG.LA3;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Controller implements IController {
	
	Book [] bookItem;
	Periodical [] periodicalItem;
/**
 * Displays the collection of library items to the screen
 */
	public void displayCollection() {
		for(int i=0; i<bookItem.length;i++)
			if(bookItem[i].isCheckedOut() == false){
				System.out.println(bookItem[i]);
				System.out.println();
			}
		for (int i =0; i<periodicalItem.length;i++)
			if(periodicalItem[i].isCheckedOut() == false){
			System.out.println(periodicalItem[i]);
			System.out.println();
			}
	}

	/**
	 * Requests for the call number from the user, uses the findItem()
	 * method to check if that item exists in the library, and if it does 
	 * calls the checkOut() method for that item and prints out the item 
	 * that has been checked out. 
	 */
	public void checkoutMaterials(){
		Scanner keyboard= new Scanner (System.in);
		System.out.print("Enter the call number: ");
		System.out.println();
		String callNumber = keyboard.nextLine();
		
		 if (findItem(callNumber)!= null){
			 if(findItem(callNumber).isCheckedOut() == false){
				 findItem(callNumber).checkOut();
				 System.out.println(findItem(callNumber));
				 GregorianCalendar cal = new GregorianCalendar();
				 findItem(callNumber).setDateDue(cal);
			 }
			 else{
			 		System.out.println("Item is not available.");
			 }
		 }
		 else{
				 System.out.println("The file is not found.");
		 }
	}
	/**
	 * Searches in both the array of books and the array of periodicals 
	 * for the book with the call number received as a parameter.
	 * @param callNum The call number of the item requested by the user
	 * @return The requested item, or 'null' if item does not exist.
	 */
	public ILibrary findItem(String callNum){
	
	for (int i=0; i<bookItem.length ;i++){
		if(bookItem[i].getCallNumber().equals(callNum)){
			return bookItem[i];
		}
	}
	for (int i=0; i<periodicalItem.length ;i++){
		if(periodicalItem[i].getCallNumber().equals(callNum)){
			return periodicalItem[i];
		}
	}
	return null;
	}
	/**
	 * Displays the menu options to the user.
	 */

	public void showMenu(){

		System.out.println("------------- Menu -------------");
		System.out.println("l) Display collection\n2) Check out materials\n3) Ouit");
		System.out.println("------------------------------------");
		System.out.print("Please choose an option: ");
		
	}
	/**
	 * Reads data from the input file and stores the items in the 
	 * appropriate array. 
	 * @param fileName The name of the input file.
	 * @throws IOException Included in case input file is not found.
	 */
	public void readInput(String fileName) throws IOException{
		File file = new File (fileName);
		Scanner inputFile = new Scanner(file);

		bookItem = new Book[inputFile.nextInt()]; 
		periodicalItem= new Periodical[inputFile.nextInt()];

		int number=0;
		int num = 0;
		while (inputFile.hasNext()){
			String [] line =  inputFile.nextLine().split(",");
			if (line[0].equals("B")){
				bookItem[number] = new Book(line[0],line[1],line[2],line[3],line[4]); 
				number++;
			}
			if (line[0].equals("P")){
			periodicalItem[num] = new Periodical (line[0],line[1],line[2], line[3], line[4], line[5]);
			num++;
		}
	}
	}
}