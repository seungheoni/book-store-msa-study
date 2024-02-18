package com.example.bookstoreproduct.service;

import com.example.bookstoreproduct.dto.PaymentHistoryRequest;
import com.example.bookstoreproduct.repository.BookRepository;
import com.example.database.entity.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final RestTemplate restTemplate;

    @Value("${bookstore.payment.url}")
    private String paymentServiceUrl;

    @Value("${bookstore.payment.port}")
    private String paymentServicePort;

    public BookServiceImpl(BookRepository bookRepository, RestTemplate restTemplate) {
        this.bookRepository = bookRepository;
        this.restTemplate = restTemplate;
    }

    //새로운 책을 데이터베이스에 등록
    @Override
    public Book bookRegistry(Book book) {
        bookRepository.save(book);
        return book;
    }

    @Override
    public Boolean purchaseBook(Long id, Long quantity) {
        //책 존재 여부와 수량 체크
        Book book = bookRepository.findById(id);
        if (book == null || book.getQuantity() < quantity) {
            return false;
        }

        // 결제 요청 객체 생성
        BigDecimal paymentAmount = book.getPrice().multiply(BigDecimal.valueOf(quantity));
        PaymentHistoryRequest paymentRequest = new PaymentHistoryRequest(id, quantity, paymentAmount);
        HttpEntity<PaymentHistoryRequest> request = new HttpEntity<>(paymentRequest);

        // 결제 서비스 URL
        String url = "http://" + paymentServiceUrl + ":" + paymentServicePort + "/api/payments";
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        if (!response.getStatusCode().is2xxSuccessful()) {
            // 결제 실패 처리
            return false;
        }

        // 책 수량 감소
        bookRepository.decreaseQuantity(book.getBookId(),book.getQuantity() - quantity);

        return true; // 결제 성공
    }
}
