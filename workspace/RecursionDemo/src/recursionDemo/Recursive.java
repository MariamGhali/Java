package recursionDemo;

import java.util.Scanner;
import java.util.Stack;

import javax.swing.JOptionPane;

public class Recursive {
	public static int test2(int x, int y)
	{
	  if ( x < y)
	  {
	    return -5;
	  }
	  else
	  {
	    return (test2(x - y, y + 5) + 6);
	    
	}
}
}