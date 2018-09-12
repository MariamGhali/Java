package test;

import java.io.RandomAccessFile;
import java.util.Random;

public class test1 {

	   public static void main(String[] args) {
	      try {
	         RandomAccessFile raf = new RandomAccessFile(args[0], "rw");//Open our file with read/write access
	         Random rdn = new Random();//Get a new random generator
	         int min = 0; int max = 999;//Our file will have a maximum size of 999 bytes
	         int amin = 0; int amax = 25;//The alphabet has 26 letters thus we want to generate a random offset
	         //to "pick" those letters
	         int length = rdn.nextInt(max - min + 1) + min;//Get the length of our file
	         raf.setLength((long)length);//Set the length or size of the file, note that the we do not have to
	         //set length of the file as the write method will "grow" the file with each sequential write
	         for(int i=0; i < length; i++){//Run until our file is full
	            int chr = rdn.nextInt(amax - amin + 1) + amin;//Randomly get our offset
	            chr += 65;//ASCII capital letters range from 65-90, so add 65 to whatever we got
	            raf.write(chr);//Write the int to the file
	            System.out.printf("Writing %c at %d\n", chr, raf.getFilePointer());//Ouput our char and where
	            //we wrote it.
	         }
	         raf.close();//Close our filestream.
	      } catch (Exception e) {       
	         e.printStackTrace();
	      } 
	   }

}


//linear search 
for (k=0; k < name.length ; k++){
	
}
	for(i =0;i < dim_1; i++) {
		for(j = 0; j <dim_2; j++) {
			//System.out.print(array[i][j] + " ");
			if ((array[i][j])==name[k] ){
		    	//System.out.printf(name[k] +": "+ "%d" + "\n",array[i][j]);
		    	//System.out.println("i=" + i + " j=" + j);
		    	System.out.printf(name[k] +": "+ "[ " + i +","+ j+ " ]");
		    	continue;
	    }
	} 
		
		
		int length ,row, column, first, last,mid,midX,midY,i = 0;
		first=0;
		char[] name = myName.toCharArray();
		length = name.length;
	 
		row= sortedArray.length;
	    column= sortedArray[0].length;
	    last =  (row)*(column)-1;
	    
	    
	    while(first<=last){
	    	mid=(first+last)/2;
	        midX=mid/column;
	        midY=mid%column;
	        for(i=0; i<length;i++){
	        	if(sortedArray[midX][midY]==name[i]){ 
	        		System.out.print(name[i] +": "+ "[ " + midX +","+ midY+ " ]");
  	        	}else if(sortedArray[midX][midY]<name[i]){
	                first=mid+1;
	        		System.out.print(name[i] +": "+ "[ " + "-1" +","+ "-1"+ " ]");

	            }else{
	                last=mid-1;
	            }
	        }
	    }

}
