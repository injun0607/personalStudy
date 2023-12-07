package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준문제 1260번
 * 문제:
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
 * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다
 * 입력:
 * 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
 * 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
 */
public class BFSandDFS1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        st.nextToken();
        String n = st.nextToken();
        String startNode = st.nextToken();

        Dfs dfs = new Dfs();
        Bfs bfs = new Bfs();


        for (int i = 0; i < Integer.valueOf(n); i++) {
            st = new StringTokenizer(br.readLine(), " ");
            Integer node = Integer.valueOf(st.nextToken());
            Integer adjacency = Integer.valueOf(st.nextToken());
            dfs.add(node,adjacency);
            bfs.add(node,adjacency);
        }



        dfs.dfs(Integer.valueOf(startNode));
        System.out.println();
        bfs.bfs(Integer.valueOf(startNode));


        

        

    }

    public static class Dfs{

        //인접 노드리스트
        private Map<Integer, ArrayList<Integer>> adjacencyList = new HashMap<>();

        public void add(int nodeNum, int adjacency) {
            adjacencyList.computeIfAbsent(nodeNum, ad -> new ArrayList<>()).add(adjacency);
            adjacencyList.computeIfAbsent(adjacency, ad -> new ArrayList<>()).add(nodeNum);
        }

        public void dfs(int startNode) {
            Set<Integer> visited = new HashSet<>();
            dfsRecursive(startNode, visited);
            
        }

        private void dfsRecursive(int startNode, Set<Integer> visited) {
            visited.add(startNode);
            System.out.print(startNode+" ");

            ArrayList<Integer> adjacencyNumList = adjacencyList.get(startNode);
            Collections.sort(adjacencyNumList);

            if (adjacencyNumList != null) {
                for (int adjacencyNum : adjacencyNumList) {
                    if (!visited.contains(adjacencyNum)) {
                        dfsRecursive(adjacencyNum,visited);
                    }
                }
            }



        }


    }

    public static class Bfs{
        private Map<Integer, ArrayList<Integer>> adjacencyList = new HashMap<>();

        public void add(int nodeNum, int adjacency) {
            adjacencyList.computeIfAbsent(nodeNum, v -> new ArrayList<>()).add(adjacency);
            adjacencyList.computeIfAbsent(adjacency, v -> new ArrayList<>()).add(nodeNum);
        }

        public void bfs(int startNode) {
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();

            queue.add(startNode);
            
            while (!queue.isEmpty()) {
                Integer node = queue.poll();
                visited.add(node);
                System.out.print(node + " ");

                ArrayList<Integer> integers = adjacencyList.get(node);
                Collections.sort(integers);
                if (integers != null) {
                    for (Integer integer : integers) {
                        if (!visited.contains(integer)) {
                            queue.add(integer);
                            visited.add(integer);
                        }
                    }
                }

                
            }
            
            
        }
        
    }




}
