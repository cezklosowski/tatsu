package com.cezklosowski.module.books;

import com.cezklosowski.module.books.dto.BookDto;
import com.cezklosowski.module.books.dto.BookForm;
import com.cezklosowski.module.books.entity.BookEntity;
import com.cezklosowski.module.books.mapper.BookFormMapper;
import com.cezklosowski.module.books.mapper.BookMapper;
import com.cezklosowski.module.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BooksController {

	@Autowired
	private BookService bookService;

	@GetMapping("/api/books/{id}")
	public BookDto getBook(@PathVariable Long id) {
		BookEntity bookEntity = bookService.getOne(id);
		return BookMapper.map(bookEntity);
	}

	@GetMapping("/api/books")
	public List<BookDto> getBooks() {
		List<BookEntity> books = bookService.getAll();
		return BookMapper.map(books);
	}

	@PostMapping("/api/books")
	public BookDto newBooks(@Valid @RequestBody BookForm bookForm) {
		BookEntity book = BookFormMapper.map(bookForm);
		book = bookService.create(book);
		return BookMapper.map(book);
	}

	@PutMapping("/api/books/{id}")
	public BookDto updateBooks(@PathVariable Long id,
	                           @RequestBody BookEntity bookEntity) {
		BookEntity book = bookService.update(id, bookEntity);
		return BookMapper.map(book);
	}

	@DeleteMapping("/api/books/{id}")
	public void delete(@PathVariable Long id) {
		bookService.delete(id);
	}

}
