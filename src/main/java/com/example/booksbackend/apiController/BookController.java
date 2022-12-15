package com.example.booksbackend.apiController;

import com.example.booksbackend.DTO.BookRequest;
import com.example.booksbackend.entityModel.Book;
import com.example.booksbackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookService bookService;


    @GetMapping("") //--Get the List of Books. (READ) (User).
    public List<Book> getAllBooks(){
        return bookService.getBooks();
    }

    @GetMapping(path = "/{id}") //--get a Book by by /1 (READ) (User).
    public Book getBookById(@PathVariable int id){
        return bookService.getBooksById(id);
    }

    @PostMapping("/") //--CREATE a Book by id (CREATE) (User).

    public Book createBook(@RequestBody BookRequest bookRequest){
        return bookService.addBook(bookRequest.getIsbn(), bookRequest.getTitle(), bookRequest.getAuthor(),bookRequest.getPublisher() ,bookRequest.getPublisherYear());
    }

    @PutMapping(path = "/{id}") //--EDIT a Book by id (EDIT) (User).
    public Book editBook(@RequestBody BookRequest body, @PathVariable int id ){
        return bookService.editBook(body, id);
    }

    @DeleteMapping("/{id}") //--DELETE a Book by id (EDIT) (User).
    public void deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
    }

}

