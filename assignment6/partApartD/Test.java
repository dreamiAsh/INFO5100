package partApartD;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		//Part A
		Mreview m1 = new Mreview("Moving", 5);
		Mreview m2 = new Mreview("Love", 3);
		Mreview m3 = new Mreview("Moving", 3);
		m1.addRating(1);
		m1.addRating(6);
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m1.aveRating());
		System.out.println(m1.compareTo(m3));
		System.out.println(m1.equals(m3));
		
		//Part D
		/*
		 * Given a target integer target and an integer array A sorted in ascending order, 
		 * find the index i in A such that A[i] is closest to target. Please write main() method to test your code.

		Assumptions:
		1.	There can be duplicate elements in the array, and we can return any of the indices with same value.
		2.	if A is null or A is empty, throw exception to remind users.

		Example:
		A = [1, 3, 3, 4], target = 2, return 0 or 1 or 2
		A = [0, 1, 5], target = 7, return 2 */
		
		int[] A = {1, 5, 5, 8};
		System.out.println("===============Part D================");
		System.out.println(partD(9, A));		
	}
	public static int partD(int target, int[] A) {
		if(A == null || A.length == 0) throw new IllegalArgumentException();
		int t = Arrays.binarySearch(A, target);
		if(t == -1) {
			return 0;
		}else if(t == -(A.length + 1)) {
			return A.length-1;
		}else if(t >= 0 && t < A.length) {
			return t;
		}else {
			t = -t-1;
			if((Math.abs(A[t] - target)) < (Math.abs(A[t-1] - target))){
				return t;
			}else {
				return t-1;
			}
		}
	}
}
