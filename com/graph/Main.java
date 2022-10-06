package com.graph;

import java.util.*;

public class Main {
    static HashMap<Integer, Edge> graph;

    public static void main(String[] args) {
	// write your code here
        Graph<Integer> graphObj = new Graph<>();
        GraphHeuristic<Integer> graphHeuristic = new GraphHeuristic<>();
        GraphHeuristic<Integer> graphHeuristicBook = new GraphHeuristic<>();
        /*graphObj.addEdge(1, 2);
        graphObj.addEdge(1, 3);
        graphObj.addEdge(2, 3);
        graphObj.addEdge(2, 5);
        graphObj.addEdge(3, 4);
        graphObj.addEdge(3, 5);
        graphObj.addEdge(4, 5);
        graphObj.addEdge(4, 6);
        graphObj.addEdge(5, 6);
*/
        graphObj.addEdge(0, 1);
        graphObj.addEdge(0, 2);
        graphObj.addEdge(0, 3);
        graphObj.addEdge(1, 2);
        graphObj.addEdge(2, 4);

        graphObj.printAdjacency();
        System.out.println("Pencarian dengan BFS :");
        graphObj.bfs(0, new ArrayDeque<>(), new ArrayList<>());
        System.out.println("Pencarian dengan DFS :");
        graphObj.dfs(0,  new Stack<>(), new ArrayList<>());

        graphHeuristic.addEdge("Jakarta", "Surabaya", 5);
        graphHeuristic.addEdge("Jakarta", "Pontianak", 4);
        graphHeuristic.addEdge("Jakarta", "Padang", 3);
        graphHeuristic.addEdge("Jakarta", "Medan", 4);
        graphHeuristic.addEdge("Surabaya", "Jakarta", 4);
        graphHeuristic.addEdge("Surabaya", "Makassar", 3);
        graphHeuristic.addEdge("Surabaya", "Banjarmasin", 5);
        graphHeuristic.addEdge("Surabaya", "Balikpapan", 4);
        graphHeuristic.addEdge("Makassar", "Ambon", 5);
        graphHeuristic.addEdge("Makassar", "Surabaya", 5);
        graphHeuristic.addEdge("Makassar", "Jayapura", 3);
        graphHeuristic.addEdge("Makassar", "Manado", 3);

        //graphHeuristic.printAdjacency();
        //graphHeuristic.bestFirstSearch("Jakarta", "Jayapura");

        graphHeuristicBook.addEdge("S", "A", 10);
        graphHeuristicBook.addEdge("S", "B", 25);
        graphHeuristicBook.addEdge("S", "C", 30);
        graphHeuristicBook.addEdge("S", "D", 15);
        graphHeuristicBook.addEdge("S", "E", 13);
        graphHeuristicBook.addEdge("A", "G", 90);
        graphHeuristicBook.addEdge("A", "B", 10);
        graphHeuristicBook.addEdge("B", "F", 5);
        graphHeuristicBook.addEdge("B", "K", 50);
        graphHeuristicBook.addEdge("C", "H", 40);
        graphHeuristicBook.addEdge("D", "H", 25);
        graphHeuristicBook.addEdge("D", "L", 52);
        graphHeuristicBook.addEdge("E", "J", 20);
        graphHeuristicBook.addEdge("E", "B", 15);
        graphHeuristicBook.addEdge("F", "K", 40);
        graphHeuristicBook.addEdge("H", "L", 25);
        graphHeuristicBook.addEdge("J", "M", 40);
        graphHeuristicBook.addEdge("K", "G", 30);
        graphHeuristicBook.addEdge("L", "G", 40);
        graphHeuristicBook.addEdge("M", "G", 80);

        //graphHeuristicBook.bestFirstSearch("S", "G");
        //graphHeuristicBook.printAdjacency();
        //graphHeuristicBook.bestFirstSearch("S", "L");
        //graphHeuristicBook.AStar("S", "L", 0);
        BestFirst bestFirst = new BestFirst(graphHeuristicBook.getMapHeuristic());
        bestFirst.search("S", "L");

        Dijkstra dijkstra = new Dijkstra(graphHeuristicBook.getMapHeuristic());
        dijkstra.search("S", "L");

    }
}
