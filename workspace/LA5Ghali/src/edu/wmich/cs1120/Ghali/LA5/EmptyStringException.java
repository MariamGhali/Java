package edu.wmich.cs1120.Ghali.LA5;

public class EmptyStringException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmptyStringException(){
	
		super("Error: Input cannot be an empty string.");
	}
	
}
