package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Homework13904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] tables = new int[cnt][2];
        Set<Integer> end_cnt = new HashSet<>();


        //과제의 제일 마지막 마감일
        int max_day = 1;

        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int end = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            end_cnt.add(end);
            tables[i][0] = end;
            tables[i][1] = val;

            //max_day 세팅
            if (max_day < end) {
                max_day = end;
            }
        }

        //마감일을 배정할 배열생성
        int[] check = new int[max_day+1];
        //배정이 안된곳은 0
        Arrays.fill(check, 0);



        //value순으로 정렬
        Arrays.sort(tables, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        //점수들을 순회하면서
        for (int i = 0; i < cnt; i++) {
            int end = tables[i][0];
            int val = tables[i][1];
            for (int j = end; j > 0; j--) {
                //배정할 수 있는 마감일을 찾는다.
                if (check[j] == 0) {
                    check[j] = val;
                    break;
                }
            }
        }

        System.out.println(Arrays.stream(check).sum());



    }

}
