package lec;

public class FinalExam extends GradedActivity {

	private int numQuestions;
	private double pointsEach;
	private int numMissed;
	
	public FinalExam (int questions, int missed){
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
