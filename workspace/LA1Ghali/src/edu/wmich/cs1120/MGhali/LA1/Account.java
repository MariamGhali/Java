package edu.wmich.cs1120.MGhali.LA1;

public class Account {

	private int accountNumber;
	private double accountBalance;
	
	
	public Account (int accountNum,double accountBal){
		accountNumber =  accountNum;
		accountBalance = accountBal;
		
	}
	
	/**
	 * gets the account number of Account object
	 * @return the account number
	 */
	
	public int getAccountNumber(){
		
		return accountNumber;
	}
	
	/**
	 *  gets the account balance of Account object
	 * @return the amount balance
	 */
	
	public double getAccountBalance(){
		
		return accountBalance;
	}
	
	/**
	 * deposit amount from account
	 * @param depositAmount the amount the user want to deposit
	 */
	
	public void deposit(double depositAmount){
		
		double sum = accountBalance+depositAmount;
		accountBalance = sum;
	}
	
	/**
	 * withdraws specified amount from account
	 * @param withdrawlAmount he amount the user want to withdrawal
	 */
	public void withdrawl(double withdrawlAmount){
	
		double difference = accountBalance - withdrawlAmount;
		accountBalance = difference;
	}
}
