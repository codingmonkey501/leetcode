package interview.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsonaLine {

	/**
	 * Given n points on a 2D plane, find the maximum number of points that lie
	 * on the same straight line.
	 */
	public static void main(String[] args) {
		MaxPointsonaLine m = new MaxPointsonaLine();
		System.out.println(m.maxPoints(new Point[] { new Point(0, 1),
				new Point(0, 2), new Point(0, 0) }));
		
		System.out.println(m.maxPoints(new Point[] { new Point(0, 0),
				new Point(1, 1), new Point(1, -1) }));
		
		System.out.println(m.maxPoints(new Point[] { new Point(2, 3),
				new Point(3, 3), new Point(-5, 3) }));
	}

	// why double have -0.0 and +0.0?
	// The IEEE floating point standard says 1/+0 should be +infinity and 1/-0
	// should be -infinity. This makes sense if you interpret +/- 0 as the ghost
	// of a number that underflowed leaving behind only its sign. The reciprocal
	// of a positive (negative) number too small to represent is a positive
	// (negative) number too large to represent.
	public int maxPoints(Point[] points) {

		if (points.length < 3)
			return points.length;
		int result = 0;
		Map<Double, Integer> countmap = new HashMap<Double, Integer>();
		for (int i = 0; i < points.length - 1; i++) {
			countmap.clear();
			int overlap = 0;
			int max = 1;
			for (int j = i + 1; j < points.length; j++) {
				Double slope = 1.0 * (points[i].y - points[j].y) / (points[i].x - points[j].x);
				
				//positive infinite and negative infinite should be same line
				//positve zero and negative zero should be same line
				if(slope.isInfinite() || Math.abs(slope) == 0) 
					slope = Math.abs(slope);
				
				//same point
				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					++overlap;
					continue;
				}

				if (countmap.containsKey(slope)) {
					countmap.put(slope, countmap.get(slope) + 1);
				} else {
					countmap.put(slope, 2);
				}

				max = Math.max(max, countmap.get(slope));
			}
			result = Math.max(result, max + overlap);
		}
		return result;
	}
}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}