package edu.wmich.cs1120.MG.LA3;

public class Book extends LibraryItem {

	protected String bTitle;
	protected String auther;
	protected String gener;

	
	public Book (String it, String callNum, String bTit, String auth, String gen){
		super(it, callNum);
		bTitle = bTit;
		auther = auth;
		gener = gen;
	}
	/**
	 * to print every thing in the book subclass
	 */
	@Override
	public String toString(){
	String str= "Book Title:" + bTitle + "\nAuther:" + auther + "\nGenre: " +
	gener + "\nCall Number: " + callNumber;
	if(checkedOut == false)
		return str + "\nChecked Out: NO";
	
	if(checkedOut == true)
		return str + "\nChecked Out: YES";
	return str;
 }
}
