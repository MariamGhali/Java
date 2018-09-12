package edu.wmich.cs1120.MG.LA3;

import java.util.Calendar; 
import java.util.GregorianCalendar; 

public class LibraryItem implements ILibrary {

	protected boolean checkedOut = false;
	protected String callNumber;
	protected GregorianCalendar dateCheckedOut= new GregorianCalendar();
	protected GregorianCalendar dueDate = new GregorianCalendar();
	protected String thisItem;
	
	
	public LibraryItem (String item, String callNum){
		callNumber = callNum;
		thisItem = item;
	}

	/**
	 * Sets the boolean value checkedOut to true, and 
	 * initializes the dateChecked out attribute (a 
	 * GregorianCalendar object).
	 */
	public void checkOut(){
		this.checkedOut = true;
	}
	/**
	 * Generates a string with the details of the library item 
	 * whose call number has been input by the user (see example output)
	 * and returns that string.
	 * If the user wants to check out the library item, the string to be 
	 * returned also includes information that the item has been checked out, 
	 * the date it was checked out, and the due date for the item. 
	 * @return every thing in the libraryItem
	 */
    public String toString(){
    	String str ;
    	str = "Call Number:" + callNumber;
    	return str;
    	
    
    }
    /**
     * Returns the call number of this object.
     * @return the callNumber
     */
    public String getCallNumber(){
    	return callNumber;
    }
    /**
     * Returns true or false depending on if this item has been checked out.
     * @return the boolean value for isCheckedOut
     */
    public boolean isCheckedOut(){
    	return checkedOut;
    }
    /**
     * Returns the date this item was checked out.
     * @return the dateCheckedOut
     */
   public GregorianCalendar getDateCheckedOut(){
	 
	   return dateCheckedOut;
   }
   /**
    * Returns the date this item is due to be returned.
    * @return the dateDue
    */
   public GregorianCalendar getDateDue(){
	   return dueDate;
   }
   /**
    * Sets the dateDue to the parameter received.
    * @param GregorianCalendar the dateDue to set
    */
   public void setDateDue(GregorianCalendar due){
	   
	   dateCheckedOut = new GregorianCalendar();
	   
	   if(thisItem.equals("B")){
	   dueDate = (GregorianCalendar)due.clone(); 
	   dueDate.add(Calendar.DAY_OF_MONTH, 21); 
	   System.out.print(String.format("Date Out: %tD\n", dateCheckedOut)); 
	   System.out.print(String.format("Date Due: %tD\n", dueDate));

	   }
	   else if(thisItem.equals("P")){
		   dueDate = (GregorianCalendar)dateCheckedOut.clone(); 
   			dueDate.add(Calendar.DAY_OF_MONTH, 7); 
   			System.out.print(String.format("Date Out: %tD\n", dateCheckedOut)); 
   			System.out.print(String.format("Date Due: %tD\n", dueDate));
	   }
   }
}
    
    
