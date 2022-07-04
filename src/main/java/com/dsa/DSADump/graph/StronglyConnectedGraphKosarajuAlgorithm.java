package com.dsa.DSADump.graph;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
/*
Points to Remember:
1. So Kosharaju's algorithm is used to find strongly connected components from given graph.
2. It has 3 steps-->
   Find topological sort.
   Then transpose graph(adjacency list).
   Then use topological sort order from step 1 to iterate as per step 2 adjacency list.
 */
@Service
public class StronglyConnectedGraphKosarajuAlgorithm {
    public void driver()
    {
        int vertex=5;
        List<List<Integer>> adjacencyList=new LinkedList<>();
        for(int i=0;i<vertex+1;i++){
            adjacencyList.add(new LinkedList<>());
        }

        adjacencyList.get(1).add(2);
        adjacencyList.get(2).add(3);
        adjacencyList.get(3).add(1);
        adjacencyList.get(2).add(4);
        adjacencyList.get(4).add(5);

        ssk(adjacencyList,vertex);
    }

    private void ssk(List<List<Integer>> adjacencyList, int vertex) {
        int visited[]=new int[vertex+1];
        Stack<Integer> st=new Stack<>();

        for(int i=1;i<=vertex;i++){
            if(visited[i]==0){
                topologicalsort(i,adjacencyList,visited,st);
            }
        }

        List<List<Integer>> transposeAdj=new LinkedList<>();
        for(int i=0;i<=vertex;i++){
            transposeAdj.add(new LinkedList<>());
        }
        for(int i=1;i<=vertex;i++){
            visited[i]=0;
            for(int neighbours: adjacencyList.get(i)){
                transposeAdj.get(neighbours).add(i);
            }
        }

        while(!st.isEmpty()){
            int node=st.pop();
            if(visited[node]==0){
                System.out.print("SCC: ");
                revDfs(node,transposeAdj,visited);
                System.out.println("");
            }
        }
    }

    private void revDfs(int node, List<List<Integer>> transposeAdj, int[] visited) {
        visited[node]=1;
        System.out.print(node+" ");
        for(int neighbours: transposeAdj.get(node)){
            if(visited[neighbours]==0){
                revDfs(neighbours,transposeAdj,visited);
            }
        }
    }

    private void topologicalsort(int i, List<List<Integer>> adjacencyList, int[] visited, Stack<Integer> st) {
        visited[i]=1;
        for(int neighbours: adjacencyList.get(i)){
            if(visited[neighbours]==0){
                topologicalsort(neighbours,adjacencyList,visited,st);
            }
        }
        st.add(i);
    }
}