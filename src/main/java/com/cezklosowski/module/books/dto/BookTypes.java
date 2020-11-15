package com.cezklosowski.module.books.dto;

import com.cezklosowski.module.utils.StringTatsuUtils;

public enum BookTypes {
	ACTION,
	FANTASY,
	HORROR,
	CLASSIC;

	public static BookTypes byString(String str) {
		if (StringTatsuUtils.isBlank(str)) {
			return CLASSIC;
		}
		try {
			return BookTypes.valueOf(str.toUpperCase());
		} catch (Exception ex) {
			return CLASSIC;
		}
	}

}
