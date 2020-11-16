import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;


public class TaskList {


    List<TaskItem> items;


    public TaskList() {
        items = new ArrayList<>();
    }


    public TaskList markWorthy(String s) {

        try (Formatter output = new Formatter(s)) {
            for (int i = 0; i < items.size(); i++) {

                TaskItem data = items.get(i);
                output.format(i + ") %s %n %s %n %s %n %s %n", data.getMarked(), data.getTitle(), data.getDescription(), data.getDueDate());

            }
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;

    }


    public TaskList add(TaskItem data) {
        items.add(data);
        return null;
    }


    public TaskList remove(TaskItem data) {
        items.remove(data);
        return null;
    }


    public TaskList write(String filename) {
        try (Formatter output = new Formatter(filename)) {
            for (int i = 0; i < items.size(); i++) {
                TaskItem data = items.get(i);
                output.format(i + ") %s %n %s %n %s %n %s %n", data.getMarked(), data.getTitle(), data.getDescription(), data.getDueDate());
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public TaskList remove(TaskItem data, int numberi, String filename) {
        try (Formatter output = new Formatter(filename)) {

            for (int i = 0; i < items.size(); i++) {
                if (i == numberi) {
                    items.remove(data);
                }
            }

            for (int i = 0; i < items.size(); i++) {
                data = items.get(i);

                output.format(i + ") %s %n %s %n %s %n %s %n", data.getMarked(), data.getTitle(), data.getDescription(), data.getDueDate());
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}





