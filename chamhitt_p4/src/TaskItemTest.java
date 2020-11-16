import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TaskItemTest {



    //expecting a fail
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){

   // assertEquals("2002-05-", item.getDueDate() );

   // assertThrows(TaskItem.InvalidDueDateException.class, () -> new TaskItem(" ","Task1","Descrip1", "2002-05-21"));
      //  TaskItem item = new TaskItem("","Task 2", "This is a test", "2002-05-");
    //    assertThrows("2002-05-21", item.getDueDate());

        assertThrows(TaskItem.InvalidDueDateException.class, () ->new TaskItem(" ","Task1", "This is a test", "2002002-20"));

    }

//expecting a fail
    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
       // TaskItem item = new TaskItem("","324", "This is a test", "2002-05-21");
        //assertThrows( "", item.getTitle());

        assertThrows(TaskItem.InvalidTitleException.class, () ->new TaskItem(" ","", "This is a test", "2002-05-"));
    }

    //expecting a success
    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
        TaskItem item = new TaskItem("","Task 2", "This is a test", "2002-05-21");
        assertEquals("2002-05-21", item.getDueDate());

    }

    //expecting a success
    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        TaskItem item = new TaskItem("","Task 2", "This is a test", "2002-05-21");
        assertEquals("Task 2", item.getTitle());

    }

    //expecting a success
    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate(){
        TaskItem item = new TaskItem("","Task 2", "This is a test", "2002-05-21");
        assertEquals("2002-05-21", item.getDueDate());

    }

    //expecting a fail
    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle(){
       // TaskItem item = new TaskItem("***","Task 2", "This is a test", "2002-05-21");

       // assertEquals("Task", item.setTitle());
        assertThrows(TaskItem.InvalidTitleException.class, () ->new TaskItem(" ","", "This is a test", "2002-05-"));

    }

    //expecting a success
    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle(){
    TaskItem item = new TaskItem("***","Task 2", "This is a test", "2002-05-21");

        assertEquals("Task 2",  item.setTitle("Task 2"));

    }





}