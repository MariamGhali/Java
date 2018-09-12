package recursionDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		double totalIncome = 0.0;
		File file = new File ("inputFile2.txt.txt");
		Scanner inputFile = new Scanner(file);
		while (inputFile.hasNext()){
		
		   try  {    totalIncome += inputFile.nextDouble();      

		   } catch(InputMismatchException e)  {   

		        System.out.println("Non-numeric data encountered " + "in the file.");   

		         inputFile.nextLine(); 

		    }  finally  {   

		         totalIncome = 35.5; 

		    }

		}
	}
	}
