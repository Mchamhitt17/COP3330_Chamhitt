public class TaskItem {
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
            throw new InvalidDueDateException("Duedate is not valid; must be at least 1 character" +
                    " long and in the form of YYYY-MM-DD");
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

