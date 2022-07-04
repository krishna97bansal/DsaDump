package com.dsa.DSADump.graph;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class FindBridges {

    public void driver()
    {
        int vertex=5;
        List<List<Integer>> adjacencyList=new LinkedList<>();
        for(int i=0;i<vertex+1;i++){
            adjacencyList.add(new LinkedList<>());
        }

        adjacencyList.get(1).add(2);
        adjacencyList.get(2).add(1);

        adjacencyList.get(1).add(3);
        adjacencyList.get(3).add(1);

        adjacencyList.get(2).add(3);
        adjacencyList.get(3).add(2);

        adjacencyList.get(2).add(4);
        adjacencyList.get(4).add(2);

        adjacencyList.get(4).add(5);
        adjacencyList.get(5).add(4);

        bridge(adjacencyList,vertex);
    }

    private void bridge(List<List<Integer>> adjacencyList, int vertex) {
        int visited[]=new int[vertex+1];
        int disc[]=new int[vertex+1];
        int low[]=new int[vertex+1];
        int counter=1;

        List<String> result=new LinkedList<>();
        for(int i=1;i<=vertex;i++){
            if(visited[i]==0){
                dfs(i,-1,adjacencyList,visited,disc,low,counter,result);
            }
        }

        result.forEach(i->{System.out.println(i);});
    }

    private void dfs(int node, int parent, List<List<Integer>> adjacencyList, int[] visited, int[] disc, int[] low, int counter, List<String> result) {
        disc[node]=low[node]=counter;
        counter++;
        visited[node]=1;

        for(int neighbours: adjacencyList.get(node)){
            if(neighbours==parent)
                continue;
            if(visited[neighbours]==0){
                dfs(neighbours,node,adjacencyList,visited,disc,low,counter,result);
                low[node]=Math.min(low[node],low[neighbours]);
                if(low[neighbours]>disc[node])
                    result.add(neighbours+" "+node);
            }
            else{
                low[node]=Math.min(low[node],disc[neighbours]);
            }
        }
    }
}
