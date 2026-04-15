class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1; 
        int maxProf = 0; 
        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                maxProf = Math.max(maxProf, prices[r] - prices[l]);
            } else {
                l = r; 
            }
            r++;
        }
        return maxProf;
    }
}
