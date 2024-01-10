package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class WaterBottle1052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int bottle_cnt = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());


        int result = 0;

        while (true) {
            //물병의 개수
            int bottles = bottle_cnt;
            //현재 물병이 차있는 개수
            int moved = 0;

            //비트연산을 수행하면서 모든 자리수를 검사할때까지 반복
            while (bottles > 0) {
                //비트의 and 연산, 1과 비트 and 연산을 진행하니, bottles의 마지막 자리와 비교해서 1이면 moved++
                if ((bottles & 1) == 1) {
                    moved++;
                }
                //비트를 오른쪽으로 이동시켜 마지막자리 변환(다음 비트 검사준비)
                bottles >>= 1;
            }

            //물병이 차있는 개수가 움직일수 있는 수보다 작다면 이동
            if (moved <= min) {
                break;
            }

            //만약 물병이 더 많이 차있다면 물 +1 추가로 다시 비트검사 수행
            bottle_cnt++;
            //결과값도 추가
            result++;
        }

        System.out.println(result);







    }
}
