package lec;

public class Sky extends Ground{

	public Sky() {
		
		
	System.out.println("You are in the Sky");	
	}
	public Sky(String skyColor){
		super("green");
		System.out.println("the sky is "+ skyColor);
	}

}
