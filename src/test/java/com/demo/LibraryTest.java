package com.demo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest {

    private Library library;

    @Before
    public void setUp() {
        library = new Library();
        library.addBook(new Book("Le Petit Prince", "Antoine de Saint-Exupéry"));
        library.addBook(new Book("1984", "George Orwell"));
    }

    @Test
    public void testAddBook() {
        assertEquals(2, library.getBookCount());
    }

    @Test
    public void testAllBooksAvailableInitially() {
        assertEquals(2, library.getAvailableCount());
    }

    @Test
    public void testBorrowBook() {
        boolean success = library.borrowBook("1984");
        assertTrue(success);
        assertEquals(1, library.getAvailableCount());
    }

    @Test
    public void testBorrowAlreadyBorrowedBook() {
        library.borrowBook("1984");
        boolean secondAttempt = library.borrowBook("1984");
        assertFalse(secondAttempt);
    }

    @Test
    public void testReturnBook() {
        library.borrowBook("1984");
        boolean success = library.returnBook("1984");
        assertTrue(success);
        assertEquals(2, library.getAvailableCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBorrowNonExistentBook() {
        library.borrowBook("Livre Inconnu");
    }

    @Test
    public void testFindByTitle() {
        Book book = library.findByTitle("1984");
        assertNotNull(book);
        assertEquals("George Orwell", book.getAuthor());
    }
}
