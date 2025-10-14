package Felipe.D3;

import java.util.*;

public class Library {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(String title) {
        books.put(title.toLowerCase(), new Book(title));
    }

    public void borrowBook(String title) throws InvalidInput {
        Book book = books.get(title.toLowerCase());
        if (book == null) {
            throw new InvalidInput("Das Buch existiert nicht: " + title);
        }
        book.borrow();
    }

    public void returnBook(String title) throws InvalidInput {
        Book book = books.get(title.toLowerCase());
        if (book == null) {
            throw new InvalidInput("Das Buch existiert nicht: " + title);
        }
        book.giveBack();
    }

    public Collection<Book> getBooks() {
        return books.values();
    }
}