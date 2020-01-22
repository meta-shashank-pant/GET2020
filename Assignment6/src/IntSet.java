
public class IntSet {
	
	private final int[] set;
	private final int size;
	public IntSet(int arr[], int length){
		this.set = arr;
		this.size = length;
		
	}
	
	public boolean isMember(int find_num){
		int size = getSize();
		for(int i = 0; i < size; i++)
			if(set[i] == find_num)
				return true;
		return false;
	}
	
	public int getSize(){
		return size;
	}
	
	public int[] getSet(){
		return set;
	}
	
	public static boolean isSubset(IntSet set1, IntSet set2){
		int set1_size = set1.getSize();
		int set2_size = set2.getSize();
		if( set1_size < set2_size)
			return false;
		for(int i = 0; i < set2_size; i++){
			int flag = 0;
			for(int j = 0; j < set1_size; j++){
				if(set1.getSet()[j] == set2.getSet()[i]){
					flag = 1;
					break;
				}
			}
			if(flag == 0){
				return false;
			}
		}
		return true;
	}
	
	public int[] getComplement(){
		int size = getSize();
		int[] temp_complement_set = new int[11];
		int complement_set_size = temp_complement_set.length;
		for(int i = 0; i < complement_set_size; i++)
			temp_complement_set[i] = 1;
		for(int i = 0; i < size; i++)
			temp_complement_set[set[i]] = 0;
		int index = 0;
		for(int i = 0; i < complement_set_size; i++)
			if(temp_complement_set[i] == 1)
				index++;
		int[] complement_set = new int[index];
		index = 0;
		for(int i = 0; i < complement_set_size; i++){
			if(temp_complement_set[i] == 1){
				complement_set[index] = i;
				index++;
			}
		}
		return complement_set;
	}
	
	public static int[] union(IntSet set1, IntSet set2){
		int set1_size = set1.getSize(), set2_size = set2.getSize(), max_size = 1000;
		int[] temp_set = new int[1000];
		for(int i = 0; i < max_size; i++)
			temp_set[i] = 0;
		for(int i = 0; i < set1_size; i++)
			temp_set[set1.getSet()[i]] = 1;
		for(int i = 0; i < set2_size; i++)
			temp_set[set2.getSet()[i]] = 1;
		int index = 0;
		for(int i = 0; i < max_size; i++)
			if(temp_set[i] == 1)
				index++;
		int[] union_set = new int[index];
		index = 0;
		for(int i = 0; i < max_size; i++)
			if(temp_set[i] == 1){
				union_set[index] = i;
				index++;
			}
		return union_set;
	}
}
