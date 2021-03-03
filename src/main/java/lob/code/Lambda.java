package lob.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Lambda {

	@FunctionalInterface
	interface Lob {
		public abstract void run();
	}

	private static int a = 10;

	public void hello() {

		final int b = 20;
		int c = 30;
		int d = 40;

		final Lob lobA = () -> System.out.println(a);
		lobA.run();

		// a 재정의
		a = 20;
		final Lob lobB = () -> System.out.println(a);
		lobB.run();

		final Lob lobC = () -> System.out.println(b);
		lobC.run();

		final Lob lobD = () -> System.out.println(c);
		lobD.run();

		final Lob lobE = () -> System.out.println(d);
		lobE.run();


		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");

		printList(list, System.out::println);


	}

	public static void main(String[] args) {
		Lambda lambda = new Lambda();
		lambda.hello();
	}

	public static void printList(List<String> list, Consumer<String> consumer) {
		for (String item : list) {
			consumer.accept(item);
		}
	}

}
