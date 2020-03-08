package com.atos.library.dao.impl;

import com.atos.library.bean.Book;
import com.atos.library.dao.inter.BookDAOInter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BookDAOImpl implements BookDAOInter {

    private static AtomicInteger incrementId = new AtomicInteger(0);
    private static List<Book> listBook = Collections.synchronizedList(new ArrayList<>());

    @Override
    public Book add(Book book) {
        book.setId(incrementId.incrementAndGet());//sual? men ele bilirdim ki mock eden de hec bir codu oxuya bilmir class dan


        ////th//an/k//////////burada mock yoxdur her shey real obyektdir fikir ver
        listBook.add(book);
        return book;
    }

    @Override
    public List<Book> getAll() {
        return listBook;
    }

    @Override
    public boolean removeById(Integer id) {
        for (Book book : listBook) {
            if (book.getId().equals(id) && !book.isLent()) {
                listBook.remove(new Book(id));
                return true;
            }
        }
        return false;
    }

    @Override
    public Book searchByParams(Book book) {//indi bunun uchun gerek addedesen ki method sene nese qaytara bilsin
        for (Book bookList : listBook) {
            if (bookList.getTitle().equals(book.getTitle()) && bookList.getAuthor().equals(book.getAuthor())
                    && (book.getYear() == null || bookList.getYear().equals(book.getYear()))) {
                return bookList;
            }
        }
        return null;
    }

    @Override
    public boolean lentBookById(Integer id, String username) {//burda da hemchinin
        for (Book bookList : listBook) {
            if (bookList.getId().equals(id) && !bookList.isLent()) {
                bookList.setLent(true);
                bookList.setUsername(username);
                return true;
            }
        }
        return false;
    }

    @Override
    public Book getAllBooksDetailsById(Integer id) {//burada da
        for (Book bookList : listBook) {
            if(bookList.getId().equals(id)){
                return bookList;
            }
        }
        return null;
    }

    @Override
    public void removeAll(){
        listBook.clear();
    }

}