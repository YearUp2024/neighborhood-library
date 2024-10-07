package com.pluralsight;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book(int id, String title, String isbn) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;

        this.checkedOutTo = "";
        this.isCheckedOut = false;
    }

    public int getId() {
        return this.id;
    }

    public String getCheckedOutTo() {
        return this.checkedOutTo;
    }

    public String getISBN() {
        return this.isbn;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isCheckedOut() {
        return this.isCheckedOut;
    }

    public void checkedOut(String name){
        this.checkedOutTo = name;
        this.isCheckedOut = true;
    }

    public void checkedIn(){
        this.checkedOutTo = "";
        this.isCheckedOut = false;
    }



    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", isCheckedOut=" + isCheckedOut +
                ", checkedOutTo='" + checkedOutTo + '\'' +
                '}';
    }
}
