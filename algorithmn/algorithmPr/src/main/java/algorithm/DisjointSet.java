package algorithm;

public class DisjointSet {
    private int[] parent;  // 부모 노드를 저장하는 배열
    private int[] rank;    // 각 트리의 높이(순위)를 저장하는 배열

    // 생성자: n개의 원소에 대한 분리 집합을 초기화
    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // 초기에 각 원소는 자기 자신을 부모로 설정
            rank[i] = 0;   // 초기 순위는 0
        }
    }

    // 찾기(Find) 연산: 원소 x의 루트 노드를 찾는다.
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // 경로 압축
        }
        return parent[x];
    }

    // 합집합(Union) 연산: 두 원소 x, y를 포함하는 두 집합을 합친다.
    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);


        if (xRoot != yRoot) {
            // 순위를 비교하여 낮은 순위의 트리를 높은 순위의 트리 아래에 연결
            if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else if (rank[yRoot] < rank[xRoot]) {
                parent[yRoot] = xRoot;
            } else {
                // 순위가 같은 경우, 하나를 선택하고 순위를 증가
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }
        }
    }

    // 같은 집합에 속하는지 확인하는 메소드
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(10);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);

        System.out.println("1과 3은 같은 집합인가? " + ds.isConnected(1, 3)); // true
        System.out.println("1과 4는 같은 집합인가? " + ds.isConnected(1, 4)); // false

        ds.union(3, 4);

        System.out.println("1과 4는 이제 같은 집합인가? " + ds.isConnected(1, 4)); // true
    }

}
