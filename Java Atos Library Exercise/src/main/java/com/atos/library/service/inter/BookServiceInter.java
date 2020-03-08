package com.atos.library.service.inter;

import com.atos.library.bean.Book;

import java.util.List;

public interface BookServiceInter {

    Book add();

    List<Book> getAll();

    boolean removeById();

    void searchByParams();

    void lentBookById();

    void getBooksDetailsById();

    void removeAll();

}
