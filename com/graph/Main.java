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
        jakarta.setVisited(false);

        Node surabaya = new Node();
        surabaya.setNode("Surabaya");
        surabaya.setVisited(false);

        Node makassar = new Node();
        makassar.setNode("Makassar");
        makassar.setVisited(false);

        graphHeuristic.addEdge(jakarta, surabaya, 5);
        graphHeuristic.addEdge(jakarta, new Node("Pontianak", false), 4);
        graphHeuristic.addEdge(jakarta, new Node("Padang", false), 3);
        graphHeuristic.addEdge(jakarta, new Node("Medan", false), 4);
        graphHeuristic.addEdge(surabaya, jakarta, 4);
        graphHeuristic.addEdge(surabaya, makassar, 3);
        graphHeuristic.addEdge(surabaya, new Node("Banjarmasin", false), 5);
        graphHeuristic.addEdge(surabaya, new Node("Balikpapan", false), 4);
        graphHeuristic.addEdge(makassar, new Node("Ambon", false), 5);
        graphHeuristic.addEdge(makassar, surabaya, 5);
        graphHeuristic.addEdge(makassar, new Node("Jayapura", false), 3);
        graphHeuristic.addEdge(makassar, new Node("Manado", false), 3);

        graphHeuristic.printAdjacency();
        //BestFirst kota = new BestFirst(graphHeuristic.getMapHeuristic());
        //kota.search(jakarta, "Jayapura");
        //graphHeuristic.bestFirstSearch("Jakarta", "Jayapura");
        Node s = new Node("S", false);
        Node a = new Node("A", false);
        Node b = new Node("B", false);
        Node c = new Node("C", false);
        Node d = new Node("D", false);
        Node e = new Node("E", false);
        Node f = new Node("F", false);
        Node h = new Node("H", false);
        Node j = new Node("J", false);
        Node k = new Node("K", false);
        Node l = new Node("L", false);
        Node m = new Node("M", false);
        Node g =  new Node("G", false);

        graphHeuristicBook.addEdge(s, a, 10);
        graphHeuristicBook.addEdge(s, b, 25);
        graphHeuristicBook.addEdge(s, c, 30);
        graphHeuristicBook.addEdge(s, d, 15);
        graphHeuristicBook.addEdge(s, e, 13);
        graphHeuristicBook.addEdge(a, g, 90);
        graphHeuristicBook.addEdge(a, b, 10);
        graphHeuristicBook.addEdge(b, f, 5);
        graphHeuristicBook.addEdge(b, k, 50);
        graphHeuristicBook.addEdge(c, h, 40);
        graphHeuristicBook.addEdge(d, h, 25);
        graphHeuristicBook.addEdge(d, l, 52);
        graphHeuristicBook.addEdge(e, j, 20);
        graphHeuristicBook.addEdge(e, b, 15);
        graphHeuristicBook.addEdge(f, k, 40);
        graphHeuristicBook.addEdge(h, l, 25);
        graphHeuristicBook.addEdge(j, m, 40);
        graphHeuristicBook.addEdge(k, g, 30);
        graphHeuristicBook.addEdge(l, g, 40);
        graphHeuristicBook.addEdge(m, g, 80);

        //graphHeuristicBook.bestFirstSearch("S", "G");
        //graphHeuristicBook.printAdjacency();
        //graphHeuristicBook.bestFirstSearch("S", "L");
        //graphHeuristicBook.AStar("S", "L", 0);
        BestFirst bestFirst = new BestFirst(graphHeuristicBook.getMapHeuristic());
        bestFirst.search(s, "K");

        Dijkstra dijkstra = new Dijkstra(graphHeuristicBook.getMapHeuristic());
        dijkstra.search(s, k);

    }
}
