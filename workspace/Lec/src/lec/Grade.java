package lec;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Grade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input ;
		int questions;
		int missed;
		double minPass;
		Scanner keyboard = new Scanner (System.in);
		System.out.println("How many questions in the exams");
		questions = keyboard.nextInt();

		System.out.println("How many questions did you missed in the exams");
		missed = keyboard.nextInt();
		System.out.println("what is the min score?");
		minPass = keyboard.nextDouble();
		PassFailExam exam = new PassFailExam(questions,missed,minPass);
		System.out.println("Each questions cout " + exam.getPointsEach() + 
				"points"  +  "the exam sirce is "+exam.getScore()+ "exam grade is "
				+ exam.getGrade());
	}

}
