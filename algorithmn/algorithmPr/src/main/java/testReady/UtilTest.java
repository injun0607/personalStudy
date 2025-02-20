package testReady;

import java.util.*;


public class UtilTest {

    public static void main(String[] args) {


        Map<Integer,PriorityQueue<Node>> graph = new HashMap<>();




    }

    public int result(int start,int end,int nodeCnt ,Map<Integer,PriorityQueue<Node>> graph){
        int INF = Integer.MAX_VALUE;

        int[] dist = new int[nodeCnt];
        boolean[] visited = new boolean[nodeCnt];

        Arrays.fill(dist,INF);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(n->n.dist));
        dist[start -1] = 0;
        pq.add(new Node(0, start));


        while(!pq.isEmpty()){
            Node node = pq.poll();
            visited[node.nodeNum - 1]= true;

            if(graph.get(node.nodeNum) == null){
                continue;
            };

            PriorityQueue<Node> neighborQ = graph.get(node.nodeNum);

            //순회하면서 확인
            for(Node n: neighborQ){
                if(!visited[n.nodeNum -1]){
                    //현재 위치 값 구하기
                    //현재 최소 위치 + 다음 노드의 값
                    int newDist = dist[node.nodeNum-1] + n.dist;
                    if(dist[n.nodeNum-1] > newDist){
                        dist[n.nodeNum -1 ] = newDist;
                        pq.add(new Node(n.nodeNum, newDist));
                    }
                }
            }

        }

        return dist[end-1];
    }


    public static class Node{
        int dist;
        int nodeNum;

        public Node(int dist, int nodeNum){
            this.dist = dist;
            this.nodeNum = nodeNum;
        }


    }

}
