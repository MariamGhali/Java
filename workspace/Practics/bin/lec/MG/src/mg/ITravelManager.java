package mg;

import java.util.ArrayList;

public interface ITravelManager {

	//Getter for the list of trips
		ArrayList<ITrip> getTripRequests();
		//Setter for the list of trips
		void setTripRequests(ArrayList<ITrip> tripRequests);
		//Returns the total cost of all the trips in the list.
		int calculateTotalCost();

}
