package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 11779번 문제
 * n(1≤n≤1,000)개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 m(1≤m≤100,000)개의 버스가 있다.
 * 우리는 A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화 시키려고 한다.
 * 그러면 A번째 도시에서 B번째 도시 까지 가는데 드는 최소비용과 경로를 출력하여라. 항상 시작점에서 도착점으로의 경로가 존재한다.
 */
public class MInConst11779 {

    public static final int INF = Integer.MAX_VALUE;

    public static class Node{
        private int nodeNum;
        private int distance;

        public Node(int nodeNum, int distance) {
            this.nodeNum = nodeNum;
            this.distance = distance;
        }

    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st;

        HashMap<Integer, PriorityQueue<Node>> adjacencyMap = new HashMap<>();
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            adjacencyMap.computeIfAbsent(start, v -> new PriorityQueue<>(Comparator.comparingInt(value -> value.distance))).add(new Node(end, distance));

        }

        st = new StringTokenizer(br.readLine(), " ");
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        result(adjacencyMap,length,startNode,endNode);

    }

    public static void result(HashMap<Integer, PriorityQueue<Node>> adjacencyMap, int length, int startNode, int endNode) {


        int[] dist = new int[length];
        HashMap<Integer, ArrayList<Integer>> path = new HashMap<>();


        boolean[] visited = new boolean[length];


        Arrays.fill(dist, INF);


        dist[startNode-1] = 0;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(v -> v.distance));
        priorityQueue.add(new Node(startNode, 0));

        path.put(startNode, new ArrayList<>());

        int preNum = startNode;

        while (!priorityQueue.isEmpty()) {

            int nodeNum = priorityQueue.poll().nodeNum;
            ArrayList<Integer> prePath = path.get(preNum);

            path.computeIfAbsent(nodeNum, val -> new ArrayList<>(prePath)).add(preNum);

            preNum = nodeNum;


            visited[nodeNum-1] = true;
            if (nodeNum == endNode) {
                break;
            }
            PriorityQueue<Node> adjacencyNodeList = adjacencyMap.get(nodeNum);
            if (adjacencyNodeList == null) {
                continue;
            }

            for (Node node : adjacencyNodeList) {
                if (!visited[node.nodeNum-1]) {

                    int newDistance = dist[nodeNum-1] + node.distance;
                    if (newDistance < dist[node.nodeNum-1]) {

                        dist[node.nodeNum - 1] = newDistance;
                        priorityQueue.add(new Node(node.nodeNum, newDistance));

                    }


                }
            }
        }

        ArrayList<Integer> integers = path.get(endNode);
        integers.add(endNode);
        StringBuilder sb = new StringBuilder();

        sb.append(dist[endNode - 1] + "\n");
        sb.append(integers.size() + "\n");
        for (Integer integer : integers) {
            sb.append(integer + " ");
        }
        System.out.println(sb.toString());


    }

}
