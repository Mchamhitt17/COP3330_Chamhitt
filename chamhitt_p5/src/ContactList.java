import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ContactList {


    private static Scanner input = new Scanner(System.in);
    List<ContactItem> contacts;


    //ArrayList<ContactItem> it = new ArrayList<ContactItem>();

    public ContactList(){
        contacts = new ArrayList<ContactItem>();

    }

    public ContactItem add(){


        ContactItem data = getItem();
        try {
            contacts.add(data);
            System.out.println("Would to to continue adding more data.\n('Y' for yes or N'' for no)");
            String ans = input.next();
            if (ans.equalsIgnoreCase("y")) {
                // data = getListedItemData();
                add();

            } else if (ans.equalsIgnoreCase("n")) {
                return data;

            }
        }catch (InputMismatchException inputMismatchException){
            System.err.println("Invalid character, must be Y or N");
        }


        return data;

    }


    public void view(String filename){
        try (Formatter output = new Formatter(filename)) {
            for (int i = 0; i < contacts.size(); i++) {
                ContactItem data = contacts.get(i);
                output.format(i + ") %s %n %s %n %s %n %s %n", data.getFirstName(),data.getLastName() , data.getPhoneNumber(), data.getEmailAddress());
                System.out.println("");
                System.out.println("Contact item: "+ i);
                System.out.println(data);
                System.out.println("\n");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        

    }





    public ContactItem getItem(){
        ContactItem data;
        while (true) {
            try {

                System.out.println("Enter first name: ");
                String firstName ;
                firstName = input.next();

                System.out.println("Enter last name: ");
                String lastName ;
                lastName = input.next();

                System.out.println("Enter phone number in form of ###-###-####: ");
                String phoneNumber;
                phoneNumber = input.next();

                System.out.println("Enter email address.(email@123.com): ");
                String emailAddress ;
                emailAddress = input.next();

               ContactItem test = new ContactItem(firstName, lastName, phoneNumber, emailAddress);
                    test.ifEditAllisValid(firstName, lastName, phoneNumber, emailAddress);


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




    public void remove(){

        try {

            System.out.println("Enter the list you would like to delete");
            int numToDelete = input.nextInt();

            ContactItem data = contacts.get(numToDelete);
            contacts.remove(data);

        }catch (InputMismatchException inputMismatchException){
            System.err.println("Invalid number");
        }catch(IndexOutOfBoundsException invalidIndex){
            System.err.println("Invalid number");
        }

    }

    public void reader(String filename){

        try {

            File myList = new File(filename);
            Scanner reader = new Scanner(myList);
            int i = 0;
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



    }



}
