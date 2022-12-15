package com.example.booksbackend.service;

import com.example.booksbackend.DTO.BookRequest;
import com.example.booksbackend.entityModel.Book;
import com.example.booksbackend.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookService {

    BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(){
        List<Book> books = bookRepository.findAll();
        return books;
    }

    public Book getBooksById(int id) {
        return bookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contact not found"));
    }


    public Book addBook(int isbn, String title, String author, String publisher, int publisherYear){
        Book book = new Book(isbn, title, author, publisher, publisherYear);
        bookRepository.save(book);

        return book;

    }

    public Book editBook(BookRequest bookRequest, int id){
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contact with this id doesn't exist"));
        book.setIsbn(bookRequest.getIsbn());
        book.setTitle(bookRequest.getTitle());
        book.setAuthor(bookRequest.getAuthor());
        book.setPublisher(bookRequest.getPublisher());
        book.setPublisherYear(bookRequest.getPublisherYear());

        return bookRepository.save(book);
    }

    public void deleteBook(int id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contact with this id doesn't exist"));
        bookRepository.delete(book);
    }




}
