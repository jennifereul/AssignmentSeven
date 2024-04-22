import java.util.*;

public class QuestionFive {

    static class Edge {
        char dest;
        int weight;

        Edge(char dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Method to find all paths of length 5 from u to w
    static void findAllPaths(Map<Character, List<Edge>> graph, char u, char w, List<Character> path, int length) {
        path.add(u);
        length++;

        if (length == 5) {
            if (u == w) {
                System.out.println(path);
            }
            return;
        }

        for (Edge edge : graph.get(u)) {
            char v = edge.dest;
            findAllPaths(graph, v, w, new ArrayList<>(path), length);
        }
    }

    public static void main(String[] args) {
        // Example usage:

        // Create a directed weighted graph
        Map<Character, List<Edge>> graph = new HashMap<>();
        graph.put('A', Arrays.asList(new Edge('B', 1), new Edge('C', 2)));
        graph.put('B', Collections.singletonList(new Edge('C', 3)));
        graph.put('C', Collections.singletonList(new Edge('A', 4)));

        // Define the start and end vertices
        char u = 'A';
        char w = 'C';

        // Find and print all paths from u to w with length 5
        findAllPaths(graph, u, w, new ArrayList<>(), 0);
    }
}

