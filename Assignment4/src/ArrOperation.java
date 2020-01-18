public class ArrOperation {
	
	/**
	 * This method will return the index if there is a place to split the input array so that the sum
	 * of the numbers on one side is equal to the sum of the numbers on the other side else return -1.
	 * @param input_array is the array of integer type.
	 * @return value is the index from which the sum on the either side will be equal.
	 * It will throw assertion in the case input array is empty.
	 */
	public int splitArray(int[] input_array){
		int size = input_array.length;
		assert size != 0 : "Array size is 0";
		assert size != 1 : "Array size should be greater than 1.";
		int index = 0;
		int array_sum = arraySum(input_array);
		if(array_sum % 2 == 1)
			return -1;
		int req_sum = array_sum / 2;
		int curr_sum = 0;
		for(int i = 0; i < size; i++){
			if(req_sum == curr_sum){
				return i;
			}else if(req_sum < curr_sum){
				return -1;
			}else{
				curr_sum += input_array[i];
			}
		}
		return index;
	}
	
	/**
	 * This method is called from the splitArray() and will return the sum of the input array.
	 * @param arr is the input array of type integer.
	 * @return value is the sum of all the values inside of array.
	 */
	private int arraySum(int arr[]){
		int sum = 0;
		int size = arr.length;
		for(int i = 0; i < size; i++)
			sum += arr[i];
		return sum;
	}
	
	/**
	 * This method will return an array that contains exactly the same numbers as the input array,
	 * but rearranged so that every X is immediately followed by a Y.
	 * @param input_array is the array of type integer.
	 * @return array is of type integer and in the correct format as specified otherwise assertion is thrown.
	 * Constraint: Do not move X within array, but every other number may move.
	 * Throw assertion in following cases :
	 * 1. If array is empty.
	 * 2. If there are unequal number of X and Y in the input array.
	 * 3. If two adjacent X values are there.
	 * 4. If X occurs at the last index of the array.
	 */
	public int[] fixXY(int[] input_array){
		int num_of_X = count_X(input_array);
		int num_of_Y = count_Y(input_array);
		int X = 4, Y = 5;
		int index = 0;
		int size = input_array.length;
		boolean is_adjacent = adjacent_X(input_array);
		assert num_of_X == num_of_Y : "Number of X and Y should be equal.";
		assert input_array[size -1] != X : "Last value of array can not be X";
		assert size != 0 : "Array size is 0";
		assert !is_adjacent : "There are 2 adjacent X";
		for(int i = 0; i < size; i++){
			if((input_array[i] == Y) && (i >= index)){
				for(int j = index; j < size; j++){
					if(input_array[j] == X){
						int tmp = input_array[i];
						input_array[i] = input_array[j + 1];
						input_array[j + 1] = tmp;
						index = j + 2;
						break;
					}
				}
			}
		}
		return input_array;
	}
	
	/**
	 * This method is called from fixXY() and is calculating the number of X in the input array.
	 * @param arr is the input array 
	 * @return value is the number of X(X = 4) in the input array.
	 */
	private int count_X(int[] arr){
		int size = arr.length;
		int X = 4, count = 0;
		for(int i = 0; i < size; i++)
			if(arr[i] == X)
				count++;
		return count;
	}
	
	/**
	 * This method is called from fixXY() and is calculating the number of Y in the input array.
	 * @param arr is the input array 
	 * @return value is the number of Y(Y = 5) in the input array.
	 */
	private int count_Y(int[] arr){
		int size = arr.length;
		int Y = 5, count = 0;
		for(int i = 0; i < size; i++)
			if(arr[i] == Y)
				count++;
		return count;
	}
	
	/**
	 * This method is called from fixXY() and is checking whether there are adjacent X in the input array. 
	 * @param arr is the input array of type integer.
	 * @return value is of type boolean, true if there are adjacent X otherwise false.
	 */
	private boolean adjacent_X(int[] arr){
		int size = arr.length, X = 4;
		for(int i = 0; i < size-1; i++)
			if((arr[i] == X) && (arr[i+1] == X))
				return true;
		return false;
	}
	
	/**
	 * This method is used to find the total number of clumps in the array.
	 * @param input_array is the array of type integer.
	 * @return value is the number of clumps in the input array.
	 * Clump in an array is a series of 2 or more adjacent elements of the same value.
	 */
	public int countClumps(int[] input_array){
		int count = 0;
		int flag = 0;
		int size = input_array.length;
		assert size != 0 : "Array size is 0";
		for(int i = 0; i < size-1; i++){
			if(input_array[i] == input_array[i+1]){
				flag = 1;
			}else{
				if(flag == 1)
					count++;
				flag = 0;
			}
		}
		if(flag == 1)
			count++;
		return count;
	}
	
	/**
	 * This method is used to find the maximum size mirror in the array.
	 * Mirror section in an array is a group of contiguous elements such 
	 * that somewhere in the array, the same group appears in reverse order.
	 * @param input_array is the array of type integer.
	 * @return value is the size of max mirror.
	 */
	public int maxMirror(int[] input_array){
		int rows, columns; 
		int max = 0;
		rows = columns = input_array.length + 1;
		assert rows - 1 != 0 : "Array size is 0";
		int[][] input_matrix = new int[rows][columns];
		for(int i = 0; i < rows; i++){
			input_matrix[i][0] = 0;
			input_matrix[0][i] = 0;
		}
		for(int i = 1; i < rows; i++){
			for(int j = 1; j < columns; j++){
				int tmp_max = 0;
				if(input_array[i - 1] == input_array[rows - j -1]){
					tmp_max = input_matrix[i][j] = input_matrix[i-1][j-1] + 1;
				}else{
					input_matrix[i][j] = 0;
				}
				if(tmp_max > max)
					max = tmp_max;
			}
		}
		return max;
	}
	
}
