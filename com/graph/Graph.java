package com.graph;

import java.util.*;

public class Graph<T> {
    public HashMap<T, List<T>> map = new HashMap<>();

    //public ArrayDeque<T> vertexQueue = new ArrayDeque<>();
    //private ArrayList<T> visitedVertex = new ArrayList<>();

    private void addVertex(T s){
        map.put(s, new LinkedList<>());
    }

    public void addEdge(T source, T destination) {
        if(!map.containsKey(source)){
           addVertex(source);
        }
        if(!map.containsKey(destination)){
            addVertex(destination);
        }
        if(!map.get(source).contains(destination)) {
            map.get(source).add(destination);
        }
    }

    private void countVertices(){
        System.out.println("Number of vertices : " +  map.size());
    }

    private void countEdges(){
        int count = 0;
        for(T v : map.keySet()){
            count+= map.get(v).size();
        }
        System.out.println("Number of edges : " +  count);
    }

    public void printAdjacency(){
        map.forEach((key, value) -> {
            System.out.print(key + " : ");
            for (T edge: value) {
                System.out.print(edge + " ");
            }
            System.out.print("\n");
        });
        countVertices();
        countEdges();
    }

    public void bfs(T startPoint, ArrayDeque<T> vertexQueue, ArrayList<T> visitedVertex){
        if(!visitedVertex.contains(startPoint)) {
            visitedVertex.add(startPoint);
        }
        List<T> data = map.get(startPoint);
        for (T u : data) {
            if (!vertexQueue.contains(u) && !visitedVertex.contains(u)) {
                vertexQueue.add(u);
            }
            /*if(u == destinationPoint){
                System.out.println("ketemu di vertex : " + vertexQueue.getFirst());
                vertexQueue.clear();
                visitedVertex.clear();
                return;
            }*/
        }
        System.out.println(visitedVertex);

        if(vertexQueue.size() > 0 ) {
            T first  = vertexQueue.getFirst();
            vertexQueue.removeFirst();
            bfs(first, vertexQueue, visitedVertex);
        }

    }

    public void dfs(T startingPoint,  Stack<T> stackQueue, ArrayList<T> visitedVertex){
        if(!visitedVertex.contains(startingPoint)) {
            visitedVertex.add(startingPoint);
        }

        List<T> data = map.get(startingPoint);
        for (T u : data) {
            if(!visitedVertex.contains(u) && !stackQueue.contains(u)){
                stackQueue.push(u);
            }
        }

        if(!visitedVertex.contains(stackQueue.peek()))
            visitedVertex.add(stackQueue.peek());

        System.out.println(visitedVertex);
        stackQueue.pop();
        if(stackQueue.size() > 0 ) {

            dfs(stackQueue.peek(), stackQueue, visitedVertex);
        }
    }

}
