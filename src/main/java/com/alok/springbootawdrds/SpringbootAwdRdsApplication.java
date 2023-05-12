package com.alok.springbootawdrds;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/book")
public class SpringbootAwdRdsApplication {
	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAwdRdsApplication.class, args);
	}

	@PostMapping()
	public Book saveBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	@GetMapping
	public List<Book> findBooks() {
		return bookRepository.findAll();
	}

	@SneakyThrows
	@GetMapping("/{id}")
	public Book findBook(@PathVariable Integer id) {
		Book book = bookRepository.findById(id).orElseThrow(()->new Exception("Book Not Found"));
		return book;
	}

}
