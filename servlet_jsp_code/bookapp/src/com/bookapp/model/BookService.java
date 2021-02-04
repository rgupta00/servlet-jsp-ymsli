package com.bookapp.model;

import java.util.*;

public class BookService {

	public static List<String> getBookSuggestion(String topic) {
		List<String> list = new ArrayList<String>();

		if (topic.equalsIgnoreCase("Java")) {
			list.add("head first");
			list.add("thinking in java");
		} else if (topic.equalsIgnoreCase("Servlet")) {
			list.add("head first servlet jsp");
			list.add("core servlet.com");
		} else if (topic.equalsIgnoreCase("Spring")) {
			list.add("Spring in action");
			list.add("begining spring 4");
		} else
			list.add("no book");

		return list;
	}
}
