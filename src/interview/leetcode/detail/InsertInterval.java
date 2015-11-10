package interview.leetcode.detail;

import java.util.ArrayList;
import java.util.List;


public class InsertInterval {

	
	/**
	 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

		You may assume that the intervals were initially sorted according to their start times.
		
		Example 1:
		Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
		
		Example 2:
		Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
		
		This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
	 */
	public static void main(String[] args) {

		// //double for loop cannot cover [[2,3],[4,5],[6,7],[8,9],[1,10]]
		Interval i1 = new Interval(1, 5);
		Interval i2 = new Interval(1, 7);
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(i1);

		InsertInterval m = new InsertInterval();
		for(Interval i: m.insert(intervals, i2))
			System.out.println(i);

	}
	
	
	
    public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        
        for(int i=0; i<=intervals.size(); i++){
            
            if(i==intervals.size() || intervals.get(i).start >= newInterval.start){
                intervals.add(i, newInterval);
                
                startToMerge(intervals, i);
                return intervals;
            }
        }
        return intervals;
    }



	private void startToMerge(List<Interval> intervals, int i) {

		for(int j=i; j<intervals.size();){
		    if(j==0) {
		        j++;
		        continue;
		    }
		    Interval merged = merge(intervals.get(j-1), intervals.get(j));
		    if(merged!=null){
		        intervals.remove(j);
		        intervals.remove(j-1);
		        intervals.add(j-1, merged);
		    }else{
		        j++;
		    }
		}
	}
    
    private Interval merge(Interval a, Interval b){
        if(a.end < b.start) return null;
        if(a.end > b.end) return new Interval(a.start, a.end);
        else return new Interval(a.start, b.end);
    }
    
    
    

	// we want to keep the sequence by the value order of start value
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

		int i = 0;
		while (i != intervals.size()) {
			Interval interval = intervals.get(i);
			if (newInterval.end < interval.start) {
				intervals.add(i, newInterval);
				return intervals;
			} else if (newInterval.start > interval.end) {
				i++;
			} else {
				newInterval.start = Math.min(newInterval.start, interval.start);
				newInterval.end = Math.max(newInterval.end, interval.end);
				intervals.remove(i);
			}
		}
		intervals.add(intervals.size(), newInterval);
		return intervals;
	}

	

}
