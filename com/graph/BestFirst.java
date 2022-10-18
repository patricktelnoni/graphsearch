package com.graph;

import java.util.*;

public class BestFirst extends SearchAlgorithm{
    String minNode;
    ArrayList<String> totalPath = new ArrayList<>();

    public BestFirst(GraphHeuristic graph){
        mapHeuristic = graph;
    }

    private String getMinNode(){
        return Collections.min(pq.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public void getPath(String finish){

        while(!visited.isEmpty()){
            String current = visited.get(visited.size()-1);
            if(mapHeuristic.containNode(current)){
                HashMap<String, Double> neighbor = mapHeuristic.getNeighborByNode(current).getNeighbor();
                for(Map.Entry<String, Double> n : neighbor.entrySet()){
                    if(n.getKey().equals(finish)){
                        totalPath.add(current);
                        finish = current;
                    }
                }
            }
            visited.remove(current);
        }
        System.out.println(totalPath);
    }

    public void search(String start, String finish){

        pq.put(start, 0.0);
        if(mapHeuristic.containNode(start) && !visited.contains(start)){
            Node node = mapHeuristic.getNeighborByNode(start);
            HashMap<String, Double> neighbor = node.getNeighbor();
            neighbor.forEach((key, value)->{
                if(!visited.contains(key))
                    pq.put(key, value);
            });
        }

        //visited.
        visited.add(start);
        pq.remove(start);

        if(pq.size() > 0){
            String minNode = this.getMinNode();
            if(!pq.entrySet().stream().anyMatch(t -> t.getKey().equals(finish))){
                search(minNode, finish);
            }
            else {
                visited.add(finish);
                totalPath.add(finish);
                getPath(finish);
            }
        }
        else
            System.out.println("Tujuan tidak ditemukan dalam daftar");
    }
}
