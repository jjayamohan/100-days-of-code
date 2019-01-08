package com.jay.datastructure;

import java.util.LinkedList;
import java.util.*;

public class DirectedGraph {

    private Map<Vertex, List<Vertex>> adjvertices = new HashMap<>();


    public void add(String from, String  to) {
        add(new Vertex(from), new Vertex(to));
    }

    public void add(Vertex from, Vertex to) {
        addVertex(from);
        addVertex(to);

        adjvertices.get(from).add(to);
    }

    public void remove (Vertex from, Vertex to) {
        if (!(this.contains(from) && this.contains(to)))
            throw new IllegalArgumentException("Nonexistent vertex");

        adjvertices.get(from).remove(to);
    }

    public void addVertex(String label) {
        adjvertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void addVertex(Vertex vertex) {
        adjvertices.putIfAbsent(vertex, new ArrayList<>());
    }

    public void removeVertex(Vertex vertex) {
        adjvertices.remove(vertex);
    }

    public List<Vertex> getVertices(Vertex vertex) {
        return adjvertices.get(vertex);
    }

    public boolean contains (Vertex vertex) {
        return adjvertices.containsKey(vertex);
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

        DirectedGraph graph = new DirectedGraph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");

        graph.add("Alice", "Maria");

        graph.add("Bob", "Alice");
        graph.add("Mark", "Alice");

        graph.add("Rob", "Bob");
        graph.add("Rob", "Mark");
        graph.add("Rob", "Maria");

        graph.depthFirstTraversal(graph, "Rob");
        graph.breadthFirstTraversal(graph, "Rob");

    }

    public void depthFirstTraversal(DirectedGraph graph, String root) {

        if (root == null || root.isEmpty())
            return;

        Set<Vertex> visited = new LinkedHashSet<>();
        System.out.println();
        System.out.println("DFS: ");
        dfs(new Vertex(root), visited);
    }


    public void breadthFirstTraversal(DirectedGraph graph, String root) {

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
