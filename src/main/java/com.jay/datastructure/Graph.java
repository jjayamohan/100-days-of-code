package com.jay.datastructure;


import java.util.*;

public class Graph {

    private Map<Vertex, List<Vertex>> adjvertices = new HashMap<>();


    public void addVertex(String label) {
        adjvertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void removeVertex(String label) {
        adjvertices.remove(label);
    }

    public List<Vertex> getVertices(String label) {
        return adjvertices.get(new Vertex(label));
    }

    public List<Vertex> getVertices(Vertex vertex) {
        return getVertices(vertex.label);
    }


    public void addEdge(String label1, String label2) {

        Vertex vertex1 = new Vertex(label1);
        Vertex vertex2 = new Vertex(label2);

        adjvertices.get(vertex1).add(vertex2);
        adjvertices.get(vertex2).add(vertex1);
    }

    private void removeEdge(String label1, String label2) {

        Vertex vertex1 = new Vertex(label1);
        Vertex vertex2 = new Vertex(label2);

        adjvertices.get(vertex1).remove(vertex2);
        adjvertices.get(vertex2).remove(vertex1);
    }

    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");


        graph.depthFirstTraversal(graph, "Alice");
        graph.breadthFirstTraversal(graph, "Alice");

    }

    public void depthFirstTraversal(Graph graph, String root) {

        if (root == null || root.isEmpty())
            return;

        Set<Vertex> visited = new LinkedHashSet<>();
        System.out.println();
        System.out.println("DFS: ");
        dfs(new Vertex(root), visited);
    }


    public void breadthFirstTraversal(Graph graph, String root) {

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
        Queue<Vertex> queue = new java.util.LinkedList<>();

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
