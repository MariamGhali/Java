package lec;

public class GradedActivity {

	private double score;
	
	public void setScore(double s){
		score = s;
	}
	
	public double getScore(){
		return score;
	}
	public char getGrade(){
		char letter;
		if (score >= 90)
			letter= 'A';
		else if (score >=80 )
			letter= 'B';
		else if (score >= 70)
			letter = 'C';
		else if (score >=60)
			letter = 'D';
		else   
			letter = 'F';
		return letter;
	}
}
