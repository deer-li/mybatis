package com.deer.pojo;

/**
 * @author: 86175
 * @date: 2021/12/1 19:54
 * @description:构建实体类，作为查询结果集返回类型
 */
public class Book {
    private Integer id;
    private String bookName;
    private String price;
    private String num;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", price='" + price + '\'' +
                ", num='" + num + '\'' +
                '}';
    }
}
