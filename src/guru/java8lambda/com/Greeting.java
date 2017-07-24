package guru.java8lambda.com;
/**
 * 
 * @author Srisarguru
 *
 */

// to make sure that no other developer can change this interface by adding a new abstract method add
//@ functionalInterface Annotation

@FunctionalInterface
public interface Greeting {
	public void perform();
}
