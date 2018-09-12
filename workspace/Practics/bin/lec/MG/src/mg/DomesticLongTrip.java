package mg;

public class DomesticLongTrip implements ITrip {


	private int dis ;
	private int day;
	
	public DomesticLongTrip( ){
		
	}
	public DomesticLongTrip(int distance, int days ){
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
		int totalCost = (4 * getDistance()) + (150 * getDuration());
		return totalCost;
	}

}

