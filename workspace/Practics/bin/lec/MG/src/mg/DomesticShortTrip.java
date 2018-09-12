package mg;

public class DomesticShortTrip implements ITrip {

	private int dis ;
	private int day;
	
	public DomesticShortTrip( ){
		
	}

	public DomesticShortTrip(int distance, int days ){
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
		int totalCost = (3 * getDistance()) + (150 * getDuration());
		return totalCost;
	}

}
