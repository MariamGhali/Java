package lec;

public class PassFailActivity extends GradedActivity {

	private double minPassScore;
	
	public  PassFailActivity(double min){
		minPassScore = min;
		
	}
	
@Override

	public char getGrade(){
	char letter;
	if (super.getScore() >= minPassScore)
		letter = 'P'; 
	else
		letter = 'F';
	return letter;
}
}

