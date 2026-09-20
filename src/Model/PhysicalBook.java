package Model;

public class PhysicalBook extends Book implements Borrowable {
    private int shelfNumber;

    public PhysicalBook(String bookId, String title, String author, int shelfNumber) {
        super(bookId, title, author);
        this.shelfNumber = shelfNumber;
    }

    public int getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(int shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    // Polymorphism: Physical Book ke liye alag price calculation (₹20/day)
    @Override
    public double getRentalPrice(int days) {
        return days * 20.0;
    }

    @Override
    public void borrowBook() {
        System.out.println("Physical book issued successfully from shelf: " + shelfNumber);
    }

    @Override
    public void returnBook() {
        System.out.println("Physical book returned to shelf: " + shelfNumber);
    }
}