package testReady;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;


public class UtilTest2 {

    public static void main(String[] args) {










    }

    public int result(int start ,int cnt,int end , Map<Integer,PriorityQueue<Node>> graph){

        int INF = Integer.MAX_VALUE;
        int[] dist = new int[cnt];

        boolean[] visited = new boolean[cnt];

        Arrays.fill(dist,INF);
        PriorityQueue<Node> pq = new PriorityQueue<Node>(Comparator.comparing(node->node.dist));

        dist[start-1] = 0;

        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int curNodeNum = curNode.num;
            visited[curNodeNum -1] = true;

            if(graph.get(curNodeNum) == null){
                continue;
            }

            PriorityQueue<Node> nodeLinkList = graph.get(curNodeNum);

            for(Node nextNode : nodeLinkList){
                int nextNodeNum = nextNode.num;
                if(!visited[nextNodeNum-1]){
                    int nextDist = dist[curNodeNum-1] + nextNode.dist;
                    //작으면?
                    if(nextDist < dist[nextNodeNum -1]){
                        dist[nextNodeNum -1] = nextDist;
                        pq.add(new Node(nextNodeNum,nextDist));
                    }

                }
            }



        }


        return dist[end-1];
    }





    public static class Node{
        int num;
        int dist;

        public Node(int num , int dist){
            this.num = num;
            this.dist = dist;
        }
    }

}
