package question3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComputeMass cm = new ComputeMass();
		String compound = "CHO(CH(CH(CH3)3)2)4";
		int ans = cm.getMass(compound, 0);
		System.out.println(ans);
//		int a = '9';
//		System.out.println(a);
	}

}
