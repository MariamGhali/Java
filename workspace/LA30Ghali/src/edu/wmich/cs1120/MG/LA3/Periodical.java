package edu.wmich.cs1120.MG.LA3;

public class Periodical extends LibraryItem {

	protected String pTitle; 
	protected int volume;
	protected int issue;
	protected String subject;
	
	public Periodical (String i, String callNum ,String title,  String v, String iss, String sub ){
	super(i, callNum);
	pTitle = title;
	volume = Integer.parseInt(v);
	issue = Integer.parseInt(iss);
	subject = sub;
	}
	/**
	 * to print every thing in the periodical subclass
	 */
	@Override
	public String toString(){
		String str=  "Periodical Title: " + pTitle + "\nVolume: " + volume +
				"\nIssue: " + issue + "\nSubject:" + subject + "\nCall Number: "
				+ callNumber;
		if(checkedOut == false)
			return str + "\nChecked Out: NO";
		
		if(checkedOut == true)
			return str + "\nChecked Out: YES";
		return str;
		 
	}	
}
