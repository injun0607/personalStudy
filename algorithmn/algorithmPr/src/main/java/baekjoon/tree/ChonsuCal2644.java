package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 2644번 문제 : 촌수계산
 * 문제 : 우리 나라는 가족 혹은 친척들 사이의 관계를 촌수라는 단위로 표현하는 독특한 문화를 가지고 있다.
 * 이러한 촌수는 다음과 같은 방식으로 계산된다. 기본적으로 부모와 자식 사이를 1촌으로 정의하고 이로부터 사람들 간의 촌수를 계산한다.
 * 예를 들면 나와 아버지, 아버지와 할아버지는 각각 1촌으로 나와 할아버지는 2촌이 되고, 아버지 형제들과 할아버지는 1촌, 나와 아버지 형제들과는 3촌이 된다.
 *
 * 여러 사람들에 대한 부모 자식들 간의 관계가 주어졌을 때, 주어진 두 사람의 촌수를 계산하는 프로그램을 작성하시오.
 */

public class ChonsuCal2644 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nodeCnt = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Dfs dfs = new Dfs(start, end);

        int n = Integer.valueOf(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startNode = Integer.parseInt(st.nextToken());
            int adjacency = Integer.parseInt(st.nextToken());
            dfs.add(startNode, adjacency);

        }
        dfs.dfs();
        System.out.println(dfs.cnt);

    }

    public static class Dfs{
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        private int start = 0;
        private int end = 0;
        private int cnt = -1;


        public Dfs(int start, int end) {
            this.start = start;
            this.end = end;

        }
        public void add(int nodeNum, int adjacency) {
            graph.computeIfAbsent(nodeNum, v -> new ArrayList<>()).add(adjacency);
            graph.computeIfAbsent(adjacency, v -> new ArrayList<>()).add(nodeNum);

        }

        public void dfs() {
            HashSet<Integer> visited = new HashSet<>();
            if (graph.get(this.start) == null) {
                graph.put(this.start, new ArrayList<>());
            }
            int startCnt = -1;
            recursiveDfs(this.start, visited,startCnt);
        }

        private void recursiveDfs(int node, HashSet<Integer> visited,int startCnt) {
            int tempCnt = startCnt;
            visited.add(node);
            tempCnt++;

            if (node == end) {
                cnt = tempCnt;
                return;
            }


            ArrayList<Integer> neighbors = graph.get(node);
            if (!neighbors.isEmpty()) {
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        recursiveDfs(neighbor, visited,tempCnt);
                    }
                }
            }

        }


    }
}
