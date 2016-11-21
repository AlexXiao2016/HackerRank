package datastructure.tree;
import java.util.*;

public class MinimumSpanningTree {
	public ArrayList<Connection> getLowCost(List<Connection> list) {
		ArrayList<Connection> result = new ArrayList<Connection> ();
		Set<String> set = new HashSet<>();
		HashMap<String, String> map = new HashMap<>();
		
		Collections.sort(list, new Comparator<Connection>(){
			@Override
			public int compare(Connection a, Connection b) {
				return a.cost - b.cost;
			}
		});
		
		for(Connection city : list){
			String cityA = city.city1;
			String cityB = city.city2;
			set.add(cityA);
			set.add(cityB);
			map.put(cityA, cityA);
			map.put(cityB, cityB);
		}
		
		for(Connection c : list){
			if(union(c.city1, c.city2, map)){
				result.add(c);
			}
		}
		
		if(result.size() != set.size() - 1){
			return null;
		}
		
		Collections.sort(result, new Comparator<Connection>(){

			@Override
			public int compare(Connection a, Connection b) {
				if(a.city1.equals(b.city1)){
					return a.city2.compareTo(b.city2);
				}
				return a.city1.compareTo(b.city1);
			}
			
		});
		
		return result;
	}
	
	public boolean union(String cityA, String cityB, HashMap<String, String> map){
		String aRoot = find(cityA, map);
		String bRoot = find(cityB, map);
		
		if(aRoot.equals(bRoot)){
			return false;
		}
		map.put(bRoot, aRoot);
		return true;
	}
	
	private String find(String cityA, HashMap<String, String> map){
		if(cityA.equals(map.get(cityA))){
			return cityA;
		}
		
		String parent = find(map.get(cityA), map);
		map.put(cityA, map.get(cityA));
		return parent;
	}
	
	public static void main(String args[]){
		ArrayList<Connection> connections = new ArrayList<>();
	    connections.add(new Connection("A","B",6));
	    connections.add(new Connection("B","C",4));
	    connections.add(new Connection("C","D",5));
	    connections.add(new Connection("D","E",8));
	    connections.add(new Connection("E","F",1));
	    connections.add(new Connection("B","F",10));
	    connections.add(new Connection("E","C",9));
	    connections.add(new Connection("F","C",7));
	    connections.add(new Connection("B","E",3));
	    connections.add(new Connection("A","F",1));

	    MinimumSpanningTree mst = new MinimumSpanningTree();
	    ArrayList<Connection> res = mst.getLowCost(connections);
	    for (Connection c : res){
	        System.out.println(c.city1 + " -> " + c.city2 + " cost : " + c.cost);
	    }
	}
}

class Connection{
	String city1;
	String city2;
	int cost;

	Connection(String city1, String city2, int cost){
		this.city1 = city1;
		this.city2 = city2;
		this.cost = cost;
	}

	public void printConnection () {
		System.out.println("{ " + this.city1 + " , " + this.city2 + "} " + this.cost);
	}
}
