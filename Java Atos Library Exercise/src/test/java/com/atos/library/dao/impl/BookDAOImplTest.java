package com.atos.library.dao.impl;

import com.atos.library.bean.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BookDAOImplTest {

    private BookDAOImpl bookDAO = new BookDAOImpl();

    @Before
    public void beforeEach(){
        bookDAO.removeAll();
    }

    @Test
    public void addBook() {
        Book stubBook = getStubBook();
        bookDAO.add(stubBook);
        Assert.assertEquals("inserted id is wrong", 1L, (long) stubBook.getId());
    }

    @Test
    public void getAllBooks() {
        Book stubBook = getStubBook();
        bookDAO.add(stubBook);
        Assert.assertEquals("list doesn't contain all books", 1L,  bookDAO.getAll().size());
    }

    @Test
    public void given_addedBook_then_removeByIdShouldRemoveAndReturnTrue() {//burani basha dushmedim
        Book stubBook = getStubBook();
        bookDAO.add(stubBook);//sen stubBook.getId deyirsen bu getId ni biz ne zaman verdik ki sen getId ede bilirsen?, yeni setId olmadan
        //getId nece oldu?
        List<Book> list = bookDAO.getAll();
        Assert.assertEquals("book could not be added", 1L, (long) list.size());
        bookDAO.removeById(stubBook.getId());
        Assert.assertEquals("book could not be removed", 0L, list.size());
    }

    @Test
    public void given_emptyList_then_removeById_shouldByIdReturnFalse() {//burani basha dushmedim
        boolean result = bookDAO.removeById(1);//burda olmuyan bir id ni remove etmeye calishdigimiz ucun false verdi?
        //beli
        //bir dene de sualim var
        Assert.assertEquals("removeid should return false", false, result);
    }

    private Book getStubBook() {//sual? sual?//burda new Book yaradiriq amcaq yuxarida sen
        return new Book();
    }

}
