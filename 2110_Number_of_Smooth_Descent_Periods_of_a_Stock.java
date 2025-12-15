class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long ans = (long)n;
        long cont = 0;
        for(int i = 0; i<n-1; i++){
            if(prices[i] == prices[i+1] + 1){
                cont++;
                //System.out.print("Smooth ");
            }
            else{
                cont++;
                if(cont > 0){
                    long subs = (cont)*(cont + 1);
                    subs/=2;
                    ans += (subs - cont);
                    //System.out.println(subs + " " + ans + " " + cont);
                }
                cont = 0;
            }
        }
        if(cont > 0){
            cont++;
            long subs = (cont)*(cont + 1);
            subs/=2;
            ans += (subs - cont);
        }
        return ans;
    }
}


// Optimisation : Editorial
// class Solution {

//     public long getDescentPeriods(int[] prices) {
//         int n = prices.length;
//         long res = 1; // total number of smooth descending periods, initial value is dp[0]
//         int prev = 1; // total number of smooth descending periods ending with the previous element, initial value is dp[0]
//         // traverse the array starting from 1, and update prev and the total res according to the recurrence relation
//         for (int i = 1; i < n; ++i) {
//             if (prices[i] == prices[i - 1] - 1) {
//                 ++prev;
//             } else {
//                 prev = 1;
//             }
//             res += prev;
//         }
//         return res;
//     }
// }
