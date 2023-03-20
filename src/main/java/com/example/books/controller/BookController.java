package com.example.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.books.model.Book;
import com.example.books.services.BookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public Book add(@RequestBody Book book) {
        return bookService.add(book);
    }

    @GetMapping("/{id}")
    public Optional<Book> getByID(@PathVariable int id) {
        return bookService.getByID(id);
    }

    @GetMapping("/{name}")
    public Optional<Book> getByName(@PathVariable String name) {
        return bookService.getByName(name);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        bookService.delete(id);
        return "Operation concluded with exit";

    }

    @PutMapping("/{id}")
    public Book update(@RequestBody Book book, @PathVariable int id) {
        return bookService.update(id, book);
    }

}
