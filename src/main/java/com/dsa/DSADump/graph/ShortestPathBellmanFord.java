package com.dsa.DSADump.graph;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
/*
Points to Remember:
1.  Dijkstra’s algorithm is a Greedy algorithm and time complexity is O((V+E)LogV) (with the use of Fibonacci heap).
    Dijkstra doesn’t work for Graphs with negative weights, Bellman-Ford works for such graphs.
2.  Bellman-Ford is also simpler than Dijkstra and suites well for distributed systems. But time complexity of Bellman-Ford is O(VE), which is more than Dijkstra.
3. Approach is simple just relax all the edges 1 to N-1 times.
4. If even after doing 1 more time after 1 to N-1 we are able to find the shortest path, then that means there is some negative cycle that keeps
   on giving the shortest path.
 */
@Service
public class ShortestPathBellmanFord {

    public void driver() {
        int vertex = 6;
        List<BellmanNode> adj = new LinkedList<>();

        adj.add(new BellmanNode(4, 3, 6));
        adj.add(new BellmanNode(6, 4, 1));
        adj.add(new BellmanNode(1, 2, 5));
        adj.add(new BellmanNode(2, 6, -3));
        adj.add(new BellmanNode(2, 3, -2));
        adj.add(new BellmanNode(4, 5, -2));
        adj.add(new BellmanNode(3, 5, 3));

        shortestPath(vertex, adj, 1);
    }

    private void shortestPath(int N, List<BellmanNode> edges, int src) {
        int dist[] = new int[N+1];
        for (int i = 0; i < N + 1; i++) dist[i] = 10000000;

        dist[src] = 0;

        for (int i = 1; i <= N - 1; i++) {
            for (BellmanNode node : edges) {
                if (dist[node.u] + node.weight < dist[node.v]) {
                    dist[node.v] = dist[node.u] + node.weight;
                }
            }
        }

        int fl = 0;
        for (BellmanNode node : edges) {
            if (dist[node.u] + node.weight < dist[node.v]) {
                fl = 1;
                System.out.println("Negative Cycle");
                break;
            }
        }

        if (fl == 0) {
            for (int i = 0; i < N; i++) {
                System.out.print(dist[i] + " ");
            }
        }
    }
}
class BellmanNode{
    int u;
    int v;
    int weight;

    public BellmanNode(int u,int v,int weight) {
        this.u=u;
        this.v=v;
        this.weight=weight;
    }
}