package guru.functionalInterfaces.com;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import guru.lambdaexercise.com.Condition;
import guru.lambdaexercise.com.Person;

public class FunctionalInterfaces {
	
	public static void main(String[] args) {
	List<Person> people = Arrays.asList(
			new Person("Charles", "Dickens", 60),
			new Person("Lewis", "Carroll", 42),
			new Person("Thomas", "Carlyle", 51),
			new Person("Charlotte", "Bronte", 45),
			new Person("Matthew", "Arnold", 39)
			);


	// Step 1: Sort list by last name
			Collections.sort(people, (p1,p2) -> p1.getLastName().compareTo(p2.getLastName()));
			
			// Step 2: Create a method that prints all elements in the list
			System.out.println("Printing all persons");
			printConditionally(people, p -> true, p -> System.out.println(p)); //Consumer function accepts an argument and no result
			
			// Step 3: Create a method that prints all people that have last name beginning with C
			System.out.println("Printing all persons with last name beginning with C");
			printConditionally(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p));
			
			System.out.println("Printing all persons with first name beginning with C");
			//now we can have different types of printing based on first name or fully or just lastname or age...
			printConditionally(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p.getFirstName()));
			
		}

		private static void printConditionally1(List<Person> people, Condition condition) {
			for (Person p : people) {
				if (condition.test(p)) {
					System.out.println(p);
				}
			}
			}
			
			//Using java.util.functions have out of box interfaes which are functional interfaces. No need for Condition Interface
			private static void printConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
				for (Person p : people) {
					if (predicate.test(p)) {
						consumer.accept(p);;
					}
					
				}
				
			
			}

	}