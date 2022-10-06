package com.graph;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BestFirst extends SearchAlgorithm{

    public BestFirst(HashMap<String, Map<String,Integer>> graph){
        mapHeuristic = graph;
    }

    public void search(String start, String finish){
        pq.put(start, 0);
        if(mapHeuristic.containsKey(start)){
            mapHeuristic.get(start).forEach((key, value)->{
                if(!visited.contains(key))
                    pq.put(key, value);
            });
        }
        //System.out.println(pq);
        visited.add(start);
        pq.remove(start);

        if(pq.size() > 0 ){
            String min_key = Collections.min(pq.entrySet(), Map.Entry.comparingByValue()).getKey();
            if(!pq.containsKey(finish))
                search(min_key, finish);
            else {
                visited.add(finish);
                //System.out.println(visited);
                System.out.println(reconstructPath(visited));
            }
        }
        else
            System.out.println("Tujuan tidak ditemukan dalam daftar");
    }
}
