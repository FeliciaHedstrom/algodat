package test;

import java.util.ArrayList;
import java.util.Stack;

public class StableMarriage {
	private Stack<Man> men;
	private ArrayList<Woman> marriedWomen;
	private ArrayList<Woman> women;

	public StableMarriage(Stack<Man> men, ArrayList<Woman> women) {
		this.men = men;
		this.women = women;
		marriedWomen = new ArrayList<Woman>();
	}

	public void run() {
		while (!men.isEmpty()) {
			Man currentGuy = men.pop();
			while(!currentGuy.isMarried()){
			Woman currentGal=currentGuy.getPreference();
			if(currentGal.isMarried()&&(!currentGal.prefersHusband(currentGuy))){
				currentGal.getHusband().divorce();
				men.push(currentGal.getHusband());
				currentGal.marry(currentGuy);
				currentGuy.marry(currentGal);
				
			}else if(!currentGal.isMarried()){
				currentGal.marry(currentGuy);
				marriedWomen.add(currentGal);
				currentGuy.marry(currentGal);

			}
		}
	}
	}


	public String print(ArrayList<Man> men) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < men.size(); i++){
	
			sb.append(men.get(i).getName()+" -- "+men.get(i).getWife().getName()+"\n");
			
		}
		return sb.toString();
	}
}
