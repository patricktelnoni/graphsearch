package com.graph;

import java.util.*;

public class BestFirst extends SearchAlgorithm{
    Node minNode;
    ArrayList<String> totalPath = new ArrayList<>();

    public BestFirst(ArrayList<Node> graph){
        mapHeuristic = graph;
    }

    private Node getMinNode(){
        double minDistance = 0.0;
        for (Map.Entry<Node, Double> data: pq.entrySet()){
            if(!data.getKey().isVisited()){
                if(minDistance == 0.0){
                    minDistance = data.getValue();
                    minNode = data.getKey();
                }
                if(data.getValue() < minDistance){
                    minDistance = data.getValue();
                    minNode = data.getKey();
                }
            }
        }
        return minNode;
    }

    public void getPath(String finish){

        while(!visited.isEmpty()){
            Node current = visited.get(visited.size()-1);
            if(current.hasNeighbor()){
                HashMap<Node, Double> neighbor = current.getNeighbor();
                for(Map.Entry<Node, Double> n : neighbor.entrySet()){
                    if(n.getKey().getNode().equals(finish)){
                        totalPath.add(current.getNode());
                        finish = current.getNode();
                    }
                }
            }
            visited.remove(current);
        }
        System.out.println(totalPath);
    }

    public void search(Node start, String finish){

        pq.put(start, 0.0);
        if(mapHeuristic.contains(start) && !start.isVisited()){
            HashMap<Node, Double> neighbor = start.getNeighbor();
            neighbor.forEach((key, value)->{
                if(!key.isVisited())
                    pq.put(key, value);
            });
        }

        start.setVisited(true);
        visited.add(start);
        pq.remove(start);

        if(pq.size() > 0){
            Node minNode = this.getMinNode();
            if(!pq.entrySet().stream().anyMatch(t -> t.getKey().getNode().equals(finish))){
                search(minNode, finish);
            }
            else {
                visited.add(new Node<>(finish, true));
                totalPath.add(finish);
                getPath(finish);
            }
        }
        else
            System.out.println("Tujuan tidak ditemukan dalam daftar");
    }
}
