package com.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SearchAlgorithm {
    protected HashMap<String, Integer> pq = new HashMap<>();
    public ArrayList<String> visited = new ArrayList<>();
    public HashMap<String, Map<String,Integer>> mapHeuristic = new HashMap<>();

    protected String reconstructPath(ArrayList<String> visited){
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
}
