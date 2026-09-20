package Model;

public class Reservation {
    private String reservationId;
    private String userId;
    private String bookId;

    public Reservation(String reservationId, String userId, String bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }
}
