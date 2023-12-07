package algorithm;

import java.util.*;

/**
 * 접근 아이디어:
 * 1. 연결된 노드들을 맵으로 만든다
 * 2. 다음 계층의 시작값을 queue에 담는다.
 * 3. 연결된 같은계층부터 탐색을 시작한다.
 */

public class BFSpractice {
    class Graph {
        private Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        public void addEdge(int source, int destination) {
            adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
            adjacencyList.computeIfAbsent(destination, k -> new ArrayList<>());
        }

        public void bfs(int startNode) {
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            queue.add(startNode);
            visited.add(startNode);

            while (!queue.isEmpty()) {
                int currentNode = queue.poll();
                System.out.print(currentNode + " ");

                List<Integer> neighbors = adjacencyList.get(currentNode);
                if (neighbors != null) {
                    for (int neighbor : neighbors) {
                        if (!visited.contains(neighbor)) {
                            queue.add(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
            }
        }
    }

}
