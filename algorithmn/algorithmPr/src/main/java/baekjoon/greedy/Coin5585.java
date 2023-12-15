package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coin5585 {
    public static void main(String[] args) throws IOException {

        int[] coins = {500, 100, 50, 10, 5, 1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int value = 1000-Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int coin : coins) {
            int coinCnt = value / coin;
            cnt += coinCnt;
            value %= coin;
        }

        System.out.println(cnt);



    }
}
