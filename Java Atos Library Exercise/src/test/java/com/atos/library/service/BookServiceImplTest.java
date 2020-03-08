package com.atos.library.service;

import com.atos.library.bean.Book;
import com.atos.library.dao.impl.BookDAOImpl;
import com.atos.library.service.impl.BookServiceImpl;
import com.atos.library.util.ScannerUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;


@RunWith(PowerMockRunner.class)
@PrepareForTest(ScannerUtil.class)
public class BookServiceImplTest {

    @Mock
    private BookDAOImpl bookDao = new BookDAOImpl();

    @Spy
    @InjectMocks
    private BookServiceImpl bookService = new BookServiceImpl();

    @Before
    public void beforeEach(){
        MockitoAnnotations.initMocks(this);
        PowerMockito.mockStatic(ScannerUtil.class);
        bookService.removeAll();
    }
//indiki halda service ve dao classlari tamamile musteqi olaraq test edilmish sayilir chunki daonu chagirmiriq real olaraq
    //aydindir?indi ki versiya mene daha chox aydindir neyinki bayaq etdiyin yol
    //bayaq etdiyim integration testdir. bu ise unit test, unit i oxumusham deye mene tanish gelirdi. Basha dushdum.
    //tamam amma yadinda saxla ki integration lazim olanda gerek real olaraq  butun obyektler prosesde ishtirak etmelidir
    //ayri sual?Allah senden razi olsun senden de bye
    @Test
    public void addBook() {
        when(ScannerUtil.askForString(any(String.class))).thenReturn("testStr");
        when(ScannerUtil.askForDate(any(String.class))).thenReturn(new Date());
        when(bookDao.add(any(Book.class))).thenReturn(new Book(1));
        Book book = bookService.add();
        Assert.assertEquals("book could not be inserted", 1L, (long) book.getId());
    }

    @Test
    public void getAllBooks() {
        when(bookDao.getAll()).thenReturn(Arrays.asList(new Book(1)));
        Assert.assertEquals("list doesn't contain all books", 1L,  bookService.getAll().size());
    }

    @Test
    public void given_addedBook_then_removeByIdShouldRemoveAndReturnTrue() {
        when(ScannerUtil.askForInteger(any(String.class))).thenReturn(1);
        when(bookDao.removeById(1)).thenReturn(true);
        Assert.assertEquals("book could not be removed", true, bookService.removeById());
    }

    @Test
    public void given_emptyList_then_removeById_shouldByIdReturnFalse() {
        when(ScannerUtil.askForInteger(any(String.class))).thenReturn(1);
        when(bookDao.removeById(any(Integer.class))).thenReturn(false);
        Assert.assertEquals("removeid should return false", false, bookService.removeById());
    }

}
