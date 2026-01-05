//Dijkstra's Algorithm

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //times[n-1][0] == source
        //times[n-1][1] == dest.
        //times[n-1][2] == time taken

        //find the shortest time it takes to reach all nodes.
        //edge case : if k!=any number in times[n-1][0] --> return -1

        //since these are nodes, we need to iterate through connections, i.e., find the shortest path.

        int[] timeDelay = new int[n+1];
        Arrays.fill(timeDelay, Integer.MAX_VALUE); //filled w infinity
        timeDelay[k] = 0; //distance from source is 0, rest is inf.

        //Make Adjacency list
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }
        //The loop runs from 0 to n because the graph is 1-indexed, 
        //so we create n+1 adjacency lists and ignore index 0.”

        for(int[] time: times){
            adjList.get(time[0]).add(new int[] {time[1], time[2] });
        }

        //Min-Heap, which is my PQ
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); 
        //added the comparator to show how the ordering should be done
        pq.add(new int[] {k, 0} );

        while(!pq.isEmpty()){
            int[] curr = pq.poll(); //first minm dist.
            int currNode = curr[0];
            int currDelay = curr[1];

            //Ignore stale entries
            if(currDelay > timeDelay[currNode])
                continue; 
            //if a larger distance is encountered, 
            //I will skip processing it since I alr have a better distance solution in place

            //progressing deeper in the graph, for next curr dest, as next source.
            for(int[] nbg : adjList.get(currNode)){
                int nextNode = nbg[0];
                int edgeDelay = nbg[1];

                if(currDelay + edgeDelay < timeDelay[nextNode]){
                    timeDelay[nextNode] = currDelay + edgeDelay; //marked the shorter distance.
                    pq.add(new int[] {nextNode, timeDelay[nextNode]});
                }
            }
        }

        int ans = 0;
        for(int i = 1; i<=n; i++){
            if(timeDelay[i] == Integer.MAX_VALUE)
                return -1;
            ans = Math.max(ans, timeDelay[i]);
        }

        return ans;
    }
}
