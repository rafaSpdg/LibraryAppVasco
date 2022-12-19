import java.util.Collection;
import java.util.List;

public class LibraryApplication implements Library {
    private final BookRepository bookRepo;
    private final UserRepository userRepository;

    private boolean debug;

    public LibraryApplication() {
        this(new BookRepository(), new UserRepository());
    }

    public LibraryApplication(BookRepository br, UserRepository ur) {
        userRepository = ur;
        bookRepo = br;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    // search book with compatible isbn
    @Override
    public Book searchBookByIsbn(String isbn) {
        System.out.println("Searching for books by ISBN " + isbn + ":");

        Book book = bookRepo.findByIsbn(isbn);

        return book;
    }

    @Override
    public Collection<Book> searchBooksTitleContains(String isbn) {

        return null;
    }

    // register a new book
    @Override
    public List<Book> registerBook(String isbn, String title, String genre, String author, int quantity, int numChekedOut) {
        bookRepo.getBooks().add(new Book(isbn, title, genre, author, quantity, numChekedOut));

        return bookRepo.getBooks();
    }

    // search book with that string in the title
    public Book searchBookByTitle(String title) {
        return bookRepo.findByTitle(title);
    }



    //register a new user
    @Override
    public List<User> registerUser(String name, String dob, String address,int id) {
        userRepository.getUsers().add(new User(name, dob, address,id));

        return userRepository.getUsers();
    }

    @Override
    public Collection<Book> searchBookTitleContains(String search) {
        return bookRepo.findByTitleContains(search);
    }

    //search user with that name
    public User searchUserByName(String name) {
        System.out.println("Searching for Users by name %s" + name + ":");
        User user = userRepository.findByName(name);
        if (user != null) {
            System.out.println("\n 1 user found:\n\tName: " + user.getName() + "\n\tDate of Birth: " + user.getDateOfBirth() + "\n\tAddress: " + user.getAddress() + "\n\t");
            System.out.println("\n");
        } else {
            System.out.println("0 users found.");
        }
        System.out.println("\n\n\n");

        return user;
    }

    // search user with that name and address
    @Override
    public User searchUserByNameAndByID(String name, int id) {
        System.out.println("Searching user by compatible name and ID...");
        List<User> users = userRepository.getUsers();
        for(User user : users) {
            if(name.equalsIgnoreCase(user.getName()) && id == user.getId()) {
                return user;
            }
        }
        return null;
    }


    //show users with that address
    @Override
    public User searchUsersByAddress(String address) {
        System.out.println("Searching for Users by address" + address + " in personal information :");
        List<User> users = userRepository.findByAddress(address);
        //System.out.printf("%s users found%s", users.size(), users.size() > 0 ? ":" : ".");
        for (User user : users) {
            return user;
        }
        return null;
    }

    @Override
    public Collection<User> searchUsersWithOverextendedRentals() {
        return null;
    }

    //rent an existing book
    public void rentBook(User u, Collection<Book> b) {
        u.getBooks().add(b);
    }

    public void checkOutBook(String isbn) {
        Book book = bookRepo.findByIsbn(isbn);
        if (book != null) {
            if (book.checkOut()) {
                System.out.println("\nBook checked out successfully!");
                System.out.println("\tISBN: " + book.getIsbn() + "\n\tTitle: " + book.getTitle() + "\n\tAuthor: " + book.getAuthor() + "\n\t");
            } else {
                System.out.println("Check out FAILED!");
                System.out.println("\tISBN: " + book.getIsbn() + "\n\tTitle: " + book.getTitle() + "\n\tAuthor: " + book.getAuthor() + "\n\t");
                System.out.println("Reason: More books checked out than recorded quantity.");
            }
        } else {
            System.out.print("Failed to check out book\n");
            System.out.printf("Reason:There is no book with ISBN %s on record", isbn);
        }
        System.out.println();
    }

    public void checkInBook(String isbn) {
        Book book = bookRepo.findByIsbn(isbn);
        if (book != null) {
            if(book.checkIn()) {
                System.out.println("\nBook checked in successfully!");
                System.out.println("\tISBN: " + book.getIsbn() + "\n\tTitle: " + book.getTitle() + "\n\tAuthor: " + book.getAuthor() + "\n\t");
            } else {
                System.out.println("Book checked in FAILED!");
                System.out.println("\tISBN: " + book.getIsbn() + "\n\tTitle: " + book.getTitle() + "\n\tAuthor: " + book.getAuthor() + "\n\t");
            }
        } else {
            System.out.print("Failed to check in book\n");
            System.out.printf("Reason:There is no book with ISBN %s on record", isbn);
        }
        System.out.println();
    }

    private void debug(String s) {
        if (debug) {
            System.out.println(s);
        }
    }
}
