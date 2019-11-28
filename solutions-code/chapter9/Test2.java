package chapter9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test2 {

	private static final String TEXT = "Lorem ipsum dolor sit amet, "
			+ "consectetur adipiscing elit. Nunc quis tempor tellus. Nulla "
			+ "tincidunt pretium justo non finibus. Fusce quis bibendum ante. "
			+ "Vivamus a ex maximus, iaculis nunc eu, posuere augue. Vestibulum "
			+ "ante ipsum primis in faucibus orci luctus et ultrices posuere "
			+ "cubilia Curae; Nullam ut lorem metus. Vivamus consequat eros "
			+ "sed lorem rhoncus finibus. Sed porta euismod consequat. Etiam "
			+ "sodales accumsan nulla, non pretium ex tincidunt eget. Aliquam "
			+ "nibh erat, tristique vel augue sit amet, sodales sollicitudin leo. "
			+ "Mauris in arcu volutpat, efficitur erat imperdiet, finibus dolor. "
			+ "Vestibulum a dolor sed justo tempor elementum. Pellentesque eu "
			+ "tincidunt ex, et posuere orci. Phasellus non nibh non nibh pharetra "
			+ "lobortis. ";
	
	private static String[] WORDS = TEXT.toLowerCase().split("[\\s\\.,]+");
	
	public static void main(String[] args) {
		
		solution2();
	}
	
	private static final void solution1()
	{
		HashMap<String, Integer> counts = new HashMap<>();
		for( String word : WORDS )
		{
			counts.put(word, counts.getOrDefault(word, 0) + 1);
		}
		int max = 0;
		String maxWord = "NONE";
		for( String word : counts.keySet() )
		{
			if( counts.get(word) > max )
			{
				max = counts.get(word);
				maxWord = word;
			}
		}
		System.out.println(String.format("Most frequent: \"%s\" (%d occurrences)", maxWord, max));
	}
	
	private static final void solution2()
	{
		Entry<String, List<String>> result = Arrays.stream(TEXT.toLowerCase().split("[\\s\\.,]+"))
		 	.collect(Collectors.groupingBy(Function.identity()))
		 	.entrySet()
		 	.stream()
		 	.sorted((e1, e2)->e2.getValue().size() - e1.getValue().size())
		 	.findFirst()
		 	.get();
		System.out.println(String.format("Most frequent: \"%s\" (%d occurrences)", result.getKey(), result.getValue().size()));
	}
}
