import java.util.Collection;
import java.util.List;

public interface Library {
    List<Book> registerBook(String isbn, String title, String genre, String author,int quantity, int numCheckedOut);
    Book searchBookByTitle(String title);
    Book searchBookByIsbn(String isbn);
    Collection<Book> searchBooksTitleContains(String isbn);

    List <User> registerUser(String name, String address, String dob,int id);

    Collection<Book> searchBookTitleContains(String search);

    User searchUserByName(String name);

    User searchUserByNameAndByID(String name, int id);
    User searchUsersByAddress(String address);
    Collection<User> searchUsersWithOverextendedRentals();
}
