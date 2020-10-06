
public class Square extends Shape2D{

    private double i;

    public Square(double i) {
        super();
        this.i = i;
    }


    @Override
    public String getName() {
        return square;
    }


    @Override
    public double getArea() {
        return i*i;
    }



}
