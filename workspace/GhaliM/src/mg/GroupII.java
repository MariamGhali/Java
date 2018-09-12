package mg;

public class GroupII implements IStamp{

	protected double face;
	protected String name ;
	protected int year ;
	
	
	public GroupII (String n ,double f , int y ){
		
		face = f;
		name = n;
		year = y;
		
		
	}
	
	/**
	 * to set the face value 
	 * @param f get the face vlaue 
	 */
	public void setFaceValue(double f){
		face = f ;
	}
	/**
	 * to get the face value 
	 * @return the face value 
	 */
	public double getFaceValue(){
		
		return face ;
	}
	
	/**
	 * to set the name of the stamp 
	 * @param n the name 
	 */
	public void setName (String n){
		name = n;
	}
	/**
	 * to return the name 
	 * @return name of the stamp
	 */
	public String getName(){
		return name ;
	}
	
	/**
	 * to set the year 
	 * @param y the year 
	 */
	public void setYear(int y){
		year = y ; 
	}
	/**
	 * to get the year
	 * @return the year 
	 */
	public int getYear(){
		return year; 
	}
	
	
	/**
	 * to calculate the commerical value 
	 * @return the commerical value
	 */
	
	public double calculateCommercialValue (){
		
		return face *2 ;
	}
}
