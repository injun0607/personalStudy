package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Virus2606 {
    public static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int num = Integer.parseInt(br.readLine());
        int cnt = Integer.parseInt(br.readLine());

        DFS dfs = new DFS();
        StringTokenizer st;
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int node = Integer.parseInt(st.nextToken());
            int add = Integer.parseInt(st.nextToken());

            dfs.add(node, add);
        }

        dfs.dfs(1);

        System.out.println(result);
        

    }
    
    
    public static class DFS{

        private Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        public void add(int node, int add) {
            adjacencyList.computeIfAbsent(node, v -> new ArrayList<>()).add(add);
            adjacencyList.computeIfAbsent(add, v -> new ArrayList<>()).add(node);
        }

        public void dfs(int startNode) {
            HashSet<Integer> visited = new HashSet<>();
            recursive(startNode, visited);

        }

        private void recursive(int startNode, HashSet<Integer> visited) {
            visited.add(startNode);

            List<Integer> adjacency = adjacencyList.get(startNode);
            if (adjacency != null) {
                for (Integer ad : adjacency) {
                    if (!visited.contains(ad)) {
                        result++;
                        recursive(ad, visited);
                    }
                }
            }


        }


    }


}
