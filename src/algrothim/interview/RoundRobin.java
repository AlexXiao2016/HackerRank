package algrothim.interview;
import java.util.*;

public class RoundRobin {
	public float Solution(int[] Atime, int[] Etime, int q) {
		if(Atime == null || Etime == null || Atime.length != Etime.length) return 0;
		
		int length = Atime.length;
		int currTime = 0, waitTime = 0, i = 0;
		Queue<RobinProcess> queue = new LinkedList<>();
		while(!queue.isEmpty() || i < length){
			if(!queue.isEmpty()){
				RobinProcess cur = queue.poll();
				waitTime += currTime - cur.arrTime;
				currTime += Math.min(q, cur.exeTime);
				for(; i < length && Atime[i] <= currTime; i++){
					queue.offer(new RobinProcess(Atime[i], Etime[i]));
				}
				if(cur.exeTime > q){
					queue.offer(new RobinProcess(currTime, cur.exeTime - q));
				}
				
			}else{
				queue.offer(new RobinProcess(Atime[i], Etime[i]));
				currTime = Atime[i++];
			}
		}
		return (float) waitTime / length;
	}
	
	public static void main(String args[]){
		int a[] = {0, 1, 4};
		int e[] = {5, 2, 3};
		RoundRobin rr = new RoundRobin();
		float w = rr.Solution(a, e, 3);
		System.out.print(w);
	}
}

class RobinProcess{
	int arrTime;
	int exeTime;
	RobinProcess(int a, int e){
		arrTime = a;
		exeTime = e;
	}
}

