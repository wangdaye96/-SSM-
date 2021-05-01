package com.wang.pojo;

/**
 * @author wangdaye996
 * @Date 2021/4/23
 * @Time 17:52
 */
public class Book {
    private int bookId;
    private String bookName;
    private double bookPrice;
    private String detail;

    public Book() {
    }

    public Book(int bookId, String bookName, double bookPrice, String detail) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.detail = detail;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookId(){
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                ", detail='" + detail + '\'' +
                '}';
    }

}
