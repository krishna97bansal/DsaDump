package com.dsa.DSADump.graph;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class TraversalViaBFS {
    // FOR EXAMPLE:---
    // 1--2--3      4--6
    //    |  |
    //    7--5
    public List<Integer> driver()
    {
        int vertex=7;
        List<List<Integer>> adjacencyList=new LinkedList<>();
        for(int i=0;i<vertex+1;i++){
            adjacencyList.add(new LinkedList<>());
        }

        adjacencyList.get(1).add(2);
        adjacencyList.get(2).add(1);

        adjacencyList.get(2).add(3);
        adjacencyList.get(3).add(2);

        adjacencyList.get(3).add(5);
        adjacencyList.get(5).add(3);

        adjacencyList.get(5).add(7);
        adjacencyList.get(7).add(5);

        adjacencyList.get(2).add(7);
        adjacencyList.get(7).add(2);

        adjacencyList.get(2).add(7);
        adjacencyList.get(7).add(2);

        adjacencyList.get(4).add(6);
        adjacencyList.get(6).add(4);

        return getBFSTraversal(vertex,adjacencyList);
    }

    public List<Integer> getBFSTraversal(int vertex,List<List<Integer>> adjList){
        List<Integer> result=new LinkedList<>();
        boolean visited[]=new boolean[vertex+1];

        for(int i=1;i<=vertex;i++){
            if(visited[i]==false) {
                Queue<Integer> q = new LinkedList();
                q.add(i);
                visited[i] = true;
                while (!q.isEmpty()) {
                    int node =q.poll();
                    result.add(node);
                    for(int neighbours: adjList.get(node))
                    {
                        if(visited[neighbours]==false) {
                            q.add(neighbours);
                            visited[neighbours] = true;
                        }
                    }
                }
            }
        }
        return result;
    }
}
