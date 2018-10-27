package com.psalguero.springboot.basics.springbootin10steps;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class BooksController {

    @GetMapping("/books")
    public List<Book> getListAllBooks() {
        return Arrays.asList(
                new Book(1,"Spring boot 5","Patrick Salguero"),
                new Book(2,"Master Git", "Patrick Salguero")
        );
    }
}
