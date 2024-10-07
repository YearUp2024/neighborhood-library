package com.pluralsight;

public class Main {
    public static Book[] library;

    public static void main(String[] args) {
        library = getInitializedLibrary();
        for(Book book : library){
            System.out.println(book.getTitle());
        }
    }

    public static Book[] getInitializedLibrary() {
        Book[] library = new Book[20];
        library[0] = new Book(1, "ISBN11332211", "Practical Tableau");
        library[1] = new Book(2, "ISBN1133229918", "Pro Git");
        library[2] = new Book(3, "ISBN2299220202", "Genetic Programming");
        library[3] = new Book(4, "ISBN9780136083238", "Clean Code");
        library[3] = new Book(4, "ISBN111222333", "The Pragmatic Programmer");
        library[4] = new Book(5, "ISBN444555666", "Clean Code");
        library[5] = new Book(6, "ISBN777888999", "Refactoring");
        library[6] = new Book(7, "ISBN112233445", "Design Patterns");
        library[7] = new Book(8, "ISBN998877665", "Introduction to Algorithms");
        library[8] = new Book(9, "ISBN556677889", "The Art of Computer Programming");
        library[9] = new Book(10, "ISBN101010101", "Cracking the Coding Interview");
        library[10] = new Book(11, "ISBN202020202", "Effective Java");
        library[11] = new Book(12, "ISBN303030303", "Java Concurrency in Practice");
        library[12] = new Book(13, "ISBN404040404", "The Clean Coder");
        library[13] = new Book(14, "ISBN505050505", "Patterns of Enterprise Application Architecture");
        library[14] = new Book(15, "ISBN606060606", "Head First Java");
        library[15] = new Book(16, "ISBN707070707", "Test-Driven Development by Example");
        library[16] = new Book(17, "ISBN808080808", "You Don't Know JS");
        library[17] = new Book(18, "ISBN909090909", "The Mythical Man-Month");
        library[18] = new Book(19, "ISBN111111111", "Algorithms to Live By");
        library[19] = new Book(20, "ISBN222222222", "Computer Networks");
        return library;
    }

}