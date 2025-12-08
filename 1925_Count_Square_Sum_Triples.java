//Not very optimised, first solution
// 22ms


class Solution {
    public int countTriples(int n) {
        // make a set with sq triples of all nums from 1 to n. 
        //check which two nums addition result equates from set.

        //Logic 2 : c will always be greater than a, b integers
        int ans = 0;
        Set<Double> set = new HashSet<>();
        for(double i = 1; i<=n;i++){
            set.add(i);
        }

        for(int i = 1; i<=n;i++){
            for(int j = i+1; j<=n;j++){
                double num = Math.sqrt((i*i)+(j*j));
                if(set.contains(num)){
                    ans+=2;
                }
            }
        }
        return ans;
    }
}

