package com.pluralsight;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;

        this.isCheckedOut = false;
        this.checkedOutTo = "";
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
