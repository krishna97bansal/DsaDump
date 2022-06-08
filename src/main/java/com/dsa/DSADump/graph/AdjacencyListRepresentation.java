package com.dsa.DSADump.graph;

import java.util.LinkedList;
import java.util.List;

public class AdjacencyListRepresentation {
    // for example: graph is like this--
    //  1--2--5
    //     |  |
    //     3--4


    public List<List<Integer>> getAdjacencyList()
    {
        int vertex=5;
        List<List<Integer>> adjacencyList=new LinkedList<>();
        for(int i=0;i<vertex+1;i++){
            adjacencyList.add(new LinkedList<>());
        }

        adjacencyList.get(1).add(2);
        adjacencyList.get(2).add(1);

        adjacencyList.get(2).add(3);
        adjacencyList.get(3).add(2);

        adjacencyList.get(3).add(4);
        adjacencyList.get(4).add(3);

        adjacencyList.get(4).add(5);
        adjacencyList.get(5).add(4);

        adjacencyList.get(2).add(5);
        adjacencyList.get(5).add(2);

        return adjacencyList;
    }

}
