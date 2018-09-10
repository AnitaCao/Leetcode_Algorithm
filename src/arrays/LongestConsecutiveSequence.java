package arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	
	
	
	public static int longestConseSeq(int[] A){
		
		Set<Integer> numSet = new HashSet<>();
		
		for(int n : A){
			numSet.add(n);
		}
		int ans = 0;
		for(int n : A){
			int previous = n-1;
			
			//if not has previous number, means current number is the smallest in this sequence.
			if(!numSet.contains(previous)){
				int j = n;
				while(numSet.contains(j)){
					j++;
				}
				int count = j-n; //distance from the largest number in the consecutive sequence to the start of the sequence.
				if(ans < count){
					ans = count;
				}
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args){
		int[] A = {19,33,32,30,6,4,34};
		int[] A1 = {10,9,2,5,3,7,101,18};
		
		System.out.println(longestConseSeq(A));
		System.out.println(longestConseSeq(A1));
	}

}
