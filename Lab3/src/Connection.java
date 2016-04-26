
public class Connection implements Comparable<Object>{
	private String from;
	private String to;
	private int distance;
	public Connection(String from, String to, int distance){
		this.from=from;
		this.to=to;
		this.distance=distance;
	}
	public String getFrom(){
		return from;
	}
	public String getTo(){
		return to;
	}
	public int getDistance(){
		return distance;
	}
	public boolean myDistanceIsShorter(Connection c){
		if(this.distance<c.getDistance()){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof Connection){
			return distance - (((Connection) o).getDistance());
	
		
		}
		return 0;
	}
}
