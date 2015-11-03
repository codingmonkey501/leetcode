package interview.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {

	
	/**
	 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

		For example,
		Given [100, 4, 200, 1, 3, 2],
		The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
		
		Your algorithm should run in O(n) complexity.
	 */
	public static void main(String[] args) {
		LongestConsecutiveSequence l=new LongestConsecutiveSequence();
		System.out.println(l.longestConsecutive(new int[]{0}));
	}
	
	
    public int longestConsecutive3(int[] num) {
        
        Set<Integer> s = new HashSet<Integer>();
        int max=0;
        
        for (int i=0; i<num.length; i++)
            s.add(num[i]);
        
        for (int i=0; i<num.length; i++){
            
            int length=0;
            if(s.contains(num[i])){
                int t = num[i]-1;
                while(s.contains(t)){
                    s.remove(t--);
                    length++;
                }
                t=num[i] + 1;
                while(s.contains(t)){
                    s.remove(t++);
                    length++;
                }
                length++;
            }
            max = Math.max(length, max);
        }
        return max;
    }

	
	public int longestConsecutive(int[] num) {
		Map<Integer, Boolean> used=new HashMap<Integer, Boolean>();
        for (int i : num) {
            used.put(i, false);
        }
        
        int longest = 0;
        for (int i : num) {
            if (used.get(i)) continue;
            int length = 1;
            used.put(i, true);
            for (int j = i + 1; used.get(j)!=null; ++j) {
                used.put(j,true);
                ++length;
            }
            for (int j = i - 1; used.get(j)!=null; --j) {
                used.put(j, true);
                ++length;
            }
            longest = Math.max(longest, length);
        }
        return longest;
    }

}
