package test;

import java.io.IOException;

public class Main {
	public static void main(String[]args) throws IOException{
		Reader reader =new Reader(args[0]);
		reader.read();
		Printer printer = new Printer("output.txt");
		StableMarriage sm = new StableMarriage(reader.getMen(), reader.getWomen());
		sm.run();
		System.out.println(sm.print(reader.getTempMen()));
		printer.print(sm.print(reader.getTempMen()));
	}

}
