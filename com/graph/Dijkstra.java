package com.graph;

import java.util.*;

public class Dijkstra extends SearchAlgorithm{
    HashMap<Node, Double> distances = new HashMap<>();
    HashMap<Node, Node> previous = new HashMap<>();
    ArrayList<Node> totalPath = new ArrayList<>();
    boolean found = false;


    public Dijkstra(ArrayList<Node> graph){
        mapHeuristic = graph;
    }

    private void reconstructPath(Node currentNode, Node start){
        while(!currentNode.equals(start)){
            totalPath.add(currentNode);
            currentNode = previous.get(currentNode);
        }
        totalPath.add(start);
        Collections.reverse(totalPath);

        System.out.println(previous);
        //System.out.println(totalPath);
        for (Node node: totalPath) {
            System.out.println(node.getNode());
        }
    }

    public void search(Node start, Node finish){
        for (Node node:mapHeuristic) {
            distances.put(node, Double.MAX_VALUE);
            previous.put(node, null);
        }
        distances.put(start, 0.0);

        while (!distances.isEmpty() && !found){
            Node minNode = Collections.min(distances.entrySet(), Map.Entry.comparingByValue()).getKey();
            if(minNode.hasNeighbor() && distances.containsKey(minNode)){
                HashMap<Node, Double> neighbor = minNode.getNeighbor();
                for (Map.Entry<Node, Double> n: neighbor.entrySet()) {
                    if(distances.containsKey(n.getKey()) && !visited.contains(n.getKey())){
                        double tempDist = distances.get(minNode) + n.getValue();
                        if(tempDist < distances.get(n.getKey())){
                            distances.put(n.getKey(), tempDist);
                            previous.put(n.getKey(), minNode);
                        }
                    }
                }

                visited.add(minNode);
            }
            if(minNode.equals(finish))
                found = true;

            distances.remove(minNode);
            //System.out.println(visited);
            visited.stream().forEach(System.out::println);
        }
        if(found)
            reconstructPath(finish, start);
        else
            System.out.println("Tujuan tidak ditemukan");
    }


}
