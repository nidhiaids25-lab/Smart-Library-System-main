import org.junit.platform.reporting.shadow.org.opentest4j.reporting.events.core.UserName;

import Model.Book;
import Model.EBook;
import Model.PhysicalBook;
import Model.User;

class Main {
    public static void main(String[] args) {
        System.out.println("=== SMART LIBRARY SYSTEM TEST ===\n");

        // 1. User ka hardcoded data banayein
        UserName user1 = new User("U101", "Nidhi");
        System.out.println("User Created: " + user1.getName() + " (ID: " + user1.getUserId() + ")");
        System.out.println("-----------------------------------");

        // 2. Physical Book ka object banayein
        // Parameters: (Book ID, Title, Author, Shelf Number)
        PhysicalBook book1 = new PhysicalBook("B101", "Java Programming", "James Gosling", 4);

        System.out.println("Physical Book Details:");
        System.out.println("Title: " + book1.getTitle());
        System.out.println("Shelf No: " + book1.getShelfNumber());
        // Polymorphism check: 5 dino ka rent calculation
        System.out.println("Rental Price for 5 days: ₹" + book1.getRentalPrice(5));
        
        // Interface method check
        book1.borrowBook();
        System.out.println("-----------------------------------");

        // 3. EBook ka object banayein
        // Parameters: (Book ID, Title, Author, Download Link)
        EBook ebook1 = new EBook("E201", "Mastering Git & GitHub", "Linus Torvalds", "https://library.com/git.pdf");

        System.out.println("EBook Details:");
        System.out.println("Title: " + ebook1.getTitle());
        System.out.println("Download URL: " + ebook1.getAccessUrl());
        // Polymorphism check: EBook ka sasta rent calculation
        System.out.println("Rental Price for 5 days: ₹" + ebook1.getRentalPrice(5));
        
        // Interface method check
        ebook1.download();
        System.out.println("-----------------------------------");
    }
}