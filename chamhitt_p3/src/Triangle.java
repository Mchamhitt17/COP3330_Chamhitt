
public class Triangle extends Shape2D {
    private double a;
    private double b;

    Triangle(double a, double b) {
        super();
        this.a = a;
        this.b = b;
    }

    @Override
    public String getName() {
        return triangle;
    }

    @Override
    public double getArea() {
        return a*b*1/2;
    }


}
