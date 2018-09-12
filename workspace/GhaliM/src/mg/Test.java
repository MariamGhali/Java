package mg;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		String philatelistName;
		Philatelist  phatelist = new Philatelist();
	
		phatelist.setName("John");
		IStamp sp = new GroupII("Shot", 0.75,1996 );
	
		System.out.println(sp.getName()+sp.getFaceValue()+sp.getYear()+"II");

}
}