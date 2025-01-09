import java.util.*;

class Graph {
    private Map<String, List<String>> adjacencyList;
    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(String vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(String vertex1, String vertex2) {
        if (!adjacencyList.containsKey(vertex1) || !adjacencyList.containsKey(vertex2)) {
            System.out.println("One or both vertices do not exist.");
            return;
        }
        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
    }

    public void dfs(String startVertex) {
        Set<String> visited = new HashSet<>();
        System.out.println("DFS Traversal:");
        dfsRecursive(startVertex, visited);
        System.out.println();
    }

    private void dfsRecursive(String vertex, Set<String> visited) {
        if (!visited.contains(vertex)) {
            System.out.print(vertex + " ");
            visited.add(vertex);

            for (String neighbor : adjacencyList.get(vertex)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    public void bfs(String startVertex) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        System.out.println("BFS Traversal:");
        
        queue.add(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            for (String neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void displayGraph() {
        System.out.println("Graph:");
        for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}

public class SimpleGraph {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");

        graph.dfs("A");
        graph.bfs("A");
    }
}
