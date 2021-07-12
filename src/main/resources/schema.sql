CREATE TABLE BOOK (
    BOOK_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    BOOK_NAME VARCHAR2(40) NOT NULL,
    AUTHOR VARCHAR2(20) NOT NULL,
    AVAILABLE_COPIES BIGINT DEFAULT 0,
    TOTAL_COPIES BIGINT DEFAULT 0
);
