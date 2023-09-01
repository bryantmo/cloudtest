package com.example.bootprojecttest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BookConfig {

    @Value("${book.name}")
    private String name;
    @Value("${book.author}")
    private String author;
    @Value("${book.price}")
    private Integer price;
    @Value("${book.desc}")
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookConfig{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", desc='" + desc + '\'' +
                '}';
    }
}
