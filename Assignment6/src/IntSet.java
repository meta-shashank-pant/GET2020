
public class IntSet {
	
	private final int[] set;
	private final int size;
	public IntSet(int arr[]){
		this.set = arr;
		this.size = arr.length;
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
	
	public boolean isSubset(IntSet set1, IntSet set2){
		int set1_size = set1.getSize();
		int set2_size = set2.getSize();
		if( set1_size < set2_size)
			return false;
		for(int i = 0; i < set1_size; i++){
			int flag = 0;
			for(int j = 0; j < set2_size; j++){
				if(set1.getSet()[i] == set2.getSet()[j]){
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
		int[] temp_complement_set = new int[1000];
		int[] complement_set = new int[1000];
		int complement_set_size = complement_set.length;
		for(int i = 0; i < complement_set_size; i++)
			temp_complement_set[i] = 1;
		for(int i = 0; i < size; i++)
			temp_complement_set[set[i] - 1] = 0;
		int index = 0;
		for(int i = 0; i < complement_set_size; i++){
			if(temp_complement_set[i] == 1){
				complement_set[index] = i + 1;
				index++;
			}
		}
		return complement_set;
	}
	
	public int[] union(int[] set1, int[] set2){
		int set1_size = set1.length, set2_size = set2.length, max_size = 1000;
		int union_size = set1_size + set2_size;
		int[] temp_set = new int[1000];
		int[] union_set = new int[union_size];
		for(int i = 0; i < max_size; i++)
			temp_set[i] = 0;
		for(int i = 0; i < set1_size; i++)
			temp_set[set1[i] - 1] = 1;
		for(int i = 0; i < set2_size; i++)
			temp_set[set2[i] - 1] = 1;
		int index = 0;
		for(int i = 0; i < max_size; i++){
			if(temp_set[i] == 1){
				union_set[index] = i+1; 
				index++;
			}
				
		}
		return union_set;
	}
}
