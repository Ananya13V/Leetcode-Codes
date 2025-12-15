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
