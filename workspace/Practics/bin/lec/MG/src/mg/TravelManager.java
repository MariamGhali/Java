package mg;

import java.util.ArrayList;

public class TravelManager implements ITravelManager {

	private ArrayList <ITrip> array = new ArrayList<ITrip>();
		
	
	@Override	
	public void setTripRequests(ArrayList<ITrip> tripRequests){
		array = tripRequests;
	}
	@Override
	public ArrayList<ITrip> getTripRequests(){
		
		return array;
	}
		
	@Override
	public int calculateTotalCost(){
		int totalCost=0;
		for(int i = 0 ; i<9;i++){
			totalCost+= array.get(i).calculateCost();
		}
		return totalCost;
	}

}
