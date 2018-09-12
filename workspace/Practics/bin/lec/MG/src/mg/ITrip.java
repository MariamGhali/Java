package mg;

public interface ITrip {

	//Getter for distance
		int getDistance();
		//Setter for distance
		void setDistance(int distance);
		//Getter for duration
		int getDuration();
		//Setter for duration	
		void setDuration(int days);
		//Calculates the cost for this particular trip
		int calculateCost();

}
