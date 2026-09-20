package Model;

public class EBook extends Book implements DigitalAccessible {
    private String downloadLink;

    public EBook(String bookId, String title, String author, String downloadLink) {
        super(bookId, title, author);
        this.downloadLink = downloadLink;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

    // Polymorphism: EBook ke liye alag sasta price calculation (₹10/day)
    @Override
    public double getRentalPrice(int days) {
        return days * 10.0;
    }

    @Override
    public void download() {
        System.out.println("Downloading eBook from: " + downloadLink);
    }

    @Override
    public String getAccessUrl() {
        return downloadLink;
    }
}