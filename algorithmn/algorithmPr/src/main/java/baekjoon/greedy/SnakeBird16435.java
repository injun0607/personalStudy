package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SnakeBird16435 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int cnt = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] fruits = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        //오름차순 정렬
        Arrays.sort(fruits);
        for (int fruit : fruits) {
            //해당조건이 true면 length 1 증가
            if (length >= fruit) {
                length++;
            }else{
                break;
            }
        }

        System.out.println(length);
    }

}
