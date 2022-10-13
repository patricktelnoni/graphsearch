package com.graph;

import java.util.HashMap;

public class Node<T> {

    private boolean isVisited;
    private String node;
    private HashMap<Node, Double> neighbor;

    public Node(){

    }

    public Node(String node, boolean isVisited){
        this.node = node;
        this.isVisited = isVisited;
    }

    public boolean hasNeighbor(){
        return this.neighbor != null ? true:false;
    }

    public Double getDistance(Node node){
        return neighbor.get(node);
    }

    public boolean isVisited(){
        return isVisited;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getNode() {
        return node;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public HashMap<Node, Double> getNeighbor() {
        return neighbor;
    }

    public void setNeighbor(HashMap<Node, Double> neighbor) {
        this.neighbor = neighbor;
    }
}
