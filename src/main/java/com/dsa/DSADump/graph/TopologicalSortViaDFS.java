package com.dsa.DSADump.graph;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

@Service
public class TopologicalSortViaDFS {

    public void driver()
    {
        int vertex=6;
        List<List<Integer>> adjacencyList=new LinkedList<>();
        for(int i=0;i<vertex+1;i++){
            adjacencyList.add(new LinkedList<>());
        }

        adjacencyList.get(3).add(4);

        adjacencyList.get(4).add(2);

        adjacencyList.get(5).add(1);
        adjacencyList.get(5).add(2);

        adjacencyList.get(6).add(1);
        adjacencyList.get(6).add(3);

        for(int i: getTopo(vertex,adjacencyList)){
            System.out.println(i);
        }
    }

    private List<Integer> getTopo(int vertex, List<List<Integer>> adjacencyList) {
        boolean visited[]=new boolean[vertex+1];
        List<Integer> result=new LinkedList<>();
        Stack<Integer> st=new Stack<>();

        for(int i=1;i<=vertex;i++){
            if(visited[i]==false){
                dfs(i,adjacencyList,visited,st);
            }
        }

        while(!st.isEmpty()){
            result.add(st.pop());
        }
        return result;
    }

    private void dfs(int i, List<List<Integer>> adjacencyList, boolean[] visited, Stack<Integer> st) {
        visited[i]=true;
        for(int neighbour: adjacencyList.get(i)){
            if(visited[neighbour]==false){
                dfs(neighbour,adjacencyList,visited,st);
            }
        }
        st.add(i);
    }
}