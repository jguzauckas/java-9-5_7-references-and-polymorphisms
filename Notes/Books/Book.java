package Notes.Books;

public class Book {
    private String title;
    private String author;
    private int pagecount;

    public Book() {
        this.title = "";
        this.author = "";
        this.pagecount = -1;
    } 

    public Book(String title, String author, int pagecount) {
        this.title = title;
        this.author = author;
        this.pagecount = pagecount;
    }

    public String toString() {
        return "\"" + this.title + "\" by " + this.author;
    }

    public String getTitle() {
        return this.title;
    }
    
    public String getAuthor() {
        return this.author;
    }
    
    public int getPagecount() {
        return this.pagecount;
    }
}
