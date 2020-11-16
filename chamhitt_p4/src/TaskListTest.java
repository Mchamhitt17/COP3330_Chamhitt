import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TaskListTest {

    @Test
    public void addingTaskItemsIncreasesSize() {
        //TaskList<String> items = new TaskList().write("output.txt");
        //(List<TaskItem>) new TaskList();

        //   assertEquals(1,items.write(data));
/*
        TaskItem categories = (TaskItem) asList("one", "two", "three");
        TaskList items = new TaskList().add(categories);
          assertEquals(1, items.get(items));
*/

        TaskList m =  new TaskList();

     //   assertEquals(1,m.add(data));
    }

    @Test
    public void completingTaskItemChangesStatus(){
        TaskList list = new TaskList();

    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex(){
        App access = new App();
    }

    @Test
    public void editingTaskItemChangesValues(){

    }

    @Test
    public void editingTaskItemDescriptionChangesValue(){

    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){

    }

    @Test
    public void editingTaskItemDueDateChangesValue(){

    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){

    }

    @Test
    public void editingTaskItemTitleChangesValue(){

    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex(){

    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex(){
       // assertThrows(TaskItem.InvalidDescriptionException.class, () ->new TaskItem(" ","Task", "", "2002-05-"));
        TaskItem m =  new TaskItem(" ", "Test", "Test1","2002-02-02");
        assertEquals(false, m.isDescriptionValid(""));

    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex(){
        TaskItem m =  new TaskItem(" ", "Test", "Test1","2002-02-02");
        assertEquals(true, m.isDescriptionValid("Test1"));
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex(){
        TaskItem m =  new TaskItem(" ", "Test", "Test1","2002-02-02");
        assertEquals(false, m.validDueDate("0000-11-02"));
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex(){
        TaskItem m =  new TaskItem(" ", "Test", "Test1","2002-02-02");
        assertEquals(true, m.validDueDate("2020-11-02"));
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex(){
        TaskItem m =  new TaskItem(" ", "Test", "Test1","2002-02-02");
        assertEquals(false, m.isTitleValid(""));
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex(){
        TaskItem m =  new TaskItem(" ", "Test", "Test1","2002-02-02");
        assertEquals(true, m.isTitleValid("Title 1"));
    }

    @Test
    public void newTaskListIsEmpty(){

    }

    @Test
    public void removingTaskItemsDecreasesSize(){

    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex(){

    }

    @Test
    public void savedTaskListCanBeLoaded(){

    }

    @Test
    public void uncompletingTaskItemChangesStatus(){

    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){

    }



}