package DSA.Graph;


import java.util.*;

public class Graph {
    Map<Integer, LinkedList<Integer>> graph = new HashMap<>();

    private void add(int value) {
        graph.put(value, new LinkedList<>());
    }

    public void insert(int vertex, int edge) {
        if (!graph.containsKey(vertex)) {
            add(vertex);
        }
        if (!graph.containsKey(edge)) {
            add(edge);
        }
        graph.get(vertex).add(edge);
        graph.get(edge).add(vertex);

    }


    public void remove(int key) {

        if (graph.containsKey(key)) {
            LinkedList<Integer> edges = graph.get(key);

            for (Integer edge : edges) {
                graph.get(edge).remove(Integer.valueOf(key));
            }

            graph.remove(key);
        }
    }

    public LinkedList<Integer> bfs(int startVertex) {

        LinkedList<Integer> res = new LinkedList<>();

        if (!graph.containsKey(startVertex)) {
            return res;
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentIndex = queue.poll();

            if (!visited.contains(currentIndex)) {
                visited.add(currentIndex);
                res.add(currentIndex);

                LinkedList<Integer> neighbours = graph.get(currentIndex);
                for (Integer neighbour : neighbours) {
                    if (!visited.contains(neighbour)) {
                        queue.add(neighbour);
                    }
                }
            }
        }
        return res;
    }
    public List<Integer> dfs(int startVertex) {

        List<Integer> res = new ArrayList<>();

        if (!graph.containsKey(startVertex)) {
            return res;
        }
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int currentIndex = stack.pop();

            if (!visited.contains(currentIndex)) {
                res.add(currentIndex);
                visited.add(currentIndex);

                for (Integer neighbour : graph.get(currentIndex)) {
                    if (!visited.contains(neighbour)) {
                        stack.add(neighbour);
                    }
                }
            }
        }
        return res;
    }

    public void display() {
        for (Integer vertex : graph.keySet()) {
            System.out.print(vertex + " : ");
            for (Integer value : graph.get(vertex)) {
                System.out.print(value + " -> ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();


        graph.insert(10, 3);
        graph.insert(2, 19);
        graph.insert(19, 3);
        graph.insert(1, 12);
        graph.insert(12, 3);

        graph.display();

        System.out.println();
        System.out.println("DFS");
        System.out.println(graph.dfs(1));
        System.out.println("BFS");
        System.out.println(graph.bfs(1));
    }
}
