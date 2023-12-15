package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Treasure1026 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cnt = Integer.parseInt(br.readLine());
        int[] A = new int[cnt];
        Integer[] B = new Integer[cnt];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < cnt; i++) {
            int a = Integer.parseInt(st.nextToken());
            A[i] = a;
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < cnt; i++) {
            int b = Integer.parseInt(st.nextToken());
            B[i] = b;
        }

        //최소값으로 정렬
        Arrays.sort(A);
        //최대값으로 정렬
        Arrays.sort(B, Comparator.reverseOrder());


        int result = 0;
        for (int i = 0; i < cnt; i++) {
            result += A[i] * B[i];
        }

        System.out.println(result);


    }



}
