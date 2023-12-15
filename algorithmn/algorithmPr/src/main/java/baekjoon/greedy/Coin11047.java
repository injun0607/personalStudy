package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin11047 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int cnt = Integer.parseInt(st.nextToken());
        int totalPrice = Integer.parseInt(st.nextToken());

        int[] coins = new int[cnt];

        for (int i = 0; i < cnt; i++) {

            int coinValue = Integer.parseInt(br.readLine());
            coins[i] = coinValue;

        }

        int totalCoinCnt = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            if (totalPrice == 0) {
                break;
            }
            int coinCnt = totalPrice / coins[i];
            totalCoinCnt += coinCnt;

            totalPrice %= coins[i];

        }

        System.out.println(totalCoinCnt);




    }
}
