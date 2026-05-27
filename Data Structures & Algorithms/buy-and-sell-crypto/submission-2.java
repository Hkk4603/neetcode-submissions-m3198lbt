class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE; 
        int maxProfit = Integer.MIN_VALUE; 
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i]; 
            } else {
                maxProfit = Math.max(prices[i] - buy, maxProfit); 
            }
        }

        return maxProfit == Integer.MIN_VALUE ? 0 : maxProfit; 
    }
}
