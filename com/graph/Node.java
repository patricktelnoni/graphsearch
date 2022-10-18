package com.graph;

import java.util.HashMap;

public class Node<T> {


    private String node;
    private HashMap<String, Double> neighbor;

    public Node(){

    }

    public Node(String node){
        this.node = node;
    }

    public boolean hasNeighbor(){
        return this.neighbor != null ? true:false;
    }

    public Double getDistance(Node node){
        return neighbor.get(node);
    }



    public void setNode(String node) {
        this.node = node;
    }

    public String getNode() {
        return node;
    }



    public HashMap<String, Double> getNeighbor() {
        return neighbor;
    }

    public void setNeighbor(HashMap<String, Double> neighbor) {
        this.neighbor = neighbor;
    }
}
