package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 1753
 * 방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오. 단, 모든 간선의 가중치는 10 이하의 자연수이다.
 */
public class MinPath1753 {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int length = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());

        //연결관계 그래프
        HashMap<Integer, PriorityQueue<Node>> adjacencyMap = new HashMap<Integer, PriorityQueue<Node>>();

        Integer startNode = Integer.valueOf(br.readLine());

        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int node = Integer.parseInt(st.nextToken());
            int adjacency = Integer.parseInt(st.nextToken());
            int distance =  Integer.parseInt(st.nextToken());

            //연결관계 삽입
            adjacencyMap.computeIfAbsent(node, v -> new PriorityQueue<>(Comparator.comparingInt(value->value.distance))).add(new Node(adjacency,distance));

        }



        result(adjacencyMap,startNode,length);



    }


    public static void result(Map<Integer, PriorityQueue<Node>> adjacencyMap, int startNode, int length) {

        //최소거리들
        int[] dist = new int[length];
        //방문체크
        boolean[] visited = new boolean[length];

        //시작지점 빼고 INF 로초기화
        Arrays.fill(dist, INF);
        //node 번호와 배열index는 1차이나기때문에 -1
        dist[startNode-1] = 0;

        //연결관계의 거리탐색을 위한 우선순위큐
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(v-> v.distance));
        //우선순위큐 시작지점 거리 0으로 초기화
        priorityQueue.add(new Node(startNode, 0));

        //우선순위큐가 있는 한 게속반복
        while (!priorityQueue.isEmpty()) {
            int nodeNum = priorityQueue.poll().nodeNum;

            //해당 노드에 연결된 모든 노드들을 가져온다
            PriorityQueue<Node> nodeList = adjacencyMap.get(nodeNum);
            if (nodeList==null) {
                continue;
            }

            //연결된 노드들을 순회하면서 노드까지의 거리를 구한다.
            for (Node node : nodeList) {
                if(!visited[node.nodeNum-1]){
                    int newDistance = dist[nodeNum-1] + node.distance;
                    if (newDistance < dist[node.nodeNum-1]) {
                        dist[node.nodeNum-1] = newDistance;
                        priorityQueue.add(new Node(node.nodeNum, newDistance));
                    }


                }
            }


        }

        StringBuilder sb = new StringBuilder();
        for (int d : dist) {
            if(d == INF){
                sb.append("INF" + "\n");
            }else{
                sb.append(d +"\n");
            }

        }
        System.out.println(sb.toString());

    }
    public static class Node{
        private int nodeNum;
        private int distance;

        Node(int nodeNum, int distance) {
            this.nodeNum = nodeNum;
            this.distance = distance;
        }


    }
}
