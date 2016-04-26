package Lab4;

import java.util.Comparator;

public class Position implements Comparable<Object> {
	double x;
	double y;
	String name;
	boolean sortByX;

	public Position(double x, double y, String name) {
		this.x = x;
		this.y = y;
		this.name = name;
		sortByX = true;
	}

	public double getX() {
		return x;
	}

	public void sortByX() {
		sortByX = true;
	}

	public void sortByY() {
		sortByX = false;
	}

	public double getY() {
		return y;
	}

	public String getName() {
		return name;
	}

	public String getInfo() {
		return Double.toString(x) + " " + Double.toString(y) + " " + name;
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Position) {
			if (sortByX) {
				if (x < ((Position) o).getX()) {
					return -1;
				} else if (x > ((Position) o).getX()) {
					return 1;
				}

			} else {
				if (y < ((Position) o).getY()) {
					return 1;
				} else if (y > ((Position) o).getY()) {
					return -1;
				}

			}
		}
		return 0;

	}
}