package com.atos.library.bean;

import java.util.Date;
import java.util.Objects;

public class Book {
// Book consist of title, year and author.
    private Integer id;
    private String title;
    private Date year;
    private String author;
    private boolean lent;
    private String username;

    public Book(){
    }

    public Book(Integer id){
        this.id = id;
    }

    public Book(String title, Date year, String author){
        this.title = title;
        this.year = year;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isLent() {
        return lent;
    }

    public void setLent(boolean lent) {
        this.lent = lent;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Book book = (Book) object;
        return id.equals(book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "id= " + id +
                ", title= " + title +
                ", year= " + year +
                ", author= " + author;
    }
}
