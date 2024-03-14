package Notes.Books;

public class PictureBook extends Book {
    private String illustrator;

    public PictureBook() {
        super();
        this.illustrator = "";
    }

    public PictureBook(String title, String author, int pagecount, String illustrator) {
        super(title, author, pagecount);
        this.illustrator = illustrator;
    }

    public String toString() {
        return "Picturebook \"" + super.getTitle() + "\" written by " + super.getAuthor() + " and illustrated by " + this.illustrator;
    }

    public String getIllustrator() {
        return this.illustrator;
    }
}
