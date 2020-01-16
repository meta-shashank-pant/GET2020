import java.util.Scanner;


public class Area {

	private boolean flag = true;
	private double height, width, radius;
	private double PI = 3.14;
	public void start(){
		
		System.out.println("Calculate the area :- ");
		Scanner scan = new Scanner(System.in);
		int val = 1;
		double result;
		String output;
		while(flag){
			System.out.println("1. TRIANGLE\n2. RECTANGLE\n3. SQUARE\n"
					+ "4. CIRCLE\n5. EXIT");
			try{
				val = scan.nextInt();
			}catch(Exception e){
				start();
			}
			switch(val){
			case 1:
				System.out.println("Area of Triangle: ");
				System.out.print("Enter width: ");
				width = get_input();
				System.out.print("Enter height: ");
				height = get_input();
				result = triangle(width, height);
				output = String.format("%.2f", result);
				System.out.println("-> " + output);
				break;
			case 2:
				System.out.println("Area of Rectangle: ");
				System.out.print("Enter width: ");
				width = get_input();
				System.out.print("Enter height: ");
				height = get_input();
				result = rectangle(width, height);
				output = String.format("%.2f", result);
				System.out.println("-> " + output);
				break;
			case 3:
				System.out.println("Area of Square: ");
				System.out.print("Enter width: ");
				width = get_input();
				result = square(width);
				output = String.format("%.2f", result);
				System.out.println("-> " + output);
				break;
			case 4:
				System.out.println("Area of Circle: ");
				System.out.print("Enter radius: ");
				radius = get_input();
				result = circle(radius);
				output = String.format("%.2f", result);
				System.out.println("-> " + output);
				break;
			case 5:
				System.out.println("Sucessfully Exit.");
				flag = false;
				break;
			default:
				System.out.println("Invalid input!, Try again.");
				break;
			}
		}

	}
	
	private double triangle(double width, double height){
		
		double output = 0;
		try{
			output = (width * height) / 2;
		}catch(ArithmeticException e){
			System.out.println("Arithmetic Exception!!!");
		}
		return output;
	}
	
	private double rectangle(double width, double height){
		
		double output = 0;
		try{
			output = width * height;
		}catch(ArithmeticException e){
			System.out.println("Arithmetic Exception!!!");
		}
		return output;
	}
	
	private double square(double width){
		
		double output = 0;
		try{
			output = width * width;
		}catch(ArithmeticException e){
			System.out.println("Arithmetic Exception!!!");
		}
		return output;
	}
	
	private double circle(double radius){
		
		double output = 0;
		try{
			output = PI * radius * radius;
		}catch(ArithmeticException e){
			System.out.println("Arithmetic Exception!!!");
		}
		return output;
	}
	
	private double get_input(){
		
		Scanner scan = new Scanner(System.in);
		double output = 0;
		try{
			output = scan.nextDouble();
			if(output <= 0){
				System.out.println("Invalid argument! ");
				get_input();
			}
		}catch(Exception e){
			System.out.println("Invalid argument! ");
			get_input();
		}
		return output;
	}

}
