package com.atos.library.configuration;

import com.atos.library.dao.impl.BookDAOImpl;
import com.atos.library.dao.inter.BookDAOInter;
import com.atos.library.service.impl.BookServiceImpl;
import com.atos.library.service.inter.BookServiceInter;

public class Context {

    public static BookDAOInter instanceBookDAO(){
        return new BookDAOImpl();
    }

    public static BookServiceInter instanceBookService(){
        return new BookServiceImpl();
    }

}
