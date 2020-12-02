import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    @Test
    public void constructorFailsWithInvalidDueDate() {
        assertThrows(TaskItem.InvalidDueDateException.class, () ->new TaskItem(" ","Task1", "This is a test", "2002002-20"));

    }

    @Test
    public void constructorFailsWithInvalidTitle() {
        assertThrows(TaskItem.InvalidTitleException.class, () ->new TaskItem(" ","", "This is a test", "2002-05-"));

    }


    @Test
    public void constructorSucceedsWithValidDueDate() {
        TaskItem item = new TaskItem("","Task 2", "This is a test", "2002-05-21");
        assertEquals("2002-05-21", item.getDueDate());

    }


    @Test
    public void constructorSucceedsWithValidTitle() {
        TaskItem item = new TaskItem("","Task 2", "This is a test", "2002-05-21");
        assertEquals("Task 2", item.getTitle());
    }

    @Test
    public void editingDescriptionSucceedsWithExpectedValue() {
        TaskItem item = new TaskItem("","Task 2", "This is a test", "2002-10-20");
        assertEquals("This is test 2",item.editDescription("This is test 2"));
    }

    @Test
    public void editingDueDateFailsWithInvalidDateFormat() {
        TaskItem item = new TaskItem("","Task 2", "This is a test", "2002-10-20");
        assertThrows(TaskItem.InvalidDueDateException.class, () -> item.editDueDate("October 20, 2002"));

    }


    @Test
    public void editingDueDateFailsWithInvalidYYYMMDD() {
        TaskItem item = new TaskItem("","Task 2", "This is a test", "2002-10-20");
        assertThrows(TaskItem.InvalidDueDateException.class, () -> item.editDueDate("2002-10-1"));

    }


    @Test
    public void editingDueDateSucceedsWithExpectedValue() {
        TaskItem item = new TaskItem("","Task 2", "This is a test", "2002-10-30");
      //  assertThrows(TaskItem.InvalidTitleException.class, () -> item.editDueDate("2002-05-21"));
        assertEquals("2002-05-21", item.editDueDate("2002-05-21"));
    }

    @Test
    public void editingTitleFailsWithEmptyString() {
        TaskItem item = new TaskItem("","Task 2", "This is a test", "2002-05-21");
        assertThrows(TaskItem.InvalidTitleException.class, () -> item.editTitle(""));

    }
    // assertThrows(ContactItem.InvalidValuesException.class, () -> item.ifEditAllisValid(item.editFirstName(""),  item.editLastName(""),item.editPhone(""),item.editEmail("")));
    @Test
    public void editingTitleSucceedsWithExpectedValue() {
        TaskItem item = new TaskItem("","Task 2", "This is a test", "2002-05-21");
        assertEquals("Title 1",item.editTitle("Title 1"));
    }


}