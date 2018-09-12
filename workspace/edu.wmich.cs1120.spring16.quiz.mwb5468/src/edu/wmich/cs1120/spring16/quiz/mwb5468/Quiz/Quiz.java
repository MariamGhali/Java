package edu.wmich.cs1120.spring16.quiz.mwb5468.Quiz;

import java.util.*;

import edu.wmich.cs1120.spring16.quiz.mwb5468.Questions.IQuestion;

public class Quiz implements IQuiz {

	private List<IQuestion> questions = new ArrayList<IQuestion>();
	private int  count  = 0 ; 
	private boolean isStarted;
	private boolean iscompleted;
	public Quiz(List<IQuestion> question){
		for (int i=0; i<question.size();i++){
			questions.add(i, question.get(i));
		}
	}
	/** 
	@return number of questions in the quiz 
 	 */ 
	@Override
	public int getNumberOfQuestions() {
		
		
		return questions.size();		
	}

	/** 
	@return True if a quiz has been started. False otherwise 
 	 */
	@Override
	public boolean isStarted() {
		
		return false;
	}

	/** 
	@return True if the last question has been answer, false otherwise. 
 	 */ 
	@Override
	public boolean isCompleted() {
	
		return false;
	}

	/** 
	@return true if there is a question after the current one, false otherwise. 
 	 */ 
	@Override
	public boolean hasNextQuestion() {
		if(count<questions.size()){
			return true;
		}
		return false;
	}

	/** 
	@return the answer to the current question 
 	 */
	@Override
	public String getCurrentAnswer() {
		
		return questions.get(count-1).getAnswer();
	}

	/** 
	checks if the user input matches the question's answer. 
	@param answer the user input as a string 
	@return true if the answer matches, false otherwise. 
 	 */
	@Override
	public boolean checkAnswer(String answer) {
		
		return questions.get(count-1).checkAnswer(answer);
	}	

	/** 
	Resets the number of incorrect answers and the current question to 0, 
	isStarted and isCompleted to false; 
 	 */ 
	@Override
	public void reset() {
		count=0;
		isStarted = false;
		iscompleted = false;	
	}

	/** 
	@return the number of the current question 
 	 */
	@Override
	public int getQuestionNumber() {
		return count+1;
		
	}

	/** 
	@param questions list of questions in the quiz 
 	 */ 
	@Override
	public void setQuestions(List<IQuestion> question) {
		for (int i=0; i<question.size();i++){
			questions.add(i, question.get(i));
		}
	}

	/** 
	@return List of questions in the quiz 
 	 */ 
	@Override
	public List<IQuestion> getQuestions() {
		
		return questions;
	}

	/** 
	Sets isCompleted to false if there are no more questions after returning;  	 
	* @return the next question that should be answered. 
 	 */ 
	@Override
	public IQuestion getNextQuestion() {
	
		if(hasNextQuestion()== true)		
			return  questions.get(count);
		return null;
	}

	/** 
	sets the isStarted variable to true if it is false and returns the current question  	
	 * @return the current question waiting for an answer. 
 	 */ 
	@Override
	public IQuestion getCurrentQuestion() {
		count++;
		return questions.get(count-1);
	}
}
