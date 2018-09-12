package pmt;

import java.io.File;
import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File ("inputFile.txt");
		
		String line ;
		double num;
		double result;
		    try {

		        Scanner inputFile = new Scanner(file);
		        PrintWriter outputFile  = new PrintWriter ("outputFile.txt" );
		        while (inputFile.hasNextLine()) {
		        	line = inputFile.nextLine();
		            String []array = line.split(" ");
		            if (array[0].equals("FTMT")){
		            	num = Double.parseDouble(array[1]);
		            	result = num * (0.3048);
		            	outputFile.println((num + " ft"+" = " + result + " m"));
		            }
		            
		            else if (array[0].equals("MTFT")){
		            	num = Double.parseDouble(array[1]);
		            	result = num * (3.2808 );
		            	outputFile.println((num + " m"+" = " + result + " ft"));
		            }
		            else if (array[0].equals("SFSM")){
		            	num = Double.parseDouble(array[1]);
		            	result = num * (0.092903 );
		            	outputFile.println(num + " sq ft"+" = " + result + " sq m");
		            }
		            else if (array[0].equals("SMSF")){
		            	num = Double.parseDouble(array[1]);
		            	result = num * (10.764 );
		            	outputFile.println(num + " sq m"+" = " + result + " sq ft");
		            }
		            else if (array[0].equals("CFCM")){
		            	num = Double.parseDouble(array[1]);
		            	result = num * (0.028317 );
		            	outputFile.println(num + " cu ft"+" = " + result + " cu m");
		            }
		            else if (array[0].equals("CMCF")){
		            	num = Double.parseDouble(array[1]);
		            	result = num * (35.315 );
		            	outputFile.println(num + " cu m"+" = " + result + " cu ft");
		            }
		        }
		        
		        inputFile.close();
		        outputFile.close();
		    } 
		    catch (FileNotFoundException e) {
		        System.out.println(e.getMessage());;
		    }
		 }
		}
