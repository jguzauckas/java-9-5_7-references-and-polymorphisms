package Notes.Books;

public class Main {
    public static void main(String[] args) {
        Novel favoriteNovel = new Novel("The Way of Kings", "Brandon Sanderson", 1001, "Fantasy");
        Book favoriteBook = new Novel("The Way of Kings", "Brandon Sanderson", 1001, "Fantasy");

        System.out.println(favoriteBook.getTitle());
        System.out.println(favoriteBook);
    }
}
