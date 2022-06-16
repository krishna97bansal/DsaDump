package com.dsa.DSADump.graph;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class BipartiteGraphViaDFS {
    public boolean driver()
    {
        int vertex=7;
        List<List<Integer>> adjacencyList=new LinkedList<>();

        for(int i=0;i<=vertex;i++)
        {
            adjacencyList.add(new LinkedList<>());
        }

        adjacencyList.get(0).add(1);
        adjacencyList.get(1).add(0);

        adjacencyList.get(1).add(2);
        adjacencyList.get(2).add(1);

        adjacencyList.get(2).add(3);
        adjacencyList.get(3).add(2);

        adjacencyList.get(4).add(3);
        adjacencyList.get(3).add(4);

        adjacencyList.get(4).add(5);
        adjacencyList.get(5).add(4);

        adjacencyList.get(4).add(6);
        adjacencyList.get(6).add(4);

        adjacencyList.get(1).add(6);
        adjacencyList.get(6).add(1);

        return findBipartite(vertex, adjacencyList);
    }

    private boolean findBipartite(int vertex, List<List<Integer>> adjacencyList) {
         int coloured[]=new int[vertex];
         for(int i=0;i<vertex;i++){
             coloured[i]=-1;
         }
         for(int i=0;i<vertex;i++) {
             if(coloured[i]==-1){
                 if(!check(i,adjacencyList,coloured,0)) {
                     return false;
                 }
             }
         }
         return true;
    }

    private boolean check(int i, List<List<Integer>> adjacencyList, int[] coloured, int colour) {
        coloured[i]=colour;
        for(int neighbours: adjacencyList.get(i)){
            if(coloured[neighbours]==-1){
                if(!check(neighbours,adjacencyList,coloured,1-coloured[i])){
                    return false;
                }
            }
            else if(coloured[neighbours]==coloured[i]){
                return  false;
            }
        }
        return true;
    }
}
