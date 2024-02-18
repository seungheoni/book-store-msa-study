package com.example.bookstoreproduct.dto;


import java.math.BigDecimal;

public class PaymentHistoryRequest {
    private Long bookId;
    private Long quantity;
    private BigDecimal amount;

    public PaymentHistoryRequest() {
    }

    public PaymentHistoryRequest(Long bookId, Long quantity, BigDecimal amount) {
        this.bookId = bookId;
        this.quantity = quantity;
        this.amount = amount;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "bookId=" + bookId +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }
}
