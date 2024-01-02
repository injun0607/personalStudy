package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Sensor2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //총 센서개수
        int cnt = Integer.parseInt(br.readLine());
        //기지국 개수
        int receptionCnt = Integer.parseInt(br.readLine());

        //센서를 담을 배영
        int[] sensors = new int[cnt];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //결과값
        int result = 0 ;

        //센서들을 담는다
        for (int i = 0; i < cnt; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());

        }

        /**
         * 센서들을 기지국이 모두 커버해야한다.
         * 각 센서들에 기지국을 배치하고, 센서개수 - 기지국 = 기지국이 추가로 커버해야할 센서의 개수
         * 효율적으로 커버하는 방법은 센서의 거리의 차이가 가장 적은 곳들을 기지국이 커버해야한다.
         */
        //기지국이 추가로 커버해야할 센서의 개수
        int n = cnt - receptionCnt;

        //오름차순으로 정렬
        Arrays.sort(sensors);

        //센서들간의 거리의 차이
        ArrayList<Integer> diff = new ArrayList<>();
        //거리의 차이를 구함
        for (int i = 0; i < sensors.length - 1; i++) {
            int length = sensors[i + 1] - sensors[i];
            diff.add(length);
        }

        //가장 거리들이 짧은 순서대로 배치
        Collections.sort(diff);

        //거리가 짧은 순서대로 기지국이 커버할 센서의 개수 만큼 더하면 된다.
        for (int i = 0; i < n; i++) {
            result += diff.get(i);
        }

        System.out.println(result);
    }
}
