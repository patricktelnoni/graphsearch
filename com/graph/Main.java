package com.graph;

import java.util.*;

public class Main {
    static HashMap<Integer, Edge> graph;

    public static void main(String[] args) {
	// write your code here
        Graph<Integer> graphObj = new Graph<>();
        GraphHeuristic<Node> graphHeuristic = new GraphHeuristic<>();
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

        Node jakarta = new Node();
        jakarta.setNode("Jakarta");

        Node surabaya = new Node();
        surabaya.setNode("Surabaya");

        Node makassar = new Node();
        makassar.setNode("Makassar");

        graphHeuristic.addEdge(jakarta, "Surabaya", 5);
        graphHeuristic.addEdge(jakarta, "Pontianak" , 4);
        graphHeuristic.addEdge(jakarta, "Padang" , 3);
        graphHeuristic.addEdge(jakarta, "Medan", 4);
        graphHeuristic.addEdge(surabaya, "Jakarta", 4);
        graphHeuristic.addEdge(surabaya, "Makassar", 3);
        graphHeuristic.addEdge(surabaya, "Banjarmasin", 5);
        graphHeuristic.addEdge(surabaya, "Balikpapan",  4);
        graphHeuristic.addEdge(makassar, "Ambon",  5);
        graphHeuristic.addEdge(makassar, "Surabaya", 5);
        graphHeuristic.addEdge(makassar, "Jayapura",  3);
        graphHeuristic.addEdge(makassar, "Manado", 3);

        graphHeuristic.printAdjacency();
        BestFirst kota = new BestFirst(graphHeuristic);
        kota.search("Jakarta", "Jayapura");
        //graphHeuristic.bestFirstSearch("Jakarta", "Jayapura");
        Node s = new Node("S");
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node h = new Node("H");
        Node j = new Node("J");
        Node k = new Node("K");
        Node l = new Node("L");
        Node m = new Node("M");
        Node g = new Node("G");

        graphHeuristicBook.addEdge(s, "A", 10);
        graphHeuristicBook.addEdge(s, "B", 25);
        graphHeuristicBook.addEdge(s, "C", 30);
        graphHeuristicBook.addEdge(s, "D", 15);
        graphHeuristicBook.addEdge(s, "E", 13);
        graphHeuristicBook.addEdge(a, "G", 90);
        graphHeuristicBook.addEdge(a, "B", 10);
        graphHeuristicBook.addEdge(b, "F", 5);
        graphHeuristicBook.addEdge(b, "K", 50);
        graphHeuristicBook.addEdge(c, "H", 40);
        graphHeuristicBook.addEdge(d, "H", 25);
        graphHeuristicBook.addEdge(d, "L", 52);
        graphHeuristicBook.addEdge(e, "J", 20);
        graphHeuristicBook.addEdge(e, "B", 15);
        graphHeuristicBook.addEdge(f, "K", 40);
        graphHeuristicBook.addEdge(h, "L", 25);
        graphHeuristicBook.addEdge(j, "M", 40);
        graphHeuristicBook.addEdge(k, "G", 30);
        graphHeuristicBook.addEdge(l, "G", 40);
        graphHeuristicBook.addEdge(m, "G", 80);

        //graphHeuristicBook.bestFirstSearch("S", "G");
        //graphHeuristicBook.printAdjacency();
        //graphHeuristicBook.bestFirstSearch("S", "L");
        //graphHeuristicBook.AStar("S", "L", 0);
        BestFirst bestFirst = new BestFirst(graphHeuristicBook);
        bestFirst.search("S", "K");

        Dijkstra dijkstra = new Dijkstra(graphHeuristicBook);
        dijkstra.search("S", "K");

    }
}
