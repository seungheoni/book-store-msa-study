CREATE TABLE Book (
                      id SERIAL PRIMARY KEY,
                      title VARCHAR(255),
                      price DECIMAL(10, 2),
                      quantity INTEGER
);

CREATE TABLE PaymentHistory (
                      id SERIAL PRIMARY KEY,
                      bookid INT,
                      amount DECIMAL(10, 2),
                      FOREIGN KEY (bookid) REFERENCES Book(id)
);

INSERT INTO Book (title, price, quantity) VALUES ('정도전', 5000 , 3);
INSERT INTO Book (title, price, quantity) VALUES ('미움받을 용기', 2000, 2);
INSERT INTO Book (title, price, quantity) VALUES ('죽음의 수용소에서', 3000, 1);