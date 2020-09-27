import java.util.ArrayList;
import java.util.Scanner;

public class App {

static Scanner read = new Scanner(System.in);

    private static int numberOfTimes=0;
    private static double n, sum=0;


    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }




    private static void displayBmiInfo(BodyMassIndex bmi) {
        n= bmi.bmiCalc();
        sum += n;
        System.out.println(n);
        bmi.bmiUnder();
        bmi.bmiNormal();
        bmi.bmiOverweight();
        bmi.bmiObese();

    }


    private static boolean moreInput() {
        System.out.print("Please enter Y (to continue) or N (to end) \n");
        System.out.print("*  Note: Invalid values will lead to unlikely BMIs  * \n");
        String input = read.next();

        System.out.print("");
        if (input.equalsIgnoreCase("y")) {
            numberOfTimes++;
            return true;
        }
        else {
            return false;
        }
    }

    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        for (int i = 0; i < bmiData.size(); ++i) {
            System.out.println("BMI " + i + " = " + " " + bmiData.get(i) );
            }

        System.out.println("The average is BMI "
                + (Math.round((sum/numberOfTimes)*10000)/10000));
    }


    private static double getUserHeight() {
        double heightInput;
        System.out.println("Enter a height in inches (value greater than 0)");
        heightInput = read.nextDouble();

        while (heightInput <= 0) {
            System.out.println("Invalid value");
            heightInput = 0;
            break;
        }
        return heightInput;
    }


    private static double getUserWeight() {
        double weightInput;
        System.out.println("Enter the weight in pounds (value greater than 0)");
        weightInput = read.nextDouble();

        while (weightInput <= 0) {
            System.out.println("Invalid value");
            weightInput = 0;
            break;
        }
        return weightInput;
    }
}