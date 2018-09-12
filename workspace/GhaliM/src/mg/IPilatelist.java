package mg;

import java.util.List;

public interface IPilatelist {
	
	/**
	 * to set the name of the stamp 
	 * @param n the name 
	 */
	public void setName (String n);
	/**
	 * to return the name 
	 * @return name of the stamp
	 */
	public String getName();
	
	/**
	 * to calculate the total commmerical 
	 * @return the total number 
	 */
	public double calculateTotalCommericalValue () ;
	
	/**
	 * the array  list 
	 * @return the array list 
	 */
	public List <IStamp> getStamp();
	
	/**
	 *  to add more stamps 
	 * @param stamp stamp
	 */
	public void addStamp (IStamp stamp);

}
