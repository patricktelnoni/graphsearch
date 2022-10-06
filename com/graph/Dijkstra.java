package com.graph;

import java.util.*;

public class Dijkstra extends SearchAlgorithm{
    HashMap<String, Integer> distances = new HashMap<>();
    HashMap<String, String> previous = new HashMap<>();
    ArrayList<String> totalPath = new ArrayList<>();


    public Dijkstra(HashMap<String, Map<String,Integer>> graph){
        mapHeuristic = graph;
    }

    private void reconstructPath(String currentNode, String start){

        while(currentNode != start){
            totalPath.add(currentNode);
            currentNode = previous.get(currentNode);
        }
        totalPath.add(start);
        Collections.reverse(totalPath);
        System.out.println(previous);

        System.out.println(totalPath);
    }
    public void search(String start, String finish){
        mapHeuristic.forEach((key, value) ->{
            distances.put(key, Integer.MAX_VALUE);
            previous.put(key, "");
        });
        distances.put(start, 0);

        while (!distances.isEmpty()){
            String minNode = Collections.min(distances.entrySet(), Map.Entry.comparingByValue()).getKey();
            if(mapHeuristic.containsKey(minNode) && distances.containsKey(minNode)){
                mapHeuristic.get(minNode).forEach((key, value)->{
                    int tempDist = distances.get(minNode) + mapHeuristic.get(minNode).get(key);
                    if(distances.containsKey(key)){
                        if(tempDist < distances.get(key)){
                            distances.put(key, tempDist);
                            previous.put(key, minNode);
                        }
                    }
                });
            }

            distances.remove(minNode);
            System.out.println(distances);
        }

        reconstructPath(finish, start);
    }
}
