import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookRepository {

    private List<Book> books = new ArrayList<>();

    public BookRepository () {
    }

    //add all books to the list
    public BookRepository(Collection<Book> books) {
        this.books.addAll(books);
    }

    // find book with that isbn
    public Book findByIsbn(String isbn) {
        for(Book book : books) {
            if(book.getIsbn() == isbn) {
                return book;
            }
        }
        return null;
    }

    //find book with that title
    public Book findByTitle(String title) {
        for(Book book : books) {
            if(book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> findByTitleContains(String search) {
        List<Book> booksFound = new ArrayList<>();
        for(Book book : books) {
            if(book.getTitle().toLowerCase().contains(search.toLowerCase())) {
                booksFound.add(book);
            }
        }
        return booksFound;
    }

    public List<Book> getBooks() {
        return books;
    }
}
