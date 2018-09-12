package edu.wmich.cs1120.Ghali.LA5;

import java.util.Scanner;
import java.util.*;

public class Controller implements IController {

	protected ISms mySms;
	protected IPigLatin myPigLatin;
	
	public Controller (ISms mysms, IPigLatin mypigLatin ){
		mySms = mysms;
		myPigLatin = mypigLatin;
	}
	
	@Override
	public void setSmsObject(ISms mySms){
		mySms = new Sms();
	}
	
	@Override
	public void setPigLatinObject(IPigLatin myPigLatin){
	
		myPigLatin = new PigLatin();
	}
	@Override
	public void runProgram() throws IllegalArgumentException{
		
		int inputNum=-1;
		do {
			System.out.println("What would you like to do? ");
			System.out.println("Choose from the following menu:\n"+"1 - Text "
					+ "to SMS conversion\n"+"2 - SMS to Text conversion\n"+
					"3 - Text to PigLatin conversion\n" +"0 - Quit");
			
			while(true){
				try{
					Scanner keyboard = new Scanner(System.in);
					inputNum = keyboard.nextInt();		
			 
					if(inputNum> 3 || inputNum < 0 ){
						throw new IllegalArgumentException("Invalid number! Option must be 0, 1, 2 or 3.");	
					}
					else if (inputNum ==1){
						System.out.println("Input text to be converted to SMS:");
						convertTextToSMS();
						break;
					}
					else if (inputNum == 2){
						System.out.println("Input SMS to be converted to text:");
						convertSMSToText();
						break;
					}
					else if (inputNum == 3){
						System.out.println("Input text to be converted to pigLatin:");
						convertTextToPigLatin();
						break;
					}
					else if(inputNum == 0 ){
						System.out.println("Program terminating ...");
						break;
					}
				}
				catch(InputMismatchException e){
					System.out.println("Invalid option. Input must be a number."); 
					System.out.println("Please enter: 0, 1, 2 or 3.");
				}
				catch(IllegalArgumentException e){
					System.out.println(e.getMessage());
				}
			}
		}while(inputNum != 0);
	}
		
	@Override
	public void convertTextToSMS(){
		
		Scanner keyboard = new Scanner(System.in);
		String input = "";
		while(input.isEmpty()){
			try{
				input = keyboard.nextLine();
				if(input.isEmpty())
					throw new EmptyStringException();
			}catch(EmptyStringException e){
				System.out.println(e.getMessage());
			}
		}
		
		mySms.setInput(input);
		mySms.textToSMS();
	}
	@Override
	public void convertSMSToText(){
		Scanner keyboard = new Scanner(System.in);
		String input = "";
		while(input.isEmpty()){
			try{
				input = keyboard.nextLine();
				if(input.isEmpty())
					throw new EmptyStringException();
			}catch(EmptyStringException e){
				System.out.println(e.getMessage());
			}
		}
			mySms.setInput(input);
			mySms.smsToText();
	}

	@Override
	public void convertTextToPigLatin(){
		
		Scanner keyboard = new Scanner(System.in);
		String input = "";
		while(input.isEmpty()){
			try{
				input = keyboard.nextLine();
				if(input.isEmpty())
					throw new EmptyStringException();
			}catch(EmptyStringException e){
				System.out.println(e.getMessage());
			}
		}
		myPigLatin.setInput(input);
		myPigLatin.textToPigLatin();
	}
}