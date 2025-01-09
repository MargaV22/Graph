import java.util.*;

class Graph {
    private Map<String, List<String>> adjacencyList;
    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String node1, String node2) {
        if (adjacencyList.containsKey(node1) && adjacencyList.containsKey(node2)) {
            adjacencyList.get(node1).add(node2);
            adjacencyList.get(node2).add(node1); 
        } else {
            System.out.println("One or both nodes do not exist.");
        }
    }

    public void displayGraph() {
        for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public boolean hasNode(String node) {
        return adjacencyList.containsKey(node);
    }

    public boolean hasEdge(String node1, String node2) {
        return adjacencyList.containsKey(node1) && adjacencyList.get(node1).contains(node2);
    }
}

public class SimpleGraph {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");

        System.out.println("Graph:");
        graph.displayGraph();

        System.out.println("\nDoes node 'A' exist? " + graph.hasNode("A"));
        System.out.println("Does node 'E' exist? " + graph.hasNode("E"));

        System.out.println("\nDoes an edge between 'A' and 'B' exist? " + graph.hasEdge("A", "B"));
        System.out.println("Does an edge between 'C' and 'D' exist? " + graph.hasEdge("C", "D"));
    }
}
