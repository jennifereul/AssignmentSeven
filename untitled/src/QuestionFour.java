import java.util.*;

public class QuestionFour {

    static class Edge {
        char dest;
        int weight;

        Edge(char dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Task 1: Determine if a matrix represents a directed graph
    public static boolean isDirectedGraph(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return true; // If not symmetric, it's a directed graph
                }
            }
        }
        return false;
    }

    // Task 2: Find every path of length 5 between two vertices
    public static void findPaths(Map<Character, List<Edge>> graph, char u, char w, List<Character> path, int length) {
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
            if (!path.contains(v)) {
                findPaths(graph, v, w, new ArrayList<>(path), length);
            }
        }
    }

    public static void main(String[] args) {
        // Example usage:

        // Task 1: Determine if a matrix represents a directed graph
        int[][] matrix1 = {{0, 1, 0},
                {0, 0, 1},
                {0, 0, 0}};
        System.out.println("Matrix represents a directed graph: " + isDirectedGraph(matrix1));

        int[][] matrix2 = {{0, 1, 0},
                {1, 0, 1},
                {0, 1, 0}};
        System.out.println("Matrix represents a directed graph: " + isDirectedGraph(matrix2));

        // Task 2: Find every path of length 5 between two vertices
        Map<Character, List<Edge>> graph = new HashMap<>();
        graph.put('A', Arrays.asList(new Edge('B', 1), new Edge('C', 2)));
        graph.put('B', Collections.singletonList(new Edge('C', 3)));
        graph.put('C', Collections.singletonList(new Edge('A', 4)));

        findPaths(graph, 'A', 'C', new ArrayList<>(), 0);
    }
}

