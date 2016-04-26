import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import javax.swing.SpinnerDateModel;

public class WordLadder {
	HashMap<String, ArrayList<String>> map;
	ArrayList<String> words;
	boolean alreadyFoundLetter;
	boolean searchedTree;

	public WordLadder(ArrayList<String> words) {
		this.words = words;
		map = new HashMap<String, ArrayList<String>>();
	}

	public void fillMap() {
		for (String s : words) {
			map.put(s, new ArrayList<String>());
		}
		// System.out.println(map);
		for (int k = 0; k < words.size(); k++) {
			String currentWord = words.get(k);
			String[] splittedCurrentWord = currentWord.split("");
			for (int i = 0; i < words.size(); i++) {
				if (k != i) {

					String subWord = words.get(i);
					String[] splittedSubWord = words.get(i).split("");
					for (int a = 2; a < splittedCurrentWord.length; a++) {
						alreadyFoundLetter = false;
						for (int b = 0; b < splittedSubWord.length; b++) {
							if (splittedCurrentWord[a].equals(splittedSubWord[b]) && (!alreadyFoundLetter)) {
								splittedSubWord[b] = "0";
								alreadyFoundLetter = true;
							}
						}
					}

					int counter = 0;
					for (int c = 0; c < 6; c++) {
						if (splittedSubWord[c].equals("0")) {
							counter++;
						}
					}
					if (counter == 4) {
						map.get(currentWord).add(subWord);
					}
				}
			}
		}
	}

	public int getDistance(String w1, String w2) {
		Set<String> unvisitedWords = new HashSet<String>();
		for (String s : words) {
			unvisitedWords.add(s);
		}
		if (w1.equals(w2)) {
			return 0;
		}
		Node root = new Node(w1, 0);
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		unvisitedWords.remove(w1);
		while (!q.isEmpty()) {
			Node currentNode = q.poll();
			if (currentNode.getName().equals(w2)) {
				return currentNode.getDepth();
			} else {
				unvisitedWords.remove(currentNode.getName());
				for (String s : map.get(currentNode.getName())) {
					if (unvisitedWords.contains(s)) {
						q.add(new Node(s, currentNode.getDepth() + 1));
					}
				}

			}
		}
		return -1;

	}
}
