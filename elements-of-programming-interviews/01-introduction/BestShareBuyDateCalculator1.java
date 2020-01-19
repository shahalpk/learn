import java.io.*;

class BestShareBuyDateCalculator1 {
    public static void main(String args[]) throws IOException {
        Solution sol = new Solution();
        System.out.println(sol.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}

class Solution {

    private int[] prices;

    public int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        } else {
            this.prices = prices;
            return this.findBestDays(0, prices.length-1);
        }
    }

    public int calculateMinimum(int start, int end){
        int min = prices[start];
        for (int i=start;i<=end;i++){
            if (prices[i] < min){
                min = prices[i];
            }
        }
        return min;
    }

    public int calculateMaximum(int start, int end){
        int max = prices[start];
        for (int i=start;i<=end;i++){
            if (prices[i] > max){
                max = prices[i];
            }
        }
        return max;
    }

    /**
     * Returns an array with first index as the buy / sell days
     */
    public int findBestDays(int start, int end) {

        if (start == end)
            return 0;

        try {
            int mid = (end+start)/2;
            debug("Start is " + start + ", End is " + end + ", Mid is " + mid);
            int aMaxProfit = this.findBestDays(start, mid);
            int bMaxProfit = this.findBestDays(mid + 1, end);

            int maxProfit = Integer.max(aMaxProfit, bMaxProfit);

            /* Combine here */
            int aMinPrice = this.calculateMinimum(start, mid);
            int bMaxPrice = this.calculateMaximum(mid + 1, end);

            debug("Start is " + start + ", End is " + end + ", Mid is " + mid + "| aMax is " + aMaxProfit + ", bMax is " + bMaxProfit + ", aMin is " + aMinPrice + ", bMax is " + bMaxPrice + ", RETURN::" + Integer.max(maxProfit, (bMaxPrice - aMinPrice)));
            
            return Integer.max(maxProfit, (bMaxPrice - aMinPrice));    
        } catch (Exception e){
            System.out.println("ERROR");
            e.printStackTrace();
            System.exit(1);
        }
        return 0;
    }

    public void debug(String msg){
        // System.out.println(msg);
    }
    
}

