import java.io.Serializable;

public class TaskItem implements Serializable{
    private String title;
    private String description;
    private String dueDate;
    private String marked;


    public TaskItem(String marked, String title, String description, String dueDate) {

        if(isTitleValid(title)) {
            this.title = title;
        } else {
            throw new InvalidTitleException("Title is not valid; must be at least 1 character long");
        }

        this.marked = marked;

        if(isDescriptionValid(description)) {
            this.description = description;
        } else {
            throw new InvalidDescriptionException("Description is not valid; must be at least 1 character long");
        }


        if(validDueDate(dueDate)) {
            this.dueDate = dueDate;
        } else {
            throw new InvalidDueDateException("Duedate is not valid; must be at least 1 character long and in the form of YYYY-MM-DD");
        }
    }

    public String getTitle() {

        return title;
    }
    public boolean isTitleValid(String title) {
        return title.length() > 0;
    }



    public String setTitle(String title) {
        if(isTitleValid(title)) {
            this.title = title;
        } else {
            throw new InvalidTitleException("Title is not valid; must be at least 1 character long");
        }
        return this.title;

    }


    public String getDescription() {


        return description;
    }

    public boolean isDescriptionValid(String description) {
        return description.length() > 0;
    }

    public boolean validDueDate(String dueDate){
        return dueDate.length() == 10 &&
                dueDate.charAt(0) != '0' &&
                dueDate.charAt(4) == '-' &&
                dueDate.charAt(7) == '-';

    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {

        return dueDate;
    }

    public void setDueDate(String dueDate) {

        this.dueDate = dueDate;
    }

    public String getMarked() {
        return marked;
    }


    public void setMarked(String marked) {
        this.marked = marked;
    }

    public String editTitle(String title){
        if(isTitleValid(title) == true){
            this.title = title;
        } else{
        throw new InvalidTitleException("Title is not valid; must be at least 1 character long");
     }
        return this.title;
    }

    public String editDescription(String description){
        if(isDescriptionValid(description) == true) {
            this.description = description;
        } else{
            throw new InvalidDescriptionException("Description is not valid; must be at least 1 character long");
        }
        return this.description;
    }


    public String editDueDate(String dueDate){
        try {
            if (validDueDate(dueDate) == true) {
                this.dueDate = dueDate;
            }
              //  throw new InvalidDueDateException("Duedate is not valid, must be in the form of YYYY-MM-DD");

        }catch (InvalidDueDateException invalidDueDateException){
            System.err.printf("Duedate is not valid, must be in the form of YYYY-MM-DD");
        }
        return this.dueDate;
    }

    public boolean ifEditAllTasksValid(String marked, String title, String description, String dueDate){

        if (marked == "" && title == "" &&
                description == "" && dueDate == "") {

            throw new TaskItem.InvalidValuesException("Atleast one item must be filled");
        } else{
            return true;
        }


    }
/*
    public String editEmail(String emailAddress) {

        if (emailAddress.length() >= 0) {
            this.emailAddress = emailAddress;
        } else{
            throw new ContactItem.InvalidEmailException("Invalid input");
        }
        return this.emailAddress;
    }
 */



    @Override
    public String toString() {
        return "===TaskItem===\n" +
                "Completion: " + marked  +"\n" +
                "Title: " + title  +"\n" +
                "Description: " + description  +"\n"+
                "Duedate: " + dueDate;
    }


    class InvalidValuesException extends IllegalArgumentException {
        public InvalidValuesException (String msg) {
            super(msg);
        }
    }


    class InvalidTitleException extends IllegalArgumentException {
        public InvalidTitleException(String msg) {
            super(msg);
        }
    }

    class InvalidDescriptionException extends IllegalArgumentException {
        public InvalidDescriptionException(String msg) {
            super(msg);
        }
    }


    class InvalidDueDateException extends IllegalArgumentException {
        public InvalidDueDateException(String msg) {
            super(msg);
        }
    }


    class InvalidMarkException extends IllegalArgumentException {
        public InvalidMarkException(String msg) {
            super(msg);
        }
    }
}


