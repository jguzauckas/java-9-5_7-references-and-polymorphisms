package Notes.Books;

public class Textbook extends Book {
    private String subject;
    private int edition;

    public Textbook() {
        super();
        this.subject = "";
        this.edition = 0;
    }

    public Textbook(String title, String author, int pagecount, String subject, int edition) {
        super(title, author, pagecount);
        this.subject = subject;
        this.edition = edition;
    }

    public String toString() {
        return this.subject + " Textbook \"" + super.getTitle() + "\", Edition " + this.edition + " by " + super.getAuthor();
    }

    public boolean equals(Textbook other) {
        if (super.equals(other) && this.edition == other.edition) {
            return true;
        }
        return false;
    }

    public String getSubject() {
        return this.subject;
    }

    public int getEdition() {
        return this.edition;
    }
}
