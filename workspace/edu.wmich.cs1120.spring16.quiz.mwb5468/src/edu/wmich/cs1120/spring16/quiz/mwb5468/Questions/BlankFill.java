package edu.wmich.cs1120.spring16.quiz.mwb5468.Questions;

public class BlankFill extends Question{

	protected String ans;
	public BlankFill(String questionText, String answer){
		super(questionText);
		ans = answer;
		
	}
	/**
	* @return returns the question text plus any other extra prompts or details.
	*/
	public String getQuestion(){
		
		return question +"\nFill in the blank.";
		
	}
	/**
	*
	* @return the answer as a string
	*/
	public String getAnswer(){
		
		return ans;
	}
	/**
	*
	* @param answer the answer entered by the user
	* @return true if the answer is correct, false otherwise.
	*/
	public boolean checkAnswer(String answer){
		
		if (answer.equalsIgnoreCase(ans)){
			return true ;
		}
		else 
			return false ; 
	}

}
