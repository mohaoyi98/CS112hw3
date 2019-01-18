/*
 * Student First Name: Mohao
 * Student Last Name: Yi
 * Student BU Number: U35238289
 * Email: mohaoyi@bu.edu
 * Purpose: This class defines methods to reorder the elements in an array 
 *          according to certain rules.
 */

package hw3;

public class ReOrder {
	
	// This method takes in the reference to an integer array called items, 
	// and reorders the elements in items into three parts: <0, ==0, and >0.
	public static void reorder(int[] items)
	{	// To implement this method, we consecutively check each element 
		// in items, decide the index of the position it belongs to, and 
		// place it there.
		
		
		// the index of the next position to place a negative integer
		int negativeIndex = 0;
		// the index of the next position to place a positive integer
		int positiveIndex = items.length - 1;
		// the current index in items that we are checking
		int checkIndex = 0;
		
		// keep reordering when there are unchecked elements in items
		// note that the already checked elements are items[i], where
		// i < checkIndex or i > positiveIndex
		while (checkIndex <= positiveIndex) {
			// we only need to reorder non-zero integers, since if they
			// are correctly arranged, zeros will automatically be 
			// correctly arranged
			
			// reorder negative integers
			if (items[checkIndex] < 0) {
				ReOrder.swap(negativeIndex, checkIndex, items);
				negativeIndex++;
				checkIndex++;
				
			// reorder positive integers
			} else if (items[checkIndex] > 0) {
				ReOrder.swap(positiveIndex, checkIndex, items);
				positiveIndex--;
			
			// if the currently being checked integer is zero, 
			// then let it keep its position, but update the checkIndex to 
			// indicate that we have checked it
			} else {
				checkIndex++;
			}
			
		}
	}
	
	// inputs: the reference to an integer array items, and 
	// two integers i and j that represent two indices of items
	// This method swaps element i and element j in array items
	private static void swap(int i,int j,int[] items)
	{
		// temporarily stores items[j] to another variable, 
		// so that we will not lose it
		int temp = items[j];
		items[j] = items[i];
		items[i] = temp;
	}

	public static void main(String[] args) {
		
		int [] items={7,-3,0,0,8,-2};
		int [] items1 = {0, 53, -1, 0, 5, 0, -60, 0, 42, -9, 0};
		/*
		 * printing the values in the items before 
		 * calling the method reorder.
		 */
		for(int item:items)
		{
			System.out.print(item + " ");
		}
		
		System.out.println();
		
		//calling the reorder method
		ReOrder.reorder(items);
		/*
		 * printing the values in the items after 
		 * calling the method reorder
		 */
		for(int item:items)
		{
			System.out.print(item + " ");
		}
		
		System.out.println();
		
		for(int item:items1)
		{
			System.out.print(item + " ");
		}
		
		System.out.println();
		
		//calling the reorder method
		ReOrder.reorder(items1);
		/*
		 * printing the values in the items after 
		 * calling the method reorder
		 */
		for(int item:items1)
		{
			System.out.print(item + " ");
		}
		
		System.out.println();
	}
}