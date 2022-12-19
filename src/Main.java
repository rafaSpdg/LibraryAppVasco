import TicTacToe.TicTacToe;
import quizGame.DisplayQuiz;
import quizGame.Game;
import BattleShip.*;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

//proteger o codigo e colocar exceptions e try / catch

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws PositionException, NotEnoughPermissionException {

        //Creating a list of users
        List<User> usersList = new ArrayList<>();
        usersList.add(new User("Chico", "22/04/1994", "Vila do Conde", 45567));
        usersList.add(new User("Rafael", "23/10/1997", "Aveiro", 56899));
        usersList.add(new User("Mariana", "11/12/2002", "Lisboa", 33533));
        usersList.add(new User("Ricardo", "16/10/2004", "Lisboa", 88888));
        usersList.add(new User("Jacinto", "11/12/2002", "Algarve", 90001));

        UserRepository ur = new UserRepository(usersList);

        //Creating a list of books
        List<Book> books = new ArrayList<>();
        books.add(new Book("54672", "Afonso Night-Moon", "romance", "Afonso", 10, 7));
        books.add(new Book("54675", "Fast and Furious", "action", "Paul", 5, 1));
        books.add(new Book("54677", "Tokyo", "action", "Paul", 4, 0));
        books.add(new Book("54678", "Jumanji", "game", "Adam", 6, 2));
        books.add(new Book("54988", "Saw", "Horror", "Tiller", 9, 3));
        books.add(new Book("74622", "Special Force", "action", "Caroline", 10, 6));

        BookRepository br = new BookRepository(books);

        LibraryApplication libraryApplication = new LibraryApplication(br, ur);

        //libraryApp Menu / Options

        System.out.println("                   Wᴇʟᴄᴏᴍᴇ ᴛᴏ 🆁🅶 🅻🅸🅱🆁🅰🆁🆈");
        System.out.println();

        int choice;
        do {
            System.out.println("1 - [ Rᴇᴏ̨ᴜᴇsᴛ ᴏɴᴇ ᴏғ ᴛʜᴇ ᴀᴠᴀɪʟᴀʙʟᴇ Gᴀᴍᴇs ]\n" +
                    "\n" +
                    "2 - [ Rᴇɢɪsᴛᴇʀ ᴀ ɴᴇᴡ ᴜsᴇʀ ᴛᴏ ᴛʜᴇ LɪʙʀᴀʀʏAᴘᴘ ]\n" +
                    "\n" +
                    "3 - [ Sᴇᴀʀᴄʜ ғᴏʀ ᴀɴ ᴇxɪsᴛɪɴɢ ᴜsᴇʀ ]\n" +
                    "\n" +
                    "4 - [ Sʜᴏᴡ ᴀʟʟ ᴛʜᴇ  ʀᴇɢɪsᴛᴇʀᴇᴅ ᴜsᴇʀs]\n" +
                    "\n" +
                    "5 - [ Rᴇɢɪsᴛᴇʀ ᴀ ɴᴇᴡ ʙᴏᴏᴋ ɪɴ LɪʙʀᴀʀʏAᴘᴘ ]\n" +
                    "\n" +
                    "6 - [ Sᴇᴀʀᴄʜ ғᴏʀ ᴀɴ ᴇxɪsᴛɪɴɢ ʙᴏᴏᴋ. ]\n" +
                    "\n" +
                    "7 - [ Cʜᴇᴄᴋ ɪɴ ʙᴏᴏᴋ ]\n" +
                    "\n" +
                    "8 - [ Cʜᴇᴄᴋ ᴏᴜᴛ ʙᴏᴏᴋ ]\n" +
                    "\n" +
                    "9 - [ Rᴇᴏ̨ᴜᴇsᴛ ᴀ ʙᴏᴏᴋ ᴡɪᴛʜ ᴀ ʀᴇɢɪsᴛᴇʀᴇᴅ ᴜsᴇʀ ]\n" +
                    "\n" +
                    "10 - [ Exɪᴛ ]");
            System.out.println();

            System.out.print("Enter here your option: ");
            choice = scanner.nextInt();

            //Switching between user or worker options
            switch (choice) {
                case 1:
                    int response;
                    System.out.println();
                    System.out.println("Searching for games...\n");
                    System.out.println("""
                            Founded 3 games:
                            \t 1 - Quiz Game
                            \t 2 - TicTacToe
                            \t 3 - BattleShip""");
                    System.out.println("\nYou want to request any game? ");
                    System.out.println("Yes - Press the key (1)");
                    System.out.println("No - Press the key (2)");
                    System.out.print("1 / 2 : ");
                    response = scanner.nextInt();
                    if (response > 2 || response < 1) {
                        throw new NotEnoughPermissionException("Invalid input");
                    }
                    int gameChoice = 0;
                    if (response == 1) {
                        System.out.println("Checking if you have permission to request the game:");
                        System.out.print("Type here your Name: ");
                        String name = scanner.next();
                        System.out.print("Type here your ID: ");
                        int id = scanner.nextInt();
                        System.out.println();
                        if (id < 0) {
                            throw new NotEnoughPermissionException("Invalid input.");
                        }
                        if (libraryApplication.searchUserByNameAndByID(name, id) != null) {
                            do {
                                System.out.println("\nYou are registered. You have permission to request the Game you want.");
                                System.out.println("\nChoose the game you want to play:");
                                System.out.println("""
                                        \t 1 - Quiz Game
                                        \t 2 - TicTacToe
                                        \t 3 - BattleShip""");
                                System.out.print("Option: ");
                                gameChoice = scanner.nextInt();
                                System.out.println();
                            } while (gameChoice > 3 || gameChoice < 1);
                        } else {
                            System.out.println("\nYou are not registered in our libraryApp.\n" +
                                    "You will need to register in order to order one of our games or books.");
                        }
                    }
                    switch (gameChoice) {
                        case 1 -> {
                            Game game = new Game();
                            game.run();
                            System.out.print("\nPress any key to return:");
                            scanner.nextLine();
                        }
                        case 2 -> {
                            TicTacToe.run();
                            System.out.print("\nPress any key to return:");
                            scanner.nextLine();
                        }
                        case 3 -> {
                            BattleShip.Game.runGame();
                            System.out.print("\nPress any key to return:");
                            scanner.nextLine();
                        }
                        default -> System.out.println();
                    }
                    break;
                case 2:
                    String name = null;
                    String dob = null;
                    String city = null;
                    try {
                        System.out.println("Registering user...");
                        System.out.print("Name: ");
                        name = scanner.next();
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println("Invalid input.");
                    }
                    try {
                        System.out.print("Date of Birth: ");
                        dob = scanner.next();
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println("Invalid input.");
                    }
                    try {
                        System.out.print("City: ");
                        city = scanner.next();
                        System.out.println();
                    } catch(Exception e) {
                        System.out.println("Invalid input.");
                    }
                    System.out.print("ID: Creating ID...");
                    int randID = 10000 + (int) (Math.random() * 100000);
                    System.out.println("ID created: " + randID);
                    System.out.println(libraryApplication.registerUser(name, dob, city, randID));
                    System.out.println("User registered successfully.");
                    System.out.print("\nPress any key to return:");
                    new Scanner(System.in).nextLine();
                    break;
                case 3:
                    libraryApplication.searchUsersByAddress("lisboa");
                    libraryApplication.searchUserByName("rafael");
                    libraryApplication.searchUserByName("Manel");
                    System.out.print("\nPress any key to return:");
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.println(ur.getUsers());
                    System.out.print("\nPress any key to return:");
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.println(libraryApplication.registerBook("65675", "Rafael is the best!", "Drama", "Rafael Goncalves", 5, 0));
                    System.out.print("\nPress any key to return:");
                    scanner.nextLine();
                    break;
                case 6:
                    Collection<Book> bookByISBN = libraryApplication.searchBooksTitleContains("54672");
                    System.out.println(bookByISBN);
                    libraryApplication.searchBookByIsbn("23456");
                    libraryApplication.searchBookByTitle("My horse is dumb!");
                    System.out.println(libraryApplication.searchBookTitleContains("fast"));
                    System.out.print("\nPress any key to return:");
                    scanner.nextLine();
                    break;
                case 7:
                    libraryApplication.checkInBook("54677");
                    System.out.print("\nPress any key to return:");
                    scanner.nextLine();
                    break;
                case 8:
                    libraryApplication.checkOutBook("54672");
                    System.out.print("\nPress any key to return:");
                    scanner.nextLine();
                    break;
                case 9:
                    Collection<Book> fast = libraryApplication.searchBookTitleContains("fast");
                    User rafa = libraryApplication.searchUserByName("rafael");
                    libraryApplication.rentBook(rafa, fast);


                    Collection<Book> afonso = libraryApplication.searchBookTitleContains("afonso");
                    libraryApplication.rentBook(rafa, afonso);

                    System.out.println(rafa.getBooks());
                    System.out.print("\nPress any key to return:");
                    scanner.nextLine();
                    break;
                default:
                    System.out.println();
            }

        } while (choice != 10);
    }
}
