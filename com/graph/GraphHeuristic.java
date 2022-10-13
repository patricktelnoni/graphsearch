package com.graph;

import java.util.*;

public class GraphHeuristic<T> {
    private ArrayList<Node> mapHeuristic    = new ArrayList<>();
    private HashMap<String, Integer> pq     = new HashMap<>();
    private ArrayList<String> visited       = new ArrayList<>();
    private ArrayList<String> addedVertices = new ArrayList<>();

    public ArrayList<Node> getMapHeuristic() {
        return mapHeuristic;
    }

    private void addVertex(Node node){
        mapHeuristic.add(node);
    }

    public void addEdge(Node source, Node destination, double distance){
        if(!mapHeuristic.contains(source)){
            addVertex(source);
            source.setNeighbor(new HashMap<String, Double>());
            //addedVertices.add(source);
        }

        if(mapHeuristic.contains(source)){
            HashMap<Node, Double> neighbor = source.getNeighbor();
            neighbor.put(destination, distance);
            source.setNeighbor(neighbor);

        }

        /*
         if(!mapHeuristic.contains(node.getNode())){
            addVertex(node);
        }

        if(!mapHeuristic.containsKey(destination)){
            addVertex(destination);
        }*/

        /*if(!mapHeuristic.get(node).getNode().containsKey(source)) {
            mapHeuristic.get(source).put(new Node(destination, false, new HashMap<T, Integer>()), distance);
        }*/
    }

    public String reconstructPath(ArrayList<String> visited){
        String current  = "";
        current         = visited.get(visited.size()-1);

        ArrayList<String> totalPath = new ArrayList<>();

        totalPath.add(current);
        visited.remove(current);

        while(!visited.isEmpty()){
            String tail = visited.get(visited.size()-1);
            if(mapHeuristic.contains(tail)){
                int index = mapHeuristic.indexOf(tail);
                if(mapHeuristic.get(index).getNeighbor().containsKey(current)){
                    totalPath.add(tail);
                    current = tail;
                }
            }
            visited.remove(tail);
        }
        Collections.reverse(totalPath);
        return String.join("-", totalPath);
    }

    public int getManhattanDistance(int value, int index) {
        value = value == 0? 9 : value;
        return Math.abs((value - 1) % 3 - index % 3) + Math.abs((value - 1)/3  - index / 3);
    }

    public void printAdjacency(){
        for (Node node: mapHeuristic) {
            System.out.print(node.getNode() + " : (");
            node.getNeighbor().forEach((key, value)->{
                System.out.print(key + ": " + value + ", ");
            });
            System.out.print(")\n");
        }
        /*mapHeuristic.forEach((key, value) -> {
            System.out.print(key.getNode() + " : (");
            value.forEach((key1, value1) -> {
                System.out.print(key1 + ": " + value1 + ", ");
            });
            System.out.print(")\n");
        });*/
        //countVertices();
        //countEdges();
    }

    public void countH(){
        
    }

    public void AStar(T startPoint){

    }
}

