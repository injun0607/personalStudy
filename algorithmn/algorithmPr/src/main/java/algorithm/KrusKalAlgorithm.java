package algorithm;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KrusKalAlgorithm {


    // 간선을 나타내는 클래스
    class Edge implements Comparable<Edge> {
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    static class UnionFind {
        private int[] parent, rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            //현재의 노드가 루트노드가 아니라면 재귀함수 호출
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootX] = rootY;
                    rank[rootY]++;
                }
            }
        }
    }

    public static List<Edge> kruskalMST(int vertices, List<Edge> edges) {
        List<Edge> result = new ArrayList<>();

        // 간선을 가중치의 오름차순으로 정렬
        Collections.sort(edges);

        // Union-Find 자료구조 초기화
        UnionFind unionFind = new UnionFind(vertices);

        for (Edge edge : edges) {
            int rootSource = unionFind.find(edge.source);
            int rootDestination = unionFind.find(edge.destination);

            // 사이클을 방지하기 위해 두 정점이 서로 다른 집합에 속해 있다면 간선을 결과에 추가
            if (rootSource != rootDestination) {
                result.add(edge);
                unionFind.union(rootSource, rootDestination);
            }
        }

        return result;
    }

}
