import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookFileRepository {

    private List<Book> books = new ArrayList<>();

    public BookFileRepository() {
    }

    public BookFileRepository(Collection<Book> books) {
        this.books.addAll(books);
    }

    public Book findByIsbn(String isbn) {
        for(Book book : books) {
            if(book.getIsbn() == isbn) {
                return book;
            }
        }
        return null;
    }

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
