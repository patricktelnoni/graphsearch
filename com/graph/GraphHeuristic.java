package com.graph;

import java.util.*;

public class GraphHeuristic<T> {
    private HashMap<String, Map<String,Integer>> mapHeuristic = new HashMap<>();
    public ArrayList<String> track = new ArrayList<>();
    private HashMap<String, Integer> pq = new HashMap<>();
    private ArrayList<String> visited = new ArrayList<>();
    private HashMap<String, Integer> generatedTrack = new HashMap<>();

    public HashMap<String, Map<String, Integer>> getMapHeuristic() {
        return mapHeuristic;
    }

    private void addVertex(String s){
        mapHeuristic.put(s, new HashMap<String, Integer>());
    }

    public void addEdge(String source, String destination, int distance){
        if(!mapHeuristic.containsKey(source)){
            addVertex(source);
        }
        /*if(!mapHeuristic.containsKey(destination)){
            addVertex(destination);
        }*/
        if(!mapHeuristic.get(source).containsKey(source)) {
            mapHeuristic.get(source).put(destination, distance);
        }
    }

    public String reconstructPath(ArrayList<String> visited){
        String current  = "";
        current         = visited.get(visited.size()-1);

        ArrayList<String> totalPath = new ArrayList<>();
        totalPath.add(current);
        visited.remove(current);
        while(!visited.isEmpty()){
            String tail = visited.get(visited.size()-1);
            if(mapHeuristic.containsKey(tail)){
                if(mapHeuristic.get(tail).containsKey(current)){
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

    public void AStar(String start, String finish, int cost){
        Map.Entry<String, Integer> best_node;
        pq.put(start, cost);
        if(pq.size() == 0){
            System.out.println("Not found");
        }
        else{
            best_node       = Collections.min(pq.entrySet(), Map.Entry.comparingByValue());
            if(!visited.contains(best_node.getKey())){
                visited.add(best_node.getKey());
                pq.remove(best_node.getKey());
                //System.out.println(best_node.getKey());
                mapHeuristic.get(best_node.getKey()).forEach((key, value)->{
                    if(!pq.containsKey(key)){
                        if(!visited.contains(key)){
                            pq.put(key, value + cost);
                        }
                    }
                });
                if(pq.containsKey(finish)){
                    String path = reconstructPath(visited);
                    generatedTrack.put(path, pq.get(finish));

                    HashMap<String, Integer> mergedMap = new HashMap<>();
                    mergedMap.putAll(generatedTrack);
                    mergedMap.putAll(pq);
                    //System.out.println(path);
                    Map.Entry<String, Integer> minPair = Collections.min(mergedMap.entrySet(), Map.Entry.comparingByValue());
                    if(generatedTrack.containsKey(minPair.getKey())){
                        System.out.println("Ketemu " + mergedMap);
                    }
                    else{
                        pq.remove(finish);
                        AStar(minPair.getKey(), finish, minPair.getValue());
                    }
                }
                else{
                    best_node = Collections.min(pq.entrySet(), Map.Entry.comparingByValue());
                    AStar(best_node.getKey(), finish, best_node.getValue());
                }
            }
            else{
                pq.remove(best_node.getKey());
                best_node = Collections.min(pq.entrySet(), Map.Entry.comparingByValue());
                AStar(best_node.getKey(), finish, best_node.getValue());
            }
        }
    }

    public void printAdjacency(){
        mapHeuristic.forEach((key, value) -> {
            System.out.print(key + " : (");
            value.forEach((key1, value1) -> {
                System.out.print(key1 + ": " + value1 + ", ");
            });
            System.out.print(")\n");
        });
        //countVertices();
        //countEdges();
    }

    public void countH(){
        
    }

    public void AStar(T startPoint){

    }
}

