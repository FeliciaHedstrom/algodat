import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Spanning {
	private int totalDistance;
	private ArrayList<Connection> connections;
	private ArrayList<String> cities;
	private HashMap<String, ArrayList<Connection>> map;

	public Spanning(ArrayList<String> cities, ArrayList<Connection> connections) {
		this.cities = cities;
		this.connections = connections;
		map = new HashMap<String, ArrayList<Connection>>();
		totalDistance = 0;
		

	}

	public void fillMap() {
		for (String s : cities) {
			map.put(s, new ArrayList<Connection>());
		}
		for (String s : cities) {
			for (Connection c : connections) {
				if (s.equals(c.getFrom())) {
					map.get(s).add(c);
				}
			}

		}
	}

	public int getMinimalWeight() {
		Queue<Connection> queue = new PriorityQueue<Connection>();
		Set<String> visitedCities = new HashSet<String>();

		String firstCity = cities.get(0);
		Connection currentConnection = null;
		visitedCities.add(firstCity);
		for (Connection c : map.get(firstCity)) {
			queue.offer(c);
		}
		while (visitedCities.size() !=cities.size()) {
			currentConnection = queue.poll();
			String currentCity=currentConnection.getTo();
				if (!visitedCities.contains(currentCity)) {
					totalDistance += currentConnection.getDistance();
					visitedCities.add(currentCity);
					for (Connection c : map.get(currentCity)) {
						if(!visitedCities.contains(c.getTo())){
						queue.offer(c);
						}
					}

				}
	
		}
		return totalDistance;
	}
}
