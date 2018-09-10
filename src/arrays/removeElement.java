package arrays;


/**
 * 
 * @author Ting.Cao
 * given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed.
 */
public class removeElement {
	public static int removeEles(int[] A, int target){
		int index = 0;
		for (int i = 0; i < A.length; i++) {
			if(A[i] != target){
				A[index++] = A[i];
			}
		}
		return index;
	}
	
	public static void main(String arg[]) {
		int[] A = {1,1,3,0,56,7,4,3,2,0};
		int newLength = removeEles(A,0);
		System.out.println(newLength);
		
	}

}
