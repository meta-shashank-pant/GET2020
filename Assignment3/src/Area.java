import java.util.Scanner;

/**
 * Area class will calculate the area of various geometries like:
 * Triangle, Rectangle, Square, Circle.
 * @author Shashank
 * Area will be calculated for valid inputs only.
 */
public class Area {

	private boolean flag = true;
	private double height, width, radius;
	private double PI = 3.14;
	
	/**
	 * start() is the driver method in this class, it is called from main() method.
	 * Here, variable "val" will hold the user choice among various options like:
	 * 1. Area of Triangle
	 * 2. Area of Rectangle
	 * 3. Area of Square
	 * 4. Area of Circle
	 * Output string is formatted and displayed to user in this function.
	 */
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
	
	/**
	 * This method is used to calculate the area of triangle.
	 * @param width is the input width of triangle of type double.
	 * @param height is the input height of triangle of type double.
	 * @return output is the resultant area of the triangle of type double.
	 * Formula used: Area of triangle = (1 / 2) * (width * height)
	 */
	private double triangle(double width, double height){
		
		double output = 0;
		try{
			output = (width * height) / 2;
		}catch(ArithmeticException e){
			System.out.println("Arithmetic Exception!!!");
		}
		return output;
	}
	
	/**
	 * This method is used to calculate the area of rectangle.
	 * @param width is the input width of rectangle of type double.
	 * @param height is the input height of rectangle of type double.
	 * @return output is the resultant area of the rectangle of type double.
	 * Formula used: Area of rectangle = (width * height)
	 */
	private double rectangle(double width, double height){
		
		double output = 0;
		try{
			output = width * height;
		}catch(ArithmeticException e){
			System.out.println("Arithmetic Exception!!!");
		}
		return output;
	}
	
	/**
	 * This method is used to calculate the area of square.
	 * @param width is the input width of square of type double.
	 * @return output is the resultant area of the square of type double.
	 * Formula used: Area of square = (width * width)
	 */
	private double square(double width){
		
		double output = 0;
		try{
			output = width * width;
		}catch(ArithmeticException e){
			System.out.println("Arithmetic Exception!!!");
		}
		return output;
	}
	
	/**
	 * This method is used to calculate the area of circle.
	 * @param radius is the input radius of circle of type double.
	 * @return output is the resultant area of the circle of type double.
	 * Formula used: Area of circle = PI * (radius * radius)
	 */
	private double circle(double radius){
		
		double output = 0;
		try{
			output = PI * radius * radius;
		}catch(ArithmeticException e){
			System.out.println("Arithmetic Exception!!!");
		}
		return output;
	}
	
	/**
	 * Functionality of this method is to take input and check if its valid and then returning the same.
	 * @return value is the valid double value.
	 * For a value to be valid:
	 * 1. It should be a double value.
	 * 2. The value should be greater than 0.
	 */
	private double get_input(){
		
		Scanner scan = new Scanner(System.in);
		double output = 0;
		try{
			output = scan.nextDouble();
			if(output < 0){
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
