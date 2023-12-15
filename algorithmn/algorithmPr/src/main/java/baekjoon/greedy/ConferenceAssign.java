package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ConferenceAssign {

    public static int CNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] timeTable = new int[cnt][2];

        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            timeTable[i][0] = startTime;
            timeTable[i][1] = endTime;

        }

        Arrays.sort(timeTable,new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });

        int result = 0;
        int prevEndtime = 0;

        for (int i = 0; i < cnt; i++) {
            if (prevEndtime <= timeTable[i][0]) {
                result++;
                prevEndtime = timeTable[i][1];
            }

        }

        System.out.println(result);



    }




}
