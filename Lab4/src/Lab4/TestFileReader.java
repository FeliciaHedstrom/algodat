package Lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestFileReader {
	private String filePath;
	private ArrayList<Double> distances;
	public TestFileReader(String filePath){
		this.filePath=filePath;
		distances = new ArrayList<Double>();
		
	}
	public ArrayList<String> getFiles(){
		ArrayList<String> files = new ArrayList<String>();	
		Scanner input = new Scanner(System.in);
		File file = new File(filePath);
		try {
			input = new Scanner(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(input.hasNextLine()){
			String line = input.nextLine();
			String[]sub = line.split(" ");
			String fileName = sub[0].substring(8, sub[0].length()-1); 
			files.add(fileName);
			distances.add(Double.parseDouble(sub[2]));
			
		}
		return files;
		
	}
	public ArrayList<Double> getDistance(){
		return distances;
		
	}

}
