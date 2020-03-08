package com.atos.library.service.impl;

import com.atos.library.bean.Book;
import com.atos.library.configuration.Context;
import com.atos.library.configuration.Messages;
import com.atos.library.dao.inter.BookDAOInter;
import com.atos.library.service.inter.BookServiceInter;
import com.atos.library.util.ScannerUtil;

import java.util.Date;
import java.util.List;

public class BookServiceImpl implements BookServiceInter {

    private BookDAOInter bookDAOInter = Context.instanceBookDAO();

    @Override
    public Book add() {
        String title = ScannerUtil.askForString("Title");
        Date year = ScannerUtil.askForDate("Year");
        String author = ScannerUtil.askForString("Author");
        return bookDAOInter.add(new Book(title, year, author));
    }

    @Override
    public List<Book> getAll() {
        List<Book> list = bookDAOInter.getAll();
        int countLent = 0;
        for (Book book:list){
            if(book.isLent()){
                countLent++;
            }
        }
        System.out.println(list);
        System.out.println("Available: " + (list.size() - countLent));
        System.out.println("Lent: " + countLent);
        return list;
    }

    @Override
    public boolean removeById() {
        Integer id = ScannerUtil.askForInteger("Id");
        return bookDAOInter.removeById(id);
    }

    @Override
    public void searchByParams() {
        String title = ScannerUtil.askForString("Title");
        Date year = ScannerUtil.askForDate("Year");
        String author = ScannerUtil.askForString("Author");
        Book book = bookDAOInter.searchByParams(new Book(title, year, author));
        System.out.println(book);
    }

    @Override
    public void lentBookById() {
        Integer id = ScannerUtil.askForInteger("Id");
        String username = ScannerUtil.askForString("Username");
        boolean result = bookDAOInter.lentBookById(id, username);
        if(result){
            System.out.println(Messages.bookHasLent + username);
        }
    }

    @Override
    public void getBooksDetailsById() {
        Integer id = ScannerUtil.askForInteger("Id");
        Book book = bookDAOInter.getAllBooksDetailsById(id);
        if(!book.isLent()){
            System.out.println(book);
        }else {
            System.out.println(Messages.bookHasLent + book.getUsername());
        }
    }

    @Override
    public void removeAll(){
        bookDAOInter.removeAll();
    }

}
