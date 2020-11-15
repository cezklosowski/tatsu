package com.cezklosowski.module.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTatsuUtilsTest {

	@Test
	public void shouldReturnTrueWhenProductionIsOn() {
		assertThat(StringTatsuUtils.isProductionState()).isTrue();
	}

	@Test
	public void shouldReturnFalseWhenDevIsOff() {
		assertThat(StringTatsuUtils.isDevState()).isFalse();
	}

	@Test
	public void shouldReturnTrueWhenStringIsBlank() {
		assertThat(StringTatsuUtils.isBlank(null)).isTrue();
		assertThat(StringTatsuUtils.isBlank("")).isTrue();
		assertThat(StringTatsuUtils.isBlank("   ")).isTrue();
	}

	@Test
	public void shouldReturnFalseWhenStringIsNotBlank() {
		assertThat(StringTatsuUtils.isBlank("  a")).isFalse();
		assertThat(StringTatsuUtils.isBlank("a   ")).isFalse();
	}

	@Test
	public void shouldReturnFalseWhenEmailIsNotValid() {
		assertThat(StringTatsuUtils.isEmail("")).isFalse();
		assertThat(StringTatsuUtils.isEmail(" ")).isFalse();
		assertThat(StringTatsuUtils.isEmail("abc")).isFalse();
		assertThat(StringTatsuUtils.isEmail("abc@")).isFalse();
		assertThat(StringTatsuUtils.isEmail("abc@gmail")).isFalse();
		assertThat(StringTatsuUtils.isEmail("abc@gmail.")).isFalse();
		assertThat(StringTatsuUtils.isEmail("abc@gmail.@")).isFalse();
	}

	@Test
	public void shouldReturnTrueWhenEmailIsValid() {
		assertThat(StringTatsuUtils.isEmail("abc@abc.abd")).isTrue();
		assertThat(StringTatsuUtils.isEmail("abc@abc.ab")).isTrue();
		assertThat(StringTatsuUtils.isEmail("ABD@aB.aBC")).isTrue();
	}

	@Test
	public void shouldReturnFullName() {
		assertThat(StringTatsuUtils.getFullName(null, null)).isEqualTo("");
		assertThat(StringTatsuUtils.getFullName("ala", null)).isEqualTo("ala");
		assertThat(StringTatsuUtils.getFullName(null, "kowalska")).isEqualTo("kowalska");
		assertThat(StringTatsuUtils.getFullName("alina", "krawczyk")).isEqualTo("alina krawczyk");
	}
}