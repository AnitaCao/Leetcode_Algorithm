package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Sum_2_3_4 {
	
	public static int[] twoSum(int[] A, int target){
		
		int[] index = new int[]{-1,-1};
		
		Set<Integer> numberSet = new HashSet<>();
		for(int i=0; i<A.length;i++){
			if(!numberSet.contains(target-A[i])){
				numberSet.add(A[i]);
			}else{
				index[1] = i+1;
				for(int j = 0; j < i; j ++){
					if(target == A[i]+A[j]){
						index[0] = j+1;
						return index;
					}
				}
			}
		}
		return index;
		
	}
	
	public static int[] twoSum2(int[] A, int target){
		int[] index = new int[]{-1,-1};
		
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for(int i = 0; i < A.length; i++){
			if(map.containsKey(target - A[i])){
				index[1] = i+1;
				index[0] = map.get(target-A[i]) + 1;
			}else map.put(A[i], i);
		}
		return index;
		
	}
	
	public static HashSet<List<Integer>> threeSum(int[] A){
		HashSet<List<Integer>> set = new HashSet<>();
		Arrays.sort(A);
		
		for (int i = 0; i < A.length-2; i++) {
			int start = i + 1;
			int end = A.length - 1;
			while(start < end){
				if(A[i] + A[start] + A[end] == 0){
					List<Integer> res = new ArrayList<>();
					res.add(A[i]);
					res.add(A[start]);
					res.add(A[end]);
					set.add(res);
					start ++;
					end --;
				}else if(A[i] + A[start] + A[end] < 0){
					start ++;
				}else end --;
			}
		}
		return set;
	}
	
	
	public static Map<Integer, Set<List<Integer>>> threeSumClosest(int[] A, int target){
		Map<Integer, Set<List<Integer>>> map = new HashMap<>();
		Arrays.sort(A);
		
		Set<List<Integer>> results = new HashSet<>();
		List<Integer> result = new ArrayList<>();
		result.add(A[0]);
		result.add(A[1]);
		result.add(A[2]);
		
		results.add(result);
		int diff = Math.abs(A[0] + A[1] + A[2] - target);
		
		map.put(diff, results);
		
		for (int i = 0; i < A.length-2; i++) {
			
			int start = i+1;
			int end = A.length-1;
			while(start < end){
				
				int sum = A[i] + A[start] + A[end];
				int newDiff = Math.abs(sum - target);
				
				if(newDiff < diff){
					map.remove(diff);
					diff = newDiff;
				}
				
				if(newDiff <= diff){
					if(map.get(newDiff) == null){
						results = new HashSet<>();
					}else results = map.get(newDiff);
					
					result = new ArrayList<>();
					result.add(A[i]);
					result.add(A[start]);
					result.add(A[end]);
					
					results.add(result);
					map.put(newDiff, results);
					
				}
				if(sum < target){
					start ++;
				}else end --;
			}
		}
		return map;
		
	}
	
	
	public Set<List<Integer>> fourSum(int[] A, int target){
		Set<List<Integer>> set = new HashSet<>();
		
		HashMap<Integer, ArrayList<ArrayList<Integer>>> dict = new HashMap<>();
		
		for(int i = 0; i < A.length - 1; i ++){
			for(int j = i+1; j < A.length; j ++){
				int sum = A[i] + A[j];
				ArrayList<Integer> pair = new ArrayList<>(2);
				pair.add(A[i]); 
				pair.add(A[j]);
				if(dict.containsKey(sum)){
					dict.get(sum).add(pair);
					
				}else {
					ArrayList<ArrayList<Integer>> pairList = new ArrayList<>();
					pairList.add(pair);
					dict.put(sum, pairList);
				}
			}
		}
		
		for(Integer sum : dict.keySet()){
			ArrayList<ArrayList<Integer>> pairList = dict.get(sum);
			if(dict.containsKey(target - sum)){
				if(target - sum == sum && pairList.size() == 1)
					continue;
				
				ArrayList<ArrayList<Integer>> pairs = dict.get(target - sum);
				
			}
			
			
		}
		
		
		
		
		
		return set;
		
	}
	
	public static void main(String arg[]){
//		int[] A = {2,7,11,5};
//		int[] index = twoSum2(A, 9);
//		System.out.println(index[0] + ", " + index[1]);
//		
//		int[] B = {-2,-1,-1,-1,-1,0,1,2,2};
//		HashSet<List<Integer>> set = threeSum(B);
//		
//		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
//			List<Integer> list = (List<Integer>) iterator.next();
//			System.out.println(list);
//		}
		
		int[] C = {-3,-2,-2,0,4,5,6,7};
		Map<Integer, Set<List<Integer>>> resutls = threeSumClosest(C,3);
		
		for(Map.Entry<Integer, Set<List<Integer>>> entry : resutls.entrySet()){
			
			System.out.println(entry.getKey());
			
			Set<List<Integer>> v = entry.getValue();
			for (Iterator iterator = v.iterator(); iterator.hasNext();) {
				List<Integer> list = (List<Integer>) iterator.next();
				System.out.println(list);
			}
		}
	}

}
