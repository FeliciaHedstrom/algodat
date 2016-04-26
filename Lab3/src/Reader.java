import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
	private String citiesAndConnections;
	ArrayList<String> cities;
	ArrayList<Connection> connections;

	public Reader(String citiesAndConnections) {
		this.citiesAndConnections = citiesAndConnections;
		cities = new ArrayList<String>();
		connections = new ArrayList<Connection>();
	}

	public ArrayList<String> getCities() {
		return cities;
	}

	public ArrayList<Connection> getConnection() {
		return connections;
	}

	public void readFile() {
		Scanner input = new Scanner(System.in);
		File file = new File(citiesAndConnections);
		try {
			input = new Scanner(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (input.hasNextLine()) {
			String line = input.nextLine();
			if (!(line.charAt(line.length() - 1) == 93)) { // ett ] - tecken
				if (line.charAt(0) == 34) { // ett " - tecken
					line = line.substring(1, line.length() - 2);
				} else {
					line = line.substring(0, line.length() - 1);
				}
				cities.add(line);

			} else {
				String from;
				String to;
				int distance;
				String stringDistance;
				String[] subString = line.split("--");
				if (subString[0].charAt(0) == 34) {
					from = subString[0].substring(1, subString[0].length() - 1);

				} else {
					from = subString[0];
				}

				if (subString[1].charAt(0) == 34) {
					String[] toCityAndDistance = subString[1].split(Character.toString('"'));
					stringDistance = toCityAndDistance[2].substring(2, toCityAndDistance[2].length() - 1);
					to = toCityAndDistance[1];
				} else {
					String[] toCityAndDistance = subString[1].split(" ");
					stringDistance = toCityAndDistance[1].substring(1, toCityAndDistance[1].length() - 1);
					to = toCityAndDistance[0];

				}
				distance = Integer.parseInt(stringDistance);
				connections.add(new Connection(from, to, distance));
				connections.add(new Connection(to, from, distance));
			}

		}

	}

}
