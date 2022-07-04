package com.dsa.DSADump.graph;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/*
Points to Remember:
1. Articulation points are those nodes, removal of which split the graph in two or more components.
2. Here there is a bit change in base condition (=) and root node decision.Rest is same as Bridge approach.
3. Here we are using DFS to achieve same.
 */
@Service
public class FindArticulationPoints {
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
        int disc[]=new int[vertex+1];  // The discovery array is to mark the node discovery time.
        int low[]=new int[vertex+1];   // The low array is to mark the ancestors of the parent that node can visit.
        int counter=1;                 // Counter to mark the time visit.

        Set<Integer> result=new HashSet<>();
        for(int i=1;i<=vertex;i++){
            if(visited[i]==0){
                dfs(i,-1,adjacencyList,visited,disc,low,counter,result);
            }
        }

        result.forEach(i->{System.out.println(i);});
    }

    private void dfs(int node, int parent, List<List<Integer>> adjacencyList, int[] visited, int[] disc, int[] low, int counter, Set<Integer> result) {
        disc[node]=low[node]=counter;
        counter++;
        visited[node]=1;
        int child=0;

        for(int neighbours: adjacencyList.get(node)){
            if(neighbours==parent)       // The approach is to look down not to look up at parent. So we don't want to take action on parent node.
                continue;
            if(visited[neighbours]==0){
                dfs(neighbours,node,adjacencyList,visited,disc,low,counter,result);
                /*
                Check if the subtree rooted with child has a connection to one of the ancestors of parent.
                 */
                low[node]=Math.min(low[node],low[neighbours]);
                /*
                The condition to find bridge edge is as follows:
                if child's low timer is more and equal(which signify can i go beyond up in direction after removing node)
                than the parent discovered time, which signify that child is the only way to visit down tree,
                and the parent discovered first so there is no other way to go beyond that edge.
                Root node will be handled separately.
                 */
                if(low[neighbours]>=disc[node] && parent!=-1) {
                    result.add(node);
                }
                /*
                This counter is to keep track for root node to decide whether it's articulation point or not.
                 */
                child++;
            }
            else{
                /*
                In case the neighbours are already visited then that edge can never be the bridge,
                so just mark the most top rooted ancestor(the one visited(disc) first will have lesser time counter so that's why taking minimum)
                that node can visit.
                 */
                low[node]=Math.min(low[node],disc[neighbours]);
            }
        }
        /*
        To decide whether root is articulation point or not,
        if it has multiple child with diff path then its articulation point.
         */
        if(parent==-1 && child>1){
            result.add(node);
        }
    }
}