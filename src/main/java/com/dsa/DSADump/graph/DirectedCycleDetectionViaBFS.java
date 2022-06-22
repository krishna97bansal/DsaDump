package com.dsa.DSADump.graph;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
