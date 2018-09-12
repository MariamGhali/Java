package edu.wmich.cs1120.MG.LA3;

/**
 * Name: Mariam Ghali
 * Date :02/25/2016
 * LAB 03
 * to read the file and display it or check if the book or the periodical 
 * is on the file or not or quiz the program
 */

import java.util.Scanner;
import java.io.IOException;
public class LA3Assign {
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);
		IController control = new Controller();
	    	control.readInput("input.txt");
        	String response = "";
        	boolean quitFlag = false;
        
        while (!quitFlag) {
            control.showMenu();
            response = keyboard.nextLine();
            System.out.println();
            switch (response) {
                case "1":
                    control.displayCollection();
                    break;
                case "2":
                    control.checkoutMaterials();
                    break;
                case "3":
                    quitFlag = true;
                    break;
            }
        }
	
        keyboard.close();
	}

}	// End of main class

