package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ATM11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr.add(a);

        }
        Collections.sort(arr);

        int[] intArr = new int[cnt+1];
        Arrays.fill(intArr, 0);

        for (int i = 0; i < cnt; i++) {
            intArr[i + 1] = intArr[i] + arr.get(i);
        }


        System.out.print(Arrays.stream(intArr).sum());


    }

}
