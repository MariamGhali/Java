package hw3;
/**
 * this class will sort the LL
 * @author mariam
 *
 */
public class linklistSorting {
	private static node k;
	private static node l;
	
	/**
	 * it will take the number of the input and the linked list as a paramter
	 * and compare the values of the linked list with bubble sort 
	 * @param n the number of the input
	 * @param linkedList the LL
	 */
	public void bubbleSort(int n, charLinkedList linkedList) {
		int sizeOfLinkedList = n;
		int i = 0;
		int j = 0;	
		
		char temp1;
			
		if (sizeOfLinkedList > 1) {
			for (i = 0; i < sizeOfLinkedList - 1; i++) {
				k = linkedList.head; // current node
				l = linkedList.head.next;
				for (j = 0; j < sizeOfLinkedList - 1 ; j++) {
					//if (k.value > l.value) {
					if(main.sort(k.value, l.value)){
						temp1 = k.value;
						k.value = l.value;
						l.value = temp1	;
					}
					if(l.next !=null){
						k = k.next;
						l = l.next;	
					}else {
						break;
					}
				}
			}
		}
	}
	/**
	 * it will take the number of the input and the linked list as a paramter
	 * and compare the values of the linked list with selection sort 
	 * @param n the number of the input 
	 * @param linkedList LL
	 */
	public static void selectionSort(int n, charLinkedList linkedList){
		char temp1;
		int sizeOfLinkedList = n; 
	    int i  = 0 ;
	    int j = 1;
	   
        for (i = 0; i < sizeOfLinkedList-1; i++){ //outer loop
        	int min_index = i; //the first unsorted index
        	k = linkedList.head; // current node
			l = linkedList.head.next;
            for (j = i+1; j < sizeOfLinkedList; j++){
                //if (k.value > l.value){
            	if(main.sort(k.value, l.value)){
                    min_index = j;    
            // Swap the found minimum element with the first
            // element
	            }
	            if (min_index != i){
	            	temp1 = k.value;
					k.value = l.value;
					l.value = temp1	;
	            }
	            if(l.next !=null){
					k = k.next;
					l = l.next;	
				}else {
				
					break;
				}
            }
		} 
   }
	/*public static void insertionSort(int n, charLinkedList linkedList) {
		int sizeOfLinkedList = n;
		int i = 0;
		int j = 0;	
		char temp1;
		int position = 0;
			
		
        for (i = 0; i < sizeOfLinkedList-1 ; i++) {
        	k = linkedList.head; // current node
    		l = linkedList.head.next;
             if(k.value > l.value)
        	//if (sort(charArray[i], charArray[i+1])) {
                    //temp = charArray[j];
                    //charArray[j] = charArray[j-1];
                    //charArray[j-1] = temp;
                position = binarySearch(linkedList, l.value, 0 , i);
              
                temp1 = l.value;
                //Shift
                for (j=i+1; j>position; j--){
                	 = charArray[j-1];
                }
                charArray[position] = temp;	
                	//charArray[j] = charArray[position];
                	//charArray[j-1] = temp;
            }
        }
	}
	
	public static int binarySearch(charLinkedList linkedList,char item, int low, int high)
	{
	    if (high <= low)
	        return  ((item > linkedList[low])? (low + 1): low);
	 
	    int mid = (low + high)/2;
	 
	    if(item == linkedList[mid])
	        return  (mid+1);
	 
	    //if(item > a[mid])
	    if (item> linkedList[mid])	 	
	    	return binarySearch(linkedList, item, mid+1, high);
	    return binarySearch(linkedList, item, low, mid-1);
	}
*/
	/**
	 * to return the data that returned from the bubble and insertion sort 
	 * @param linkedList take the LL 
	 */
	public void printData(charLinkedList linkedList) {
        node currentNode = linkedList.head;
        while(currentNode.next != null) {
            char data = currentNode.value;
            System.out.print(data + " ");
            currentNode = currentNode.next;
        }
        System.out.println("\n ");
    }
}
