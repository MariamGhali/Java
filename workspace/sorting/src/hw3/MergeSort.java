package hw3;
/**
 * it will take the unsorted array divide it into subarray usorted it and merge it to the main array again
 * @author mariam
 *
 */
public class MergeSort {
	/**
	 * Merges two subarrays of arr[].
	 *  First subarray is arr[l..m]
	 *  Second subarray is arr[m+1..r]
	 *  will take the subarray and sort both array then merge it back to the main array 
	 * @param arr
	 * @param left
	 * @param middle
	 * @param right
	 */
    void merge(char arr[], int left, int middle, int right)
    {
        // Find sizes of two subarrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;
        int i,j = 0;
        /* Create temp arrays */
        char leftArray[] = new char [n1];
        char rightArray[] = new char [n2];
 
        /*Copy data to temp arrays*/   //??
        for (i=0; i<n1; ++i)
            leftArray[i] = arr[left + i];
        for (j=0; j<n2; ++j)
            rightArray[j] = arr[middle + 1+ j];
 
 
        /* Merge the temp arrays */
 
  
 
        // Initial index of merged subarry array
        int k = left;
        i=0; j=0;
        while (i < n1 && j < n2)
        {
        	if (main.sort(rightArray[j], leftArray[i])) //if the first element of the right subarray is greater than the the first element of the left subarray
            {
                arr[k] = leftArray[i];	//copy the value of the left subarray to a temp array
                i++;
            }
            else
            {
                arr[k] = rightArray[j]; //copy the value of the right subarray to a temp array
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */  //????
        while (i < n1)
        {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
 /**
  * it will find the middle of the array of the linked list then spilt it into 
  * right and left subarray and keep spilting until both left and right subarrays will have
  * only one element then call merge sort 
  * @param arr
  * @param left
  * @param right
  * @return the array after the meger of the left and right subarray
  */
    // Main function that sorts arr[l..r] using
    // merge()
    char[] sort(char arr[], int left, int right)
    {
    	int middle = 0;
        if (left < right)
        {
            // Find the middle point
            middle = (left+right)/2;
 
            // Sort first and second halves
            sort(arr, left, middle);	//keep dividing until the left array has only one element
            sort(arr , middle+1, right);//keep dividing until the right array has only one element
 
            // Merge the sorted halves
            merge(arr, left, middle, right);
        }
		return arr;
    }    
}
