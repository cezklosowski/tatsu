package com.cezklosowski.module.person;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonDtoTest {

	private static final String NAME = "Michał";
	private static final String SURNAME = "Szałkowski";
	private static final String EMAIL = "no@michalszalkowski.com";

	@Test
	public void shouldReturnEmptyObject() {
		// given
		// when
			// przygotowanie danych
				PersonDto personDto = new PersonDto();
		// then
			// asercje
				assertThat(personDto.getName()).isNull();
				assertThat(personDto.getSurname()).isNull();
				assertThat(personDto.getEmail()).isNull();
				assertThat(personDto.isEmailValid()).isFalse();
	}

	@Test
	public void shouldReturnPerson() {
		// given
		// when
		PersonDto personDto = new PersonDto(NAME,SURNAME,EMAIL);
		// then
		assertThat(personDto.getName()).isEqualTo("Michał");
		assertThat(personDto.getSurname()).isEqualTo("Szałkowski");
		assertThat(personDto.getEmail()).isEqualTo("no@michalszalkowski.com");
		assertThat(personDto.isEmailValid()).isTrue();
	}
}