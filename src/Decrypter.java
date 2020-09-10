public class Decrypter {
    private static String stringValueToDecrypt;


    //The original string value
    public Decrypter(String stringValueToDecrypt) {
        this.stringValueToDecrypt = stringValueToDecrypt;

    }


    public static String originalStrPrinted() {
        String[] originalValInStrArrayForm = stringValueToDecrypt.split("");

        return (originalValInStrArrayForm[0] + originalValInStrArrayForm[1]
                + originalValInStrArrayForm[2] + originalValInStrArrayForm[3] + " ");
    }


    public static String origStringOutput() {
        return (originalStrPrinted());
    }


    public static String decryptedStr() {

        String[] originalValInStrArrayForm = stringValueToDecrypt.split("");

        int size = originalValInStrArrayForm.length;
        double [] arrDecrypt = new double[size];
        for (int i = 0; i < size; i++) {
            arrDecrypt[i] = Integer.parseInt(originalValInStrArrayForm[i]);

            // computation to get the value divided by 10 and adding 1.
            //then its multiplied by 10 and that number is subtracted by 7.
            double a = arrDecrypt[i] / 10;
            double b = a + 1;
            double c = b * 10;
            arrDecrypt[i] = (int)c-7;

            //if outcome number is less 10 it is finished with the for loop
            if (arrDecrypt[i] > 10) {
                arrDecrypt[i] = arrDecrypt[i] - 10;
            }

        }

        //takes the arrays of a type double and converts to integer
        int intArrEncrypt0 = (int) arrDecrypt[0];
        int intArrEncrypt1 = (int) arrDecrypt[1];
        int intArrEncrypt2 = (int) arrDecrypt[2];
        int intArrEncrypt3 = (int) arrDecrypt[3];

        return ( Integer.toString(intArrEncrypt2) + Integer.toString(intArrEncrypt3) +
                Integer.toString(intArrEncrypt0)) + Integer.toString(intArrEncrypt1);

    }


    public static String decrypt () {
        return ("Decrypts: \n" + origStringOutput() + "to " + decryptedStr());
    }


}
