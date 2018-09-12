package edu.wmich.cs1120.spring16.quiz.mwb5468.Questions;

public abstract class Question implements IQuestion {

	 protected String question;
	 
	 public Question (String ques){
		 question = ques;
	 }
	
	 /**
	* @return returns the question text plus any other extra prompts or details.
	*/
	 @Override

	 public abstract String getQuestion();
	
	 /**
	*
	* @return the answer as a string
	*/
	 @Override
	
	 public abstract String getAnswer();
	
	 /**
	*
	* @param answer the answer entered by the user
	* @return true if the answer is correct, false otherwise.
	*/

	 @Override
	 public abstract boolean checkAnswer(String answer);
	 
	 /**
	 *
	 * @return the wording of the question as a string
	 */
	 final String getText(){

		 return question;
	 }


}
