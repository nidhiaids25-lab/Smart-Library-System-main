package Model;

public class Transaction {
    private String transactionId;
    private String userId;
    private String bookId;

    public Transaction(String transactionId, String userId, String bookId) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.bookId = bookId;
    }

    public String getTransactionId() { return transactionId; }
}