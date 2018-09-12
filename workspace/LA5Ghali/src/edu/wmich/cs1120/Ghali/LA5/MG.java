package edu.wmich.cs1120.Ghali.LA5;

public class MG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ISms sms = new Sms();
		IPigLatin pigLatin = new PigLatin();
		IController control = new Controller(sms, pigLatin);
		
		control.runProgram();

		
	}

}
