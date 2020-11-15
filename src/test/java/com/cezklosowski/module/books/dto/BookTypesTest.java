package com.cezklosowski.module.books.dto;

import org.junit.Test;

import java.awt.print.Book;

import static org.assertj.core.api.Assertions.assertThat;

public class BookTypesTest {

	@Test
	public void shouldReturnDefaultEnumInCaseOfNullOrInvalidValue() {

		// given
		String typeNull = null;
		String typeInvalid = "poetry";
		String typeEmpty = "";

		// when
		BookTypes bookTypeNull = BookTypes.byString(typeNull);
		BookTypes bookTypeInvalid = BookTypes.byString(typeInvalid);
		BookTypes bookTypeEmpty = BookTypes.byString(typeEmpty);

		// then

		assertThat(bookTypeNull).isEqualTo(BookTypes.CLASSIC);
		assertThat(bookTypeInvalid).isEqualTo(BookTypes.CLASSIC);
		assertThat(bookTypeEmpty).isEqualTo(BookTypes.CLASSIC);
	}

	@Test
	public void shouldReturnEnumByString() {

		// given
		String typeString = "ACTION";

		// when
		BookTypes bookType = BookTypes.byString(typeString);

		// then
		assertThat(bookType).isEqualTo(BookTypes.ACTION);
	}

	@Test
	public void shouldReturnEnumByStringAndIgnoreCase() {

		// given
		String typeString = "actiON";

		// when
		BookTypes bookType = BookTypes.byString(typeString);

		// then
		assertThat(bookType).isEqualTo(BookTypes.ACTION);
	}

}