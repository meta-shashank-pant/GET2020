
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,1,3,4,5,6,3,4,3,4,7,8,4,1,2,4,5,6,7,8,9,7,6,5,4,1,8,9,5,3};
//		int result[] = fixXY(arr);
//		for(int i=0;i<arr.length;i++)
//			System.out.print(result[i]+" ");
		int ans = maxMirror(arr);
		System.out.println(ans);
	}
	
	public static int[] fixXY(int[] input_array){
		int num_of_X = count_X(input_array);
		int num_of_Y = count_Y(input_array);
		int X = 4, Y = 5;
		int index = 0;
		int size = input_array.length;
		boolean is_adjacent = adjacent_X(input_array);
		if((num_of_X != num_of_Y) || (input_array[size -1] == X) || (size == 0) || (is_adjacent) ){
			throw new AssertionError();
		}
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
	
	private static int count_X(int[] arr){
		int size = arr.length;
		int X = 4, count = 0;
		for(int i = 0; i < size; i++)
			if(arr[i] == X)
				count++;
		return count;
	}
	
	private static int count_Y(int[] arr){
		int size = arr.length;
		int Y = 5, count = 0;
		for(int i = 0; i < size; i++)
			if(arr[i] == Y)
				count++;
		return count;
	}
	
	private static boolean adjacent_X(int[] arr){
		int size = arr.length, X = 4;
		for(int i = 0; i < size-1; i++)
			if((arr[i] == X) && (arr[i+1] == X))
				return true;
		return false;
	}
	
	public static int maxMirror(int[] input_array){
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
		
		for(int i = 0;i<rows;i++){
			for(int j=0; j<columns;j++)
				System.out.print(input_matrix[i][j]);
			System.out.println();
		}
		return max;
	}
	
	
	

}
