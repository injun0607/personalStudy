package algorithm;

import java.util.*;

/**
 * 접근 아이디어 :
 * 1. 해당 노드와 연결된 노드들을 맵으로 표현을한다(value는 연결된 노드들의 arr)
 * 2. 시작노드에서 연결된 노드들을 순차적으로 방문하며
 * 3. 방문한 노드는 기록한다.
 */

public class DFSpractice {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);

        System.out.println("DFS traversal starting from node 1:");
        graph.dfs(1);
    }

    static class Graph {
        private Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        public void addEdge(int source, int destination) {
            adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
            adjacencyList.computeIfAbsent(destination, k -> new ArrayList<>());
        }

        public void dfs(int startNode) {
            Set<Integer> visited = new HashSet<>();
            dfsRecursive(startNode, visited);
        }

        private void dfsRecursive(int currentNode, Set<Integer> visited) {
            visited.add(currentNode);
            System.out.print(currentNode + " ");

            List<Integer> neighbors = adjacencyList.get(currentNode);
            if (neighbors != null) {
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        dfsRecursive(neighbor, visited);
                    }
                }
            }
        }
    }
}


