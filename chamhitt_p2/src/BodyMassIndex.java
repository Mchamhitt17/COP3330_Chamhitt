
public class BodyMassIndex {

    private double weight;
    private double height;
    private static double wt;
    private static double ht;


    private static double getHeight() {
        return ht;
    }

    private static double getWeight() {
        return wt;
    }

    @Override
    public String toString() {

        return "BodyMassIndex [" +
                "Height=" + height +
                ", Weight=" + weight +
                ", BMI =" + bmiInBodyMassIndexClassCalc() +
                ']';
    }


    public BodyMassIndex(double height, double weight) {
        this.height = height;
        this.weight = weight;
        this.ht = height;
        this.wt = weight;

    }


   /*using the calculation in BMI class to place in toString, for output */
    private double bmiInBodyMassIndexClassCalc() {
        return (Math.round(((703 * this.weight) /
                (this.height * this.height)))*10000)/10000;
    }

  /*calculation is used to get the calculation and use for determination and
  to be used in App.java
   */

    public static double bmiCalc() {
        double r = (703 * getWeight() / (getHeight() * getHeight()));
        double rounded =  Math.round(r*10000)/10000;
        return rounded;
    }


//BMI categories

    public static String bmiUnder() {
        String s = null;
        if (bmiCalc() < 18.5) {
            System.out.println("Underweight \n");
            s = "Underweight";
        }
        return s;
    }


    public static String bmiNormal() {
        String s = null;
        if ((bmiCalc()) > 18.5 && (bmiCalc()) < 25) {
            System.out.println("Normal Weight \n");
            s = "Normal Weight";
        }
        return s;
    }


    public static String bmiOverweight() {
        String s = null;
        if ((bmiCalc()) >= 25 && (bmiCalc()) < 30) {
            System.out.println("Overweight \n");
            s = "Overweight";
        }
        return s;
    }

    public static String bmiObese() {
        String s = null;
        if  ((bmiCalc()) >= 30) {
            System.out.println("Obese \n");
            s = "Obese";
        }
        return s;
    }
}














