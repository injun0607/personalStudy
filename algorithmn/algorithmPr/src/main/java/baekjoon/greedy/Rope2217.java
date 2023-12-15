package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Rope2217 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        Integer[] ropes = new Integer[cnt];

        for (int i = 0; i < cnt; i++) {
            int rope = Integer.parseInt(br.readLine());
            ropes[i] = rope;
        }

        //최대 로프 무게순으로 정렬
        Arrays.sort(ropes, Comparator.reverseOrder());
        int result = 0 ;
        //로프의 분산무게를 측정
        for (int i = 1; i <= ropes.length; i++) {
            int ropeWeight = ropes[i-1]*i;
            if (ropeWeight > result) {
                result = ropeWeight;
            }
        }
        System.out.println(result);

    }


}
