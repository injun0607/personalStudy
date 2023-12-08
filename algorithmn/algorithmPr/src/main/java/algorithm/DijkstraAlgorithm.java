package algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 다익스트라 알고리즘
 * 접근 아이디어
 * 1. 시작 지점에서부터 도착지점까지 가장 빠른 수단을 찾는 알고리즘이다
 * 2. 우선 노드를 생성하라. 해당 노드에는 노드의 번호와 시작지점의 거리가 담겨있다.
 * 3. 연결정보가 담긴 그래프가 있고 , 시작지점 부터 도착지점까지의 최단거리를 저장할 배열을 생성
 * 4. 방문정보를 저장할 배열을 생성
 * 5. 최단거리 배열(dist)에는 아주 큰수로 초기화를 한다.
 * 6. 우선순위큐를 생성(가장가까운 노드가 기준으로 생성)
 * 7. 우선순위큐가 비어있지 않다면 해당 노드와 연결된 노드들을 순회하면서 거리를 측정한다. 우선순위 큐가 존재한다는건 연결된 노드들이 있다는 뜻이다.
 * 8. 거리를 측정한다음 짧다면 dist를 업데이트 해주고 해당노드를 우선순위큐에 넣어준다.
 */

public class DijkstraAlgorithm {
    private static final int INF = Integer.MAX_VALUE;

    public static void dijkstra(int[][] graph, int start) {
        //세로까지의 거리를 구하고(즉목적지의 y축)
        int vertices = graph.length;
        //해당 y축까지의 최소값을 담을 배열
        int[] dist = new int[vertices];
        //y축까지 갈때 해당 y축을 방문했는지 안했는지
        boolean[] visited = new boolean[vertices];

        //dist => y축까지의 값들을 무한으로 초기화
        Arrays.fill(dist, INF);
        //dis => 시작지점은 0
        dist[start] = 0;


        //우선순위큐 생성 기준은 노드까지의 거리를 기준
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        //우선순위 큐에 시작노드를 초기화(시작노드 생성 거리는 0)
        priorityQueue.add(new Node(start, 0));

        //우선순위큐가 비어있지 않다면 반복
        while (!priorityQueue.isEmpty()) {
            //우선순위큐에서 맨우선순위를 뽑고 해당 노드의번호(vertex)를 가져온다;
            int u = priorityQueue.poll().vertex;

            //방문목록에 해당노드의 번호(vertex)업데이트
            visited[u] = true;

            //y축까지의 거리 까지 반복
            for (int v = 0; v < vertices; v++) {
                //만약 해당노드가 방문하지않은 상태고 갈수있는 상태라면(연결되어있다면)
                if (!visited[v] && graph[u][v] != INF) {
                    //새로운 거리 측정 => 현재 최단거리 + 해당노드까지의 거리
                    int newDistance = dist[u] + graph[u][v];

                    //만약 새로운 거리가 최단거리보다 짧다면 추가
                    if (newDistance < dist[v]) {
                        //최단거리를 새로운거리로 갱신
                        dist[v] = newDistance;
                        //우선순위 큐에 넣는다.
                        priorityQueue.add(new Node(v, newDistance));
                    }
                }
            }
        }

        // 출력
        System.out.println("최단 경로 결과:");
        for (int i = 0; i < vertices; i++) {
            System.out.println("노드 " + i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) {
        // 예제 그래프
        int[][] graph = {
                {0, 4, INF, INF, INF, INF, INF, 8, INF},
                {4, 0, 8, INF, INF, INF, INF, 11, INF},
                {INF, 8, 0, 7, INF, 4, INF, INF, 2},
                {INF, INF, 7, 0, 9, 14, INF, INF, INF},
                {INF, INF, INF, 9, 0, 10, INF, INF, INF},
                {INF, INF, 4, 14, 10, 0, 2, INF, INF},
                {INF, INF, INF, INF, INF, 2, 0, 1, 6},
                {8, 11, INF, INF, INF, INF, 1, 0, 7},
                {INF, INF, 2, INF, INF, INF, 6, 7, 0}
        };

        int startNode = 0; // 시작 노드 설정
        dijkstra(graph, startNode);
    }

    static class Node {
        int vertex;
        int distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}
