package com.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SearchAlgorithm {
    protected HashMap<String, Double> pq = new HashMap<>();
    public ArrayList<String> visited = new ArrayList<>();
    public GraphHeuristic mapHeuristic;
}
