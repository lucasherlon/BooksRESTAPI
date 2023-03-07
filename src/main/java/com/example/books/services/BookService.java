package com.example.books.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.books.model.Book;
import com.example.books.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    /**
     * Obtain all the books in the repository
     * @return
     */
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    /**
     * Get a book in the repository according to the id
     * @param id the id of the book
     * @return the book with the id
     */
    public Optional<Book> getByID(Integer id) {
        return bookRepository.getByID(id);
    }

    /**
     * Add a book in the repository
     * @param book the book that will be added
     * @return the book added
     */
    public Book add(Book book) {
        return bookRepository.add(book);
    }

    /**
     * Delete a book from the repository
     * @param id the id of the book to be deleted
     */
    public void delete(Integer id) {
        bookRepository.delete(id);
    }

    /**
     * Update a book from the repository
     * @param id the id of the book to be updated
     * @param book the book that will be updated
     * @return
     */
    public Book update(Integer id, Book book) {
        book.setId(id);
        return bookRepository.update(book);

    }


}
