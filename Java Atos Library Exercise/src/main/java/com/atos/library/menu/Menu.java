package com.atos.library.menu;

public enum Menu {

    add(1,"Add new book to the library"),
    get_all_books(2,"Get all the books in the library"),
    remove_book_by_id(3,"Remove the book by id"),
    search_book_by_params(4,"Search the book by title, year, author or combination like title and author"),
    lent_book_byid(5,"Lent the book by id"),
    get_all_books_details_by_id(6,"Get all book's details by ID"),
    exit(7,"To exit from Library");

    private int id;
    private String label;

    Menu(int id, String label){
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return id + ". " + label;
    }
}
