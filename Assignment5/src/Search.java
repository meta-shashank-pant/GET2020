/**
 * Search class has two methods linear search and binary search.
 * @author Shashank
 * Both linear and binary search is done with the help of recursion.
 */
public class Search {
	
	/**
	 * Linear Search : Linear search or sequential search is a method for finding a target value within an array. 
	 * It sequentially checks each element of the array for the target value until a match is found or until all 
	 * the elements have been searched.
	 * 
	 * @param linear_arr is the input array of type integer.
	 * @param find_num is the number to be searched in the array.
	 * @param index is the value of the current index, element at that index is to be compared with find_num.
	 * @return is the index at which the number is found, -1 otherwise.
	 */
	public int linearSearch(int linear_arr[], int find_num, int index){
		int element_num = linear_arr.length;
		if(linear_arr[index] == find_num){
			return index;
		}else if(index == element_num - 1){
			return -1;
		}else{
			return linearSearch(linear_arr, find_num, index + 1);
		}
	}
	
	/**
	 * Binary Search :  Binary search is a search algorithm that finds the position of a target value within a sorted array. 
	 * Binary search compares the target value to the middle element of the array. If they are not equal, the half in which 
	 * the target cannot lie is eliminated and the search continues on the remaining half, again taking the middle element to 
	 * compare to the target value, and repeating this until the target value is found.
	 * 
	 * @param binary_arr is the input array of type integer.
	 * @param firstElementIndex is the index number pointing to the first element of the array.
	 * @param lastElementIndex is the index number pointing to the last element of the array.
	 * @param find_num is the number to be searched in the array.
	 * @return is the index at which the number is found, -1 otherwise.
	 */
	public int binarySearch(int binary_arr[], int firstElementIndex, int lastElementIndex, int find_num){
        int middelElementIndex = (firstElementIndex +lastElementIndex) / 2;
        if(firstElementIndex > lastElementIndex)
            return -1;
        else if(find_num == binary_arr[middelElementIndex])
            return middelElementIndex;
        else if(find_num < binary_arr[middelElementIndex])
            return binarySearch( binary_arr, firstElementIndex, middelElementIndex - 1, find_num);
        else
            return binarySearch( binary_arr, middelElementIndex + 1, lastElementIndex, find_num);
    }
}
