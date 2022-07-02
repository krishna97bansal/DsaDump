package com.dsa.DSADump.graph;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Points to Remember(via Khan's Algorithm):
1. As we know khan's Algorithm is for DAG only, so we use that aspect just introduce one variable count,
   if it's equal to vertex that it follows Khan's Algorithm otherwise it has cycle.
2. Similar would happen for undirected graph because the relation is to and fro,
   so we can't apply khan's algorithm to find cycle in undirected graph.
 */
@Service
public class DirectedCycleDetectionViaBFS {

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
        int indegree[]=new int[vertex+1];
        for(int i=1;i<=vertex;i++){
            for(int neighbours: adjacencyList.get(i)){
                indegree[neighbours]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        int count=0;
        for(int i=1;i<=vertex;i++){
            if(indegree[i]==0){
                q.add(i);
                while(!q.isEmpty()){
                    int node=q.poll();
                    count++;
                    for(int neighbour: adjacencyList.get(node)){
                        if(indegree[neighbour]==0){
                            indegree[neighbour]--;
                            q.add(neighbour);
                        }
                    }
                }
            }
        }
        return count==vertex?false:true;
    }
}
