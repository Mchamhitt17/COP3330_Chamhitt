import static java.lang.Math.pow;

public class Circle extends Shape2D {
    private double r;
    static final double PI = 3.1415926;

    Circle(double r) {
        super();
        this.r = r;
    }


    @Override
    public String getName() {
        return circle;
    }


    @Override
    public double getArea() {
        return pow(r,2)*PI;
    }



}
