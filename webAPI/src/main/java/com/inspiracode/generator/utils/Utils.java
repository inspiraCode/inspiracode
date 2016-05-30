package com.inspiracode.generator.utils;

public class Utils {
	public static String ToVariable(String value) {

		if (value == null || value.equals("")) {
			throw new IllegalArgumentException(
					"Value must not be empty nor null.");
		}

		StringBuilder result = new StringBuilder();
		String[] valueSplitted = value.split(" ");
		result.append(valueSplitted[0]);
		for (int i = 1; i < valueSplitted.length; i++) {
			result.append(valueSplitted[i].substring(0, 1).toUpperCase());
			result.append(valueSplitted[i].substring(1).toLowerCase());
		}
		return result.toString();
	}
}
