package com.demo;

public class App {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("Le Petit Prince", "Antoine de Saint-Exupéry"));
        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("Clean Code", "Robert C. Martin"));

        System.out.println("=== Bibliothèque ===");
        System.out.println("Nombre total de livres : " + library.getBookCount());
        System.out.println("Livres disponibles : " + library.getAvailableCount());

        System.out.println("\nEmprunt de '1984'...");
        library.borrowBook("1984");
        System.out.println("Livres disponibles : " + library.getAvailableCount());

        System.out.println("\nRetour de '1984'...");
        library.returnBook("1984");
        System.out.println("Livres disponibles : " + library.getAvailableCount());
    }
}