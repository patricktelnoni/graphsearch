package com.graph;

import java.util.*;

public class Dijkstra extends SearchAlgorithm{
    HashMap<String, Double> distances = new HashMap<>();
    HashMap<String, String> previous = new HashMap<>();
    ArrayList<String> totalPath = new ArrayList<>();
    boolean found = false;


    public Dijkstra(GraphHeuristic graph){
        mapHeuristic = graph;
    }

    private void reconstructPath(String currentNode, String start){
        while(!currentNode.equals(start)){
            totalPath.add(currentNode);
            currentNode = previous.get(currentNode);
        }
        totalPath.add(start);
        Collections.reverse(totalPath);

        System.out.println(previous);
        //System.out.println(totalPath);
        for (String node: totalPath) {
            System.out.print(node);
        }
    }

    public void search(String start, String finish){
        ArrayList<Node> nodeList = mapHeuristic.getMapHeuristic();

        for (Node node: nodeList) {
            distances.put(node.getNode(), Double.MAX_VALUE);
            previous.put(node.getNode(), null);
        }
        distances.put(start, 0.0);

        while (!distances.isEmpty() && !found){
            String minNode = Collections.min(distances.entrySet(), Map.Entry.comparingByValue()).getKey();

            if(minNode.equals(finish))
                found = true;

            if(mapHeuristic.containNode(minNode) && distances.containsKey(minNode)){
                HashMap<String, Double> neighbor = mapHeuristic.getNeighborByNode(minNode).getNeighbor();

                for (Map.Entry<String, Double> n: neighbor.entrySet()) {
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


            distances.remove(minNode);
            //System.out.println(visited);
            //visited.stream().forEach(System.out::println);
        }
        if(found)
            reconstructPath(finish, start);
        else
            System.out.println("Tujuan tidak ditemukan");
    }


}
