import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ContactApp {


    private static Scanner input = new Scanner(System.in);
    private static ContactList listedContact;

   // private ContactList listedContact;
    private ContactItem listedItem;

     public ContactApp (){
         listedContact = new ContactList();
    }

    // add data
    private void addData(){


         listedContact.add();


     /*


     ContactItem data = getListedItemData();
     try {
         listedContact.add(data);
         System.out.println("Would to to continue adding more data.\n('Y' for yes or N'' for no)");
         String ans = input.next();
         if (ans.equalsIgnoreCase("y")) {
             // data = getListedItemData();
             addData();

         } else if (ans.equalsIgnoreCase("n")) {
             return data;

         }
     }catch (InputMismatchException inputMismatchException){
         System.err.println("Invalid character, must be Y or N");
     }


       return data;





      */


    }


    //remove data
    private void removeData(){

             listedContact.remove();



    }

    //view data
    private static void viewData(String filename){
        listedContact.view(filename);

    }

    public ContactItem readOut(String filename) {
         //listedContact.reader(filename);
        ContactItem data = null;

        try {
            File myList = new File(filename);
            Scanner reader = new Scanner(myList);

            int i =0;
            while (reader.hasNext()) {

                // int o = reader.nextInt();
                //System.out.println(o);
                String firstName = reader.nextLine();
                String lastName = reader.nextLine();
                String phoneNumber = reader.nextLine();
                String emailAddress = reader.nextLine();
                //if(description != null)


                System.out.println( " "+ firstName + lastName+ phoneNumber + emailAddress);
                i++;
                
                data = new ContactItem(firstName,lastName,phoneNumber, emailAddress);
                return data;
            }

            reader.close();

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Error, cannot find file");
            fileNotFoundException.printStackTrace();
        }
        catch (NoSuchElementException noSuchElementException) {
            System.out.println("Error, cannot find file");
            noSuchElementException.printStackTrace();
        }
  return data;
    }

    //edit data
    private void editData(){
         try {
             System.out.println("Would you like to add or remove the data?");
             String choice = input.next();

             if (choice.equalsIgnoreCase("add")) {

                 addData();
             }
             if (choice.equalsIgnoreCase("remove")) {
                 System.out.println("removing:");
                 removeData();
             }
         }catch (InputMismatchException inputMismatchException) {
             System.out.println("Incorrent input. Must be either add or remove ");
         }catch ( NoSuchElementException  noSuchElementException){
             noSuchElementException.getStackTrace();
         }

    }





    //gets the items for the new ContactItemList, if data equals null.
    public ContactItem getListedItemData(){
        ContactItem data;
        while (true) {
            try {

                System.out.print("Enter first name: ");
                String firstName = input.next();


                System.out.print("Enter last name: ");
                String lastName = input.next();


                System.out.print("Enter phone number in form of ###-###-####: ");
                String phoneNumber = input.next();

                System.out.print("Enter email address.(email@123.com): ");
                String emailAddress = input.next();



                data = new ContactItem(firstName, lastName, phoneNumber, emailAddress);
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println("Invalid argument...");
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Invalid Input");
            }

        }
        return data;
    }



    public static void displayMenu(int optNum[], String itemsOptions[]){
    //Display menu option
    System.out.println("List Operation Menu for Contact");
        System.out.println("---------");
        for(int i=0; i< optNum.length; i++ ) {
            System.out.println( optNum[i] + ") " + itemsOptions[i] );
        }
        System.out.println("---------");

    }



    public  void menu(String filename){

        int choice;
        System.out.println("File is: " +filename);
        ArrayList<String> list1  = new ArrayList<>();
        int optNum[] = {1,2,3,4,5,6};

        String itemOptions[] = {"view the list"," add an item",
                "edit an item", "remove an item", "save the current list", "quit to the main menu" };
        displayMenu(optNum, itemOptions);

        // HashMap<String, String> option = new HashMap<>();

        choice = input.nextInt();

        int quitToMain =  optNum.length;
        while(choice != quitToMain) {
            //option 1
            if(choice == optNum[0]){
                System.out.println(itemOptions[0]);

                viewData(filename);
                //readOut(filename);

            }
            //option 2
            else if(choice == optNum[1]){

                System.out.println(itemOptions[1]);

               addData();



            }
            //option 3
            else if(choice == optNum[2]){
                System.out.println(itemOptions[2]);
               viewData(filename);
              // ContactItem data = readOut(filename);
               editData();

            }
            //option 4
            else if(choice == optNum[3]){
                System.out.println(itemOptions[3]);
               viewData(filename);
                //readOut(filename);

                //ContactItem data = readOut(filename);

                removeData();
                viewData(filename);
            }
            //option 5
            else if(choice == optNum[4]){
                System.out.println(itemOptions[4]);
            }

            displayMenu(optNum, itemOptions);

            choice = input.nextInt();
        }


    }



    public static void main(String filename){


   // System.out.println( "File: "+ filename);
    ContactApp access = new ContactApp();
       access.menu(filename);

    }
}
