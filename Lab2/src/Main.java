import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[]args) throws IOException{
		Reader reader = new Reader(args[0],args[1]);
		Printer printer = new Printer("output.txt");
		WordLadder wl = new WordLadder(reader.readDat());
		ArrayList<String[]> words = reader.readTxt();
		ArrayList<Integer> distances = new ArrayList<Integer>();
		wl.fillMap();
		for(String[] s:words){
			distances.add(wl.getDistance(s[0], s[1]));
		}
		StringBuilder sb = new StringBuilder();
		for(int i : distances){
			sb.append(i + "\n");
		}
		System.out.println(sb.toString());
		printer.print(sb.toString());
	}

}
