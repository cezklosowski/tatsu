package com.cezklosowski.module.books.service;

import com.cezklosowski.module.books.entity.BookEntity;
import com.cezklosowski.module.books.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

	private static final long VALID_BOOK_ID = 1;
	private static final long NOT_VALID_BOOK_ID = 0;
	private static final BookEntity BOOK = new BookEntity();

	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	private BookService bookService;

	@Test
	public void shouldCallGetOneWhenIdIsValid() {

		// when
		bookService.getOne(VALID_BOOK_ID);

		// then
		Mockito.verify(bookRepository).getOne(VALID_BOOK_ID);
	}

	@Test
	public void shouldNotCallGetOneWhenIdIsValid() {

		// when
		bookService.getOne(NOT_VALID_BOOK_ID);

		// then
		Mockito.verify(bookRepository, times(0)).getOne(NOT_VALID_BOOK_ID);
	}

	@Test
	public void shouldCallFindAll() {

		// when
		bookService.getAll();

		// then
		Mockito.verify(bookRepository).findAll();
	}

	@Test
	public void shouldCallDaoSaveAndFlashDuringCreation() {

		// when
		bookService.create(BOOK);

		// then
		Mockito.verify(bookRepository).saveAndFlush(BOOK);
	}

	@Test
	public void shouldNotCallDaoSaveAndFlashWhenObjectIsEqualToNull() {

		// when
		bookService.create(null);

		// then
		Mockito.verify(bookRepository, times(0)).saveAndFlush(null);
	}

	@Test
	public void shouldCallDaoDeleteById() {

		// when
		bookService.delete(VALID_BOOK_ID);

		// then
		Mockito.verify(bookRepository).deleteById(VALID_BOOK_ID);

	}

	@Test
	public void shouldSaveAndFlashInCaseOfUpdate() {

		// when
		bookService.update(VALID_BOOK_ID,BOOK);

		// then
		Mockito.verify(bookRepository).saveAndFlush(BOOK);
	}
}