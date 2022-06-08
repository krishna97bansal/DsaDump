package com.dsa.DSADump.graph;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
// for example: graph is like this--
//  1--2--5
//     |  |
//     3--4
// In undirected graph we have mobility to and fro, so that's why adding 2 entries in list for each edge.
// In directed graph there would be only one entry.
@Service
public class AdjacencyListRepresentation {

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
