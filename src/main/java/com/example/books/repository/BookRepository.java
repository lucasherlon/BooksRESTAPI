package com.example.books.repository;

import com.example.books.model.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Repository;
import com.example.books.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {

    private List<Book> books = new ArrayList<>();
    private Integer lastID = 0;

    /**
     * Method to get all the books listed
     * @return return the arrayList of books
     */
    public List<Book> getAllBooks() {
        return books;
    }

    /**
     * Gets a book in the arrayList by its ID
     * @param id the id of the book
     * @return the book with the given id
     */
    public Optional<Book> getByID(Integer id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst();
    }

    /**
     * Add a new book to the arrayList
     * @param book
     * @return
     */
    public Book add(Book book) {
        lastID++;
        book.setId(lastID);
        books.add(book);
        return book;
    }

    /**
     * Delete a book from the arrayList
     * @param id id of the book to be deleted
     */
    public void delete(Integer id) {
        books.removeIf(book -> book.getId() == id);
    }

    /**
     * Update a book in the list
     * @param book the book that will replace the older
     * @return the book added to the list
     */
    public Book update(Book book) {
        Optional<Book> bookOptional = getByID(book.getId());

        if (bookOptional.isEmpty())
            throw new ResourceNotFoundException("Book not found!");

        delete(book.getId());
        books.add(book);
        return book;
    }

}
