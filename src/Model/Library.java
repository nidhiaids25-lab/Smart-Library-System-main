package Model;

import java.util.ArrayList;
import java.util.List;

import org.junit.platform.reporting.shadow.org.opentest4j.reporting.events.core.UserName;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<UserName> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(UserName user) {
        users.add(user);
    }

    public List<Book> getBooks() { return books; }
}