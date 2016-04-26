import java.util.ArrayList;

public class FirstTest {
	public static void main (String args[]){
		ArrayList<String> words = new ArrayList<String>();
		words.add("there");
		words.add("which");
		words.add("their");
		words.add("about");
		words.add("these");
		words.add("words");
		words.add("would");
		words.add("other");
		words.add("write");
		words.add("could");
		WordLadder wl = new WordLadder(words);
		wl.fillMap();
		System.out.println(wl.getDistance("other", "there"));
		System.out.println(wl.getDistance("other", "their"));
		System.out.println(wl.getDistance("could", "would"));
		System.out.println(wl.getDistance("would", "could"));
		System.out.println(wl.getDistance("there", "other"));
		System.out.println(wl.getDistance("about", "there"));
		System.out.println("Hej" + "\n");
	}
}
