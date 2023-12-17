package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Microwave10162 {
    public static void main(String[] args) throws IOException {
        int[] times = {300, 60, 10};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());


        int[] cnts = new int[3];
        for (int i = 0 ;i<times.length;i++) {
            int time = times[i];
            int cnt = num / time;
            num %= time;
            cnts[i] = cnt;
        }

        if (num != 0) {
            System.out.println(-1);
        }else{
            for (int cnt : cnts) {
                System.out.print(cnt+" ");
            }
        }

    }

}
