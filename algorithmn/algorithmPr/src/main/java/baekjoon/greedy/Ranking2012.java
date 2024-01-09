package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ranking2012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        int[] ranks = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            ranks[i] = Integer.parseInt(br.readLine());
        }

        //오름차순 정렬
        Arrays.sort(ranks);

        long result = 0;

        for (int i = 0; i < ranks.length; i++) {
            //학생들의 예상등수 - 1의 값이 i <- 실제 매겨질 등수와의 차이다.
            int rank = ranks[i] - 1;
            result += Math.abs(rank - i);
        }

        System.out.println(result);

    }


}
