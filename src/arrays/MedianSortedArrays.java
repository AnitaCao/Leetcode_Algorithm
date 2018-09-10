package arrays;

/**
 * there are two sorted array A and B of size m and n respectively.
 * Find the k'th biggest element.
 */
public class MedianSortedArrays {
	
	//the time complexity is O(m+n), when k is m+n 
	//this method assume that A and B are in ascending order.
	public static int findmediaSortedArrays(int[] A, int[] B, int k){
		
		int m = A.length-1;
		int n = B.length-1;
		int target = -1;
		int count = 0;
		while(count < k){
			if(A[m] >= B[n]){
				target = A[m];
				count ++;
				m--;
			}else{
				target = B[n];
				count ++;
				n--;
			}
		}
		return target;
	}
	
	
	//assume that A and B are in descending order.
    /**
     * 
     * @param A
     * @param B
     * @param aFirst as the first index, start with 0
     * @param aEnd as the last index, start with length-1
     * @param bFirst
     * @param bEnd
     * @param k the k'th element.
     * TIME COMPLEXITY IS O(logn + logm)
     * @return
     */
	public static int findmediaSortedArrays1(int[] A, int[] B, int aFirst, int aEnd, int bFirst, int bEnd, int k){
		
		
		if(A.length == 0){
			if(k<=B.length) return B[k-1];
			else return -1;
		}
		if(B.length == 0){
			if(k<=A.length) return A[k-1];
			else return -1;
		}
		
		if(k>(aEnd-aFirst+1)+(bEnd-bFirst+1) || k<1){
			return -1;
		}
		if(k == 1){
			return Math.max(A[aFirst], B[bFirst]);
		}
		
		int mid1 = aFirst + (aEnd - aFirst)/2;  // the middle element's index
		int number1 = (aEnd - aFirst)/2 + 1; // half elements of the array.
		int mid2 = bFirst + (bEnd - bFirst)/2; // the middle element's index
		int number2 = (bEnd - bFirst)/2 +1; // half elements of the array.
		
		if(number1 + number2 < k){
			if(A[mid1] < B[mid2]){
				k = k-number2;
				return findmediaSortedArrays1(A, B, aFirst, aEnd, mid2+1, bEnd, k);}
			else {
				k = k-number1;
				return findmediaSortedArrays1(A, B, mid1+1, aEnd, bFirst, bEnd, k);}
		}else if(number1 + number2 >k){
			if(A[mid1] > B[mid2])
				return findmediaSortedArrays1(A,B,aFirst, aEnd, bFirst, mid2, k);
			else return findmediaSortedArrays1(A, B, aFirst, mid1, bFirst, bEnd, k);
		}else{
			if(A[mid1] == B[mid2]) return A[mid1];
			if(A[mid1] > B[mid2]){
				if(mid1<aEnd) return Math.max(A[mid1+1], B[mid2]);
				else return B[mid2];
			}else{
				if(mid2<bEnd) return Math.max(A[mid1], B[mid2+1]);
				else return A[mid1];
			}
		}
		
	}
	
	
	public static int findmediaSortedArrays2(int[] A, int[] B, int m, int n, int k){
		
		
		return -1;
	}
	
	
	public static void main(String[] arr){
//		int[] A = {1,3,3,4,5,6,7,8};
//		int[] B = {1,2,3,4,5,6};
//		int result = findmediaSortedArrays(A,B,1);
//		System.out.println(result);
		
		int[] a1 = {9,7,6,3,3,3,3,2,1,0,-1};
		int[] a2 = {10,8,8,8,3,1};
		int a = a1.length -1;
		int b = a2.length -1;
		int result = findmediaSortedArrays1(a1, a2, 0, a, 0, b, 7);
		System.out.println(result);
	}

}
