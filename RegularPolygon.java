import java.util.*;
import java.lang.Math;

public class RegularPolygon
{
    private int sides;
    private double sideLength;
    Scanner x = new Scanner(System.in);

    public RegularPolygon(int sides, double sideLength)
    {
        this.sides = sides;
        this.sideLength = sideLength;
    }
    
    public int getSides()
    {
        System.out.println("Enter number of sides: ");
        this.sides = x.nextInt();
        return sides;

    }

    public double getsideLength()
    {
        System.out.println("Enter the length of the side: ");
        this.sideLength = x.nextDouble();
        return sideLength;
    }

    public void computeArea()
    {
        double area = (0.25 * sides * sideLength  * sideLength) / (Math.tan(Math.PI/sides));
        System.out.println("The area is: " + area);
    }
}

