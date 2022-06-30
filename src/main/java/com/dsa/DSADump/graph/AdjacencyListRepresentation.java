package com.dsa.DSADump.graph;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
/*
Points to Remember:
1. The representation of graph can be done using the List<List<Integer>> where index is the vertex,
   and list at that index is the adjacent neighbours from that index.
2. In case of undirected graph, the relation between vertexes will be bilateral or to and fro.
3. In case of directed graph, the relation between vertexes will be as per direction, if there is
   no further way just don't mention it in adjacency list.
 */
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
