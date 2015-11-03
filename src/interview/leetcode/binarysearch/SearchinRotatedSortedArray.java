package interview.leetcode.binarysearch;

public class SearchinRotatedSortedArray {

	
	/**
	 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

		(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
		
		You are given a target value to search. If found in the array return its index, otherwise return -1.
		
		You may assume no duplicate exists in the array.
	 */
	public int search(int[] A, int target) {

		int s = 0;
		int e = A.length - 1;

		while (s <= e) {
			int m = (s + e) / 2;

			if (target == A[m])
				return m;
			else if (A[s] <= A[m]) {
				if (A[s] <= target && target < A[m])
					e = m;
				else
					s = m + 1;
			} else {
				if (A[m] < target && target <= A[e])
					s = m + 1;
				else
					e = m;
			}
		}

		return -1;
	}
	
	public int search5(int[] A, int target) {
		
        int s =0;
        int e=A.length-1;
        
        while(s<=e){
            int m=(s+e)/2;
            
            if(target == A[m])
                return m;
            else if(A[s]<=A[m]){
                if(target == A[s])
                    return s;
                if(target == A[m])
                    return m;
                if (A[s] < target && target < A[m])
					e = m - 1;
				else
					s = m + 1;
            } else {
                if(target == A[e])
                    return e;
                if(target == A[m])
                    return m;
                if (A[m] < target && target < A[e])
					s = m + 1;
				else
					e = m - 1;
            }
        }
        
        return -1;
    }

	
	public int search3(int[] A, int target) {

		int first = 0, last = A.length;
		while (first != last) {
			int mid = (first + last) / 2;

			if (A[mid] == target)
				return mid;
			if (A[first] <= A[mid]) {
				if (A[first] <= target && target < A[mid])
					last = mid;
				else
					first = mid + 1;
			} else {
				if (A[mid] < target && target <= A[last - 1])
					first = mid + 1;
				else
					last = mid;
			}
		}
		return -1;
	}


	
	public int search2(int[] A, int target) {

		if (A == null || A.length == 0)
			return -1;

		int start = 0;
		int end = A.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (A[mid] == target) {
				return mid;
			} else if (A[mid] < target) {
				if (A[start] < A[mid]) {
					start = mid + 1;
				} else {
					// move both end inside
					if (A[start] == target)
						return start;
					else
						start++;
					if (A[end] == target)
						return end;
					else
						end--;
				}

			} else if (A[mid] > target) {
				if (A[end] > A[mid]) {
					end = mid - 1;
				} else {
					// move both end inside
					if (A[start] == target)
						return start;
					else
						start++;
					if (A[end] == target)
						return end;
					else
						end--;
				}
			}
		}

		return -1;
	}
}
