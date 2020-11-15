package com.cezklosowski.module.person;

import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonMapperTest {

    private static final String NAME = "Michał";
    private static final String SURNAME = "Szałkowski";
    private static final String EMAIL = "no@michalszalkowski.com";

    @Test
    public void shouldReturnNull() {

        // given
        PersonEntity personEntity = null;

        // when
        PersonDto personDto = PersonMapper.map(personEntity);

        // then
        assertThat(personDto).isNull();

    }

    @Test
    public void shouldReturnDto() {

        // given
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(NAME);
        personEntity.setSurname(SURNAME);
        personEntity.setEmail(EMAIL);

        // when
        PersonDto personDto = PersonMapper.map(personEntity);

        // then
        assertThat(personDto.getName()).isEqualTo(personEntity.getName());
        assertThat(personDto.getSurname()).isEqualTo(personEntity.getSurname());
        assertThat(personDto.getEmail()).isEqualTo(personEntity.getEmail());
    }

    @Test
    public void shouldReturnEmptyList() {

        // given
        List<PersonEntity> personEntityList = List.of();

        // when
        List<PersonDto> personDtoList = PersonMapper.asList(personEntityList);

        // then
        assertThat(personDtoList).isEmpty();

    }

    @Test
    public void shouldReturnList() {

        // given
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(NAME);
        personEntity.setSurname(SURNAME);
        personEntity.setEmail(EMAIL);

        List<PersonEntity> personEntityList = List.of(personEntity, personEntity);

        // when
        List<PersonDto> personDtoList = PersonMapper.asList(personEntityList);

        // then
        assertThat(personDtoList)
                .isNotEmpty()
                .hasSize(2);
    }

    @Test
    public void shouldReturnSet() {

        // given
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(NAME);
        personEntity.setSurname(SURNAME);
        personEntity.setEmail(EMAIL);

        List<PersonEntity> personEntityList = List.of(personEntity, personEntity);

        // when
        Set<PersonDto> personDtoSet = PersonMapper.asSet(personEntityList);

        // then
        assertThat(personDtoSet)
                .isNotEmpty()
                .hasSize(1);
    }
}