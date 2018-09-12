package mg;

public class InternationalTrip implements ITrip {
	private int dis ;
	private int day;
	
	public InternationalTrip(int distance, int days ){
		dis = distance;
		day = days ;
	}

	@Override
	public void setDistance(int distance) {
	
		dis = distance;
	}
	@Override
	public int getDistance() {
			
			return dis;
		}
	@Override
	public void setDuration(int days) {
		day= days;

	}
	@Override
	public int getDuration() {
		
		return day;
	}
	@Override
	public int calculateCost() {
		
		int totalCost = (5 * getDistance()) + (300 * getDuration());
		return totalCost;
	}

}
