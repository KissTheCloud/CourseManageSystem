package com.ts.coursework.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordCreator {
	public static void main(String[] args) {
		String input="123456";
		System.out.print(new BCryptPasswordEncoder().encode(input));
	}
}
