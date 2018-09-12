package lec;

public class PassFailExam extends PassFailActivity {

	
	private int numQuestions;
	private double pointsEach;
	private int numMissed;
	
	public PassFailExam (int questions, int missed, double minPassing){
		super(minPassing);
		double numScore;
		
		numQuestions = questions;
		numMissed = missed;
		pointsEach = 100/questions;
		numScore  = 100- missed*pointsEach;
		setScore(numScore);
	}
	public double getPointsEach(){
	
		return pointsEach;
		
	}
	public int getNumMissed(){
		return numMissed;
	}
}


