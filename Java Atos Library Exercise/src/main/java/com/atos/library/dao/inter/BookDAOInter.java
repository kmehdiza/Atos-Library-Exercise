package com.atos.library.dao.inter;

import com.atos.library.bean.Book;

import java.util.List;

public interface BookDAOInter {

    Book add(Book book);

    List<Book> getAll();

    boolean removeById(Integer id);

    Book searchByParams(Book book);

    boolean lentBookById(Integer id, String username);

    Book getAllBooksDetailsById(Integer id);

    void removeAll();
}
