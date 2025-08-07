import model.Book;
import model.User;
import service.Library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n📚 Library Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View All Books");
            System.out.println("6. View All Users");
            System.out.println("7. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    lib.addBook(new Book(id, title));
                    System.out.println("✅ Book added.");
                }
                case 2 -> {
                    System.out.print("Enter User ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter User Name: ");
                    String name = sc.nextLine();
                    lib.addUser(new User(id, name));
                    System.out.println("✅ User added.");
                }
                case 3 -> {
                    System.out.print("Enter Book ID to issue: ");
                    int bookId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    lib.issueBook(bookId, userId);
                }
                case 4 -> {
                    System.out.print("Enter Book ID to return: ");
                    int bookId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    lib.returnBook(bookId, userId);
                }
                case 5 -> lib.listBooks();
                case 6 -> lib.listUsers();
                case 7 -> {
                    System.out.println("👋 Exiting Library System.");
                    return;
                }
                default -> System.out.println("❌ Invalid choice.");
            }
        }
    }
}
