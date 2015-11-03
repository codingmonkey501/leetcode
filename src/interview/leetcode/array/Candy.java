package interview.leetcode.array;

public class Candy {

	/**
	 * There are N children standing in a line. Each child is assigned a rating
	 * value.
	 * 
	 * You are giving candies to these children subjected to the following
	 * requirements:
	 * 
	 * Each child must have at least one candy. Children with a higher rating
	 * get more candies than their neighbors. What is the minimum candies you
	 * must give?
	 */
	public static void main(String[] args) {
		
		Candy c=new Candy();
		System.out.println(c.candy(new int[]{1,6,2,5,4,3}));
		System.out.println(c.candy(new int[]{4,2,3,4,1}));
		
	}
	
	public int candy(int[] ratings) {
		
		int[] increment=new int[ratings.length];
		
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1])
				increment[i] = increment[i-1]+1;
		}
		
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1])
				increment[i] = Math.max(increment[i+1]+1, increment[i]);
		}
		
		int sum=0;
		for(int num:increment){
			sum+=num;
		}
		
		return sum+ratings.length;
	}
	
	public int candy1(int[] ratings) {
		
		int[] increment=new int[ratings.length];
		
		for (int i = 1, inc = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1])
				increment[i] = Math.max(inc++, increment[i]);
			else
				inc = 1;
		}
		
		for (int i = ratings.length - 2, inc = 1; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1])
				increment[i] = Math.max(inc++, increment[i]);
			else
				inc = 1;
		}
		
		int sum=0;
		for(int num:increment){
			sum+=num;
		}
		
		return sum+ratings.length;
	}

}
