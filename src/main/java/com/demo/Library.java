package com.demo;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public int getBookCount() {
        return books.size();
    }

    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public boolean borrowBook(String title) {
        Book book = findByTitle(title);
        if (book == null) {
            throw new IllegalArgumentException("Livre introuvable : " + title);
        }
        if (book.isBorrowed()) {
            return false;
        }
        book.setBorrowed(true);
        return true;
    }

    public boolean returnBook(String title) {
        Book book = findByTitle(title);
        if (book == null) {
            throw new IllegalArgumentException("Livre introuvable : " + title);
        }
        if (!book.isBorrowed()) {
            return false;
        }
        book.setBorrowed(false);
        return true;
    }

    public List<Book> getAvailableBooks() {
        List<Book> available = new ArrayList<>();
        for (Book book : books) {
            if (!book.isBorrowed()) {
                available.add(book);
            }
        }
        return available;
    }

    public int getAvailableCount() {
        return getAvailableBooks().size();
    }
}