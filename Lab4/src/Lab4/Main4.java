package Lab4;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main4 {
	public static void main(String[] args) {
		TestFileReader tR= new TestFileReader("closest-pair.out");
		ArrayList<String> files = tR.getFiles();
		ArrayList<Double> distances=tR.getDistance();
		DecimalFormat df = new DecimalFormat("###.#################3");
		df.setRoundingMode(RoundingMode.CEILING);
		for(int i=0;i<files.size();i++){
			Reader reader = new Reader(files.get(i));
			reader.readFile();
			ArrayList<Position> positions = reader.getPostitions();
			ClosestPair cp = new ClosestPair(positions);
			Distance d = cp.closestDistance(cp.sortByX(positions), cp.sortByY(positions));
			double dOut = d.getDistance();
			if(dOut==distances.get(i)){
				System.out.println("true");
			}else{
				System.err.println("expected:"+distances.get(i)+" actual:"+df.format(dOut));
			}
			
			
		}
	

	}

}
