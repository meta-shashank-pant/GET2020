
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,5,4,8,7,9,10,78,56};
		int arr1[] = {2,6,8,9,45,1,6,14};
		IntSet set1 = new IntSet(arr);
		IntSet set2 = new IntSet(arr1);
		System.out.print(set2.isSubset(set1, set2));
//		for(int i = 0; i < arrr.length; i++)
//			System.out.print(arrr[i]+" ");
		int coeff[] = {2,2,4,5,1,3};
		int deg[] = {4,3,4,2,1,0};
	}

}
