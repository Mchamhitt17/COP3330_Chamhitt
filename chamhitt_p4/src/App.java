
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.lang.NumberFormatException;



public class App {
    private static Scanner input = new Scanner(System.in);

    private TaskList listedTask;



    public App() {
        listedTask = new TaskList();
    }


    private void writeData(String filename) {
        listedTask.write(filename);
    }

    private void writeMarked(String filename){
        listedTask.markWorthy(filename);
    }


    private void storeItemsData(TaskItem data) {
        listedTask.add(data);
    }


    private void removeItemsData(TaskItem data, int number, String filename) {
        int numberForListToDelete;
        numberForListToDelete =  getListNumberToRemove();
        listedTask.remove(data ,numberForListToDelete,filename);
    }

    //private void viewItemsData(TaskItem data ) {
    //  listedTask.view(data, "output.txt");
    // }

    private int getListNumberToRemove(){
        int i;
        System.out.println("Which taskitem array do you want to remove");
        Scanner input = new Scanner(System.in);
        i = input.nextInt();
        return i;
    }

    private String getmarked() {
        String tempStr  = "   ";
        String mark = null;
        System.out.println("Y for yes, N for no for assigning the task as completed or not");
        if (input.nextLine().equalsIgnoreCase("y"))
            tempStr = ("***");

        return tempStr;
    }





    private String getTitle() {
        System.out.println("Enter title ");
        return input.nextLine();
    }

    private String getDescription() {
        System.out.println("Enter Description");
        return input.nextLine();
    }

    private String getDueDate() {
        System.out.println("Enter due date in in YYYY-MM-DD");
        return input.nextLine();

    }


    private String usemarked(){
        String tempStr  = "   ";
        System.out.println("Y for yes, N for no for assigning the task as completed or not");
        if (input.nextLine().equalsIgnoreCase("y"))
            tempStr = ("***");
        return tempStr;
    }


    //Main Menu
    void processTaskList() {
/*

        int request = 3;
      //  try{
            do{
                System.out.printf("%n Enter request for task list %n%s %n%s %n%s",
                        "1 - Create a new task list",
                        "2 - Load an existing task list",
                        "3 - Quit");
                System.out.printf("%n?");
                request = input.nextInt();
                if( request == 3 ){
                    System.exit(1);
                }
                if ( request == 2){

                    //   TaskList array = new TaskList();
                    //TaskList.operationsMenu();

                    processTaskItems();
                    writeData();

                    request = 0;

                }
                if (request == 1){
                    processTaskItems();

                    request = 0;

                }
            } while (request< 1 || request >3);

            */
        // }
        //  catch(InputMismatchException inputMismatchException){
        //    System.err.println("Invalid input. Program terminated");
        //}

        // catch(IllegalArgumentException illegalArgumentException){
        //   System.err.println("Invalid input. Program terminated");

        //    }
        //  catch(NoSuchElementException noSuchElementException){
        //     System.err.println("Invalid input. Program terminated");

        //}

        // if(askShouldContinueForMainMenu()>0 && askShouldContinueForMainMenu()<4){
        int inp =0;
        String filename = "output.txt";
        for(int i=0; inp!=3; i++ ){
            while(inp == 0){
            try {
                inp = askShouldContinueForMainMenu();
            } catch (InputMismatchException inputMismatchException){
                System.err.println("Error, incorrect input");
            } catch ( NoSuchElementException  noSuchElementException){
                System.err.println("Invalid input. Program terminated");
            } catch (NumberFormatException numberFormatException){
                System.err.println("Invalid input. Program terminated");

            }
            }

            while(inp < 4 || inp > 0) {
                switch (inp) {

                    // if (inp == 1) {


                    // option1 - create a new list
                    case (1):
                       // System.out.println("Enter a filename for the output");
                      //String name =input.next();

                      // filename = name;

                         System.out.println("The file new for the new list is: ");
                         System.out.println(filename);
                         processTaskItems(filename);


                         //processTaskItems(num);
                         // writeData();
                         System.out.println("-------------");
                         // break;

                        // }

                        //option 2 - load an existing list
                        ///  if (inp == 2) {
                    case (2):
                        //enter the existing list that you want to update

                        processTaskItems(filename);


                        System.out.println("--------------");
                        //  break;

                    case (3):
                        System.out.println("End");
                        System.exit(1);


                }



            }


        }


    }


