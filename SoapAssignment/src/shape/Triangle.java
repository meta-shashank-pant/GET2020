package shape;

public class Triangle {

	/**
	 * This method is used to get the area of the triangle.
	 * @param firstSide is the length of first side.
	 * @param secondSide is the length of second side.
	 * @param thirdSide is the length of third side.
	 * @return is the string storing the area of the triangle. 
	 */
	public String area(int firstSide,int secondSide,int thirdSide)
	{
		double semiPerimeter=(firstSide+secondSide+thirdSide)/2.0;
		double areaSquare=semiPerimeter*(semiPerimeter-firstSide)*(semiPerimeter-secondSide)*(semiPerimeter-thirdSide);
		double area=Math.sqrt(areaSquare);
		return String.valueOf((double)area);
	}

}


