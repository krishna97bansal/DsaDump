package com.dsa.DSADump.graph;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TraversalViaDFS {
    // FOR EXAMPLE:---
    // 1--2--4      3--5
    //    |  |
    //    7--6
    // Unlike BFS we have to go at the depth of each vertex, so the dfs call happen at each vertex.
    public List<Integer> driver()
    {
        int vertex=7;
        List<List<Integer>> adjacencyList=new LinkedList<>();
        for(int i=0;i<vertex+1;i++){
            adjacencyList.add(new LinkedList<>());
        }
        adjacencyList.get(1).add(2);

        adjacencyList.get(2).add(1);
        adjacencyList.get(2).add(4);
        adjacencyList.get(2).add(7);

        adjacencyList.get(3).add(5);

        adjacencyList.get(4).add(2);
        adjacencyList.get(4).add(6);

        adjacencyList.get(5).add(3);

        adjacencyList.get(6).add(4);
        adjacencyList.get(6).add(7);

        adjacencyList.get(7).add(6);
        adjacencyList.get(7).add(2);

        return getDFSTraversal(vertex,adjacencyList);
    }

    private List<Integer> getDFSTraversal(int vertex, List<List<Integer>> adjacencyList) {

        List<Integer> result=new LinkedList<>();
        boolean visited[]=new boolean[vertex+1];
        for(int i=1;i<=vertex;i++){
            if(visited[i]==false)
            {
                dfs(i,adjacencyList,visited,result);
            }
        }
        return result;
    }

    private void dfs(int i, List<List<Integer>> adjacencyList, boolean[] visited, List<Integer> result) {
        result.add(i);
        visited[i]=true;
        for(int neighbours: adjacencyList.get(i)) {
            if (visited[neighbours] == false) {
                dfs(neighbours, adjacencyList, visited, result);
            }
        }
    }
}