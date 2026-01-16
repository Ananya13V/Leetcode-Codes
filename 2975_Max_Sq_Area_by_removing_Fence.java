class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        // there have to be fences with the same numbers for a square to form.
        // -1 condition can be proved in the beginning.
        List<Integer> h = new ArrayList<>();
        List<Integer> v = new ArrayList<>();
        long edge = 0;
        int mod = 1000000007;
        h.add(1);
        v.add(1);
        for(int hor : hFences){
            h.add(hor);
        }
        for(int ver : vFences){
            v.add(ver);
        }
        h.add(m);
        v.add(n);
        Set<Integer> hset = getEdges(h);
        Set<Integer> vset = getEdges(v);
        for(int a : hset){
            if(vset.contains(a)){
                edge = Math.max(edge, a);
            }
        }
        if(edge == 0) return -1;
        else return (int)((edge*edge)%mod);
        
    }

    private Set<Integer> getEdges(List<Integer> list) {
        Set<Integer> set = new HashSet<>();
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                set.add(list.get(j) - list.get(i));
            }
        }

        return set;
    }
}
