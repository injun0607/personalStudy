package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Classroom11000 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        int[][] timeTable = new int[cnt][2];

        StringTokenizer st;
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            timeTable[i][0] = start;
            timeTable[i][1] = end;
        }

        //시작시간으로 정렬
        Arrays.sort(timeTable, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> endTimes = new PriorityQueue<>();



        endTimes.add(timeTable[0][1]);
        for (int i = 1; i < cnt; i++) {
            Integer pre_end = endTimes.poll();
            //지금 시작시간이 이전 끝나는시간보다 같거나 크다면 시작 할 수 있다.
            if (pre_end <= timeTable[i][0]) {
                endTimes.add(timeTable[i][1]);
            }else{
                //안끝났다면 다시 넣고
                endTimes.add(pre_end);
                endTimes.add(timeTable[i][1]);
            }
        }

        System.out.println(endTimes.size());

    }
}
