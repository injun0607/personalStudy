package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dice1041 {
    //정육면체는 3개로 나뉘어진다
    //3개가 노출되는 그룹 4개
    //2개가 노출되는 그룹 .
    //1개가 노출되는 그룹
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] dices = new int[6];
        for (int i = 0; i < 6; i++) {
            dices[i] = Integer.parseInt(st.nextToken());
        }

        //순서쌍 (A,F) , (B,E) , (C,D) 중에 최소값을 구하면 된다.
        long[] mins = {(long) Math.min(dices[0], dices[5]), (long) Math.min(dices[1], dices[4]), (long) Math.min(dices[2], dices[3])};
        Arrays.sort(mins);
        Arrays.sort(dices);


        long three_min = mins[0] + mins[1] + mins[2];
        long two_min = mins[0] + mins[1];
        long one_val = dices[0];


        long result = 0;

        //cnt == 1 이면 삼면쓰는건 없다. 1이상이면 무조건 4개
        long three_dim = (cnt == 1) ? 0 : 4;
        long two_dim = ((cnt - 1) * 4) + ((cnt - 2) * 4);
        long one_dim = (((cnt - 1) * (cnt - 2)) * 4) + ((cnt - 2) * (cnt - 2));


        if (cnt == 1) {
            result = dices[0] + dices[1] + dices[2] + dices[3] + dices[4];
        }else{
            result = (three_min * three_dim) + (two_min * two_dim) + (one_dim * one_val);
        }

        System.out.println(result);


    }

}
