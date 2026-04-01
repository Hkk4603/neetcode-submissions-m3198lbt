class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxi = -1; 
        for (int i = 0; i < piles.length; i++) {
            maxi = Math.max(maxi, piles[i]); 
        }


        int lo = 1, hi = maxi; 
        int minRate = Integer.MAX_VALUE;
        while (lo <= hi) {
            int rate = lo + (hi - lo) / 2; 

            if (checkEatRate(piles, rate, h)){
                minRate = Math.min(minRate, rate);
                hi = rate - 1; 
            }
            else 
                lo = rate + 1; 
        }

        return minRate;
        
    }

    public boolean checkEatRate (int[] piles, int rate, int h) {
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            // sum += Math.ceil((double)piles[i]/rate);
            sum += (piles[i] + rate - 1) / rate;
        }
        if (sum <= h) 
            return true; 

        return false;
    }
}
