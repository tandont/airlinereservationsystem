package com.capgemini.airlinereservationsystem.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	
	public static Integer validId(String id) {
		Pattern pat = Pattern.compile("\\d+");
		Matcher mat = pat.matcher(id);
		if (mat.matches()) {
			return Integer.parseInt(id);
		} else {
			return null;
		}
	}

	public static String validEmail(String email) {
		Pattern pat = Pattern.compile("\\w+\\@\\w+\\.\\w+");
		Matcher mat = pat.matcher(email);
		if (mat.matches()) {
			return email;
		} else {
			return null;
		}
	}

	public static Long validContact(String contact) {
		Pattern pat = Pattern.compile("\\d{10}");
		Matcher mat = pat.matcher(contact);
		if (mat.matches()) {
			return Long.parseLong(contact);
		} else {
			return null;
		}
	}
	
	public static boolean validPassword(String pwd) {
		if (!((pwd.length() >= 8) && (pwd.length() <= 15))) {
			return false;
		}

		if (pwd.contains(" ")) {
			return false;
		}

		if (true) {
			int count = 0;
			for (int i = 0; i <= 9; i++) {

				String str1 = Integer.toString(i);

				if (pwd.contains(str1)) {
					count = 1;
				}
			}
			if (count == 0) {
				return false;
			}
		}

		if (!(pwd.contains("@") || pwd.contains("#") || pwd.contains("!") || pwd.contains("~") || pwd.contains("$")
				|| pwd.contains("%") || pwd.contains("^") || pwd.contains("&") || pwd.contains("*") || pwd.contains("(")
				|| pwd.contains(")") || pwd.contains("-") || pwd.contains("+") || pwd.contains("/") || pwd.contains(":")
				|| pwd.contains(".") || pwd.contains(", ") || pwd.contains("<") || pwd.contains(">")
				|| pwd.contains("?") || pwd.contains("|"))) {
			return false;
		}

		if (true) {
			int count = 0;

		
			for (int i = 65; i <= 90; i++) {
				char c = (char) i;

				String str1 = Character.toString(c);
				if (pwd.contains(str1)) {
					count = 1;
				}
			}
			if (count == 0) {
				return false;
			}
		}

		if (true) {
			int count = 0;
			
			for (int i = 90; i <= 122; i++) {

				char c = (char) i;
				String str1 = Character.toString(c);

				if (pwd.contains(str1)) {
					count = 1;
				}
			}
			if (count == 0) {
				return false;
			}
		}
		return true;
	}
}
