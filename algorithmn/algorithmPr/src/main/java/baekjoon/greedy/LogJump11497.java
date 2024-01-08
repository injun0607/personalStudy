package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LogJump11497 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int i = 0; i < cnt; i++) {
            int log_cnt = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int[] logList = new int[log_cnt];


            //가운데에는 가장 큰수가 들어가야한다.
            int mid = log_cnt / 2;
            for (int j = 0; j < log_cnt; j++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }

            //양 끝에서부터 작은수를 채워간다.
            //가면 갈수록 큰 수들이 가운데로 몰리게 된다.
            for (int j = 0; j < mid; j++) {
                logList[j] = pq.poll();
                logList[log_cnt - 1 - j] = pq.poll();
            }

            //중간값에 가장 큰값이 들어와야한다.
            if (log_cnt % 2 != 0) {
                if (!pq.isEmpty()) {
                    logList[mid] = pq.poll();
                }
            }

            //처음 초기화는 맨끝과 맨앞의 수의 차이
            int dif = Math.abs(logList[log_cnt - 1] - logList[0]);
            //배열을 순회하면서 숫자값의 차이를 구한다.
            for (int j = 0; j < log_cnt-1; j++) {
                int temp_dif = Math.abs(logList[j] - logList[j + 1]);
                if (temp_dif > dif) {
                    dif = temp_dif;
                }
            }

            System.out.println(dif);
            pq.clear();
        }



    }
}
