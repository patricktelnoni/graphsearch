package com.graph;

import java.util.HashMap;

public class Neighbor {
    private HashMap<Node, Double> neighbor;

    public void setNeighbor(HashMap<Node, Double> neighbor) {
        this.neighbor = neighbor;
    }

    public HashMap<Node, Double> getNeighbor() {
        return neighbor;
    }
}
