package algrothim.interview;

import java.util.*;

public class ShortestJobFirst {
	public float avgWaitTime(int[] req, int[] dur){
		if(req == null || dur == null || req.length != dur.length){
			return 0;
		}
		
		int i = 0, length = req.length;
		int waitTime = 0, curTime = 0;
		PriorityQueue<RobinProcess> pq = new PriorityQueue<>(new Comparator<RobinProcess>() {
			@Override
			public int compare(RobinProcess a, RobinProcess b){
				if(a.exeTime == b.exeTime){
					return a.arrTime - b.arrTime;
				}
				return a.exeTime - b.exeTime;				
			}
		});
		
		while(!pq.isEmpty() || i < length){
			if(!pq.isEmpty()){
				RobinProcess cur = pq.poll();
				waitTime += curTime - cur.arrTime;
				curTime += cur.exeTime;
				while(i < length && curTime >= req[i]){
					pq.offer(new RobinProcess(req[i], dur[i++]));
				}
			}else{
				pq.offer(new RobinProcess(req[i], dur[i]));
				curTime = req[i++];
			}
		}
		
		return (float) waitTime / length;
	}
}
