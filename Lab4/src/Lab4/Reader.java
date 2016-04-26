package Lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
	String fileName;
	ArrayList<Position> positions;
	boolean xFound;
	double x;
	double y;

	public Reader(String fileName) {
		this.fileName = fileName;
		positions = new ArrayList<Position>();

	}

	public ArrayList<Position> getPostitions() {
		return positions;
	}

	public void readFile() {
		Scanner input = new Scanner(System.in);
		File file = new File(fileName);
		try {
			input = new Scanner(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String line = input.nextLine();
		line = line.trim();
		if (line.contains("NAME")) {
			while (!line.contains("NODE")) {
				line = input.nextLine();
			}
			while (input.hasNextLine()) {
				line = input.nextLine();
				line = line.trim();
				if (!line.contains("EOF")&&!line.isEmpty()) {
					String[] nbrs = line.split(" ");
					xFound = false;
					for(int j = 1; j<nbrs.length; j++){
						if(!nbrs[j].isEmpty()){
							if(xFound){
								y = Double.parseDouble(nbrs[j]);
							}else{
								x = Double.parseDouble(nbrs[j]);
								xFound=true;
							}
						}
					}
					positions.add(new Position(x, y, nbrs[0]));
				}

			}

		} else {
			while (input.hasNextLine()) {
				String[] nbrs = line.split(" ");
				double x = Double.parseDouble(nbrs[1]);
				double y = Double.parseDouble(nbrs[2]);
				positions.add(new Position(x, y, nbrs[0]));
				line = input.nextLine();

			}

		}
	}
}