package com.example.bookstoreproduct.repository;

import com.example.database.entity.Book;
import org.apache.ibatis.annotations.*;

@Mapper
public interface BookRepository {

    @Insert("INSERT INTO book (title, price , quantity) VALUES (#{title}, #{price} , #{quantity})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Book book);

    // 책 ID로 책을 조회하는 메서드
    @Select("SELECT * FROM book WHERE id = #{id}")
    Book findById(long id);

    // 책의 수량을 감소시키는 메서드
    @Update("UPDATE book SET quantity = quantity - #{quantity} WHERE id = #{id}")
    void decreaseQuantity(Long id, Long quantity);
}
