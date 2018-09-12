package edu.wmich.cs1120.Ghali.LA5;

public interface ISms {

	/**
	 * Sets the input field to userInput (myInput).
	 * @param myInput - user's input.
	 */
	void setInput(String myInput);
	/**
	 * Converts text from user to SMS-text and returns it.
	 * @return - SMS-text form of user's input.
	 */
	String textToSMS();
	/**
	 * Converts SMS-text to normal text and returns it.
	 * @return - normal text form of user's input.
	 */
	String smsToText();

}
