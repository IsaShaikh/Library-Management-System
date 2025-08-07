package service;

import model.Book;
import model.User;

import java.util.HashMap;

public class Library {
    private HashMap<Integer, Book> books = new HashMap<>();
    private HashMap<Integer, User> users = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void issueBook(int bookId, int userId) {
        Book book = books.get(bookId);
        User user = users.get(userId);

        if (book == null) {
            System.out.println("❌ Book not found.");
        } else if (user == null) {
            System.out.println("❌ User not found.");
        } else if (book.isIssued()) {
            System.out.println("❌ Book is already issued.");
        } else {
            book.issue();
            user.borrowBook(bookId);
            System.out.println("✅ Book issued to user.");
        }
    }

    public void returnBook(int bookId, int userId) {
        Book book = books.get(bookId);
        User user = users.get(userId);

        if (book == null || user == null) {
            System.out.println("❌ Invalid book or user ID.");
        } else if (!user.getBorrowedBookIds().contains(bookId)) {
            System.out.println("❌ User did not borrow this book.");
        } else {
            book.returnBook();
            user.returnBook(bookId);
            System.out.println("✅ Book returned successfully.");
        }
    }

    public void listBooks() {
        books.values().forEach(System.out::println);
    }

    public void listUsers() {
        users.values().forEach(System.out::println);
    }
}
