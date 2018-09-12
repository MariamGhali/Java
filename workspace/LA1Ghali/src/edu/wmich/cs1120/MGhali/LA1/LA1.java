package edu.wmich.cs1120.MGhali.LA1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner; 

/**
 * this program going to read a file that have the account number and the  balances 
 * and take the the amount of money and account number from the user then update the file
 * @author mariam
 *
 */
public class LA1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Read file
		//Make array of accounts
		
		//Do transactions
		
		//Write back to file
	
		File myFile = new File("accountDatabase.txt"); 
		Scanner inputFile = new Scanner (myFile);
		Account [] getAccount = new Account[10];
		
	
		for (int i = 0; i<getAccount.length;i++){
			int x = inputFile.nextInt();
			double y = inputFile.nextDouble();
			getAccount[i]= new Account(x,y);
			
		}
	
		Scanner keyboard = new Scanner (System.in);

		while(true){
			printMenu();
			System.out.print("->");
			int n = getChoice(keyboard);
			if (n==0)
				break;
			if (n==1 || n==2){
				System.out.print("Please input the account number->");
				int accountNumber = getAccountNumber(keyboard);
				double amount = getAmount(keyboard);
				for (int i=0;i<getAccount.length;i++){
					if(getAccount[i].getAccountNumber()==accountNumber){
						if(n==1){
							getAccount[i].deposit(amount);
							break;
						}
						else if(n==2){
							getAccount[i].withdrawl(amount);
							break;
						}
					}
					if(i==9)
						System.out.println("Account number not found");
			
				}
			}
			else if (n==3){
				int [] array = getTransferAccountNumbers(keyboard);
				int success = 0;
				for (int i=0;i<getAccount.length;i++){
					if(getAccount[i].getAccountNumber()==array[0]){
						for (int j=0;j<getAccount.length;j++){
							if(getAccount[j].getAccountNumber()==array[1]){
								double amount = getAmount(keyboard);
								getAccount[i].withdrawl(amount);
								getAccount[j].deposit(amount);
								success = 1;
							}
							if(j==9 && success == 0)
								System.out.println("Transfer account number not found.");
						}
					}
					if(i==9 && success == 0)
						System.out.println("Transfer account number not found.");
				}
			
			}
		
		}
		updateAccountDatabase(getAccount);
		
	}

	/**
	 * print menu showing available options (1,2,3,0)to screen
	 */
	public static void printMenu(){
	
		System.out.println("l.Deposit\n2.Withdraw\n3.Transfer\n0.Exit");
	}
	
	/**
	 * Read in the user's desired option / choice
	 * @param keyboard Scanner
	 * @return the number of the choice
	 */
	public static int getChoice(Scanner keyboard){
	
	     return	keyboard.nextInt();
	}
	
	
	/**
	 * Get relevant account number from user for a deposit or withdraw transaction
	 * @param keyboard Scanner  
	 * @return the account number
	 */
	
	public static int getAccountNumber(Scanner keyboard){
		
		int accountNum = keyboard.nextInt();
		return accountNum;
	}
	
	/**
	 * Get relevant account numbers from user for a transfer transaction
	 * @param keyboard Scanner
	 * @return an array of the transfered account number
	 */
	
	public static int [] getTransferAccountNumbers(Scanner keyboard){
		
		int transferAccount1,transferAccount2;
		
		
		System.out.print("Please input the account number to transfer from ->");
		transferAccount1 = keyboard.nextInt();
		System.out.print("Please input the account number to transfer to ->");
		transferAccount2 = keyboard.nextInt();
		int [] array = {transferAccount1,transferAccount2};
		return array;
	}
	
	/**
	 *  Get amount from user for the current transaction
	 * @param keyboard Scanner 
	 * @return the amount of the money
	 */
	
	public static double getAmount(Scanner keyboard){
	
		System.out.println("Please input the amount->");
		double amount = keyboard.nextDouble();
		return amount;
	
	}
	/**
	 * Update input file with the new account balances based on user’s transactions
	 * @param account the array of the account number              
	 * @throws IOException
	 */
	public static void updateAccountDatabase(Account[] account) throws IOException{
		
		PrintWriter writer = new PrintWriter("accountDatabase.txt", "UTF-8");	
		for (int i =0;i<account.length;i++){
		writer.println(account[i].getAccountNumber()+ " "+account[i].getAccountBalance());
	}
		writer.close();
	}
	
}