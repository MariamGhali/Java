package edu.wmich.cs1120.spring16.quiz.mwb5468.Questions;

public class TrueFalse extends Question {

	protected boolean bAnswer;
	 public TrueFalse(String questionText, boolean answer) {
		 
		 super(questionText);
		 bAnswer = answer ; 
	 }
	 
	/**
	* @return returns the question text plus any other extra prompts or details.
	*/
	
	public String getQuestion(){
		
		return question + "\nEnter true or false." ;
		
	}
	
	/**
	*
	* @return the answer as a string
	*/

	public String getAnswer(){
		return   Boolean.toString(bAnswer);
	}
	
	/**
	*
	* @param answer the answer entered by the user
	* @return true if the answer is correct, false otherwise.
	*/
	
	public boolean checkAnswer(String answer){

		String str = answer.toLowerCase();
		if(answer.equals("t"))
			str = "true";
		if(answer.equals("f"))
			str = "false";
		if (getAnswer().equals(str)){
			return true ;
		}
		else 
			return false ; 
		}
}


