
package com.pluralsight;
import java.util.Scanner;

public class Main{
    public static Book[] library;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        library = GetInitializedLibrary();

        char option;
        do{
            option = PromptChoices();
            switch(option){
                case 'A':
                    DisplayBooks(GetAvailableBooks(library));
                    break;
                case 'C':
                    DisplayBooks(GetCheckedOutBooks(library));
                    break;
                case 'O':
                    CheckOutBook(library);
                    break;
                case 'R':
                    ReturnBook(library);
                    break;
            }
        }while(option != 'X');
    }

    //This is going to return Available Books
    public static Book[] GetAvailableBooks(Book[] books){
        Book[] availableBooks = new Book[books.length];
        int nextIndex = 0;

        for(Book book : books) {
            if (!book.isCheckedOut()) {
                availableBooks[nextIndex++] = book;
            }
        }

        Book[] result = new Book[nextIndex];
        System.arraycopy(availableBooks, 0, result, 0, nextIndex);
        return result;
    }

    //This is going to return Checkout books
    public static Book[] GetCheckedOutBooks(Book[] books){
        Book[] checkedOut = new Book[books.length];
        int nextIndex = 0;

        for(Book book : books){
            if(book.isCheckedOut()){
                checkedOut[nextIndex++] = book;
            }
        }

        Book[] result = new Book[nextIndex];
        System.arraycopy(checkedOut, 0, result, 0, nextIndex);
        return result;
    }

    //This is going to show the user whether books are available or checked out.
    public static void DisplayBooks(Book[] books){
        for (Book book : books) {
            if (book != null) {
                String checkedOutTo = (book.getCheckedOutTo() != null) ? "Checked out to: " + book.getCheckedOutTo() : "Available";
                System.out.printf("%5s %55s %20s %s\n", book.getId(), book.getTitle(), book.getISBN(), checkedOutTo);
            }
        }
    }

    //This will allow the user to choose from different options.
    public static char PromptChoices(){
        System.out.println("Welcome to the Library! Please select from the following options:");
        System.out.println("    Show [A]vailable Books");
        System.out.println("    Show [C]hecked Out Books");
        System.out.println("    [O] Check Out a Books");
        System.out.println("    [R] Return a Book");
        System.out.println("    E[X]it the Library");

        do {
            System.out.print("Command [A, C, O, R, X]: ");
            String command = Console.PromptForString();

            if (command.equalsIgnoreCase("A")) {
                return 'A';
            }
            if (command.equalsIgnoreCase("C")) {
                return 'C';
            }
            if (command.equalsIgnoreCase("O")) {
                return 'O';
            }
            if (command.equalsIgnoreCase("R")) {
                return 'R';
            }
            if (command.equalsIgnoreCase("X")
                    || command.equalsIgnoreCase("EXIT")
                    || command.equalsIgnoreCase("Q")
                    || command.equalsIgnoreCase("QUIT")) {
                return 'X';
            }
        } while (true);
    }

    //This will allow the user to check out book
    public static void CheckOutBook(Book[] library){
        System.out.println("Enter the ID of the Book you want to check out: ");
        int bookID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter your name: ");
        String userName = scanner.nextLine();

        for(Book book : library){
            if(book.getId() == bookID && !book.isCheckedOut()){
                book.checkedOut(userName);
                System.out.println("Book check out was successfully!");
                return;
            }
        }
        System.out.println("Book ID is not found or the book is already checked out.");
    }

    //This will allow the users to Return Book
    public static void ReturnBook(Book[] library){
        System.out.println("Enter the ID of the Book you want to return: ");
        int bookID = scanner.nextInt();

        boolean bookFound = false;
        for(Book book : library){
            if(book.getId() == bookID && book.isCheckedOut()){
                book.checkedIn();
                System.out.println("Book is returned successfully!");
                bookFound = true;
                break;
            }
        }

        if(!bookFound){
            System.out.println("Book was not found");
        }
    }

    public static Book[] GetInitializedLibrary() {
        Book[] library = new Book[20];
        library[0] = new Book(1, "Practical Tableau", "ISBN11332211");
        library[1] = new Book(2, "Pro Git", "ISBN1133229918");
        library[2] = new Book(3, "Genetic Programming", "ISBN2299220202");
        library[3] = new Book(4, "Clean Code", "ISBN9780136083238");
        library[4] = new Book(5, "Design Patterns", "ISBN9780201633610");
        library[5] = new Book(6, "Effective Java", "ISBN9780134686097");
        library[6] = new Book(7, "Java Concurrency in Practice", "ISBN9780321349606");
        library[7] = new Book(8, "The Pragmatic Programmer", "ISBN9780135957059");
        library[8] = new Book(9, "Introduction to the Theory of Computation", "ISBN9781133187790");
        library[9] = new Book(10, "Artificial Intelligence: A Modern Approach", "ISBN9780134610993");
        library[10] = new Book(11, "The Art of Computer Programming", "ISBN9780201896831");
        library[11] = new Book(12, "Python Crash Course", "ISBN9781593279288");
        library[12] = new Book(13, "The Clean Coder", "ISBN9780136083238");
        library[13] = new Book(14, "Code Complete", "ISBN9780735619678");
        library[14] = new Book(15, "Refactoring: Improving the Design of Existing Code", "ISBN9780134757599");
        library[15] = new Book(16, "Head First Design Patterns", "ISBN9780596007126");
        library[16] = new Book(17, "You Don't Know JS", "ISBN9781491950357");
        library[17] = new Book(18, "The Mythical Man-Month", "ISBN9780201835953");
        library[18] = new Book(19, "Learning JavaScript Data Structures and Algorithms", "ISBN9781785880332");
        library[19] = new Book(20, "The Elements of Programming Interviews", "ISBN9781512218237");

        return library;
    }
}

