package com.dsa.DSADump.graph;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Points to Remember:
1. So the graph is bipartite if its every node is coloured in such a way among two colours
   that no adjacent node has same colours.
2. 1- coloured[node] logic is used to alter colour(0,1);
3. -1 to denote that node is not visited.
*/
@Service
public class BipartiteGraphViaBFS {
    public boolean driver()
    {
        int vertex=7;
        List<List<Integer>> adjacencyList=new LinkedList<>();

        for(int i=0;i<=vertex;i++)
        {
            adjacencyList.add(new LinkedList<>());
        }

        adjacencyList.get(0).add(1);
        adjacencyList.get(1).add(0);

        adjacencyList.get(1).add(2);
        adjacencyList.get(2).add(1);

        adjacencyList.get(2).add(3);
        adjacencyList.get(3).add(2);

        adjacencyList.get(4).add(3);
        adjacencyList.get(3).add(4);

        adjacencyList.get(4).add(5);
        adjacencyList.get(5).add(4);

        adjacencyList.get(4).add(6);
        adjacencyList.get(6).add(4);

        adjacencyList.get(1).add(6);
        adjacencyList.get(6).add(1);

        return findBipartite(vertex, adjacencyList);
    }

    private static boolean findBipartite(int vertex, List<List<Integer>> adjacencyList) {
        int coloured[]=new int[vertex+1];
        for(int i=0;i<vertex;i++){
            coloured[i]=-1;
        }
        for(int i=0;i<vertex;i++){
            if(coloured[i]==-1){
                if(!check(i,coloured,adjacencyList)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean check(int i, int[] coloured, List<List<Integer>> adjacencyList) {
        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        coloured[i]=0;
        while(!q.isEmpty()) {
            int node = q.poll();
            for (int neighbours : adjacencyList.get(node)) {
                if (coloured[neighbours] == -1) {
                    coloured[neighbours] = 1 - coloured[node];
                    q.add(neighbours);
                } else if (coloured[neighbours] == coloured[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}

