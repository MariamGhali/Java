import java.util.Arrays;
import java.util.Random;	//to generate a random numbers with this library 

public class Main {

	//public static int dim = 3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j,length,m = 0;
		int k = 0; 
		int dim= 5;   
		//char array [] [] = new char [dim][dim];
		objectArray array[][] = new objectArray [dim][dim];
		objectArray sorted [][]= new objectArray[dim][dim];
		int [] position = new int [2];
		Random rand = new Random();
		char[] name = {'m','a','r','i','a','m'};
		Boolean repeat = false;
		m=2;
		if (m>0){
			System.out.println("Random Matrix:" +"\n" + "\n");
			for(i =0;i < dim; i++) {
			    for(j = 0; j <dim; j++) {
			    	array[i][j] = new objectArray((char)(rand.nextInt(26)+97)); 
					//array[i][j] = ranIndex;
					System.out.print(array[i][j].myChar + " ");
			    }       	    
			    System.out.println();
			}
				
			System.out.println("\n");
			long start = System.nanoTime();
			for(i=0;i<name.length;i++){	
				position = linearSearch(array,dim,name[i]);		//search through 2-dim linearly	
			}
		 	long end   = System.nanoTime();
			long total = end - start;
			double second = (double)total/ (1000000000.0);
			System.out.println("Search Time:  "+ second+ " seconds"+"\n");
			
			
			//sorting 
			sorted = sortedArray(array,dim);	//return 2-dim-sorted array 
			System.out.println("Sorted  Matrix :"+"\n");
			for(i=0;i<dim;i++){			//print it as 2 dim sorted array
				for(j=0; j<dim;j++ ){
					System.out.print(sorted[i][j].myChar + " ");	//not returing as a Matrix?!!!
				}
				System.out.println();
			}
			System.out.println("\n");
			/*get the first letter then go to the binary 
			 * search method to find if it is in the matrix or 
			 * not if it is in the matrix return the index of it  
			 * if not return -1
			*/
			
			long startTime = System.nanoTime();
			for(i=0;i<name.length;i++){	
				 binarySearch(sorted,dim,name[i]);
			}
			long endTime   = System.nanoTime();
			long totalTime = endTime- startTime;
			double seconds = (double)totalTime / (1000000000.0);
			System.out.println("Search Time:  "+ seconds + " seconds");
	
			for(i=0 ; i<name.length; i++){
				name[(rand.nextInt(name.length))] = ((char)(rand.nextInt(26)+97));
				System.out.print(name[i] + "");
				}
			}
		
	}	
	/*linear search to get the matrix and return the position of the name 
	convert the String to a char array and compare 2-dim array"Matrix" with one dim
	array which is the "name" 
	*/
	public static int [] linearSearch (objectArray[][] array, int dim,char name){
		int i,j=0;
		
		for(i =0;i < dim; i++) {	//rows
			for(j = 0; j <dim; j++) {	//columns 
				//System.out.print(array[i][j] + " ");
				if ((array[i][j].myChar)==name){
					if (array[i][j].myBool)
						continue;
					System.out.printf(name +": "+ "[ " + i +","+ j+ " ]");
					System.out.println();
					array[i][j].myBool = true;
					return new int[]{i,j};
				}
			}
		}
		System.out.println(name +": "+ "[ " + "-1" +","+ "-1" + " ]"); 
		return new int[] {-1,-1};

	}		
	/*
	 * convert the 2-dim array to one dim then sorted and converted it back 
	 * to 2-dim sorted array 
	 */
	public static objectArray[][] sortedArray (objectArray[][] array,int dim){
		int i,j,temp =0;
		char[] oneDArray = new char[dim*dim];
		  for( i = 0; i < dim; i ++){
			  for(j = 0; j < dim; j ++)
		    {
		      oneDArray[(i * dim) + j] = array[i][j].myChar;	//??
		      }
		  }
		  Arrays.sort(oneDArray);	//sort it as one dim array
		  objectArray[][] sorted_2dim_array = new objectArray[dim][dim];
		  for(i= 0; i < dim; i++)
		  {  
		     for(j = 0; j < dim; j++)
		     {
		    	 sorted_2dim_array[i][j] = new objectArray(oneDArray[i * dim + j]); //??
		     }
		  }
		return sorted_2dim_array;	
 }
	public static void binarySearch (objectArray[][] sorted,int dim,char letter){
		int length, first, last,mid,midX,midY,i= 0;
		first=0;
		last = (dim * dim)-1;  
		length = last;
	    while(first<=last){
	    	mid=(first+last)/2;
	        midX=(mid-1)/dim;	//position
	        midY=(mid-1)%dim;
	        
	        if (mid == 0){		//array has only one element and it is one the first position
	        	if (sorted[0][0].myChar==letter){ 
	        		System.out.println(letter +": "+ "[ " + midX +","+ midY+ " ]");
	        		return;
	        	}
	        	else{
	        		System.out.println(letter +": "+ "[ " + "-1" +","+ "-1" + " ]"); 
	        		return;	        	
	        	}
	        }
	        
	        if (first == last){	//last element in the array
	        	if (sorted[midX][midY].myChar==letter){ 
	        		System.out.println(letter +": "+ "[ " + midX +","+ midY+ " ]");
	        		return;
	        	}else{
	        		System.out.println(letter +": "+ "[ " + "-1" +","+ "-1" + " ]"); 
	        		return;
	        	}
	        }             	
	        if (sorted[midX][midY].myChar==letter){ 
				if (!sorted[midX][midY].myBool){	//if we already got through this letter before 
					System.out.println(letter +": "+ "[ " + midX +","+ midY+ " ]");
					sorted[midX][midY].myBool = true;
					return;
					
        		}else if(sorted[midX][midY].myBool){
					 mid = mid-1;		//stepback
					 midX=(mid-1)/dim;	//position
				     midY=(mid-1)%dim;
					if (mid !=0 && (sorted[midX][midY].myChar==letter)){ 
						System.out.println(letter +": "+ "[ " + midX +","+ midY+ " ]");
						sorted[midX][midY].myBool = true;
						return;
					}
					mid = mid+1;	//step Forward
					midX=(mid-1)/dim;	//position
					midY=(mid-1)%dim;
					if (mid < length && sorted[midX][midY].myChar==letter){ 
					 	System.out.println(letter +": "+ "[ " + midX +","+ midY+ " ]");
					 	sorted[midX][midY].myBool = true;
					 	return;				
					 	}
					}
					System.out.println(letter +": "+ "[ " + "-1" +","+ "-1" + " ]"); 
					return;
          	}else if (sorted[midX][midY].myChar<letter){
	                first=mid+1;	//go to the right side 
	        }else{
	                last=mid-1;		//go to the left side 
	        }
	   	}
	}
}