import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Pyramid extends Shape3D {
    private double l, w, h;

    Pyramid(double l, double w, double h) {
        super();
        this.l = l;
        this.w = w;
        this.h = h;
    }

    @Override
    public String getName() {
        return pyramid;
    }

    @Override
    public double getVolume() {
        return (l*w*h)/3;
    }

    @Override
    public double getArea() {
        return (l*w) +(l*sqrt(pow((w/2),2)+pow(h,2)))+(w*sqrt(pow((l/2),2)+pow(h,2)));
    }
}
