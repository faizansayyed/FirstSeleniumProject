package com.example;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Mango", "Grapes", "Kiwi");

		// Filter - Select fruits starting with letter 'A'
		List<String> filteredFruits = fruits.stream().filter(fruit -> fruit.startsWith("A"))
				.collect(Collectors.toList());
		System.out.println("Filtered fruits: " + filteredFruits);

		// Map - Convert fruits to uppercase
		List<String> uppercaseFruits = fruits.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println("Uppercase fruits: " + uppercaseFruits);

		// Sort - Sort the fruits in natural order
		List<String> sortedFruits = fruits.stream().sorted().collect(Collectors.toList());
		System.out.println("Sorted fruits: " + sortedFruits);

		// Limit - Select first three fruits
		List<String> limitedFruits = fruits.stream().limit(3).collect(Collectors.toList());
		System.out.println("Limited fruits: " + limitedFruits);

		// Reduce - Concatenate all fruits into a single string
		String concatenatedFruits = fruits.stream().reduce("", (result, fruit) -> result + fruit + ", ");
		System.out.println("Concatenated fruits: " + concatenatedFruits);

		// AnyMatch - Check if any fruit starts with letter 'M'
		boolean anyFruitStartsWithM = fruits.stream().anyMatch(fruit -> fruit.startsWith("M"));
		System.out.println("Any fruit starts with M: " + anyFruitStartsWithM);

		// Collect - Create a comma-separated string of fruits
		String commaSeparatedFruits = fruits.stream().collect(Collectors.joining(", "));
		System.out.println("Comma-separated fruits: " + commaSeparatedFruits);
	}
}
