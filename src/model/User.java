package model;

import java.util.HashSet;

public class User {
    private int id;
    private String name;
    private HashSet<Integer> borrowedBookIds;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBookIds = new HashSet<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public HashSet<Integer> getBorrowedBookIds() { return borrowedBookIds; }

    public void borrowBook(int bookId) { borrowedBookIds.add(bookId); }
    public void returnBook(int bookId) { borrowedBookIds.remove(bookId); }

    @Override
    public String toString() {
        return "User[ID=" + id + ", Name='" + name + "', BorrowedBooks=" + borrowedBookIds + "]";
    }
}
