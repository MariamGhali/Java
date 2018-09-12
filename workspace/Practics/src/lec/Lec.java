package lec;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JOptionPane;

public class Lec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		boolean endOfFile = false;
		try
		{
		FileInputStream fstream = new FileInputStream("input.bin");
		DataInputStream inputFile = new DataInputStream(fstream);
			while(!endOfFile)
			{
				try
				{
					String n = inputFile.readUTF();
					
					System.out.println(n ); 
				}
				catch(EOFException e)
				{
					endOfFile = true;
					
				}
			}
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}