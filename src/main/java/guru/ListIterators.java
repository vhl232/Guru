package guru;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListIterators {

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i <20 ; i++) {
			list.add(i);
		}
		Iterator<Integer> iterator = list.iterator();
		ListIterator<Integer> integerListIterator = list.listIterator();

	}
}
