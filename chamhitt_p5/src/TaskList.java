import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TaskList {
    private static Scanner input = new Scanner(System.in).useDelimiter("");
   // private static Scanner input = new Scanner(System.in);
    List<TaskItem> items;

    public TaskList(){
       items = new ArrayList<TaskItem>();

    }


    public TaskItem add(){


        TaskItem data = getItem();
        try {
            items.add(data);
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


    public TaskItem getItem(){
        TaskItem data;
        while (true) {
            try {

                System.out.println("Enter title: ");
                String title ;
                title = input.nextLine();
                System.out.println();


                System.out.println("Enter description: ");
                String description ;
                description = input.nextLine();
                System.out.println();

                System.out.println("Enter a duedate in form of YYYY-MM-DD: ");
                String duedate;
                duedate = input.nextLine();
                System.out.println();

                String mark;
                mark = markWorthy();
                System.out.println(mark);

                TaskItem test = new TaskItem(mark, title, description, duedate);
                test.ifEditAllTasksValid(mark, title, description, duedate);


                data = new TaskItem(mark, title, description, duedate);



                break;
          //  } catch (IllegalArgumentException illegalArgumentException) {
           //     System.out.println("Invalid argument...");
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Invalid Input");
            }

        }
        return data;
    }


   public void edit(){

        try {
            System.out.println("Would you like to add or remove the data?");
            String choice = input.next();

            if (choice.equalsIgnoreCase("add")) {

                add();
            }
            if (choice.equalsIgnoreCase("remove")) {
                System.out.println("removing:");
                remove();
            }
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Incorrent input. Must be either add or remove ");
        } catch (NoSuchElementException noSuchElementException) {
            noSuchElementException.getStackTrace();
        }



}


    public void remove(){

        try {

            System.out.println("Enter the list you would like to delete");
            int numToDelete = input.nextInt();

            TaskItem data = items.get(numToDelete);
            items.remove(data);

        }catch (InputMismatchException inputMismatchException){
            System.err.println("Invalid number");
        }catch(IndexOutOfBoundsException invalidIndex){
            System.err.println("Invalid number");
        }

    }





    public void view(String filename){
        try (Formatter output = new Formatter(filename)) {
            for (int i = 0; i < items.size(); i++) {
                TaskItem data = items.get(i);
                output.format(i + ") %s %n %s %n %s %n %s %n", data.getMarked(),data.getTitle() , data.getDescription(), data.getDueDate());
                System.out.println("");
                System.out.println("Task item: "+ i);
                System.out.println(data);
                System.out.println("\n");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }






    public void reader(String filename) {

        try {

            File myList = new File(filename);
            Scanner reader = new Scanner(myList);
            int i = 0;
            while (reader.hasNext()) {

                // int o = reader.nextInt();
                //System.out.println(o);
                String mark = reader.nextLine();
                String title = reader.nextLine();
                String description = reader.nextLine();
                String duedate = reader.nextLine();
                //if(description != null)


                System.out.println(" " + mark + title + description + duedate);
                i++;
            }
            reader.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Error, cannot find file");
            fileNotFoundException.printStackTrace();
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Error, cannot find file");
            noSuchElementException.printStackTrace();
        }

    }

    public String markWorthy() {
        System.out.println("Would you like to mark this as complete(Y or N) ");
        String ans = input.next();
        String mark;
        if(ans.equalsIgnoreCase("y")){
            mark = "***";
        }  else {
            mark ="   ";
        }

        return mark;
    }



}
