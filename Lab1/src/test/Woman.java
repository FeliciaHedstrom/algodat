package test;

import java.util.ArrayList;

public class Woman {
	private int nbr;
	private ArrayList<Man> preferenceList;
	private boolean isMarried;
	private Man husband;
	private String name;

	public Woman(int nbr, String name) {
		this.nbr = nbr;
		preferenceList = new ArrayList<Man>();
		isMarried = false;
		this.name = name;
	}

	public void addPreference(Man man) {
		preferenceList.add(man);
	}

	public boolean prefersHusband(Man man) {
		if (preferenceList.indexOf(man) < preferenceList.indexOf(husband)) {
			return false;
		}
		return true;
	}

	public void marry(Man husband) {
		isMarried = true;
		this.husband = husband;
	}

	public boolean isMarried() {
		return isMarried;
	}

	public int getNbr() {
		return nbr;
	}

	public Man getHusband() {
		return husband;

	}

	public String getName() {
		return name;

	}
}