package mg;

public interface IStamp {

	/**
	 * to get the face value 
	 * @return the face value 
	 */
	public double getFaceValue();
	
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
	 * to set the year 
	 * @param y the year 
	 */
	public void setYear(int y);
	/**
	 * to get the year
	 * @return the year 
	 */
	public int getYear();
	

	/**
	 * to set the face value 
	 * @param f get the face vlaue 
	 */
	public void setFaceValue(double f);
	
	/**
	 * to calculate the commerical value 
	 * @return the commerical value
	 */
	
	public double calculateCommercialValue (); 
}
