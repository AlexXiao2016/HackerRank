package datastructure.array;

import java.util.*;

public class MyIterator implements Iterator<Integer>{
	
	int i;
	ArrayList<Integer> result = new ArrayList<Integer>();
	
	public MyIterator(ArrayList<ArrayList<Integer>> list){
		int maxSize = 0;
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).size() > maxSize){
				maxSize = list.get(i).size();
			}			
		}
		for(int j = 0; j < maxSize; j++){
			for(ArrayList<Integer> temp : list){
				if(j < temp.size()){
					result.add(temp.get(j));
				}
			}
		}
		i = 0;
	}
	

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(i < result.size()){
			return true;
		}
		return false;
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		if(hasNext()){
			return result.get(i++);
		}
		return null;
	}
	
	public void remove(){
		if(i < result.size()){
			result.remove(i);
		}
	}
	
	public static void main(String args[]){
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(5);
		list2.add(6);
		list2.add(7);
		list2.add(8);
		list2.add(18);
		
		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(9);
		list3.add(10);
		list3.add(11);
		list3.add(12);
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		list.add(list1);
		list.add(list2);
		list.add(list3);
		
		MyIterator iterator = new MyIterator(list);
		while(iterator.hasNext()){
			System.out.print(iterator.next() + " ");
		}
		
	}
	
}
