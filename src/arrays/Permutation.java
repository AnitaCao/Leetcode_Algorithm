package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Ting.Cao
 *

 */
public class Permutation {
	
	
	/**
	 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
	 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order). 
	 * The replacement must be in-place and use only constant extra memory.
	 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
	 * 1,2,3 ¡ú 1,3,2
	 * 3,2,1 ¡ú 1,2,3
	 * 1,1,5 ¡ú 1,5,1
	 * https://leetcode.com/problems/next-permutation/description/
	 * @param A
	 * @return
	 */
	public static int[] nextPermutation(int[] A){
		//step 1: from right to left, find the first value that violate the increase.
		//step 2: from right to left, find the first digit which is larger than the value we found in step 1.
		//step 3: swap the elements from step 1 and step 2.
		//step 4: reverse all the digit on the right of the element from step 1.
		int index = -1;
		int index2 = -1;
		for (int i = A.length-1; i > 0; i--) {
			if(A[i] > A[i-1]){
				index = i-1;
				break;
			}
		}
		
		if(index != -1){
			for (int i = A.length-1; i > index; i--) {
				if(A[i] > A[index]){
					index2 = i;
					break;
				}
			}
			int temp = A[index];
			A[index] = A[index2];
			A[index2] = temp;
		}
		
		//step 3: reverse the part after index
		//if index == -1, means the whole array is in decreasing order, 
		//so that it is already the biggest permutation, so reverse the 
		//whole array to the first permutation.
		reverseArray(A,index+1,A.length-1);
		return A;
	}
	
	public static void reverseArray(int[] A, int start,int end){
		
		for (int i = 0; i <= (end-start)/2; i++) {
			int temp1 = A[i+start];
			A[i+start] =  A[end];
			A[end] = temp1;
			end --;
		}
		
	}
	
	/**
	 *  The set [1,2,3,¡­,n] contains a total of n! unique permutations.

		By listing and labeling all of the permutations in order,
		We get the following sequence (ie, for n = 3):
		
		"123"
		"132"
		"213"
		"231"
		"312"
		"321"
		Given n and k, return the kth permutation sequence.
		
		Note: Given n will be between 1 and 9 inclusive.
	 * @param A
	 * @param k
	 * @return
	 */
	public static int PermutationSequence(int n, int k){
		
		k--;
		
		//put all the numbers for array into an arraylist, easy to remove.
		List<Integer> numList = new ArrayList<>();
		for (int i = 1; i <= n; i++) 
			numList.add(i);  // number from 1 to n-1 has been added to list, and it is in order.
		
		int factorial = 1;
		for (int i = 1; i <= n; i++) {
			factorial *= i;  //after the loop, factorial is equal to (n)!
		}
		
		if(k > factorial){
			return -1; // k is bigger than the number of all permutations.
		}
		
		StringBuilder resultString = new StringBuilder(); 
		int index;
		while(n>0){
			
			factorial = factorial/(n);
			index = k/factorial;
			k = k%factorial;
			resultString.append(numList.get(index));
			numList.remove(index);
			n--;
			
		}
		
		return Integer.parseInt(resultString.toString());
		
		
		
	}
	
	public static void main(String[] args){
		//int[] A = {6,5,4,8,7,5,1};
//		int[] A = {4,3,2,1};
//		A = nextPermutation(A);
//		for (int i = 0; i < A.length; i++) {
//			System.out.print(A[i] + " ");
//		}
		
		System.out.println(PermutationSequence(5,16));
	}
	

}
