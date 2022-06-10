package com.dsa.DSADump.graph;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class UndirectedCycleDetectionViaBFS {
    // FOR EXAMPLE:---
    // 1--2    3--5--6--7
    //    |       |     |
    //    4       10--9--8--11
    // At every vertex we are maintaining the pair of node and it's parent and via bfs we are checking of neighbours via others just omitting
    // their parent, because parent to child and child to parent edge is not a loop.
    public boolean driver() {
        int vertex = 11;
        List<List<Integer>> adjacencyList = new LinkedList<>();
        for (int i = 0; i < vertex + 1; i++) {
            adjacencyList.add(new LinkedList<>());
        }
        adjacencyList.get(1).add(2);
        adjacencyList.get(2).add(1);

        adjacencyList.get(2).add(4);
        adjacencyList.get(4).add(2);

        adjacencyList.get(3).add(5);
        adjacencyList.get(5).add(3);

        adjacencyList.get(5).add(6);
        adjacencyList.get(6).add(5);

        adjacencyList.get(5).add(10);
        adjacencyList.get(10).add(5);

        adjacencyList.get(6).add(7);
        adjacencyList.get(7).add(6);

        adjacencyList.get(10).add(9);
        adjacencyList.get(9).add(10);

        adjacencyList.get(9).add(8);
        adjacencyList.get(8).add(9);

        adjacencyList.get(7).add(8);
        adjacencyList.get(8).add(7);

        adjacencyList.get(8).add(11);
        adjacencyList.get(11).add(8);

        return findCycle(vertex, adjacencyList);
    }

    private boolean findCycle(int vertex, List<List<Integer>> adjacencyList) {

        boolean visited[] = new boolean[vertex + 1];
        for (int i = 1; i <= vertex; i++) {
            if (visited[i] == false) {
                if (cycleDetection(i, adjacencyList, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean cycleDetection(int i, List<List<Integer>> adjacencyList, boolean[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(-1, i));
        while (!q.isEmpty()) {
            Pair p = q.peek();
            int parent = p.parent;
            int child = p.child;
            q.poll();
            for (int neighbours : adjacencyList.get(child)) {
                if (visited[neighbours] == false) {
                    q.add(new Pair(child, neighbours));
                    visited[neighbours]=true;
                } else if (neighbours != parent)
                    return true;
            }

        }
        return false;
    }

}
 class Pair
{
    int parent;
    int child;

    public Pair(int parent,int child) {
        this.parent = parent;
        this.child= child;
    }
}