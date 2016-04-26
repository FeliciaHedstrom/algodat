package test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
//googla ta bort whitespaces
public class GS {
	public static void main(String[] args) throws IOException {
		Stack<Man> men = new Stack<Man>();
		ArrayList<Woman> women = new ArrayList<Woman>();
		ArrayList<Man> tempmen = new ArrayList<Man>();

		try {
			Scanner input = new Scanner(System.in);
			File file = new File(args[0]);
			input = new Scanner(file);
			while (input.hasNextLine()) {
				String line = input.nextLine();
				
				if (!line.isEmpty()) {
					if (Character.isDigit(line.charAt(0))) {
						char c = line.charAt(0);
						String[] number = line.split(" ");
						String s;
						boolean hasSemi = false;
						if (Character.toString(
								number[0].charAt(number[0].length() - 1))
								.matches(":")) {
							s = number[0].substring(0, number[0].length() - 2);

							hasSemi = true;
						} else  {
							s = number[0];

						}
						
						System.out.println("S:"+s);
						if(!s.equals("")){
						int nbr = Integer.parseInt(s);
						
						if (!hasSemi) {

							String name = number[1];
							
							if (nbr % 2 == 0) {
								women.add(new Woman(nbr, name));

							} else {
								tempmen.add(new Man(nbr, name));
							}

						} else {
							String[] parts = line.split(" ");
							if (nbr % 2 == 0) {
								nbr = (nbr / 2) - 1;
								for (int i = 1; i < parts.length; i++) {
									String guy = parts[i];
									int mnbr = Integer.parseInt(guy);
									women.get(nbr).addPreference(
											tempmen.get((mnbr / 2)));
								}

							} else {
								nbr = nbr / 2;
								for (int i = parts.length - 1; i > 0; i--) {
									String gal = parts[i];
								
									int wnbr = Integer.parseInt(gal);
									System.out.println("wnbr;"+wnbr);
									tempmen.get(nbr).addPreference(
											women.get((wnbr / 2) - 1));
								}
							}

						}
					}
					}
				}
			}
			for (int i = 0; i < tempmen.size(); i++) {
				men.push(tempmen.get(i));
			}
			input.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		StableMarriage sm = new StableMarriage(men, women);
		sm.run();
		System.out.println(sm.print(tempmen));
		Printer printer = new Printer("output.txt");
		printer.print(sm.print(tempmen));

	}

}
