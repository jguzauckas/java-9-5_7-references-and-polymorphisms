package Notes.Books;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Novel favoriteNovel = new Novel("The Way of Kings", "Brandon Sanderson", 1001, "Fantasy");
        Book favoriteBook = new Novel("The Way of Kings", "Brandon Sanderson", 1001, "Fantasy");

        System.out.println(favoriteBook.getTitle());
        System.out.println(favoriteBook);

        ArrayList<Book> library = new ArrayList<Book>();
        library.add(new Book("La machine de Turing", "Alan Turing", 174));
        library.add(new Novel("The Way of Kings", "Brandon Sanderson", 1001, "Fantasy"));
        library.add(new PictureBook("If You Give a Mouse a Cookie", "Laura Joffe Numeroff", 40, "Felicia Bond"));
        library.add(new Textbook("Introduction to Algorithms", "Thomas H. Cormen", 1292, "Computer Science", 3));
        
        for (Book book : library) {
            System.out.println(book);
        }

        Book favBook1 = new Book("The Way of Kings", "Brandon Sanderson", 1001);
        Book favBook2 = new Book("The Way of Kings", "Brandon Sanderson", 1001);
        System.out.println(favBook1.equals(favBook2));

        Novel favNovel1 = new Novel("The Way of Kings", "Brandon Sanderson", 1001, "Fantasy");
        Novel favNovel2 = new Novel("The Way of Kings", "Brandon Sanderson", 1036, "Fiction");
        System.out.println(favNovel1.equals(favNovel2));

        Textbook favText1 = new Textbook("Introduction to Algorithms", "Thomas H. Cormen", 1292, "Computer Science", 3);
        Textbook favText2 = new Textbook("Introduction to Algorithms", "Thomas H. Cormen", 1292, "Computer Science", 4);
        System.out.println(favText1.equals(favText2));
        
    }
}
