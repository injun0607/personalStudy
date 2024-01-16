package algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class dijkstraPr {
    private int INF = Integer.MAX_VALUE;

    public void dijkstra(int[][]graph , int start) {
        int vertex = graph.length;
        int[] dist = new int[vertex];
        boolean[] visited = new boolean[vertex];

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));
        priorityQueue.add(new Node(start, 0));

        while (!priorityQueue.isEmpty()) {

            int currencyNode = priorityQueue.poll().vertex;
            visited[currencyNode] = true;

            for (int v = 0; v < vertex; v++) {
                if (!visited[v] && graph[currencyNode][v] != INF) {
                    int newdis = dist[currencyNode] + graph[currencyNode][v];
                    if (newdis < dist[v]) {
                        dist[v] = newdis;
                        priorityQueue.add(new Node(v, newdis));
                    }



                }


            }


        }



    }

    public static class Node{
        private int vertex;
        private int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }


    }

}
