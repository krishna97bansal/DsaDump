package com.dsa.DSADump.graph;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
/*
Points to Remember:
1. Prim's algorithm (also known as Jarník's algorithm) is a greedy algorithm that finds a minimum spanning tree,
   for a weighted undirected graph. This means it finds a subset of the edges that forms a tree that includes every vertex,
   where the total weight of all the edges in the tree is minimized.
2. Goal is to have a minimal tree with N nodes and N-1 edges with minimum cost.
3. Parent array is for marking parent child relationship with index.
4. Cost array is for marking cost associated with the edge.
5. Mst array is for marking the role of vertex in mst or not.
 */
@Service
public class PrimAlgorithm {

    public void driver(){
        int vertex=5;
        List<List<PrimNode>> adj=new LinkedList<>();
        for(int i=0;i<vertex+1;i++){
            adj.add(new LinkedList<PrimNode>());
        }

        adj.get(1).add(new PrimNode(2,2));
        adj.get(1).add(new PrimNode(4,6));

        adj.get(2).add(new PrimNode(1,2));
        adj.get(4).add(new PrimNode(1,6));

        adj.get(2).add(new PrimNode(3,3));
        adj.get(2).add(new PrimNode(5,5));

        adj.get(3).add(new PrimNode(2,3));
        adj.get(5).add(new PrimNode(2,5));

        adj.get(3).add(new PrimNode(5,7));

        adj.get(5).add(new PrimNode(3,7));

        adj.get(4).add(new PrimNode(2,8));

        adj.get(2).add(new PrimNode(4,8));

        primEvaluator(vertex,adj);
    }

    private void primEvaluator(int vertex, List<List<PrimNode>> adj) {

        int cost[]=new int[vertex+1];
        int parent[]=new int[vertex+1];
        boolean mst[]=new boolean[vertex+1];

        for(int i=0;i<vertex+1;i++){
            cost[i]=Integer.MAX_VALUE;
            parent[i]=-1;
            mst[i]=false;
        }

        cost[1]=0;
        PriorityQueue<PrimNode> q=new PriorityQueue<>(new Comparator<PrimNode>() {
            @Override
            public int compare(PrimNode o1, PrimNode o2) {
                return o1.weight-o2.weight;
            }
        });
        q.add(new PrimNode(1,cost[1]));

        for(int i=1;i<vertex;i++){
            PrimNode node=q.poll();
            mst[i]=true;
            for(PrimNode neighbour: adj.get(node.vertex)){
                if(mst[neighbour.vertex]==false && cost[neighbour.vertex]> neighbour.weight){
                    cost[neighbour.vertex]=neighbour.weight;
                    parent[neighbour.vertex]=node.vertex;
                    q.add(new PrimNode(neighbour.vertex,cost[neighbour.vertex]));
                }
            }
        }

        for(int i=1;i<vertex+1;i++){
            System.out.print(cost[i]+" ");
        }
        System.out.println("");
        for(int i=1;i<vertex+1;i++){
            System.out.print(parent[i]+" ");
        }
        System.out.println("");
        for(int i=1;i<vertex+1;i++){
            System.out.print(mst[i]+" ");
        }
    }
}

class PrimNode{
    int vertex;
    int weight;
    public PrimNode(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}