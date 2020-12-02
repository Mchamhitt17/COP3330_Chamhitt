import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {




    @Test
    public void addingItemsIncreasesSize() {
        ArrayList<ContactItem> contact = new ArrayList<>();
        ContactItem data = new ContactItem("Billy", "Jean","123-432-3454","MyE@email.com");
        contact.add(data);
        data = new ContactItem("Johnny", "Baboon","122-408-2054","YourE@email.com");
        contact.add(data);

        assertEquals(2,contact.size());


    }

    @Test
    public void editingItemsFailsWithAllBlankValues() {


    }

    @Test
    public void editingItemsFailsWithInvalidIndex() {

    }

    @Test
    public void editingSucceedsWithBlankFirstName() {

    }

    @Test
    public void editingSucceedsWithBlankLastName() {

    }

    @Test
    public void editingSucceedsWithBlankPhone() {

    }



    @Test
    public void editingSucceedsWithNonBlankValues() {

    }

    @Test
    public void newListIsEmpty() {

    }

    @Test
    public void removingItemsDecreasesSize() {
        ArrayList<ContactItem> contact = new ArrayList<>();
        ContactItem data = new ContactItem("Billy", "Jean","123-432-3454","MyE@email.com");
        contact.add(data);
        data = new ContactItem("Johnny", "Baboon","122-408-2054","YourE@email.com");
        contact.add(data);

        assertEquals(2,contact.size());

        contact.remove(1);
        assertEquals(1,contact.size());

    }


    @Test
    public void  removingItemsFailsWithInvalidIndex() {
        ArrayList<ContactItem> contact = new ArrayList<>();
        ContactItem data = new ContactItem("Billy", "Jean","123-432-3454","MyE@email.com");
        contact.add(data);
        data = new ContactItem("Johnny", "Baboon","122-408-2054","YourE@email.com");
        contact.add(data);


       // assertThrows(ContactList.InvalidIndex.class,() -> contact.remove(4));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> contact.remove(4));

    }


    @Test
    public void savedContactListCanBeLoaded() {

    }








}