    public TaskItem getTaskItemData() {
        TaskItem data;
        data = null;
        while(true) {
            try {
                String mark = getmarked();
                String title = getTitle();
                String description = getDescription();
                String duedate = getDueDate();

                data = new TaskItem(mark, title, description,duedate);
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println("Invalid argument...");
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Invalid Input");
            }
        }
        return data;
    }




    //Secondary Menu
    void processTaskItems(String file) {
        int num = 0;

        for(int j =0; num!=8; j++) {

            num = askOperationOnSecondaryMenu();

            while(num!=8) {
                switch (num) {

//option 1 - view list

                    case (1):

                        try {
                            File myList = new File(file);
                            Scanner reader = new Scanner(myList);
                            int i = 0;
                            while (reader.hasNext()) {

                                // int o = reader.nextInt();
                                //System.out.println(o);
                                String mark = reader.nextLine();
                                String title = reader.nextLine();
                                String description = reader.nextLine();
                                String dueDate = reader.nextLine();
                                //if(description != null)


                                System.out.println( " "+ mark + title + description + dueDate);
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

                        writeData(file);
                        num = 0;
                        processTaskItems(file);
                        break;

//option 2 - add to list

                    case (2):

                    TaskItem data = getTaskItemData();

                       storeItemsData(data);

                        // return;
                        num = 0;
                        processTaskItems(file);

                        break;



//option 3 - edit list

                    case (3):
                        int number = 0;
                        TaskItem dataEditor =  getTaskItemData();

                        removeItemsData(dataEditor, number , file);

                        try {
                            File myList = new File(file);
                            Scanner reader = new Scanner(myList);
                            int i = 0;
                            while (reader.hasNext()) {

                                // int o = reader.nextInt();
                                //System.out.println(o);
                                String mark = reader.nextLine();
                                String title = reader.nextLine();
                                String description = reader.nextLine();
                                String dueDate = reader.nextLine();
                                //if(description != null)


                                System.out.println(" "+ mark + title + description + dueDate);
                                i++;
                            }
                            reader.close();
                        } catch (FileNotFoundException fileNotFoundException) {
                            System.out.println("Error, cannot find file");
                            fileNotFoundException.printStackTrace();
                        }

                        writeData(file);




                        num = 0;
                        processTaskItems(file);
                        break;



//option 4 - remove item from list

                    case (4):
                        //TaskItem dataRemover = getTaskItemData();
                        //removeItemsData(dataRemover);

                        num = 0;
                        processTaskItems(file);
                        break;




//option 5 - mark item in list

                    case (5):


                        try {
                            File myList = new File(file);
                            Scanner reader = new Scanner(myList);
                            int i = 0;
                            while(reader.hasNext()){
                                // String[] mark = new String[i];

                                // int o = reader.nextInt();
                                //System.out.println(o);
                                reader.hasNext();
                                String mark = reader.nextLine();
                                System.out.println(" "+ mark);

                                String mark1 = getmarked();
                                System.out.println(" " + mark1 );

                                reader.hasNext();
                                String title = reader.nextLine();
                                reader.hasNext();
                                String description = reader.nextLine();
                                reader.hasNext();
                                String dueDate = reader.nextLine();
                                //if(description != null)


                                System.out.println(i + ") " + mark1 + title + description + dueDate);
                                i++;
                               String[] arraylist = {" " + mark1 + title + description + dueDate};
                                try (Formatter output = new Formatter("output.txt")) {

                                    output.format(String.valueOf(arraylist));
                                }
                            }
                            reader.close();


                        } catch (FileNotFoundException fileNotFoundException) {
                            System.out.println("Error, cannot find file");
                            fileNotFoundException.printStackTrace();
                        }

                        writeData(file);


                        num = 0;
                        processTaskItems(file);
                        break;
/*
                    if(mark[i].equals(" ") ){
                        System.out.println("Which array would you like to mark as completed?");
                        mark[i] = "***";
                        System.out.println(" " + mark[i] + title + description + dueDate);
                    }

 */


//option 6 - unmark item in list

                    case (6):


                        try {
                            File myList = new File(file);
                            Scanner reader = new Scanner(myList);
                            int i = 0;
                            while(reader.hasNext()){
                                // String[] mark = new String[i];

                                // int o = reader.nextInt();
                                //System.out.println(o);
                                reader.hasNext();
                                String mark = reader.nextLine();
                                System.out.println(" "+ mark);

                                String mark2 = getmarked();
                                System.out.println(" " + mark2 );

                                reader.hasNext();
                                String title = reader.nextLine();
                                reader.hasNext();
                                String description = reader.nextLine();
                                reader.hasNext();
                                String dueDate = reader.nextLine();
                                //if(description != null)


                                System.out.println(" " + mark2 + title + description + dueDate);
                                i++;
                                try (Formatter output = new Formatter("output.txt")) {

                                    output.format(" " + mark2 + title + description + dueDate);
                                }
                            }
                            reader.close();


                        } catch (FileNotFoundException fileNotFoundException) {
                            System.out.println("Error, cannot find file");
                            fileNotFoundException.printStackTrace();
                        }

                        writeData(file);


                        num = 0;
                        processTaskItems(file);
                        break;



//option 7 - save list

                    case (7):
                        num = 0;
                        processTaskItems(file);
                        System.out.println("list is saved in " + file);
                        break;


                }

                processTaskList();

            }

        }

/*
      ///try {
            int requestPt2;
            do {
                System.out.printf("List Operation Menu: %n%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s",
                        "1) - view the list",
                        "2) - add an item",
                        "3) - edit an item",
                        "4) - remove an item",
                        "5) - mark an item as completed",
                        "6) - unmark an item as completed",
                        "7) - save the current list",
                        "8) - quit to the main menu");
                System.out.printf("%n?");


                requestPt2 = input.nextInt();


                if (requestPt2 == 1) {
                    //  operationOne();
                }

                if (requestPt2 == 2) {

                }

                if (requestPt2 == 3) {

                }

                if (requestPt2 == 4) {

                }

                if (requestPt2 == 5) {

                }

                if (requestPt2 == 6) {

                }

                if (requestPt2 == 7) {

                }

                if (requestPt2 == 8) {
                    return;
                }


            } while (requestPt2 < 1 || requestPt2 > 8);


            //   }
            //  catch (Exception e){
            //    e.printStackTrace();
            // }
        }

 */


    }





    private static int askShouldContinueForMainMenu() {

            System.out.printf("%n Enter request for task list %n%s %n%s %n%s",
                    "1 - Create a new task list",
                    "2 - Load an existing task list",
                    "3 - Quit");
            System.out.printf("%n?");
            int request = Integer.parseInt(input.nextLine());


        return request;
    }

    private static int askIndexToBeMarked(){
        System.out.println("Which array task would you like to mark as completed?");

        int request = Integer.parseInt(input.nextLine());
        return request;
    }

    private static int askOperationOnSecondaryMenu() {
        System.out.printf("List Operation Menu: %n%s %n%s %n%s %n%s %n%s %n%s %n%s %n%s",
                "1) - view the list",
                "2) - add an item",
                "3) - edit an item",
                "4) - remove an item",
                "5) - mark an item as completed",
                "6) - unmark an item as completed",
                "7) - save the current list",
                "8) - quit to the main menu");
        System.out.printf("%n?");
        int reqPartTwo = Integer.parseInt(input.nextLine());

        return reqPartTwo;
    }

    public static void main(String[] args) {
        App access = new App();
        access.processTaskList();

















/*
        int request = 3;
        try{
            do{
                System.out.printf("%n Enter request for task list %n%s %n%s %n%s",
                        "1 - Create a new task list",
                        "2 - Load an existing task list",
                        "3 - Quit");
                System.out.printf("%n?");
                request = input.nextInt();
                if( request == 3 ){
                    System.exit(1);
                }
                if ( request == 2){

               //   TaskList array = new TaskList();
                  TaskList.operationsMenu();
                  request = 0;

                }
                if (request == 1){


                    request = 0;

                }
            } while (request< 1 || request >3);
        }
        catch(InputMismatchException inputMismatchException){
                System.err.println("Invalid input. Program terminated");
            }

        catch(IllegalArgumentException illegalArgumentException){
               System.err.println("Invalid input. 2Program terminated");

        }
        catch(NoSuchElementException noSuchElementException){
            System.err.println("Invalid input. 3Program terminated");

        }


        if (request == 2){
            System.out.println("yes");
        }




    }
*/

    }
}
