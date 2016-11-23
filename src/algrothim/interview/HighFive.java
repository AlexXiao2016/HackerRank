package algrothim.interview;
import java.util.*;

public class HighFive {
	public static Map<Integer, Double> getHighFive(Result[] results){
		Map<Integer, Double> map = new HashMap<>();
		if(results == null || results.length == 0) return map;
		Map<Integer, List<Integer>> info = new HashMap<>();
		for(Result result : results){
			if(!info.containsKey(result.id)){
				info.put(result.id, new ArrayList<Integer>());
			}else{
				info.get(result.id).add(result.value);
			}
		}
		
		for(Integer id : info.keySet()){
			List<Integer> list = info.get(id);					
			Collections.sort(list, new Comparator<Integer>(){
				@Override
				public int compare(Integer a, Integer b){
					return b - a;
				}
			});
			
			double sum = 0;
			for(int i = 0; i < 5; i++){
				sum += list.get(i);
			}
			map.put(id, sum / 5);			
		}
		
		return map;
	}
}


class Result{
	int id;
	int value;
	public Result(int id, int value){
		this.id = id;
		this.value = value;
	}
}