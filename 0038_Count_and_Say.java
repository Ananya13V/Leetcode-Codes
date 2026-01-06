class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        String s = "1";
        for(int i = 2; i<=n; i++){
            s = rle(s);
        }
        
        return s;
    }

    String rle(String s){
        //if(n == 0) return s;
        int count = 1;
        StringBuilder ans = new StringBuilder();
        int len = s.length();
        for(int i = 1; i<len; i++){
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
                //System.out.print("check");
                continue;
            }
            else{
                ans.append(count);
                ans.append(s.charAt(i-1));
                count = 1;
            }
        }
        ans.append(count);
        ans.append(s.charAt(len-1));
        return ans.toString();
    }
}
