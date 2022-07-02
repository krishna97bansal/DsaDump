package com.dsa.DSADump.graph;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
/*
Points to Remember:
1. In order to determine the cycle in directed graph via DFS, we have to maintain the dfsVisited array
   to keep track of what all I have traversed in current stack call.
2. If some neighbour is visited then just check whether they are traversed in current stack call.
 */
@Service
public class DirectedCycleDetectionViaDFS {

    public boolean driver()
    {
        int vertex=9;
        List<List<Integer>> adjacencyList=new LinkedList<>();
        for(int i=0;i<=vertex;i++){
            adjacencyList.add(new LinkedList<>());
        }

        adjacencyList.get(1).add(2);
        adjacencyList.get(2).add(3);

        adjacencyList.get(3).add(4);
        adjacencyList.get(3).add(6);

        adjacencyList.get(4).add(5);

        adjacencyList.get(6).add(5);

        adjacencyList.get(7).add(2);

        adjacencyList.get(7).add(8);

        adjacencyList.get(8).add(9);

        adjacencyList.get(9).add(7);

     return check(vertex,adjacencyList);

    }

    private boolean check(int vertex, List<List<Integer>> adjacencyList) {

        int visited[]=new int[vertex+1];
        int dfsVisited[]=new int[vertex+1];

        for(int i=1;i<=vertex;i++)
        {
            if(visited[i]==0){
                if(findCycle(i,dfsVisited,visited,adjacencyList)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findCycle(int i, int[] dfsVisited, int[] visited, List<List<Integer>> adjacencyList) {
        visited[i]=1;
        dfsVisited[i]=1;
        for(int neighbours: adjacencyList.get(i)){
            if(visited[neighbours]==0) {
                if (findCycle(neighbours, dfsVisited, visited, adjacencyList)) {
                    return true;
                }
            }
                else if (dfsVisited[neighbours]==1) {
                    return true;
                }
        }
        dfsVisited[i]=0;
        return false;
    }
}
