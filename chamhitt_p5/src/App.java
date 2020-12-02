import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private static Scanner input = new Scanner(System.in);

    private static void displayMain(int opt[], String firstChoices[]){
        //Display menu option
        System.out.println("Select Your Application");
        System.out.println("---------");
        for(int i=0; i< opt.length; i++ ) {
            System.out.println( opt[i] + ") " + firstChoices[i] );
        }
        System.out.println("---------");

    }

    private static void displaySecondary(int optTwo[], String secondaryChoices[]){
        System.out.println("Main Menu");
        System.out.println("---------");
        for(int i = 0; i < optTwo.length; i++) {
            System.out.println( optTwo[i] + ") " + secondaryChoices[i]);
        }
        System.out.println("---------");
    }

    public static void main(String[] args){
        int choices;
        int opt[] = {1,2,3};
        String firstChoices[] = {"task list", "contact list", "quit"};

        int optTwo[] = {1,2,3};
        String secondChoices[] = {"Create a new list", "Load existing list", "Quit"};
        displayMain(opt, firstChoices);

        choices = input.nextInt();
        int quitToMain =  opt.length;

        //Application Menu
        while(choices != quitToMain) {


            //option 1
            if(choices == opt[0]){
                System.out.println(firstChoices[0]);

                //Start of the Main Menu
                displaySecondary(optTwo, secondChoices);
               int choicesTwo = input.nextInt();
               int quitMainMenu = optTwo.length;

               while(choicesTwo != quitMainMenu){


                   //First option of mainmenu
                   if(choicesTwo == optTwo[0]){
                    try {
                        System.out.println("create a new list");
                        System.out.println("Enter the name of the textfile you would like to create(don't include .txt)");
                        String textFile;
                        textFile = input.next() + ".txt";

                        System.out.println(textFile);

                        //gets the main in TaskApp
                        TaskApp.main(textFile);

                    } catch (InputMismatchException inputMismatchException){
                       System.err.println("Invalid input");
                  // } catch (IllegalArgumentException illegalArgumentException){
                   //    System.err.println("Invalid");
                   }


                //Second option of mainmenu
               } else if (choicesTwo == optTwo[1]){
               try {
                   System.out.println("load an existing list");
                   System.out.println("Enter the file you would like to load (don't include .txt)");
                   String textFile;
                   textFile = input.next() + ".txt";
                   System.out.println(textFile);
                   //gets the main in TaskApp
                   TaskApp.main(textFile);
                   }  catch (InputMismatchException inputMismatchException){
                       System.err.println("Invalid input");
                 //  } catch (IllegalArgumentException illegalArgumentException){
                 //      System.err.println("Invalid");
                   }


               // Quit option
               } else if (choicesTwo == optTwo[2]) {
                       System.out.println(secondChoices[2]);

                   }
                   displaySecondary(optTwo, secondChoices );
                   choicesTwo = input.nextInt();

               }
               //End of while statement for MainMenu



            }


            //option 2
            else if(choices == opt[1]){
                System.out.println(firstChoices[1]);


                //Start of the Main Menu
                displaySecondary(optTwo, secondChoices);
                int choicesThree = input.nextInt();
                int quitMainMenu = optTwo.length;

                while(choicesThree != quitMainMenu) {
                    //first option on mainmenu
                    if(choicesThree == optTwo[0]){
                    try {
                        System.out.println("create a new list");
                        System.out.println("Enter the name of the textfile you would like to create (don't include .txt)");
                        String textFile;
                        textFile = input.next() + ".txt";
                        System.out.println(textFile);

                        //gets the main in ContactApp
                        ContactApp.main(textFile);
                    }catch (InputMismatchException inputMismatchException){
                        System.err.println("Must be a string");
                    }catch (IllegalArgumentException illegalArgumentException){
                        System.err.println("Must be a string");
                    }

                    //Second option on mainmenu
                     } else if (choicesThree == optTwo[1]){

                try {
                    System.out.println("load an existing list");
                    System.out.println("Enter the file you would like to load (don't include .txt)");
                    String textFile;
                    textFile = input.next() + ".txt";
                    System.out.println(textFile);

                    //gets the main in ContactApp
                    ContactApp.main(textFile);
                } catch (InputMismatchException inputMismatchException){
                        System.err.println("Invalid input");
                } catch (IllegalArgumentException illegalArgumentException){
                        System.err.println("Invalid");
                }

                    //Quit option
                    } else if (choicesThree == optTwo[2]) {
                        System.out.println(secondChoices[2]);

                    }

                    displaySecondary(optTwo, secondChoices );

                    choicesThree = input.nextInt();


                }
            //End of while statement for MainMenu


            }





            //option 3
            else if(choices == opt[2]){
                System.out.println(firstChoices[2]);
            }

            displayMain(opt, firstChoices);

            choices = input.nextInt();
        }
        //Application Menu End

    }
}