//public class Main {
//    public static Book[] library;
//
//    public static void main(String[] args){
//        library = GetInitializedLibrary();
//
//        char option;
//        do{
//            option = PromptMainChoices();
//            if(option == 'A'){
//                Book[] availableBooks = GetAvailableBooks(library);
//                DisplayBooks(availableBooks);
//            }else if(option == 'C'){
//                Book[] checkedOutBooks = GetCheckedOutBooks(library);
//                DisplayBooks(checkedOutBooks);
//            }
//        }while(option != 'X');
//    }
//
//    public static Book[] GetAvailableBooks(Book[] books){
//        Book[] available = new Book[books.length];
//
//        int nextIndex = 0;
//        for(Book book : books){
//            if(!book.isCheckedOut()){
//                available[nextIndex++] = book;
//            }
//        }
//
//        Book[] result = new Book[nextIndex];
//        System.arraycopy(available, 0, result, 0, nextIndex);
//        return result;
//    }
//
//    public static Book[] GetCheckedOutBooks(Book[] books){
//        Book[] checkedOut = new Book[books.length];
//
//        int nextIndex = 0;
//        for(Book book : books){
//            if(book.isCheckedOut()){
//                checkedOut[nextIndex++] = book;
//            }
//        }
//
//        Book[] result = new Book[nextIndex];
//        System.arraycopy(checkedOut, 0, result, 0, nextIndex);
//        return result;
//    }
//
//    public static void DisplayBooks(Book[] books){
//        System.out.printf("%5s %55s %16s\n", "ID", "Title", "ISBN");
//        for(Book book : books){
//            System.out.printf("%5s %55s %20s %s\n", book.getId(), book.getTitle(), book.getISBN(), book.getCheckedOutTo());
//        }
//    }
//
//    public static char PromptMainChoices() {
//        System.out.println("Welcome to the Library! Please select from the following choices:");
//        System.out.println("    Show [A]vailable Books");
//        System.out.println("    Show [C]hecked Out Books");
//        System.out.println("    E[X]it the Library");
//
//        do {
//            System.out.print("Command [A, C, X]: ");
//            String command = Console.PromptForString();
//
//            if (command.equalsIgnoreCase("A")) {
//                return 'A';
//            }
//            if (command.equalsIgnoreCase("C")) {
//                return 'C';
//            }
//            if (command.equalsIgnoreCase("X")
//                    || command.equalsIgnoreCase("EXIT")
//                    || command.equalsIgnoreCase("Q")
//                    || command.equalsIgnoreCase("QUIT")) {
//                return 'X';
//            }
//        } while (true);
//    }
//
//    public static Book[] GetInitializedLibrary() {
//        Book[] library = new Book[20];
//        library[0] = new Book(1, "Practical Tableau", "ISBN11332211");
//        library[1] = new Book(2, "Pro Git", "ISBN1133229918");
//        library[2] = new Book(3, "Genetic Programming", "ISBN2299220202");
//        library[3] = new Book(4, "Clean Code", "ISBN9780136083238");
//        library[4] = new Book(5, "Design Patterns", "ISBN9780201633610");
//        library[5] = new Book(6, "Effective Java", "ISBN9780134686097");
//        library[6] = new Book(7, "Java Concurrency in Practice", "ISBN9780321349606");
//        library[7] = new Book(8, "The Pragmatic Programmer", "ISBN9780135957059");
//        library[8] = new Book(9, "Introduction to the Theory of Computation", "ISBN9781133187790");
//        library[9] = new Book(10, "Artificial Intelligence: A Modern Approach", "ISBN9780134610993");
//        library[10] = new Book(11, "The Art of Computer Programming", "ISBN9780201896831");
//        library[11] = new Book(12, "Python Crash Course", "ISBN9781593279288");
//        library[12] = new Book(13, "The Clean Coder", "ISBN9780136083238");
//        library[13] = new Book(14, "Code Complete", "ISBN9780735619678");
//        library[14] = new Book(15, "Refactoring: Improving the Design of Existing Code", "ISBN9780134757599");
//        library[15] = new Book(16, "Head First Design Patterns", "ISBN9780596007126");
//        library[16] = new Book(17, "You Don't Know JS", "ISBN9781491950357");
//        library[17] = new Book(18, "The Mythical Man-Month", "ISBN9780201835953");
//        library[18] = new Book(19, "Learning JavaScript Data Structures and Algorithms", "ISBN9781785880332");
//        library[19] = new Book(20, "The Elements of Programming Interviews", "ISBN9781512218237");
//
//        library[3].checkedOut("Iftekar Hossain");
//        library[7].checkedOut("Very Long Named John");
//
//        return library;
//    }
//}