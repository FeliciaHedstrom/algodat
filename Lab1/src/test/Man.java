package test;

import java.util.ArrayList;
import java.util.Stack;

public class Man {
	private int nbr;
	private boolean isMarried;
	private Stack<Woman> preferenceList;
	private String name;
	private Woman wife;
	
	
	public Man(int nbr, String name){
		this.nbr=nbr;
		isMarried = false;
		preferenceList = new Stack<Woman>();
		this.name=name;
		wife = null;
	}
	public void addPreference(Woman woman){
		preferenceList.push(woman);
	}
	
	public Woman getPreference(){
		return preferenceList.pop();
	}
	public int getNbr(){
		return nbr;
	}
	public boolean isMarried(){
		return isMarried;
	}
	public void marry(Woman wife){
		this.wife=wife;
		isMarried=true;
	}
	public Woman getWife(){
		return wife;
	}
	public void divorce(){
		wife = null;
		isMarried=false;
	}
	public String getName(){
		return name;
	}
}
