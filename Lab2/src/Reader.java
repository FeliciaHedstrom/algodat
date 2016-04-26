import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
	private String datFile;
	private String txtFile;
	private ArrayList<String> words;
	private ArrayList<String[]> twoWords;
	

	public Reader(String datFile, String txtFile) {
		this.datFile = datFile;
		this.txtFile = txtFile;
		words = new ArrayList<String>();
		twoWords = new ArrayList<String[]>();
	}

	public ArrayList<String> readDat() {
		Scanner input = new Scanner(System.in);
		File file = new File(datFile);
		try {
			input = new Scanner(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(input.hasNextLine()){
			String line = input.nextLine();
			words.add(line);
		}
		return words;
	}

	public ArrayList<String[]> readTxt() {
		Scanner input = new Scanner(System.in);
		File file = new File(txtFile);
		try {
			input = new Scanner(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(input.hasNextLine()){
			String line = input.nextLine();
			String[] word = line.split(" ");
			twoWords.add(word);
		}
		return twoWords;
			
	}
	
}
