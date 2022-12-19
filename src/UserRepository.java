import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserRepository {

    private List<User> users = new ArrayList<>();

    public UserRepository() {
    }

    //add all users to the list
    public UserRepository(Collection<User> users) {
        this.users.addAll(users);
    }

    //get users information
    public List<User> getUsers() {
        return users;
    }

    //find user by the name
    public User findByName(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    //find user by the address
    public List<User> findByAddress(String address) {
        List<User> usersFound = new ArrayList<>();
        for (User user : users) {
            if (user.getAddress().equalsIgnoreCase(address)) {
                usersFound.add(user);
            }
        }
        System.out.println("\nSearching for Users by address " + address + " in personal information :\n");
        System.out.printf("%s users found%s", usersFound.size(), usersFound.size() > 0 ? ":" : ".");
        for(User usersAddress : usersFound) {
            System.out.println("\n\tName: " + usersAddress.getName() + "\n\tDate of Birth: " + usersAddress.getDateOfBirth() + "\n\tAddress: " + usersAddress.getAddress() + "\n\t");
        }

        return usersFound;
    }

}