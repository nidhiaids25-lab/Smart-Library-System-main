package Model;

class EBook extends Book {
    private String downloadLink;

    public EBook(String bookId, String title, String author, String downloadLink) {
        super(bookId, title, author);
        this.downloadLink = downloadLink;
    }

    public String getDownloadLink() { return downloadLink; }

    @Override
    public double getRentalPrice(int days) {
        return 0.0;
    }
}