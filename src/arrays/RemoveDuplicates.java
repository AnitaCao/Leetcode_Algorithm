package arrays;


/**
 * 2.1.1 Remove Duplicates from Sorted Array 描述 Given a sorted array, remove the
 * duplicates in place such that each element appear only once and return the
 * new length. Do not allocate extra space for another array, you must do this
 * in place with constant memory. For example, Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 * 
 * @author tingcao
 *         https://www.programcreek.com/2013/01/leetcode-remove-duplicates-from-sorted-array-java/
 *
 */
public class RemoveDuplicates {

	/**
	 * This method returns the number of unique elements, but does not change
	 * the original array correctly. For example, if the input array is {1, 2,
	 * 2, 3, 3}, the array will be changed to {1, 2, 3, 3, 3}. The correct
	 * result should be {1, 2, 3}.
	 * 
	 * @param A
	 *            SORTED array. if it is not sorted, need to sort it first.
	 * @return
	 */
	public static int removeDuplicates(int[] A) {
		if (A.length < 2)
			return A.length;
		int count = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[count] != A[i])
				A[++count] = A[i];
		}
		// int[] B = Arrays.copyOf(A, count+1);
		// Because array's size can not be changed once created,
		// there is no way we can return the original array with
		// correct results.
		return count + 1;
	}
	
	// use temp array.
	public static int removeDuplicates0(int[] A){
		if(A.length < 2) return A.length;
		int[] temp = new int[A.length];
		int j = 0;
		for (int i = 0; i < A.length-1; i++) {
			if(A[i] != A[i+1]){
				temp[j++] = A[i];
			}
		}
		temp[j++] = A[A.length - 1];
		for(int i = 0; i< j; i++){
			A[i] = temp[i];
		}
		return j;
	}

	// If we only want to count the number of unique elements, the following
	// method is good enough.
	public static int countUnique(int[] A) {
		int count = 0; // this is the number of duplicate elements.
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] == A[i + 1])
				count++;
		}
		System.out.println("duplicates are : " + count);
		return A.length - count;
	}

//*******************************************************************************************//
	
/**
 * Follow up for ”Remove Duplicates”: What if duplicates are allowed at most
 * twice? For example, Given sorted array A = [1,1,1,2,2,3], Your function
 * should return length = 5, and A is now [1,1,2,2,3]
 */
	
    // remove duplicates with allowed twice in SORTED array.	
	public static int removeDuplicates(int[] A, int x) {
		int n = A.length;
		if(n <= x) return n;
		
		int index = x;
		for(int i = x; i < n; i++){
			if(A[i] != A[index-x]) A[index++] = A[i];
		}
		return index;

	}
	
	public static int removeDuplicates1(int[] A){
		int n = A.length;
		if(n < 3) return n;
		int index = 0;
		for (int i = 0; i < n; i++) {
			if(i >0 && i < n-1 && A[i] == A[i-1] && A[i] == A[i+1]) continue;
			A[index++] = A[i];
		}
		return index;	
	}
	
	public static int removeDuplicates2(int[] A){
		int n = A.length;
		if(n < 3) return n;
		int count = 0;
		for (int i = 2; i < A.length; i++) {
			if(A[count] != A[i]){
				A[++count+1] = A[i];
			}
		}
		return count+2;
	}
	
	public static void printArray(int[] A){
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + ";");
		}
		System.out.println();
	}
//*******************************************************************************************//
	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 3, 3 };
		int unique = removeDuplicates(arr);
		System.out.println("Unique elements number is : "+unique);
		System.out.println("After method, the array is : ");
		printArray(arr);
		
//		int unique0 = removeDuplicates0(arr);
//		System.out.println("Unique elements number is : "+unique0);
//		System.out.println("After method, the array is : ");
//		printArray(arr);
		
//		int uniqueCount = countUnique(arr);
//		System.out.println("Unique elements number is : "+uniqueCount);
//		System.out.println("After method, the array is : ");
//		printArray(arr);
//		

		
		System.out.println("==========TEST 2=============");
		int[] arr1 = {1,1,1,2,2,3,3,3,4,4,5,6,6};
//		int result = removeDuplicates(arr1, 2);
//		System.out.println("Remaining elements number is : "+result);
//		System.out.println("After method, the array is : ");
//		printArray(arr1);
//		
//		int result1 = removeDuplicates1(arr1);
//		System.out.println("Remaining elements number is : "+result1);
//		System.out.println("After method, the array is : ");
//		printArray(arr1);
//		
		int result2 = removeDuplicates2(arr1);
		System.out.println("Remaining elements number is : "+result2);
		System.out.println("After method, the array is : ");
		printArray(arr1);
		
	}

}
