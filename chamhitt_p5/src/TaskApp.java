import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TaskApp {

    private static Scanner input = new Scanner(System.in);
    private static TaskList listedTask;


    public TaskApp() {
        listedTask = new TaskList();
    }

    // add data
    private void addData() {


        listedTask.add();
    }


    //remove data
    private void removeData() {

        listedTask.remove();


    }


    private static void viewData(String filename) {
        listedTask.view(filename);

    }

/*
    private void editData() {

        listedTask.edit();


    }
*/
    private void editData() {
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
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Incorrent input. Must be either add or remove ");
        } catch (NoSuchElementException noSuchElementException) {
            noSuchElementException.getStackTrace();
        }

    }










/*
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


*/

    //private void viewItemsData(TaskItem data ) {
    //  listedTask.view(data, "output.txt");
    // }



    /*
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
*/



/*
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
*/








/*
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

*/


    public static void displayMenu(int optNumber[], String itemsOptions[]) {
        //Display menu option
        System.out.println("List Operation Menu for Task");
        System.out.println("---------");
        for (int i = 0; i < optNumber.length; i++) {
            System.out.println(optNumber[i] + ") " + itemsOptions[i]);
        }
        System.out.println("---------");

    }


    public void menu(String filename) {
        int choiceTask;

        ArrayList<String> list2 = new ArrayList<>();
        int optNumber[] = {1, 2, 3, 4, 5, 6, 7, 8};

        String itemOptions[] = {"view the list", " add an item",
                "edit an item", "remove an item", "mark an item as completed",
                "unmark an item as completed", "save the current list", "quit to the main menu"};
        displayMenu(optNumber, itemOptions);

        choiceTask = input.nextInt();
        int quitToMain = optNumber.length;
        TaskApp access = new TaskApp();
        while (choiceTask != quitToMain) {
            //option 1
            if (choiceTask == optNumber[0]) {
                System.out.println(itemOptions[0]);
                //view or read  the list
                viewData(filename);

            }
            //option 2
            else if (choiceTask == optNumber[1]) {
                System.out.println(itemOptions[1]);
                //add to the list
                addData();
            }
            //option 3
            else if (choiceTask == optNumber[2]) {
                System.out.println(itemOptions[2]);
                //edit an item

                viewData(filename);

                editData();
            }
            //option 4
            else if (choiceTask == optNumber[3]) {
                System.out.println(itemOptions[3]);
                //remove an item

                viewData(filename);

                removeData();
                viewData(filename);
            }
            //option 5
            else if (choiceTask == optNumber[4]) {
                System.out.println(itemOptions[4]);
                //mark an item

            }
            //option 6
            else if (choiceTask == optNumber[5]) {
                System.out.println(itemOptions[5]);
                //unmark an item
            }
            //option 7
            else if (choiceTask == optNumber[6]) {
                System.out.println(itemOptions[6]);
                //save current list
            }

            displayMenu(optNumber, itemOptions);

            choiceTask = input.nextInt();
        }


    }


    public static void main(String filename) {
        TaskApp access = new TaskApp();
        access.menu(filename);

    }
}