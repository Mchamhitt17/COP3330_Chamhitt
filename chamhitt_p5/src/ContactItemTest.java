import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {
    @Test
    public void creationFailsWithAllBlankValues() {
       // ContactItem item = new ContactItem("","","","");
        assertThrows(ContactItem.InvalidValuesException.class, () ->new ContactItem("","", "", ""));

    }


    @Test
    public void creationSucceedsWithBlankEmail() {
        ContactItem item = new ContactItem("Name","","","");
        assertEquals("",item.getEmailAddress());
    }

    @Test
    public void creationSucceedsWithBlankFirstName() {
        ContactItem item = new ContactItem("","last","","");
        assertEquals("",item.getFirstName());
    }

    @Test
    public void creationSucceedsWithBlankLastName(){
        ContactItem item = new ContactItem("","","","1234@email.com");
        assertEquals("",item.getLastName());
    }


    @Test
    public void creationSucceedsWithBlankPhone() {
        ContactItem item = new ContactItem("","Joe","","");
        assertEquals("",item.getPhoneNumber());
    }


    @Test
    public void creationSucceedsWithNonBlankValues() {

        //  assertDoesNotThrow(ContactItem.InvalidValuesException.class, () ->new ContactItem("MJ","Parker", "321-345-2341", "something@email.com"));
        assertDoesNotThrow( () ->new ContactItem("MJ","Parker", "321-345-2341", "something@email.com"));
    }


    @Test
    public void editingFailsWithAllBlankValues() {
        ContactItem item = new ContactItem("Bobby","Joe","","email@123.com");
        item.editFirstName("");
        item.editLastName("");
        item.editPhone("");
        item.editEmail("");

       // assertThrows(item.ifEditAllisValid(item.editFirstName(""),  item.editLastName(""),item.editPhone(""),item.editEmail("")).class,

        assertThrows(ContactItem.InvalidValuesException.class, () -> item.ifEditAllisValid(item.editFirstName(""),  item.editLastName(""),item.editPhone(""),item.editEmail("")));


        // assertThrows(ContactItem.InvalidValuesException.class, () ->new ContactItem("","", "", ""));
      //  ContactItem item = new ContactItem("","","","");


    }

    @Test
    public void editingSucceedsWithBlankEmail(){
        ContactItem item = new ContactItem("","Joe","","email@123.com");

     //   assertEquals("", item.editedEmail(""))"
        assertDoesNotThrow( () ->item.editEmail( ""));

    }


    @Test
    public void  editingSucceedsWithBlankFirstName() {
        ContactItem item = new ContactItem("Bobby","Joe","","email@123.com");

        //assertEquals("", item.editedEmail(""));
        assertDoesNotThrow( () ->item.editFirstName( ""));
    }



    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactItem item = new ContactItem("","Joe","","email@123.com");

        assertEquals("", item.editLastName(""));
    }

    @Test
    public void  editingSucceedsWithBlankPhone() {
        ContactItem item = new ContactItem("","Joe","123-234-4523","email@123.com");

        assertEquals("", item.editPhone(""));
    }


    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactItem item = new ContactItem("bob","","","");
        item.editFirstName("Bobby");
        item.editLastName("Joey");
        item.editPhone("123-432-4323");
        item.editEmail("emailYo@123.com");

        assertDoesNotThrow( () ->  item.ifEditAllisValid(  item.editFirstName("Bobby"), item.editLastName("Joey"),item.editPhone("123-432-4323"),  item.editEmail("emailYo@123.com")));



    }

    @Test
    public void  testToString() {
        ContactItem item = new ContactItem("Bobby","Joe","","email@123.com");
        assertEquals(item.toString(),"===ContactItem===\n" +
                "FirstName: Bobby\n" +
                "LastName: Joe\n" +
                "PhoneNumber: \n" +
                "EmailAddress: email@123.com");


    }






}