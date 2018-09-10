package arrays;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * find a given target value's index, otherwise return -1.
 * Assume no duplicate exists in the array.
 *
 */
public class SearchInRotatedSortedArray {
	
	// this is similar to binary search, Use while loop. Time consumption is O(logn), memory consumption is O(1).
	public static int Search(int[] A, int target){
		int first = 0, last = A.length-1;
		while(first != last){
			int mid = first + (last - first)/2;
			if(A[mid] == target){ return mid; }
			if(A[first] <= A[mid]){ // we are sure that from first to mid, array is sorted.
				if(A[first] <= target && target < A[mid])
					last = mid;
				else first = mid +1;
			}else{
				if(A[mid] < target && target <= A[last])
					first = mid +1;
				else last = mid;
			}
		}
		return -1;
	}

	public static int SearchRecursive(int[] A, int first, int last, int target){
		if(first == last){
			if(A[first] == target) return first;
			else return -1;
		}
		int mid = first + (last - first)/2;
		if(A[first] <= A[mid]){
			if(A[first] <= target && target <= A[mid]){
				return SearchRecursive(A, first, mid, target);
			}else return SearchRecursive(A, mid+1, last, target);
		}else{
			if(A[mid+1] <= target && target <= A[last]){
				return SearchRecursive(A, mid+1, last, target);
			}else return SearchRecursive(A, first, mid, target);
		}
		
	}
	
	//===================Third Way===============================================
	/**
	 * Step 1: find the pivot's index
	 * Step 2: call binary search for one of the two sub-arrays
	 * Step 3: return index of the target or -1 if not found.
	 */
	//step 1, find pivot, the key condition is arr[pivotIndex] > arr[pivotIndex+1].
	public static int findPivot(int[] arr, int low, int high){
		if(high < low) return -1;
		if(high == low) return low;
		
		int mid = low + (high - low)/2;
		
		if(arr[mid] > arr[mid+1]) return mid;
		if(arr[mid] < arr[mid-1]) return mid-1;
		
		if( arr[low] <= arr[mid]) 
			return findPivot(arr, mid+1, high);
		else 
			return findPivot(arr, low, mid);
	}
	
	//step 2, binary search
	public static int binarySearch(int[] arr, int low, int high, int target){
		
		if(high < low) return -1;
		//if(high == low) return low;
		
		int mid = low + (high-low)/2;
		if(target == arr[mid]) return mid;
		if(target > arr[mid]) return binarySearch(arr, mid+1,high,target);
		return binarySearch(arr, low, mid-1, target);
		
	}
	
	public static int pivotedBinarySearch(int[] arr, int n, int target){
		int pivotIndex = findPivot(arr, 0, n-1);
		
		if(pivotIndex == -1) return binarySearch(arr,0,n-1,target);
		
		if(target == arr[pivotIndex]) return pivotIndex;
		if(target < arr[0]) return binarySearch(arr,pivotIndex+1, n-1, target);
		return binarySearch(arr, 0, pivotIndex-1, target);
	}
	
	
	//===================What if duplicates are allowed ?======================================
	/**
	 * if duplicates are allowed, when arr[mid] >= arr[first], we are not sure from first to mid is ordered anymore.
	 * such as [1,3,1,1,1], the pivot is 3, mid element is 1, but from first to mid is not in order anymore.
	 * 
	 */
	public static int SearchWithDuplicates(int[] arr, int target){
		int first = 0, last = arr.length-1;
		while(first != last){
			int mid = first + (last-first)/2;
			if(arr[mid] == target){
				return mid;
			}
			if(arr[first]<arr[mid]){
				if(arr[first] <= target && target < arr[mid]){
					last = mid;
				}else{
					first = mid + 1;
				}
			}else if(arr[first]>arr[mid]){
				if(arr[mid] < target && target <= arr[last]){
					first = mid +1;
				}else last = mid;
			}else{
				first ++;
			}
		}
		return -1;
	}
	
	
	
	public static void main(String[] args) {
//		int[] arr = { 4,5,6,7,8,9,10,0,1,2,3};
//		int n = arr.length-1;
//		int targetIndex = Search(arr, 8);
//		int targetIndex0 = SearchRecursive(arr, 0,n,8);
//		System.out.println("the target's index is : " + targetIndex);
//		System.out.println("the target's index is : " + targetIndex0);
//		
//		int targetIndex1 = Search(arr, 0);
//		int targetIndex2 = SearchRecursive(arr, 0,n,0);
//		System.out.println("the target's index is : " + targetIndex1);
//		System.out.println("the target's index is : " + targetIndex2);
//		
//		int targetIndex3 = Search(arr, 3);
//		int targetIndex4 = SearchRecursive(arr, 0,n,3);
//		System.out.println("the target's index is : " + targetIndex3);
//		System.out.println("the target's index is : " + targetIndex4);
//		
//		int targetIndex5 = Search(arr, 100);
//		int targetIndex6 = SearchRecursive(arr, 0,n,100);
//		System.out.println("the target's index is : " + targetIndex5);
//		System.out.println("the target's index is : " + targetIndex6);
		
		int[] arr1 = { 3,4,5,6,7,8,9,10,0,1,2};
		int pivotSearchIndex = pivotedBinarySearch(arr1, arr1.length, 3);
		System.out.println("the pivotSearchIndex target index is : " + pivotSearchIndex);
		
		int[] arr2 = {3,4,5,6,7,8,9,10};
		int pivotSearchIndex1 = pivotedBinarySearch(arr2, arr2.length,6);
		System.out.println("the pivotSearchIndex target index is : " + pivotSearchIndex1);
		
	}
}
