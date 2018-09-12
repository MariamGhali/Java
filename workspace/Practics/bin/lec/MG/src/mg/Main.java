package mg;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			ITrip trip1 = new DomesticShortTrip(500,4);
			ITrip trip2 = new DomesticShortTrip(300,7);
			ITrip trip3 = new DomesticShortTrip(); 
			trip3.setDistance(300);
			trip3.setDuration(5);
			ITrip trip4 = new DomesticLongTrip(2000,6);
			ITrip trip5 = new DomesticLongTrip(1500,7);
			ITrip trip6 = new DomesticLongTrip(); 
			trip6.setDistance(1800);
			trip6.setDuration(5);
			ITrip trip7 = new InternationalTrip(5000,8);
			ITrip trip8 = new InternationalTrip(8000,4);
			ITrip trip9 = new InternationalTrip(7000,9);
			ArrayList<ITrip> tripRequests = new ArrayList<ITrip>();
			tripRequests.add(trip1);
			tripRequests.add(trip2);
			tripRequests.add(trip3);
			tripRequests.add(trip4);
			tripRequests.add(trip5);
			tripRequests.add(trip6);
			tripRequests.add(trip7);
			tripRequests.add(trip8);
			tripRequests.add(trip9);
			ITravelManager tripManager = new TravelManager();
			tripManager.setTripRequests(tripRequests);
			System.out.println("This year's total travel cost is $"+tripManager.calculateTotalCost());	

		}
	
} 


