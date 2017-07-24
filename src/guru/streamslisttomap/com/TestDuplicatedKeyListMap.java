package guru.streamslisttomap.com;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestDuplicatedKeyListMap {

	public static void main(String[] args) {
		 List<Hosting> list = new ArrayList<>();
	        list.add(new Hosting(1, "liquidweb.com", 80000));
	        list.add(new Hosting(2, "linode.com", 90000));
	        list.add(new Hosting(3, "digitalocean.com", 120000));
	        list.add(new Hosting(4, "aws.amazon.com", 200000));
	        list.add(new Hosting(5, "mkyong.com", 1));

	        list.add(new Hosting(6, "linode.com", 100000)); // new line

	        // key = name, value - websites , but the key 'linode' is duplicated!?
	        Map<String, Long> result1 = list.stream().collect(
	                Collectors.toMap(Hosting::getName, Hosting::getWebsites));

	        System.out.println("Result 1 : " + result1);
	        /*
	        Exception in thread "main" java.lang.IllegalStateException: Duplicate key 90000
	    	at java.util.stream.Collectors.lambda$throwingMerger$0(Collectors.java:133)
	    	at java.util.HashMap.merge(HashMap.java:1245)
	    	//...
*/
	    	//(oldValue, newValue) -> oldValue ==> If the key is duplicated, do you prefer oldKey or newKey?
	    	
	    	//oldvalue
	        Map<String, Long> result3 = list.stream().collect(
	                Collectors.toMap(Hosting::getName, Hosting::getWebsites,
	                        (oldValue, newValue) -> oldValue
	                )
	        );
	        //Result 1 : {..., aws.amazon.com=200000, linode.com=90000}
	        
	        //newvalue
	        Map<String, Long> result2 = list.stream().collect(
	                Collectors.toMap(Hosting::getName, Hosting::getWebsites,
	                        (oldValue, newValue) -> newValue
	                )
	        );
	        //Result 1 : {..., aws.amazon.com=200000, linode.com=100000}
	        
	        
	        //Sort&Collect
	        //Comparator has more methods in Java 8
	        //LinkedHashmap
	        Map result4 = list.stream()
	                .sorted(Comparator.comparingLong(Hosting::getWebsites).reversed())
	                .collect(
	                        Collectors.toMap(
	                                Hosting::getName, Hosting::getWebsites, // key = name, value = websites
	                                (oldValue, newValue) -> oldValue,       // if same key, take the old key
	                                LinkedHashMap::new                      // returns a LinkedHashMap, keep order
	                        ));
	        //Result 1 : {aws.amazon.com=200000, digitalocean.com=120000, linode.com=100000, liquidweb.com=80000, mkyong.com=1}
	        
	        //Hashmap
	        Map result5 = list.stream()
	                .collect(
	                        Collectors.toMap(
	                                Hosting::getName, Hosting::getWebsites, // key = name, value = websites
	                                (oldValue, newValue) -> oldValue,       // if same key, take the old key
	                                HashMap::new                      // returns a HashMap, keep order
	                        ));
	    }
	}