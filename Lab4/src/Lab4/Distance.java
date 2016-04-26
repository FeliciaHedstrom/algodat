package Lab4;

public class Distance implements Comparable<Object> {
	Position p1;
	Position p2;

	public Distance(Position p1, Position p2) {
		this.p1 = p1;
		this.p2 = p2;

	}

	public double getDistance() {
		double dX = Math.abs(p1.getX() - p2.getX());
		double dY = Math.abs(p1.getY() - p2.getY());
		double distance = Math.hypot(dX, dY);
		return distance;

	}

	public String getInfo() {
		return p1.getName() + " " + p2.getName() + " " + getDistance();
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Distance) {
			if (getDistance() < ((Distance) o).getDistance()) {
				return -1;
			} else if ((getDistance() > ((Distance) o).getDistance())) {
				return 1;
			} else {
				return 0;
			}
		}
		return 0;

	}

}
