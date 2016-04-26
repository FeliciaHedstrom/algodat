
public class Main {
	public static void main(String[] args) {
		Reader reader = new Reader(args[0]);
		reader.readFile();
		Spanning spanning = new Spanning(reader.getCities(), reader.getConnection());
		spanning.fillMap();
		System.out.println(spanning.getMinimalWeight());
	}
}
