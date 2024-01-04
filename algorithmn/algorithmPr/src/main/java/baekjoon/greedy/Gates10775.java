package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 사람이라면 먼저 몇번 비행기가 오는지 확인하고 그 이하의 비행기중 가장 가까운 비행기게이트에 넣겠다.
 *
 */

public class Gates10775 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int gatesNums = Integer.parseInt(br.readLine());
        int planesNum = Integer.parseInt(br.readLine());

        boolean[] gates = new boolean[gatesNums];
        Arrays.fill(gates,true);

        DisjointSet ds = new DisjointSet(gatesNums);

        int result = 0;
        //이 비행기중 한개라도 못들어가면 폐쇄
        for (int i = 0; i < planesNum; i++) {
            int plane = Integer.parseInt(br.readLine());
            //이 루프가 끝난다는건 공항페쇄

            if (ds.find(plane) >= 0) {
                result++;
            }else{
                break;
            }

        }

        System.out.println(result);



    }

    public static class DisjointSet{
        private int[] parent;
        private boolean[] gate;

        DisjointSet(int n){
            parent = new int[n];
            gate = new boolean[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                gate[i] = true;
            }
        }

        public int find(int n) {

            //게이트에 도킹이 불가능한 상황
            if (n < 1) {
                return -1;
            }

            //비행기가 가야할 번호
            int go = parent[n - 1];

            //게이트에 도킹이 불가능한 상황
            if (go < 0) {
                return -1;
            }


            if (gate[go]) {
                //만약 게이트에 도킹이 가능한 상태라면 도킹후 폐쇄
                gate[go] = false;
                //다음 게이트 번호를 -1
                parent[n - 1] = go - 1;
                return go;
            }else{
                //도킹이 불가능한 상태라면 게이트를 내려가면서 탐색
                return parent[n - 1] = find(go);
            }
        }

    }
}
