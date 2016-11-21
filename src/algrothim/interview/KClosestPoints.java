package algrothim.interview;
import java.util.*;

public class KClosestPoints {
	public Point[] Solution(Point[] array, Point origin, int k) {
		if(array == null || k <= 0 || origin == null){
			return new Point[0];
		}
		if(k >= array.length){
			return array;
		}
		
		PriorityQueue<Point> pq = new PriorityQueue<>(k, new Comparator<Point>(){
			@Override
			public int compare(Point a, Point b){
				return (int)(getDistance(b, origin) - getDistance(a, origin));
			}
		});
		
		Point res[] = new Point[k];
		for(int i = 0; i < array.length; i++){
			pq.offer(array[i]);
			if(pq.size() > k){
				pq.poll();
			}							
		}
		
		int i = 0;
		while(!pq.isEmpty()){
			res[i++] = pq.poll();
		}
		
		return res;
	}
	
	private double getDistance(Point a, Point b){
		return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
	}
	
	public static void main(String args[]){
		Point points[] = {new Point(1, 2), new Point(3, 2), new Point(4, 2), new Point(5, 2), new Point(6, 2)};
		KClosestPoints kcp = new KClosestPoints();
		Point res[] = kcp.Solution(points, new Point(0, 0),  3);
		for(int i = 0; i < res.length; i++){
			System.out.println(res[i].x + " " + res[i].y);
		}
	}
}

class Point { 
    double x;
    double y; 
    public Point(double a, double b) {
        x = a;
        y = b;
    }
}
