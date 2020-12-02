import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {
    @Test
    public void addingItemsIncreasesSize() {

        ArrayList<TaskItem> items = new ArrayList<>();
        TaskItem data = new TaskItem("***", "Task 1","This is test 1","2000-03-12");
        items.add(data);
        data = new TaskItem("   ", "Task2","This is test 2","1996-10-15");
        items.add(data);

        assertEquals(2,items.size());




    }

    @Test
    public void completingTaskItemChangesStatus() {
        /*
        ArrayList<TaskItem> items = new ArrayList<>();
        TaskItem data = new TaskItem("***", "Task 1","This is test 1","2000-03-12");
        items.add(data);
        data = new TaskItem("   ", "Task2","This is test 2","1996-10-15");
        items.add(data);
        */




    }



    @Test
    public void completingTaskItemFailsWithInvalidIndex() {

    }

    @Test
    public void  editingItemDescriptionFailsWithInvalidIndex() {
        ArrayList<TaskItem> items = new ArrayList<>();
        TaskItem data = new TaskItem("***", "Task 1","This is test 1","2000-03-12");
        items.add(data);
        data = new TaskItem("   ", "Task2","This is test 2","1996-10-15");
        items.add(data);

      //  assertThrows(IndexOutOfBoundsException.class, () -> items.remove(4));
      //  assertThrows(TaskItem.InvalidValuesException.class,() ->  )

    }

    @Test
    public void  editingItemDescriptionSucceedsWithExpectedValue() {

        TaskItem item = new TaskItem("","Task 2", "This is a test", "2002-05-21");
        assertEquals("This is a test", item.getDescription());

    }

    @Test
    public void  editingItemDueDateSucceedsWithExpectedValue() {
        TaskItem item = new TaskItem("","Task 2", "This is a test", "2002-05-21");
        assertEquals("2002-05-21", item.getDueDate());

    }

    @Test
    public void editingItemTitleFailsWithEmptyString() {

        assertThrows(TaskItem.InvalidTitleException.class, () ->new TaskItem(" ","", "Description", "2002-05-10"));

    }

    @Test
    public void  editingItemTitleFailsWithInvalidIndex() {

    }


    @Test
    public void editingItemTitleSucceedsWithExpectedValue() {

    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat(){

    }


    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {

    }


    @Test
    public void  editingTaskItemDueDateFailsWithInvalidYYYMMDD() {

    }


    @Test
    public void  gettingItemDescriptionFailsWithInvalidIndex() {

        assertThrows(TaskItem.InvalidDescriptionException.class, () ->new TaskItem(" ","Title", "", "2002-05-09"));

    }



    @Test
    public void gettingItemDescriptionSucceedsWithValidIndex() {

    }


    @Test
    public void gettingItemDueDateFailsWithInvalidIndex() {
        assertThrows(TaskItem.InvalidDueDateException.class, () ->new TaskItem(" ","Title", "describes", "2002-05-"));

    }



    @Test
    public void gettingItemDueDateSucceedsWithValidIndex() {

    }



    @Test
    public void gettingItemTitleFailsWithInvalidIndex() {

    }



    @Test
    public void gettingItemTitleSucceedsWithValidIndex() {

    }

    @Test
    public void newListIsEmpty() {

    }



    @Test
    public void removingItemsDecreasesSize() {
        ArrayList<TaskItem> items = new ArrayList<>();
        TaskItem data = new TaskItem("***", "Task 32","Describes 32","1954-12-01");
        items.add(data);
        data = new TaskItem("   ", "Task 4","Description 4","2022-09-01");
        items.add(data);

        assertEquals(2,items.size());

        items.remove(1);
        assertEquals(1,items.size());

    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {
        ArrayList<TaskItem> items = new ArrayList<>();
        TaskItem data = new TaskItem("***", "Task 32","Describes 32","1954-12-01");
        items.add(data);
        data = new TaskItem("   ", "Task 4","Description 4","2022-09-01");
        items.add(data);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> items.remove(4));

    }



    @Test
    public void savedTaskListCanBeLoaded() {

    }



    @Test
    public void uncompletingTaskItemChangesStatus() {

    }


    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){

    }



}