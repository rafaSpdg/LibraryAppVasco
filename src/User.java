import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User {

    private final String name;

    private final String dateOfBirth;

    private final String address;

    private final int id;

    private List<Collection<Book>> books;

    public User(String name, String dateOfBirth, String address,int id) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.id = id;
        this.books = new ArrayList<java.util.Collection<Book>>();
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public List<Collection<Book>> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "User { Name: " + name + " | Address: " + address + " | Date of Birth: " + dateOfBirth + "| ID: " + id + " }\n";
    }
}
