package guru.streams.com;

import java.util.Arrays;
import java.util.List;

import guru.lambdaexercise.com.Person;
/**
 * 
 * @author Srisarguru
 *
 */
public class CollectionIteration {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);
		System.out.println("Using for loop");
		//Java7 external iterator
		for (int i = 0; i < people.size(); i++) {
			System.out.println(people.get(i));
		}
		
		System.out.println("Using for in loop");
		//Java 7 external iterator
		for (Person p : people) {
			System.out.println(p);
		}
		//Java8 internal iterator
		//do not care about order. So makes it possible to have parallelism and multithreading so two elements of lists can be operated 
		//upon by one thread and other elements operated upon by another thread. 
		people.forEach(p -> System.out.println(p));
		
		System.out.println("Using lambda for each loop");
		//or 
		people.forEach(System.out::println);
	}

}
