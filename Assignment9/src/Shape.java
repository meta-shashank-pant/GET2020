import java.util.Date;
public interface Shape {
	
	enum ShapeType{
		CIRCLE, RECTANGLE, SQUARE, TRIANGLE
	}
	
	public double getArea();
	
	public double getPerimeter();
	
	public Point getOrigin();
	
	public boolean isPointEnclosed(Point point);
	
	Date getTime();
}
