import java.util.Scanner;
import java.io.Serializable;

public class ContactItem implements Serializable {
    private static Scanner input = new Scanner(System.in);
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;



    public ContactItem(String firstName, String lastName, String phoneNumber, String emailAddress) {
        int test = 4;


        //if (isFirstNameLengthValid(firstName) == true || isLastNameLengthValid(lastName) == true ||
        //       isPhoneNumberLengthValid(phoneNumber) == true || isEmailLengthValid(emailAddress) == true) {

            if (firstName != "" || lastName != "" || phoneNumber != "" || emailAddress != "") {

                if (isFirstNameLengthValid(firstName)) {

                    this.firstName = firstName;

                } else {
                   // this.firstName = blankfirstName(firstName);
                  throw new InvalidFirstNameException("Nothing has been entered for first name");
                    //test = test - 1;
                }

                if (isLastNameLengthValid(lastName)) {

                    this.lastName = lastName;

                } else {
                  //  this.lastName = blanklastName(lastName);
                   throw new InvalidLastNameException("Nothing has been entered for last name");
                    //  test = test - 1;
                }

                if (isPhoneNumberLengthValid(phoneNumber)) {

                    this.phoneNumber = phoneNumber;

                } else {
                //    this.phoneNumber = blankPhoneNumber(phoneNumber);
                   throw new InvalidPhoneNumberException("Nothing has been entered for phone number");
                    //  test = test - 1;
                }

                if (isEmailLengthValid(emailAddress)) {

                    this.emailAddress = emailAddress;
                } else {
                    //this.emailAddress = blankEmailAddressNumber(emailAddress);
                    throw new InvalidEmailException("Nothing has been entered for email");

                }

/*
            if (isFirstNameLengthValid(firstName) == false || isLastNameLengthValid(lastName) == false ||
                    isPhoneNumberLengthValid(phoneNumber) == false || isEmailLengthValid(emailAddress) == false) {
                throw new InvalidValuesException("Atleast one item should be filled");
            }
            */
            } else {
                throw new InvalidValuesException("Atleast one item should be filled");
            }

       // } catch (InputMismatchException inputMismatchException) {
          //  inputMismatchException.printStackTrace();
      //  }

    }

            // }else if (this.firstName.equals("") && this.lastName.equals("") &&
            //           this.phoneNumber.equals("") && this.emailAddress.equals("")) {
            //       throw new InvalidValuesException("Atleast one item should be filled");


            //   if(this.firstName.equals("") && this.lastName.equals("") &&
            //  this.phoneNumber.equals("") && this.emailAddress.equals("") )




    public boolean isFirstNameLengthValid(String firstName){
        return firstName.length() >= 0;
    }

    public boolean isLastNameLengthValid(String lastName){
        return lastName.length() >= 0;
    }

    public boolean isPhoneNumberLengthValid(String phoneNumber){
        return phoneNumber.length() >= 0;
    }

    public boolean isEmailLengthValid(String emailAddress){
        return emailAddress.length() >= 0;
    }

    public String blankfirstName(String firstName) {
        String res = null;
        if(isFirstNameLengthValid(firstName) == true){
            res = "";

        }
        return res;
    }

    public String blanklastName(String lastName) {
        String res = null;
        if(isLastNameLengthValid(lastName) == true){
            res = "";

        }
        return res;
    }


    public String blankPhoneNumber(String phoneNumber) {
        String res = null;
        if(isPhoneNumberLengthValid(phoneNumber) == true){
            res = "";

        }
        return res;
    }

    public String blankEmailAddressNumber(String emailAddress) {
        String res = null;
        if(isEmailLengthValid(emailAddress) == true){
            res = "";

        }
        return res;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


    public String editFirstName(String firstName){
        if(firstName.length() >= 0) {
            this.firstName = firstName;
        } else {
            throw new InvalidFirstNameException("Invalid input");
        }
        return this.firstName;
    }

    public String editLastName(String lastName){
        if (lastName.length() >= 0) {

            this.lastName = lastName;
        } else {
            throw new InvalidLastNameException("Invalid input");
        }
        return this.lastName;
    }


    public String editPhone(String phoneNumber){

        if(phoneNumber.length() >= 0) {
            this.phoneNumber = phoneNumber;
        }
        else {
            throw new InvalidPhoneNumberException("Invalid input") ;
        }
        return this.phoneNumber ;
    }

    public String editEmail(String emailAddress) {

        if (emailAddress.length() >= 0) {
            this.emailAddress = emailAddress;
        } else{
            throw new InvalidEmailException("Invalid input");
         }
    return this.emailAddress;
    }




    public boolean ifEditAllisValid(String firstName, String lastName, String phoneNumber, String emailAddress){

            if (emailAddress == "" && firstName == "" &&
                    lastName == "" && phoneNumber == "") {

            throw new InvalidValuesException("Atleast one item must be filled");
        } else{
                return true;
            }


    }


    @Override
    public String toString() {
        return "===ContactItem===\n" +
                "FirstName: " + firstName  +"\n" +
                "LastName: " + lastName  +"\n" +
                "PhoneNumber: " + phoneNumber  +"\n"+
                "EmailAddress: " + emailAddress;
    }



    class InvalidValuesException extends IllegalArgumentException {
        public InvalidValuesException (String msg) {
            super(msg);
        }
    }


class InvalidLastNameException extends IllegalArgumentException {
    public InvalidLastNameException (String msg) {
        super(msg);
    }
}


class InvalidFirstNameException extends IllegalArgumentException {
    public InvalidFirstNameException (String msg) {
        super(msg);
    }
}


class InvalidPhoneNumberException extends IllegalArgumentException {
    public InvalidPhoneNumberException (String msg) {
        super(msg);
    }
}


class InvalidEmailException extends IllegalArgumentException {
    public InvalidEmailException (String msg) {
        super(msg);
    }
}

}
