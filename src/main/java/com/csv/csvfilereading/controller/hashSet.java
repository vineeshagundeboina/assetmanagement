package com.csv.csvfilereading.controller;

import java.util.HashSet;

public class hashSet

{

	public static void main(String[] args)

	{

		HashSet<String> hashSet = new HashSet<>();
		hashSet.add("Geeks");
		hashSet.add("GeeksforGeeks");

		hashSet.add("for");
		hashSet.add("Geeks");

		System.out.println(hashSet);

	}
}