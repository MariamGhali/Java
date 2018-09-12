package edu.wmich.cs1120.MG.LA2;

import java.util.Scanner;

public class MG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner (System.in);
		TreeDataStructure root = new TreeDataStructure("A");
			root.addChild("B", "A");
			root.addChild("C", "A");
			root.addChild("D", "B");
			root.addChild("E", "B");
			root.addChild("F", "C");
			root.addChild("G", "C");
			root.addChild("H", "D");
			root.addChild("I", "D");
			root.addChild("J", "E");
			root.addChild("K", "E");
			root.addChild("L", "F");
			//root.printTree();


			while(true){
				printMenu();
				System.out.print("->");
				int n = getChoice(keyboard);
				keyboard.nextLine();
				if (n==0)
					break;
				else if (n==1){
					System.out.print("Please input the Node you want to add-> ");
					String node = keyboard.nextLine().toUpperCase();
					System.out.print("Please input the parent node of "+ node + "-> ");	
					String parentNode = keyboard.nextLine().toUpperCase();
					root.addChild(node, parentNode);
					System.out.println("Node successfully Added");
					root.printTree();
				}
				
				else if (n==2){
					System.out.print("Please input the root node ->");
					String rootNode= keyboard.nextLine();
					int size = root.size();
					System.out.println("There are " + size +  " nodes in that tree");
				}
						
				else if (n==3){
					System.out.print("Please input the node you want to look for ->");
					String node = keyboard.nextLine();
					 root.find(node);
										
				}
			}
			
		}

		
		/**
		 * print menu showing available options (1,2,3,0)to screen
		 */
		public static void printMenu(){
		
			System.out.println("l.Add Node\n2.Tree Size\n3.Find Node\n0.Exit");
		}
		
		
		/**
		 * Read in the user's desired option / choice
		 * @param keyboard Scanner
		 * @return the number of the choice
		 */
		public static int getChoice(Scanner keyboard){
		
		     return	keyboard.nextInt();
		}
		
	}


