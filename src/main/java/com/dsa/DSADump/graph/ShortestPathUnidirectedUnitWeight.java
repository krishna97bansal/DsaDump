package com.dsa.DSADump.graph;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Points to Remember:
1.  Finding the shortest distance in undirected graph is simpler, just take distance array with max value.
2.  Mark source distance from itself as 0.
3.  Traverse all adjacent and +1 from source and compare it with their distance value.
 */
@Service
public class ShortestPathUnidirectedUnitWeight {

    public int driver()
    {
        int vertex=9;
        List<List<Integer>> adjacencyList=new LinkedList<>();
        for(int i=0;i<vertex+1;i++){
            adjacencyList.add(new LinkedList<>());
        }

        adjacencyList.get(1).add(2);
        adjacencyList.get(1).add(4);

        adjacencyList.get(2).add(3);
        adjacencyList.get(2).add(1);
        adjacencyList.get(2).add(4);

        adjacencyList.get(3).add(2);
        adjacencyList.get(3).add(7);

        adjacencyList.get(4).add(5);
        adjacencyList.get(4).add(1);
        adjacencyList.get(4).add(2);

        adjacencyList.get(5).add(4);
        adjacencyList.get(5).add(6);

        adjacencyList.get(6).add(5);
        adjacencyList.get(6).add(7);

        adjacencyList.get(7).add(3);
        adjacencyList.get(7).add(6);
        adjacencyList.get(7).add(8);
        adjacencyList.get(7).add(9);

        adjacencyList.get(8).add(9);
        adjacencyList.get(8).add(7);

        adjacencyList.get(9).add(8);
        adjacencyList.get(9).add(7);

        return shortestPath(vertex,adjacencyList,1,7);
    }

    private int shortestPath(int vertex, List<List<Integer>> adjacencyList, int source,int destination) {
        int distance[]=new int[vertex+1];
        for(int i=0;i<distance.length;i++){
            distance[i]=Integer.MAX_VALUE;
        }
        distance[source]=0;

        Queue<Integer> q=new LinkedList<>();
        q.add(source);
        while (!q.isEmpty()){
            int node=q.poll();
            for(int neighbour: adjacencyList.get(node)){
                int temp=distance[node]+1;
                if(temp<distance[neighbour]){
                    distance[neighbour]=temp;
                    q.add(neighbour);
                }

            }
        }
        return distance[destination];
    }
}
