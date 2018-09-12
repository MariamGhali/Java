package edu.wmich.cs1120.spring16.quiz.mwb5468.Quiz;

import java.util.*;

import edu.wmich.cs1120.spring16.quiz.mwb5468.Questions.IQuestion;

public class QuizUI implements IQuizUI {
	
	/** 
	*	Creates a quiz out of a set of questions 
	*	@param questions a list of questions 
	*	@return the quiz object 
	 	 */ 
	
	public IQuiz createQuiz(List<IQuestion> questions){
		return new Quiz(questions);
	}
	 	 
	 	/** 
	*	takeQuiz will go through all of the questions, 
	*	handle user input, and check the answers 
	*	@param  the quiz to be taken 
	 	 */ 
	 public void takeQuiz(IQuiz quiz){
		Scanner keyboard = new Scanner(System.in);	
		int count = 0;
		
		for (int i =0; i<quiz.getNumberOfQuestions();i++){
			System.out.print("Question " + (i+1) + ": ");
			System.out.println(quiz.getCurrentQuestion().getQuestion());
			System.out.print("Enter your answer :");
			String answer = keyboard.nextLine();
		if(quiz.checkAnswer(answer)==true){
			count++;
			System.out.println("Your answer was correct!");
		}
		else{
			System.out.println("Your answer was incorrect.");
		}
	}
		System.out.println("Out of 3 question you answered "+count+ " correctly.");
 } 

}
