package com.dsa.DSADump.graph;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
/*
Points to Remember:
1.  Finding the shortest distance in directed graph is simpler, just take distance array with max value.
2.  Mark source distance from itself as 0.
3.  Traverse all adjacent and +weight of the edge from source and compare it with their distance value.
4.  We are using heap to sort the edges as minimum distance weight first, rather than finding larger distance then reducing it to
    the shortest one.
 */
@Service
public class ShortestPathUnidirectedWeightedGraph {
    public int driver()
    {
        int vertex=5;
        List<List<Node>> adjacencyList=new LinkedList<>();
        for(int i=0;i<vertex+1;i++){
            adjacencyList.add(new LinkedList<>());
        }

        adjacencyList.get(1).add(new Node(2,2));
        adjacencyList.get(1).add(new Node(4,1));

        adjacencyList.get(2).add(new Node(1,2));
        adjacencyList.get(2).add(new Node(3,4));
        adjacencyList.get(2).add(new Node(5,5));

        adjacencyList.get(3).add(new Node(2,4));
        adjacencyList.get(3).add(new Node(4,3));
        adjacencyList.get(3).add(new Node(5,1));

        adjacencyList.get(4).add(new Node(1,1));
        adjacencyList.get(4).add(new Node(3,3));

        adjacencyList.get(5).add(new Node(2,5));
        adjacencyList.get(5).add(new Node(3,1));

        return shortestPath(vertex,adjacencyList,1,5);
    }

    private int shortestPath(int vertex, List<List<Node>> adjacencyList, int source, int destination) {
        int dist[]=new int[vertex+1];
        for(int i=0;i<dist.length;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[source]=0;
        PriorityQueue<Node> q=new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight-o2.weight;
            }
        });

        q.add(new Node(source,0));
        while(!q.isEmpty()){
            Node node=q.poll();
            for(Node neighbours:adjacencyList.get(node.vertex)){
                if(node.weight+neighbours.weight<dist[neighbours.vertex]){
                    dist[neighbours.vertex]=node.weight+neighbours.weight;
                    q.add(new Node(neighbours.vertex,dist[neighbours.vertex]));
                }
            }
        }
        return dist[destination];
    }
}

class Node{
    int vertex;
    int weight;

    public Node(int vertex,int weight) {
        this.vertex = vertex;
        this.weight=weight;
    }
}