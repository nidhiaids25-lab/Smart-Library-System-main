package dao;

import Model.Book;
import Model.PhysicalBook;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    // 1. ADD BOOK (Create)
    public void addBook(Book book) {
        String sql = "INSERT INTO books (book_id, title, author, book_type, shelf_number) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, book.getBookId());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getAuthor());
            
            if (book instanceof PhysicalBook) {
                stmt.setString(4, "PHYSICAL");
                stmt.setInt(5, ((PhysicalBook) book).getShelfNumber());
            } else {
                stmt.setString(4, "EBOOK");
                stmt.setNull(5, Types.INTEGER);
            }

            stmt.executeUpdate();
            System.out.println("Book added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 2. GET ALL BOOKS (Read)
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String id = rs.getString("book_id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                int shelf = rs.getInt("shelf_number");
                books.add(new PhysicalBook(id, title, author, shelf));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    // 3. UPDATE BOOK AUTHOR (Update)
    public void updateBookAuthor(String bookId, String newAuthor) {
        String sql = "UPDATE books SET author = ? WHERE book_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newAuthor);
            stmt.setString(2, bookId);
            stmt.executeUpdate();
            System.out.println("Book updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 4. DELETE BOOK (Delete)
    public void deleteBook(String bookId) {
        String sql = "DELETE FROM books WHERE book_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, bookId);
            stmt.executeUpdate();
            System.out.println("Book deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}