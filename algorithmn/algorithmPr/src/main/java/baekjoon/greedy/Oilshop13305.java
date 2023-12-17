package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 지금 위치에서 최대까지 기름을 채웠을때를 확인
 *
 */
public class Oilshop13305 {
//    public static void main(String[] args) throws IOException {
//
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int cnt = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        ArrayList<Integer> distance = new ArrayList<>();
//        for (int i = 0; i < cnt - 1; i++) {
//            int val = Integer.parseInt(st.nextToken());
//            distance.add(val);
//        }
//
//        long[] prefixSum = new long[cnt];
//        for (int i = 0; i < distance.size(); i++) {
//            prefixSum[i + 1] = prefixSum[i] + distance.get(i);
//        }
//
//        ArrayList<Integer> cost = new ArrayList<>();
//        st = new StringTokenizer(br.readLine(), " ");
//        for (int i = 0; i < cnt - 1; i++) {
//            int val = Integer.parseInt(st.nextToken());
//            cost.add(val);
//        }
//        long[] totalCosts = new long[cnt];
//
//        long result = 0;
//        for (int i = 0; i < cnt-1; i++) {
//            long tempResult = 0;
//            //현재위치부터 마지막위치까지 남은 코스트
//            tempResult = cost.get(i) * (prefixSum[cnt - 1] - prefixSum[i]) + totalCosts[i];
//            //다음순위의 누적코스트;
//
//            totalCosts[i + 1] = cost.get(i) * distance.get(i) + totalCosts[i];
//            if (i == 0) {
//                result = tempResult;
//            }
//            if (result > tempResult) {
//                result = tempResult;
//            }
//        }
//
//        System.out.printf("%.0f\n", result);
//
//    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long[] dis = new long[cnt-1];
        for (int i = 0; i < cnt-1; i++) {
            int val = Integer.parseInt(st.nextToken());
            dis[i] = val;
        }

        long[] cost = new long[cnt];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < cnt; i++) {
            int val = Integer.parseInt(st.nextToken());
            cost[i] = val;
        }

        long sum = 0;
        long minCost = cost[0];

        for (int i = 0; i < cnt-1; i++) {
            if (cost[i] < minCost) {
                minCost = cost[i];
            }

            sum += minCost * dis[i];

        }

        System.out.print(sum);

    }
}
