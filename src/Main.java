import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Encrypter myEncrypter= new Encrypter("1234");

        String encryptValue = myEncrypter.encrypt();
        System.out.println(encryptValue);


        Decrypter myDecrypter= new Decrypter("0189");

        String decryptValue = myDecrypter.decrypt();
        System.out.println(decryptValue);
    }

}

