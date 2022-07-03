package com.dsa.DSADump.graph;

import org.springframework.stereotype.Service;

import java.util.*;
/*
Points to Remember:
1. Krushkal is the optimised way to find MST,the approach is based on the disjoint set concept.
2. Here we maintain adj as (u,v,w).
3. We simply have to sort the adj first then we have to iterate adj.
4. We have to find whether u and v are part of same set or not(findPar), so we maintain parent and rank for that.
5. If not then union(u,v,parent,rank),add child to high rank parent only.
6. At start all rank are 0 and all are self parent.
 */
@Service
public class KrushkalAlgorithm {

    public int driver(){

        int vertex=5;
        List<KrushkalPair> adj=new LinkedList<>();
        adj.add(new KrushkalPair(1,2,2));
        adj.add(new KrushkalPair(1,4,6));
        adj.add(new KrushkalPair(2,4,8));
        adj.add(new KrushkalPair(2,3,3));
        adj.add(new KrushkalPair(2,5,5));
        adj.add(new KrushkalPair(3,5,7));

        return krushkal(adj,vertex);

    }

    private int krushkal(List<KrushkalPair> adj, int vertex) {
        int parent[]=new int[vertex+1];
        int rank[]=new int[vertex+1];
        int cost=0;

        for(int i=0;i<vertex+1;i++){
            parent[i]=i;
            rank[i]=0;
        }

        Collections.sort(adj, new Comparator<KrushkalPair>() {
            @Override
            public int compare(KrushkalPair o1, KrushkalPair o2) {
                return o1.weight-o2.weight;
            }
        });
        List<KrushkalPair> result=new LinkedList<>();
        for(KrushkalPair edge: adj){
            if(findPar(edge.u,parent)!=findPar(edge.v,parent)){
                cost+=edge.weight;
                result.add(edge);
                union(edge.u,edge.v,parent,rank);
            }
        }
        result.forEach(i->System.out.println(i));
        return cost;
    }

    private void union(int u, int v, int[] parent, int[] rank) {
        int rankU=rank[u];
        int rankV=rank[v];

        if(rankU<rankV){
            parent[u]=v;
        } else if (rankV>rankU) {
            parent[v]=u;
        }else{
            parent[v]=u;
            rank[u]++;
        }
    }

    private int findPar(int u, int[] parent) {
        if(parent[u]==u)
            return u;
        return findPar(parent[u],parent);
    }
}

class KrushkalPair{
    int u;
    int v;
    int weight;

    public KrushkalPair(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "KrushkalPair{" +
                "u=" + u +
                ", v=" + v +
                ", weight=" + weight +
                '}';
    }
}