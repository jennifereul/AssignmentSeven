import java.util.*;

class QuestionSix {
    // Function to print adjacency matrix with letters and explanations
    static void adjacencyMatrix(char[] vertices, int[][] adj, int V) {
        // Print column headers (letters)
        System.out.print("  ");
        for (char vertex : vertices) {
            System.out.print(vertex + " ");
        }
        System.out.println();

        // Print matrix rows with letters, connections, and explanations
        for (int i = 0; i < V; i++) {
            System.out.print(vertices[i] + " ");
            for (int j = 0; j < V; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }

        // Print explanations for the connections
        System.out.println("\nExplanations:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj[i][j] == 1) {
                    char fromVertex = vertices[i];
                    char toVertex = vertices[j];
                    System.out.println("The cell at row " + fromVertex + " and column " + toVertex +
                            " has '1' because there is an edge between vertex " +
                            fromVertex + " and vertex " + toVertex + ".");
                }
            }
        }
    }

    // Function to initialize the adjacency matrix
    static void initGraph(int V, String[] pairs) {
        // Initialize adjacency matrix with all zeros
        int[][] adj = new int[V][V];

        // Extract vertices
        char[] vertices = new char[V];
        for (int i = 0; i < V; i++) {
            vertices[i] = (char) ('A' + i);
        }

        // Parse the input pairs and create edges
        for (String pair : pairs) {
            // Remove parentheses and split the pair
            pair = pair.replaceAll("[\\(\\)]", "");
            String[] parts = pair.split(",\\s*");

            // Extract vertex and position
            char vertex = parts[0].charAt(0);
            int position = Integer.parseInt(parts[1]);

            // Calculate the positions of connected vertices
            int leftVertex = (V - position) % V;
            int rightVertex = (V + position) % V;

            // Add edges to the adjacency matrix
            adj[vertex - 'A'][leftVertex] = 1;
            adj[vertex - 'A'][rightVertex] = 1;
        }

        // Function Call to print adjacency matrix with letters and explanations
        adjacencyMatrix(vertices, adj, V);
    }

    // Driver Code
    public static void main(String[] args) {
        // Given input pairs
        String[] pairs = {"(I, 2)", "(A, 5)", "(E, 4)", "(F,1)", "(T, 2)", "(S, 3)"};

        // Number of vertices
        int V = 26; // Assuming all uppercase letters as vertices

        // Function Call
        initGraph(V, pairs);
    }
}

