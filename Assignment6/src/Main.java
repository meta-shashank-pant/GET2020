import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Assigment 6");
		start();
//		int arr[] = {1,5,4,8,7,9,10,78,56};
//		int arr1[] = {9,8,1,10};
//		
//		IntSet set1 = new IntSet(arr, 9);
//		IntSet set2 = new IntSet(arr1, 4);
//		int arrr[] = set2.getComplement();
//		System.out.print(IntSet.isSubset(set1, set2));
	}
	
	public static void start(){
	Scanner scan = new Scanner(System.in);
	boolean flag = true;
	int val = 1;
	while(flag){
		System.out.println("\n1. IntSet\n2. Polynomial\n3. EXIT");
		try{
			val = scan.nextInt();
		}catch(Exception e){
			start();
		}
		switch(val){
		case 1:
			System.out.println("\nOperation to be performed: ");
			IntSet set1 = null;
			set1 = set_object(set1);
			IntSet set2 = null;
			set2 = set_object(set2);
			int set_1[] = set1.getSet();
			int set_2[] = set2.getSet();
			System.out.print("Set 1:- ");
			printArray(set_1);
			System.out.print("\nSet 1:- ");
			printArray(set_2);
			//MEMBER OF SET
			System.out.println("\n\nMEMBER OF SET: \nEnter a number: ");
			int num = scan.nextInt();
			if(set1.isMember(num))
				System.out.println(num + " is the member of set1.");
			else
				System.out.println(num + " is not the member of set1.");
			if(set2.isMember(num))
				System.out.println(num + " is the member of set2.");
			else
				System.out.println(num + " is not the member of set2.");
			//SIZE OF SET
			System.out.println("\nSIZE OF SET: ");
			System.out.println("---> set1 size = " + set1.getSize());
			System.out.println("---> set2 size = " + set2.getSize());
			//SUBSET
			System.out.println("\nSUBSET: ");
			if(IntSet.isSubset(set1, set2))
				System.out.println("Set 2 is the subset of Set 1");
			else
				System.out.println("Set 2 is not the subset of Set 1");
			//COMPLEMENT
			System.out.println("\nCOMPLEMENT: ");
			System.out.print("Set 1 Complement: ");
			int arr1[] = set1.getComplement();
			printArray(arr1);
			System.out.print("\nSet 2 Complement: ");
			int arr2[] = set2.getComplement();
			printArray(arr2);
			//UNION
			System.out.println("\nUNION: ");
			int arr[] = IntSet.union(set1, set2);
			printArray(arr);
			System.out.println();
			break;
		case 2:
			System.out.println("Operation to be performed: ");
			Poly p1 = null;
			p1 = poly(p1);
			Poly p2 = null;
			p2 = poly(p2);
			System.out.println("Multiplication");
			Poly.multiplyPoly(p1, p2);
			System.out.println("\nAddition");
			Poly.addPoly(p1, p2);
			System.out.println("\nEvaluate");
			System.out.print("Enter variable: ");
			int var = scan.nextInt();
			double  ans1 = p1.evaluate(var);
			double ans2 = p2.evaluate(var);
			System.out.println("Object 1 evaluation: " + ans1 + "\nObject 2 evaluation: " + ans2);
			System.out.println("Degree of the polynomial");
			System.out.println("Object 1 degree: " + p1.getMaxDegree() + "\nObject 2 degree: " + p2.getMaxDegree());
			break;
		case 3:
			System.out.println("Sucessfully Exit.");
			flag = false;
			break;
		default:
			System.out.println("Invalid input!, Try again.");
			break;
			}
		}
		scan.close();
	}
	
	public static IntSet set_object(IntSet int_set){
		Scanner scan = new Scanner(System.in);
		int length;
		System.out.println("Enter length of the array: ");
		length = scan.nextInt();
		int arr[] = new int[length];
		for(int i = 0; i < length; i++){
			System.out.println("Enter value, index = " + (i+1));
			arr[i] = scan.nextInt();
		}
		int set[] = makeSet(arr);
		length = set.length;
		int_set = new IntSet(arr, length);
		return int_set;
	}
	
	public static int[] makeSet(int arr[]){
		int size = arr.length;
		int[] temp_new_set = new int[11];
		int new_set_size = temp_new_set.length;
		for(int i = 0; i < new_set_size; i++)
			temp_new_set[i] = 0;
		for(int i = 0; i < size; i++)
			temp_new_set[arr[i]] = 1;
		int index = 0;
		for(int i = 0; i < new_set_size; i++)
			if(temp_new_set[i] == 1)
				index++;
		int[] new_set = new int[index];
		index = 0;
		for(int i = 0; i < new_set_size; i++){
			if(temp_new_set[i] == 1){
				new_set[index] = i;
				index++;
			}
		}
		return new_set;
	}
	
	public static void printArray(int arr[]){
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+" ");
	}
	
	public static Poly poly(Poly p){
		int max_deg;
		int[] coeff = new int[50];
		int[] deg = new int[50];
		int index = 0;
		System.out.println("Enter maximum degree.");
		Scanner scan = new Scanner(System.in);
		try{
			max_deg = scan.nextInt();
		}catch(Exception e){
			System.out.println("Not Integer");
			poly(p);
			return null;
		}
		
		for(int i = 0; i <= max_deg; i++){
			System.out.println("Enter coefficient, degree = " + i);
			int coef = scan.nextInt();
			if(coef != 0){
				coeff[index] = coef;
				deg[index] = i;
				index++;
			}
		}
		p = new Poly(coeff, deg, index);
		return p;
	}
}
