package com.cezklosowski.module.utils;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionTatsuUtilsTest {

	@Test
	public void shouldReturnEmptyListWhenTypeIsNotValid() {
		assertThat(CollectionTatsuUtils.getListOfColorsPerType(null)).isEmpty();
		assertThat(CollectionTatsuUtils.getListOfColorsPerType("")).hasSize(0);
		assertThat(CollectionTatsuUtils.getListOfColorsPerType("NOT_VALID_TYPE")).isEmpty();
	}

	@Test
	public void shouldReturnFirstGroupOfColors() {
		assertThat(CollectionTatsuUtils.getListOfColorsPerType("TYPE_1")).isEqualTo(List.of("red", "blue", "green"));
		assertThat(CollectionTatsuUtils.getListOfColorsPerType("TYPE_1")).hasSize(3);

	}

	@Test
	public void shouldReturnSecondGroupOfColors() {
		assertThat(CollectionTatsuUtils.getListOfColorsPerType("TYPE_2")).containsExactly("black", "white");
	}
}