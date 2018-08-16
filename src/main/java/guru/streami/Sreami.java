package guru.streami;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Sreami {
	static Predicate<String> notLongerThanTwo = a -> a.length() > 2;
	static Predicate<String> startsWithD = a -> a.startsWith("d");
	static Comparator<String> sortBylength = (a, b) -> {
		if (a.length() > b.length()) {
			return 1;
		} else if (a.length() < b.length()) {
			return -1;
		} else return 0;
	};

	public static void main(String[] args) {
		List<String>ls = new ArrayList<>();
		ls.add("dsdsdsds");
		ls.add("a");
		ls.add("wq");
		ls.add("dwe");
		ls.add("dwer");



		ls.parallelStream()
				.filter(notLongerThanTwo)
				.filter(startsWithD)
				.sorted(sortBylength)
				.forEach(System.out::println);


	}
}
