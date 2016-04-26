



	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.Scanner;

	public class TestReader {
		public String read(String filepath) {
			Scanner input = new Scanner(System.in);
			File file = new File(filepath);
			try {
				input = new Scanner(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			StringBuilder sb = new StringBuilder();
			String s;
			while (input.hasNextLine()) {
				s = input.nextLine();
				sb.append(s);
			}
			return sb.toString();
		}

	}


