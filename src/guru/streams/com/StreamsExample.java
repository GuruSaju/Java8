package guru.streams.com;

import java.util.Arrays;
import java.util.List;

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
		

	}

}
