package interview.leetcode.binarysearch;

public class MedianofTwoSortedArraysDiffSize {

	/**
	 * There are two sorted arrays A and B of size m and n respectively. Find
	 * the median of the two sorted arrays. The overall run time complexity
	 * should be O(log (m+n)).
	 * 
	 */
	public static void main(String[] args) {

		MedianofTwoSortedArraysDiffSize m = new MedianofTwoSortedArraysDiffSize();
		System.out.println(m.findMedianSortedArrays(
				new int[] { 1, 3, 8, 9, 10 }, new int[] { 2, 4, 5, 6, 7 }));
		System.out.println(m.findMedianSortedArrays3(
				new int[] { 1, 3, 8, 9, 10 }, new int[] { 2, 4, 5, 6, 7 }));
	}

	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		int total = m + n;

		if (total % 2 != 0) // odd
			return (double) new KthElementOfTwoSortedArrays().findKth(A, B, total / 2, 0, m - 1, 0, n - 1);
		else { // even
			return (new KthElementOfTwoSortedArrays().findKth(A, B, total / 2, 0, m - 1, 0, n - 1) 
					+ new KthElementOfTwoSortedArrays().findKth(A,
					B, total / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
		}
	}
	
	
//	1) Calculate the medians m1 and m2 of the input arrays ar1[] and ar2[] respectively.
//	2) If m1 and m2 both are equal then we are done, and return m1 (or m2)
//	3) If m1 is greater than m2, then median is present in one of the below two subarrays.
//	  a) From first element of ar1 to m1 (ar1[0...|_n/2_|])
//	  b) From m2 to last element of ar2 (ar2[|_n/2_|...n-1])
//	4) If m2 is greater than m1, then median is present in one of the below two subarrays.
//	  a) From m1 to last element of ar1 (ar1[|_n/2_|...n-1])
//	  b) From first element of ar2 to m2 (ar2[0...|_n/2_|])
//	5) Repeat the above process until size of both the subarrays becomes 2.
//	6) If size of the two arrays is 2 then use below formula to get the median.
//	Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
	
	double findMedianSortedArrays3(int A[], int B[]) {
	    int N1 = A.length;
	    int N2 = B.length;
	    if (N1 < N2) return findMedianSortedArrays3(B, A);   // Make sure A2 is the shorter one.

		if (N2 == 0)
			return ((double) A[(N1 - 1) / 2] + (double) A[N1 / 2]) / 2;  // If A2 is empty

	    int lo = 0, hi = N2 * 2;
	    while (lo <= hi) {
	        int mid2 = (lo + hi) / 2;   // Try Cut 2 
	        int mid1 = N1 + N2 - mid2;  // Calculate Cut 1 accordingly

	        double L1 = (mid1 == 0) ? Integer.MIN_VALUE : A[(mid1-1)/2];  // Get L1, R1, L2, R2 respectively
	        double L2 = (mid2 == 0) ? Integer.MIN_VALUE : B[(mid2-1)/2];
	        double R1 = (mid1 == N1 * 2) ? Integer.MAX_VALUE : A[(mid1)/2];
	        double R2 = (mid2 == N2 * 2) ? Integer.MAX_VALUE : B[(mid2)/2];

	        if (L1 > R2) lo = mid2 + 1;     // A1's lower half is too big; need to move C1 left (C2 right)
	        else if (L2 > R1) hi = mid2 - 1;    // A2's lower half too big; need to move C2 left.
	        else return (Math.max(L1,L2) + Math.min(R1, R2)) / 2; // Otherwise, that's the right cut.
	    }
	    return -1;
	} 

}
