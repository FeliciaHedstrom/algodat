package test;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Reader {
	Stack<Man> men;
	ArrayList<Woman> women;
	ArrayList<Man> tempmen;
	int nbrOfGals;
	int counter;
	boolean emptyLine;
	boolean hasSemi;

	private String filepath;

	public Reader(String filepath) {
		this.filepath = filepath;
		women = new ArrayList<Woman>();
		tempmen = new ArrayList<Man>();
		men = new Stack<Man>();
		counter = 0;
		nbrOfGals = -1;
		emptyLine = false;

	}

	public void read() {
		Scanner input = new Scanner(System.in);
		File file = new File(filepath);
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (input.hasNextLine()) {
			emptyLine = false;
			String line = input.nextLine();

			if (counter == nbrOfGals) {
				emptyLine = true;

				// input.nextLine();// Varför funkar inte detta??
				counter++;

			}
			if (!emptyLine) {
				char c = line.charAt(0);
				if (c == 110) {
					String[] num = line.split("=");
					nbrOfGals = Integer.parseInt(num[1]);

				}

				if (c < 58 && c > 47) {
					String[] number = line.split(" ");
					String s;
					if (Character.toString(
							number[0].charAt(number[0].length() - 1)).matches(
							":")) {

						String[] hej = line.split(":");

						s = hej[0];

						hasSemi = true;

					} else {
						s = number[0];

					}

					if (!s.isEmpty()) {
						int nbr = Integer.parseInt(s);

						if (hasSemi == true) {

							if (nbr % 2 == 0) {
								for (int i = 0; i < tempmen.size(); i++) {

									String guyString = number[i + 1];
									int guyNbr = Integer.parseInt(guyString);
									Man guy = tempmen.get(guyNbr / 2);
									women.get((nbr / 2) - 1).addPreference(guy);

								}
							} else {
								for (int i = women.size(); i > 0; i--) {
									String galString = number[i];
									int galNbr = Integer.parseInt(galString);
									Woman gal = women.get((galNbr / 2) - 1);
									tempmen.get(nbr / 2).addPreference(gal);

								}
							}

						} else {
							String name = number[1];

							if (nbr % 2 == 0) {
								Woman w = new Woman(nbr, name);
								women.add(w);
								counter++;

							} else {
								Man m = new Man(nbr, name);
								tempmen.add(m);
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < tempmen.size(); i++) {
			men.push(tempmen.get(i));
		}

	}

	public ArrayList<Woman> getWomen() {
		return women;
	}

	public Stack<Man> getMen() {
		return men;
	}
	public ArrayList<Man> getTempMen(){
		return tempmen;
	}

}
