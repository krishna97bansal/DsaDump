package com.dsa.DSADump.graph;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UnidirectedCycleDetectionViaDFS {
    // FOR EXAMPLE:---
    // 1--2    3--5--6--7
    //    |       |     |
    //    4       10--9--8--11
    public boolean driver() {
        int vertex = 11;
        List<List<Integer>> adjacencyList = new LinkedList<>();
        for (int i = 0; i < vertex + 1; i++) {
            adjacencyList.add(new LinkedList<>());
        }
        adjacencyList.get(1).add(2);
        adjacencyList.get(2).add(1);

        adjacencyList.get(2).add(4);
        adjacencyList.get(4).add(2);

        adjacencyList.get(3).add(5);
        adjacencyList.get(5).add(3);

        adjacencyList.get(5).add(6);
        adjacencyList.get(6).add(5);

        adjacencyList.get(5).add(10);
        adjacencyList.get(10).add(5);

        adjacencyList.get(6).add(7);
        adjacencyList.get(7).add(6);

        adjacencyList.get(10).add(9);
        adjacencyList.get(9).add(10);

        adjacencyList.get(9).add(8);
        adjacencyList.get(8).add(9);

        adjacencyList.get(7).add(8);
        adjacencyList.get(8).add(7);

        adjacencyList.get(8).add(11);
        adjacencyList.get(11).add(8);

        return findCycle(vertex, adjacencyList);
    }

    private boolean findCycle(int vertex, List<List<Integer>> adjacencyList) {
        boolean visited[]=new boolean[vertex+1];

        for(int i=1;i<=vertex;i++){
            if(visited[i]==false){
               if(cycleDetection(i,-1,adjacencyList,visited))
                   return true;
            }
        }
        return false;
    }

    private boolean cycleDetection(int child, int parent, List<List<Integer>> adjacencyList, boolean[] visited) {
       visited[child]=true;
       for(int neighbours: adjacencyList.get(child)){
           if(visited[neighbours]==false){
               if(cycleDetection(neighbours,child,adjacencyList,visited))
                   return true;
           }
           else if(neighbours!=parent){
               return true;
           }
       }
       return false;
    }
}
