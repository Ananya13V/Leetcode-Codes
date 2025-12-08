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

// Optimisations: 
// 1. Don't need data structure, can be done using number itself
// 2. Don't need to use double
// 3. Only 1 for loop is enough

// Checked Solution
// class Solution {
//     public int countTriples(int n) {
// int ans=0;
// for(int i=1;i<n-1;i++){
//     for(int j=i+1;j<n;j++){
//         int req=(int)Math.sqrt(i*i+j*j);
//         if((req*req)==(i*i+j*j) && req<=n) ans+=2;
   
//     }
// } 
// return ans;
//     }
// }