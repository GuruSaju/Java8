package guru.streams.com;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import guru.lambdaexercise.com.Person;

public class StreamsExample {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);
		
		
		people.stream()
		.filter(p -> p.getLastName().startsWith("C"))
		.forEach(p -> System.out.println(p.getFirstName()));//terminal operation or condition
		
		int count1 = (int) people.stream()
		.filter(p -> p.getLastName().startsWith("C"))
		.count();
		
		long count = people.parallelStream() //split collection into multiple streams so it can be done in parallel
		.filter(p -> p.getLastName().startsWith("D"))
		.count();
		
		System.out.println(count);
		
		
		Random random = new Random();
		
		//ints() is a stream that returns a stream of random int values
		random.ints().limit(10).forEach(System.out::println);

		
		
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		// .collect(Collectors.toList()) because strings has been converted to a stream and has to collect it back as a list. 
		
		
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		//get list of unique squares
		
		//map The ‘map’ method is used to map each element to its corresponding result. 
		List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
		numbers.stream().map( i -> i*i).forEach(System.out::println);
		
		//The ‘filter’ method is used to eliminate elements based on a criteria.
		//get count of empty string
		int count2 = (int) strings.stream().filter(string -> string.isEmpty()).count();
		
		//Collectors
		List<String>strings1 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<String> filtered1 = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

		System.out.println("Filtered List: " + filtered1);
		String mergedString = strings1.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("Merged String: " + mergedString);
		
		
		//Example of streams
		List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
		System.out.println("List: " +strings);
		
	      count = strings.stream().filter(string->string.isEmpty()).count();
	      System.out.println("Empty Strings: " + count);
			
	      count = strings.stream().filter(string -> string.length() == 3).count();
	      System.out.println("Strings of length 3: " + count);
			
	      filtered = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.toList());
	      System.out.println("Filtered List: " + filtered);
			
	      mergedString = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.joining(", "));
	      System.out.println("Merged String: " + mergedString);
			
	      squaresList = numbers.stream().map( i ->i*i).distinct().collect(Collectors.toList());
	      System.out.println("Squares List: " + squaresList);
	      System.out.println("List: " +integers);
			
	      IntSummaryStatistics stats = integers.stream().mapToInt((x) ->x).summaryStatistics();
			
	      System.out.println("Highest number in List : " + stats.getMax());
	      System.out.println("Lowest number in List : " + stats.getMin());
	      System.out.println("Sum of all numbers : " + stats.getSum());
	      System.out.println("Average of all numbers : " + stats.getAverage());
	      System.out.println("Random Numbers: ");
		
	      //sorted lowest to highest
	      random.ints().limit(10).sorted().forEach(System.out::println);
			
	      //parallel processing
	      count = strings.parallelStream().filter(string -> string.isEmpty()).count();
	      System.out.println("Empty Strings: " + count);
	}

}
