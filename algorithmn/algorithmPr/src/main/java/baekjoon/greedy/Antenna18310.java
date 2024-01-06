package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Antenna18310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] nums = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        //안테나의 위치는 중간에 있어야 가장작아진다
        //짝수의 경우 중간값-1
        //홀수의 경우 중간값
        if (cnt % 2 == 0) {
            System.out.println(nums[cnt/2 - 1]);
        }else{
            System.out.println(nums[cnt/2]);
        }



    }

}
