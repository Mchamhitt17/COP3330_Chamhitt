import static java.lang.Math.pow;

public class Cube  extends Shape3D{
    private  double c;


    Cube(double c) {
        super();
        this.c = c;
    }

    @Override
    public String getName() {
        return cube;
    }

    @Override
    public double getArea() {
        return 6*pow(c,2);
    }

    @Override
    public double getVolume() {
        return pow(c,3);
    }
}
