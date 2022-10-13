package com.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SearchAlgorithm {
    protected HashMap<Node, Double> pq = new HashMap<>();
    public ArrayList<Node> visited = new ArrayList<>();
    public ArrayList<Node> mapHeuristic;

    protected String reconstructPath(){
        return "";
        
        /*String current  = "";
        current         = visited.get(visited.size()-1);

        ArrayList<String> totalPath = new ArrayList<>();
        totalPath.add(current);
        visited.remove(current);
        while(!visited.isEmpty()){
            String tail = visited.get(visited.size()-1);
            if(mapHeuristic.contains(tail)){
                if(mapHeuristic.get(tail).containsKey(current)){
                    totalPath.add(tail);
                    current = tail;
                }
            }
            visited.remove(tail);
        }
        Collections.reverse(totalPath);
        return String.join("-", totalPath);*/
    }
}
