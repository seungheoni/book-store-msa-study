package com.example.bookstorepayment.repository;

import com.example.database.entity.PaymentHistory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface PaymentHistoryRepository {

    @Insert("INSERT INTO PaymentHistory (bookid, amount) VALUES (#{bookId}, #{amount})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(PaymentHistory paymentHistory);
}
