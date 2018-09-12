package mg;

import java.util.ArrayList;
import java.util.List;

public class Philatelist implements IPilatelist {

	protected String phialelistName;
	private List<IStamp> array = new ArrayList <IStamp> ();
	
	
	/**
	 * to set the name of the phialelist 
	 * @param n the name 
	 */
	public void setName (String n){
	
		phialelistName = n;
	}
	/**
	 * to return the name of the phialelist 
	 * @return name of the stamp
	 */
	public String getName(){
		return phialelistName;
	}
	
	/**
	 * to calculate the total commmerical 
	 * @return the total number 
	 */
	public double calculateTotalCommericalValue () {
		double calculation=0;
		for(int i = 0 ;i<7; i++ ){
			calculation += array.get(i).calculateCommercialValue();
		}
		return calculation ;
	}
	
	/**
	 * the array  list 
	 * @return the array list 
	 */
	public List <IStamp> getStamp(){
		return array;
	}
	
	/**
	 *  to add more stamps 
	 * @param stamp stamp
	 */
	public void addStamp (IStamp stamp){
		array.add(stamp);
	}
}
