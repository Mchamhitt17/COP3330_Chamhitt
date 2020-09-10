public class Encrypter {
    private static String stringValueToEncrypt;


    //The original string value
    public Encrypter(String stringValueToEncrypt) {
        this.stringValueToEncrypt = stringValueToEncrypt;

    }


    public static String printedOriginalStr () {
        String[] originalValInArrayForm = stringValueToEncrypt.split("");

        return (originalValInArrayForm[0]+originalValInArrayForm[1]
                +originalValInArrayForm[2]+originalValInArrayForm[3] + " ");
    }



    public static String originalStrOutput () {
        return (printedOriginalStr());
    }



    public static String encrpytedStr() {

        String[] originalValInArrayForm = stringValueToEncrypt.split("");

        int size = originalValInArrayForm.length;
        int [] arrEncrypt = new int[size];
        for (int i = 0; i < size; i++) {
            arrEncrypt[i] = Integer.parseInt(originalValInArrayForm[i]);
            //computation to add 7 to the value and get it's remainder from dividing by 10
            arrEncrypt[i] = arrEncrypt[i] + 7;
            arrEncrypt[i] = arrEncrypt[i] % 10;
        }

        return (Integer.toString(arrEncrypt[2]) + Integer.toString(arrEncrypt[3]) +
                Integer.toString(arrEncrypt[0]) + Integer.toString(arrEncrypt[1]));
    }


    public static String encrypt() {
        return ("Encrypts: \n" + originalStrOutput()+ "to " +encrpytedStr());
    }


}



