package com.example.a15pr;

public class Book {
    private int Id_Book;
    private String Book_Name;
    private String Book_Author;
    public Book(int Id_Book, String book_Name, String book_Author){
        this.Id_Book=Id_Book;
        this.Book_Name=book_Name;
        this.Book_Author=book_Author;

    }

    public int getId_Book() {
        return Id_Book;
    }

    public void setId_Book(int id_Book) {
        this.Id_Book = Id_Book;
    }

    public String getBook_Name() {
        return Book_Name;
    }

    public void setBook_Name(String book_Name) {
        Book_Name = book_Name;
    }

    public String getBook_Author() {
        return Book_Author;
    }

    public void setBook_Author(String book_Author) {
        Book_Author = book_Author;
    }
}
