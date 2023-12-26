package dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    boolean breadthFirstSearch(List<List<Integer>> g, int source, int target) {
        boolean[] visited = new boolean[10];
        Integer[] distance = new Integer[10];
        visited[1] = true;
        Queue<Integer> q = new LinkedList<>();

        q.add(source);
        visited[source] = true;
        distance[source] = 0;

        while (q.size() > 0) {
            int u = q.element();
            q.remove();
            for (int i = 0; i < g.get(u).size(); i++) {
                int v = g.get(u).get(i);
                distance[v] = distance[u] + 1;
                if (visited[v] == false) {
                    q.add(v);
                    visited[v] = true;
                }
            }

        }
        for (boolean visit : visited) {
            System.out.print(visit + " ");
        }
        if (visited[target]) {
            System.out.println("Distance from " + source + " to " + target + " is " + distance[target]);
        }

        return visited[target];
    }


    public static void main(String[] args) {
        BFS bfs = new BFS();

        List<List<Integer>> graph = new ArrayList<>(10);
        graph = bfs.createList();
        bfs.breadthFirstSearch(graph, 2, 6);


    }

    private List<List<Integer>> createList() {

        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> l0 = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        l1.add(4);

        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(4);
        l2.add(3);


        List<Integer> l3 = new ArrayList<>();
        l2.add(2);
        l2.add(5);

        List<Integer> l4 = new ArrayList<>();
        l2.add(1);
        l2.add(2);
        l2.add(5);

        List<Integer> l5 = new ArrayList<>();
        l2.add(3);
        l2.add(6);
        l2.add(4);

        List<Integer> l6 = new ArrayList<>();
        l2.add(5);
        graph.add(l0);
        graph.add(l1);
        graph.add(l2);
        graph.add(l3);
        graph.add(l4);
        graph.add(l5);
        graph.add(l6);

        return graph;


    }

    private List<List<Integer>> createListFromInputArray(Integer[][] input) {

        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> l0 = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        l1.add(4);

        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(4);
        l2.add(3);


        List<Integer> l3 = new ArrayList<>();
        l2.add(2);
        l2.add(5);

        List<Integer> l4 = new ArrayList<>();
        l2.add(1);
        l2.add(2);
        l2.add(5);

        List<Integer> l5 = new ArrayList<>();
        l2.add(3);
        l2.add(6);
        l2.add(4);

        List<Integer> l6 = new ArrayList<>();
        l2.add(5);
        graph.add(l0);
        graph.add(l1);
        graph.add(l2);
        graph.add(l3);
        graph.add(l4);
        graph.add(l5);
        graph.add(l6);

        return graph;


    }
}
