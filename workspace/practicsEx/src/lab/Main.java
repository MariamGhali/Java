package lab;
import java.io.File;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) throws IOException {
                // TODO Auto-generated method stub

                File file = new File("input.txt");
                Scanner inputFile = new Scanner (file);
                int  num;
                ArrayList <Integer> array = new ArrayList<>();
                //int [] n = new int [4]; 
                String input = inputFile.nextLine();
                String[] numbers = input.split(","); 
                for (int i =0;i<numbers.length;i++){
                num= Integer.parseInt(numbers[i]);
                        if (num%2!=0 && num%3!=0 && num%4!=0){
                                array.add(num);
                                //for(int k = 0;k<n.length;k++){
                                        //n[k]=num;
                        //        }                
                        }        
                }
                bubblesrt(array);
                for(int i=0;i<array.size();i++){
                        System.out.println(array.get(i));
                }
                        inputFile.close();
                        
        }
       public static void bubblesrt(ArrayList<Integer> list){
        	int temp;
            if (list.size()>1) // check if the number of orders is larger than 1
            {
                for (int x=0; x<list.size(); x++) // bubble sort outer loop
                {
                	for (int i=0; i < list.size() - x - 1; i++){
                        if (list.get(i).compareTo(list.get(i+1)) >0)
                        {
                            temp = list.get(i);
                            list.set(i,list.get(i+1) );
                            list.set(i+1, temp);
                        }
                    }
                }
            }
        }
    }