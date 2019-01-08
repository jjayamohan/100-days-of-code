package com.jay.datastructure;

import java.util.LinkedList;
import java.util.*;

public class WeightedGraph {

    private List<Vertex> vertexes = new ArrayList<>();
    private List<Edge> edges = new ArrayList<>();


    public void addEdge(Vertex from, Vertex to, float weight) {
        edges.add(new Edge(from, to, weight));
    }

    public void addEdge(String label1, String label2, float weight) {
        addEdge(new Vertex(label1), new Vertex(label2), weight);
    }

    public void removeEdge (Vertex from, Vertex to) {
        edges.remove(new Edge(from, to, 0));
    }

    private void removeEdge(String label1, String label2) {
        removeEdge(new Vertex(label1), new Vertex(label2));
    }

    public void addVertex(String label) {
        vertexes.add(new Vertex(label));
    }

    public void addVertex(Vertex vertex) {
        vertexes.add(vertex);
    }

    public void removeVertex(Vertex vertex) {
        vertexes.remove(vertex);
    }

    public List<Vertex> getVertices(Vertex vertex) {
        return vertexes;
    }

    public boolean contains (Vertex vertex) {
        return vertexes.contains(vertex);
    }

    public boolean contains (Edge edge) {
        return edges.contains(edge);
    }

    public static void main(String[] args) {

        WeightedGraph graph = new WeightedGraph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");

        graph.addEdge("Alice", "Bob", 1);
        graph.addEdge("Alice", "Maria", 0.75f);
        graph.addEdge("Alice", "Mark", 0.5f);

        graph.addEdge("Bob", "Rob", 0.75f);
        graph.addEdge("Mark", "Rob", 0.5f);
        graph.addEdge("Maria", "Rob", 1);

        graph.depthFirstTraversal(graph, "Rob");
        graph.breadthFirstTraversal(graph, "Rob");

    }

    public void depthFirstTraversal(WeightedGraph graph, String root) {

        if (root == null || root.isEmpty())
            return;

        Set<Vertex> visited = new LinkedHashSet<>();
        System.out.println();
        System.out.println("DFS: ");
        dfs(new Vertex(root), visited);
    }


    public void breadthFirstTraversal(WeightedGraph graph, String root) {

        if (root == null || root.isEmpty())
            return;

        Set<Vertex> visited = new LinkedHashSet<>();
        System.out.println("\nBFS: ");
        bfs(new Vertex(root), visited);
    }


    void dfs(Vertex vertex, Set<Vertex> visited) {

        vertex.visit();
        visited.add(vertex);

        for (Vertex each : getVertices(vertex)) {
            if (!visited.contains(each)) {
                dfs(each, visited);
            }
        }
    }

    void bfs (Vertex vertex, Set<Vertex> visited) {
        Queue<Vertex> queue = new LinkedList<>();

        visited.add(vertex);
        queue.add(vertex);

        while (!queue.isEmpty()) {
            Vertex node = queue.poll();
            node.visit();

            for (Vertex child : this.getVertices(node)) {
                if (!visited.contains(child)) {
                    queue.add(child);
                    visited.add(child);
                }
            }
        }
    }
}
