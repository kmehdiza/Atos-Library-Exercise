package com.atos.library.util;

import com.atos.library.configuration.Context;
import com.atos.library.configuration.Messages;
import com.atos.library.menu.Menu;
import com.atos.library.service.impl.BookServiceImpl;
import com.atos.library.service.inter.BookServiceInter;

public class MenuUtil {

    private BookServiceInter serviceInter = Context.instanceBookService();

    public void printMenu() {
        System.out.println(Messages.welcomeMessage);
        for (Menu menu : Menu.values()) {
            System.out.println(menu);
        }
    }

    public Menu askForMenu() {
        System.out.println(Messages.chooseTheMenu);
        int menuId = ScannerUtil.askForInteger("Menu id");
        for (Menu menu : Menu.values()) {
            if (menu.getId() == menuId) {
                return menu;
            }
        }
        return null;
    }

    public void showMenu() {
        while (true) {
            printMenu();
            Menu menu = askForMenu();
            if (menu == null) {
                System.out.println(Messages.validMenuId);
                continue;
            } else if (menu == Menu.add) {
                serviceInter.add();
            } else if (menu == Menu.get_all_books) {
                serviceInter.getAll();
            } else if (menu == Menu.remove_book_by_id) {
                serviceInter.removeById();
            } else if (menu == Menu.search_book_by_params) {
                serviceInter.searchByParams();
            } else if (menu == Menu.lent_book_byid) {
                serviceInter.lentBookById();
            } else if (menu == Menu.get_all_books_details_by_id) {
                serviceInter.getBooksDetailsById();
            } else if (menu == Menu.exit) {
                break;
            }
        }
    }


}
