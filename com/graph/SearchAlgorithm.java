package com.graph;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class SearchAlgorithm {
    protected HashMap<String, Double> pq = new HashMap<>();
    public ArrayList<String> visited = new ArrayList<>();
    public GraphHeuristic mapHeuristic;
}
