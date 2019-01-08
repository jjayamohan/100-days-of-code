package com.jay.datastructure;

import java.util.Objects;

public class Edge {

    Vertex source;
    Vertex destination;
    float weight;

    public Edge(Vertex source, Vertex destination, float weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(source, edge.source) &&
                Objects.equals(destination, edge.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination);
    }
}
