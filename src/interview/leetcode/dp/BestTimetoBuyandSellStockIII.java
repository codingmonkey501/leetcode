package interview.leetcode.dp;


public class BestTimetoBuyandSellStockIII {

	
	/**
	 * Say you have an array for which the ith element is the price of a given stock on day i.

		Design an algorithm to find the maximum profit. You may complete at most two transactions.
		
		Note:
		You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
	 */

	
	  public int maxProfit3(int[] prices) {

	        int max=0;
	        int[] profits = new int[prices.length];
	        
	        int minPrice=Integer.MAX_VALUE;
	        int maxProfit=0;
	        
	        for (int i=0; i<prices.length; i++) {
	            
	            minPrice=Math.min(minPrice, prices[i]);
	            maxProfit = Math.max(maxProfit, prices[i]-minPrice);
	            profits[i] = maxProfit;
	            
	        }
	        
	        int maxPrice=Integer.MIN_VALUE;
	        maxProfit=0;
	        for (int i=prices.length-1; i>=0; i--) {
	            
	            maxPrice=Math.max(maxPrice, prices[i]);
	            maxProfit = Math.max(maxProfit, maxPrice-prices[i]);
	            max = Math.max(profits[i]+maxProfit, max);
	        }
	        
	        return max;
	        
	}

	
	public int maxProfit(int[] prices) {
		if (prices.length < 2)
			return 0;
		int n = prices.length;
		int[] f = new int[n]; // max profit between 0 and i
		int[] g = new int[n]; // max profit between i and n

		for (int i = 1, valley = prices[0]; i < n; ++i) {
			valley = Math.min(valley, prices[i]);
			f[i] = Math.max(f[i - 1], prices[i] - valley);
		}
		for (int i = n - 2, peak = prices[n - 1]; i >= 0; --i) {
			peak = Math.max(peak, prices[i]);
			g[i] = Math.max(g[i + 1], peak - prices[i]); //should be g[i+1]
		}
		int max_profit = 0;
		for (int i = 0; i < n; ++i)
			max_profit = Math.max(max_profit, f[i] + g[i]);
		return max_profit;
	}
	

}
